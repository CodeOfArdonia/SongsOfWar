package com.iafenvoy.sow.entity.power;

import com.iafenvoy.neptune.object.DamageUtil;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.registry.SowDamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class AggroDetonateEntity extends AggroProjectileEntity {
    public AggroDetonateEntity(EntityType<? extends AggroProjectileEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getCommandSenderWorld().getNearestEntity(LivingEntity.class, TargetingConditions.DEFAULT, null, this.getX(), this.getY(), this.getZ(), new AABB(this.position().add(1, 1, 1), this.position().subtract(1, 1, 1)));
        if (target != null) this.explode();
        else if (this.onGround() || this.inGround || !this.getCommandSenderWorld().getBlockState(this.blockPosition()).isAir())
            this.explode();
    }

    public void explode() {
        this.getCommandSenderWorld().explode(this, DamageUtil.build(this.ownerOrSelf(), SowDamageTypes.AGGRODETONATE), new ExplosionDamageCalculator(), this.position(), SowCommonConfig.INSTANCE.aggressium.aggrodetonatePower.getValue().floatValue(), false, Level.ExplosionInteraction.MOB);
        this.remove(RemovalReason.DISCARDED);
    }
}
