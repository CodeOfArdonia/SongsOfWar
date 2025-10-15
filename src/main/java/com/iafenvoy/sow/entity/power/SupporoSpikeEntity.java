package com.iafenvoy.sow.entity.power;

import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class SupporoSpikeEntity extends Entity {
    private static final EntityDataAccessor<BlockState> BLOCK_STATE = SynchedEntityData.defineId(SupporoSpikeEntity.class, EntityDataSerializers.BLOCK_STATE);
    private static final EntityDataAccessor<Boolean> ABSOLUTE_ROTATION = SynchedEntityData.defineId(SupporoSpikeEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Vector3f> ROTATION = SynchedEntityData.defineId(SupporoSpikeEntity.class, EntityDataSerializers.VECTOR3);
    private static final EntityDataAccessor<Float> SCALE = SynchedEntityData.defineId(SupporoSpikeEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(SupporoSpikeEntity.class, EntityDataSerializers.INT);

    public SupporoSpikeEntity(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(BLOCK_STATE, Blocks.AIR.defaultBlockState());
        builder.define(ABSOLUTE_ROTATION, false);
        builder.define(ROTATION, new Vector3f(0, 0, 0));
        builder.define(SCALE, 1F);
        builder.define(DURATION, 20);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag nbt) {
        this.setBlockState(NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), nbt.getCompound("block_state")));
        this.setAbsoluteRotation(nbt.getBoolean("absolute_rotation"));
        this.setRotation(new Vector3f(nbt.getFloat("rotation_x"), nbt.getFloat("rotation_y"), nbt.getFloat("rotation_z")));
        this.setScale(nbt.getFloat("scale"));
        this.setDuration(nbt.getInt("duration"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag nbt) {
        nbt.put("block_state", NbtUtils.writeBlockState(this.getBlockState()));
        nbt.putBoolean("absolute_rotation", this.isAbsoluteRotation());
        Vector3f rotation = this.getRotation();
        nbt.putFloat("rotation_x", rotation.x);
        nbt.putFloat("rotation_y", rotation.y);
        nbt.putFloat("rotation_z", rotation.z);
        nbt.putFloat("scale", this.getScale());
        nbt.putInt("duration", this.getDuration());
    }

    @Override
    public void tick() {
        super.tick();
        int d = this.getDuration();
        if (d <= 0) this.remove(RemovalReason.DISCARDED);
        this.setDuration(d - 1);
    }

    public Quaternionf getRotationQuaternion() {
        Vector3f rotation = this.getRotation();
        if (this.isAbsoluteRotation())
            return new Quaternionf().rotateX(rotation.x).rotationY(rotation.y).rotationZ(rotation.z);
        return new Quaternionf().rotateX(rotation.x).rotateLocalY(rotation.y).rotateLocalZ(rotation.z);
    }

    public BlockState getBlockState() {
        return this.entityData.get(BLOCK_STATE);
    }

    public void setBlockState(BlockState state) {
        this.entityData.set(BLOCK_STATE, state);
    }

    public boolean isAbsoluteRotation() {
        return this.entityData.get(ABSOLUTE_ROTATION);
    }

    public void setAbsoluteRotation(boolean absoluteRotation) {
        this.entityData.set(ABSOLUTE_ROTATION, absoluteRotation);
    }

    public Vector3f getRotation() {
        return this.entityData.get(ROTATION);
    }

    public void setRotation(Vector3f rotation) {
        this.entityData.set(ROTATION, rotation);
    }

    public float getScale() {
        return this.entityData.get(SCALE);
    }

    public void setScale(float scale) {
        this.entityData.set(SCALE, scale);
    }

    public int getDuration() {
        return this.entityData.get(DURATION);
    }

    public void setDuration(int duration) {
        this.entityData.set(DURATION, duration);
    }
}
