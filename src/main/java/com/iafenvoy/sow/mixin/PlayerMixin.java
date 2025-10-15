package com.iafenvoy.sow.mixin;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.power.PowerMergeHelper;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @SuppressWarnings("all")
    @Inject(method = "tick", at = @At("RETURN"))
    private void handleFallDistance(CallbackInfo ci) {
        Player self = (Player) (Object) this;
        AbilityData data = AbilityData.get((Player) (Object) this);
        if (this.level() instanceof ServerLevel serverWorld)
            PowerMergeHelper.run(data, self, serverWorld);
        if (data.abilityEnabled(MobiliumPowers.MOBILILEAP.get()))
            this.fallDistance = 0;
    }
}
