package com.iafenvoy.sow.mixin;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "getBlockJumpFactor", at = @At("RETURN"), cancellable = true)
    private void modifyJumpHeight(CallbackInfoReturnable<Float> cir) {
        Entity self = (Entity) (Object) this;
        if (self instanceof Player player && AbilityData.get(player).abilityEnabled(MobiliumPowers.MOBILILEAP.get()))
            cir.setReturnValue(cir.getReturnValue() * 5);
    }
}
