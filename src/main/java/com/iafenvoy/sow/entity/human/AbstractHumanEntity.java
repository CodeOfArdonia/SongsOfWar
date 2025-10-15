package com.iafenvoy.sow.entity.human;

import com.iafenvoy.neptune.render.EntityTextureProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public abstract class AbstractHumanEntity extends Monster implements EntityTextureProvider {
    protected AbstractHumanEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.ARMOR, 10.0)
                .add(Attributes.ATTACK_DAMAGE, 4.0)
                .add(Attributes.FOLLOW_RANGE, 64.0)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, false) {
            //TODO
            private double getAttackReachSqr(LivingEntity entity) {
                return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
            }
        });
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.5));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new OpenDoorGoal(this, false));
        this.goalSelector.addGoal(5, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(6, new BreakDoorGoal(this, e -> true));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new FloatGoal(this));
    }

    @Override
    public boolean removeWhenFarAway(double distanceSquared) {
        return false;
    }
}
