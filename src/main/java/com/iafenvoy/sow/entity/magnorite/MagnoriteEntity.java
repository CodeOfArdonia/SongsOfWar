package com.iafenvoy.sow.entity.magnorite;

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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MagnoriteEntity extends AbstractMagnoriteEntity {
    protected static final EntityDataAccessor<Long> MARKER_SEED = SynchedEntityData.defineId(MagnoriteEntity.class, EntityDataSerializers.LONG);

    public MagnoriteEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(MARKER_SEED, 0L);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putLong("markerSeed", this.getMarkerSeed());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("markerSeed")) this.setMarkerSeed(nbt.getLong("markerSeed"));
        else this.setMarkerSeed(this.getRandom().nextLong());
    }

    public long getMarkerSeed() {
        return this.entityData.get(MARKER_SEED);
    }

    public void setMarkerSeed(long markerSeed) {
        this.entityData.set(MARKER_SEED, markerSeed);
    }

    //FIXME
    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor world, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnReason, @Nullable SpawnGroupData entityData) {
        SpawnGroupData data = super.finalizeSpawn(world, difficulty, spawnReason, entityData);
        this.setMarkerSeed(this.getRandom().nextLong());
        return data;
    }

    @Override
    public ResourceLocation getTextureId() {
        return ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/white.png");
    }

    @Override
    public Optional<ResourceLocation> getMarkerTextureId() {
        return Optional.empty();
    }
}
