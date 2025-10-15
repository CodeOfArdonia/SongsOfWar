package com.iafenvoy.sow.entity.ardoni.random;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.Proxies;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.item.ArdoniGraveItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class ArdoniEntity extends AbstractArdoniEntity {
    protected static final EntityDataAccessor<Long> MARKER_SEED = SynchedEntityData.defineId(ArdoniEntity.class, EntityDataSerializers.LONG);
    protected static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(ArdoniEntity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Boolean> FEMALE = SynchedEntityData.defineId(ArdoniEntity.class, EntityDataSerializers.BOOLEAN);

    public ArdoniEntity(EntityType<? extends ArdoniEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public Optional<ResourceLocation> getMarkerTextureId() {
        return Optional.empty();
    }

    @Override
    protected @NotNull Component getTypeName() {
        String random = Proxies.ardoniNameProxy.getNameBySeed(this.getMarkerSeed());
        if (!random.isBlank()) return this.getArdoniType().formatName(random);
        return super.getTypeName();
    }

    @Override
    public boolean hasCustomName() {
        return true;
    }

    @Override
    public Color4i getColor() {
        if (this.hasCustomName() && this.getName().getString().equals("jeb_"))
            return Color4i.fromHSV((this.tickCount + this.getId()) / 100.0f, 1, 1);
        return this.getArdoniType().getColor(this.getMarkerSeed());
    }

    @Override
    public ResourceLocation getTextureId() {
        return ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_base.png");
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(MARKER_SEED, 0L);
        builder.define(AGE, 1);
        builder.define(FEMALE, false);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putLong("markerSeed", this.getMarkerSeed());
        nbt.putInt("age", this.getAge());
        nbt.putBoolean("female", this.isFemale());
    }

    public void setDefaultData() {
        this.setMarkerSeed(System.nanoTime());
        this.setAge(RandomHelper.nextInt(1, 5));
        this.setGender(RandomHelper.nextInt(0, 5) == 0);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.setDefaultData();
        if (nbt.contains("markerSeed")) this.setMarkerSeed(nbt.getLong("markerSeed"));
        if (nbt.contains("age")) this.setAge(nbt.getInt("age"));
        if (nbt.contains("female")) this.setGender(nbt.getBoolean("female"));
    }

    @Nullable
    @Override
    //FIXME
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor world, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnReason, @Nullable SpawnGroupData entityData) {
        SpawnGroupData data = super.finalizeSpawn(world, difficulty, spawnReason, entityData);
        this.setDefaultData();
        return data;
    }

    public long getMarkerSeed() {
        return this.entityData.get(MARKER_SEED);
    }

    public void setMarkerSeed(long markerSeed) {
        this.entityData.set(MARKER_SEED, markerSeed);
    }

    public int getAge() {
        return this.entityData.get(AGE);
    }

    public void setAge(int age) {
        this.entityData.set(AGE, age);
    }

    @Override
    public boolean isFemale() {
        return this.entityData.get(FEMALE);
    }

    public void setGender(boolean female) {
        this.entityData.set(FEMALE, female);
    }

    @Override
    public ItemStack toGrave() {
        return ArdoniGraveItem.buildGrave(this.getMarkerSeed(), this.getArdoniType(), this.getAge(), this.isFemale());
    }
}
