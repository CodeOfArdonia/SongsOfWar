package com.iafenvoy.sow.mixin;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Inject(method = "updateFallFlying", at = @At("HEAD"), cancellable = true)
    private void handleFallFlyingCheck(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (!entity.level().isClientSide && entity instanceof Player player && !player.onGround() && !player.isPassenger() && !player.hasEffect(MobEffects.LEVITATION))
            if (AbilityData.get(player).abilityEnabled(MobiliumPowers.MOBILIWINGS.get())) {
                this.setSharedFlag(7, true);
                ci.cancel();
            }
    }

    @SuppressWarnings("ConstantValue")
    @ModifyExpressionValue(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hasEffect(Lnet/minecraft/core/Holder;)Z", ordinal = 0))
    private boolean handleSlowFalling(boolean original) {
        if (this.isRemoved() || this.isNoGravity()) return original;
        if ((Object) this instanceof LivingEntity player && AbilityData.get(player).abilityEnabled(MobiliumPowers.MOBILIGLIDE.get())) {
            this.fallDistance = 0;
            return true;
        }
        return original;
    }
}
