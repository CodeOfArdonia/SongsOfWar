package com.iafenvoy.sow.entity.magnorite;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MagnoriteEntity extends AbstractMagnoriteEntity {
    protected static final TrackedData<Long> MARKER_SEED = DataTracker.registerData(MagnoriteEntity.class, TrackedDataHandlerRegistry.LONG);

    public MagnoriteEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(MARKER_SEED, 0L);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putLong("markerSeed", this.getMarkerSeed());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("markerSeed")) this.setMarkerSeed(nbt.getLong("markerSeed"));
        else this.setMarkerSeed(this.getRandom().nextLong());
    }

    public long getMarkerSeed() {
        return this.dataTracker.get(MARKER_SEED);
    }

    public void setMarkerSeed(long markerSeed) {
        this.dataTracker.set(MARKER_SEED, markerSeed);
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        EntityData data = super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
        this.setMarkerSeed(this.getRandom().nextLong());
        return data;
    }

    @Override
    public Identifier getTextureId() {
        return Identifier.of(SongsOfWar.MOD_ID, "textures/white.png");
    }

    @Override
    public Optional<Identifier> getMarkerTextureId() {
        return Optional.empty();
    }
}
