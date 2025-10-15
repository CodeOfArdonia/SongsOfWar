package com.iafenvoy.sow.entity.power;

import com.iafenvoy.neptune.object.DamageUtil;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.neptune.world.FakeExplosionBehavior;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.registry.SowDamageTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class AggroSphereEntity extends AggroProjectileEntity {
    public AggroSphereEntity(EntityType<? extends AggroSphereEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.onGround() || this.inGround || !this.getCommandSenderWorld().getBlockState(this.blockPosition()).isAir()) {
            this.getCommandSenderWorld().explode(this, DamageUtil.build(this.ownerOrSelf(), SowDamageTypes.AGGROSPHERE), new FakeExplosionBehavior(), this.position(), 2, false, Level.ExplosionInteraction.NONE);
            this.remove(RemovalReason.DISCARDED);
        }
        LivingEntity target = this.getCommandSenderWorld().getNearestEntity(LivingEntity.class, TargetingConditions.DEFAULT, null, this.getX(), this.getY(), this.getZ(), new AABB(this.position().add(1, 1, 1), this.position().subtract(1, 1, 1)));
        if (target != null) {
            target.hurt(DamageUtil.build(this.ownerOrSelf(), SowDamageTypes.AGGROSPHERE), this.transformDamage(SowCommonConfig.INSTANCE.aggressium.aggrosphereDamage.getValue().floatValue()));
            this.remove(RemovalReason.DISCARDED);
        }
        this.getCommandSenderWorld().addParticle(ParticleTypes.FLAME,
                RandomHelper.rangeRand(this.getX(), 0.3),
                RandomHelper.rangeRand(this.getY() + 0.25, 0.3),
                RandomHelper.rangeRand(this.getZ(), 0.3),
                this.getDeltaMovement().x(),
                this.getDeltaMovement().y(),
                this.getDeltaMovement().z());
    }
}
