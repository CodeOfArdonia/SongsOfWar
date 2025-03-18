package com.iafenvoy.sow.mixin;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tickFallFlying", at = @At("HEAD"), cancellable = true)
    private void handleFallFlyingCheck(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (!entity.getWorld().isClient && entity instanceof PlayerEntity player && !player.isOnGround() && !player.hasVehicle() && !player.hasStatusEffect(StatusEffects.LEVITATION))
            if (AbilityData.byPlayer(player).abilityEnabled(MobiliumPowers.MOBILIWINGS)) {
                this.setFlag(7, true);
                ci.cancel();
            }
    }

    @SuppressWarnings("all")
    @Inject(method = "tick", at = @At("RETURN"))
    private void endTick(CallbackInfo ci) {
        if (this.isRemoved() || this.hasNoGravity()) return;
        if ((Object) this instanceof PlayerEntity player && AbilityData.byPlayer(player).abilityEnabled(MobiliumPowers.MOBILIGLIDE)) {
            Vec3d velocity = this.getVelocity();
            this.setVelocity(velocity.x, 0.01 / 4.0, velocity.z);
            this.fallDistance = 0;
        }
    }
}
