package com.iafenvoy.sow.entity.zombie;

import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SowHuskEntity extends AbstractZombieEntity {
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(SowHuskEntity.class, EntityDataSerializers.INT);

    public SowHuskEntity(EntityType<? extends Zombie> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 1);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("variant", this.getVariant());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("variant")) this.setVariant(nbt.getInt("variant"));
        else this.setVariant(RandomHelper.nextInt(1, 13));
    }

    //FIXME
    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor world, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnReason, @Nullable SpawnGroupData entityData) {
        SpawnGroupData data = super.finalizeSpawn(world, difficulty, spawnReason, entityData);
        this.setVariant(RandomHelper.nextInt(1, 13));
        return data;
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    @Override
    public ResourceLocation getTextureId() {
        return ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/zombie/husk_" + this.getVariant() + ".png");
    }

    @Override
    public Optional<ResourceLocation> getMarkerTextureId() {
        return Optional.ofNullable(ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/zombie/eye.png"));
    }

    @Override
    protected boolean isSunSensitive() {
        return false;
    }
}
