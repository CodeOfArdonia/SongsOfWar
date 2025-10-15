package com.iafenvoy.sow.entity.power;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ProteCloneEntity extends Mob {
    private static final EntityDataAccessor<Integer> DISAPPEAR_CD = SynchedEntityData.defineId(ProteCloneEntity.class, EntityDataSerializers.INT);

    public ProteCloneEntity(EntityType<? extends Mob> type, Level world) {
        super(type, world);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DISAPPEAR_CD, -1);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.setDisappearCd(nbt.getInt("disappear_cd"));
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("disappear_cd", this.getDisappearCd());
    }

    public int getDisappearCd() {
        return this.entityData.get(DISAPPEAR_CD);
    }

    public void setDisappearCd(int cd) {
        this.entityData.set(DISAPPEAR_CD, cd);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) return;
        int cd = this.getDisappearCd();
        if (cd == 0) this.remove(RemovalReason.DISCARDED);
        else if (cd > 0) this.setDisappearCd(cd - 1);
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        this.remove(RemovalReason.KILLED);
        return true;
    }
}
