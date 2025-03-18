package com.iafenvoy.sow.mixin;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.power.PowerMergeHelper;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @SuppressWarnings("all")
    @Inject(method = "tick", at = @At("RETURN"))
    private void handleFallDistance(CallbackInfo ci) {
        PlayerEntity self = (PlayerEntity) (Object) this;
        AbilityData data = AbilityData.byPlayer((PlayerEntity) (Object) this);
        if (this.getWorld() instanceof ServerWorld serverWorld)
            PowerMergeHelper.run(data, self, serverWorld);
        if (AbilityData.byPlayer((PlayerEntity) (Object) this).abilityEnabled(MobiliumPowers.MOBILILEAP))
            this.fallDistance = 0;
    }
}
