package com.iafenvoy.sow.entity.power;

import com.iafenvoy.neptune.ability.AbilityDataHolder;
import com.iafenvoy.neptune.object.DamageUtil;
import com.iafenvoy.neptune.world.FakeExplosionBehavior;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class AggroProjectileEntity extends AbstractArrow implements SupporekesisControllable {
    private static final EntityDataAccessor<Integer> DISAPPEAR_CD = SynchedEntityData.defineId(AggroProjectileEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> EXPLODE = SynchedEntityData.defineId(AggroProjectileEntity.class, EntityDataSerializers.BOOLEAN);
    private float damageMultiplier = 1f;

    protected AggroProjectileEntity(EntityType<? extends AggroProjectileEntity> entityType, Level world) {
        super(entityType, world);
        this.setNoPhysics(true);
        this.setNoGravity(true);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DISAPPEAR_CD, -1);
        builder.define(EXPLODE, false);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("disappear_cd", this.getDisappearCd());
        nbt.putBoolean("explode", this.getExplode());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.setDisappearCd(nbt.getInt("disappear_cd"));
        this.setExplode(nbt.getBoolean("explode"));
    }

    @NotNull
    protected Entity ownerOrSelf() {
        return this.getOwner() == null ? this : this.getOwner();
    }

    public float transformDamage(float base) {
        return base * this.damageMultiplier;
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    public void tick() {
        super.tick();
        Vec3 vec3d = this.getDeltaMovement();
        double d = vec3d.horizontalDistance();
        this.setYRot((float) (Mth.atan2(vec3d.x, vec3d.z) * 57.2957763671875));
        this.setXRot((float) (Mth.atan2(vec3d.y, d) * 57.2957763671875));
        if (this.getY() > 1000 || this.tickCount > 20 * 60)
            this.remove(RemovalReason.DISCARDED);
        int cd = this.getDisappearCd();
        if (cd == 0) {
            if (this.getExplode())
                this.getCommandSenderWorld().explode(this, DamageUtil.build(this.ownerOrSelf(), DamageTypes.EXPLOSION), new FakeExplosionBehavior(), this.position(), 0, false, Level.ExplosionInteraction.NONE);
            this.remove(RemovalReason.DISCARDED);
        } else if (cd > 0) this.setDisappearCd(cd - 1);
    }

    public boolean getExplode() {
        return this.entityData.get(EXPLODE);
    }

    public int getDisappearCd() {
        return this.entityData.get(DISAPPEAR_CD);
    }

    public void setExplode(boolean explode) {
        this.entityData.set(EXPLODE, explode);
    }

    public void setDisappearCd(int cd) {
        this.entityData.set(DISAPPEAR_CD, cd, true);
    }

    @Override
    public void setCritArrow(boolean b) {
        this.damageMultiplier = AbilityDataHolder.DAMAGE_MUL;
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        return new ItemStack(Items.FIRE_CHARGE);
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return new ItemStack(Items.ARROW);
    }

    @Override
    public void setDisappearCd(int disappearDelay, boolean explode) {
        this.setDeltaMovement(0, 0, 0);
        this.hurtMarked = true;
        this.setDisappearCd(disappearDelay);
        this.setExplode(explode);
    }
}
