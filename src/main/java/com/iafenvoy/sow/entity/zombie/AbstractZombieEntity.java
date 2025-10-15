package com.iafenvoy.sow.entity.zombie;

import com.iafenvoy.neptune.render.EntityWithMarkerTextureProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public abstract class AbstractZombieEntity extends Zombie implements EntityWithMarkerTextureProvider {
    public AbstractZombieEntity(EntityType<? extends Zombie> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public boolean removeWhenFarAway(double distanceSquared) {
        return false;
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
}
