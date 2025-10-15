package com.iafenvoy.sow.mixin;

import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.entity.ardoni.IngresssusEntity;
import com.iafenvoy.sow.registry.SowEntities;
import com.iafenvoy.sow.registry.SowSkulls;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FishingHook.class)
public abstract class FishingHookMixin extends Entity {
    @Shadow
    @Final
    private RandomSource syncronizedRandom;

    public FishingHookMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Shadow
    @Nullable
    public abstract Player getPlayerOwner();

    @Inject(method = "retrieve", at = @At(value = "INVOKE", target = "Ljava/util/Iterator;hasNext()Z"), cancellable = true)
    private void onGenerateLoot(ItemStack usedItem, CallbackInfoReturnable<Integer> cir) {
        Player player = this.getPlayerOwner();
        if (player == null) return;
        if (this.syncronizedRandom.nextDouble() < SowCommonConfig.INSTANCE.common.specialFishChance.getValue() || player.getItemBySlot(EquipmentSlot.HEAD).is(SowSkulls.ACHILLEAN_HEAD_ITEM.get())) {
            IngresssusEntity entity = SowEntities.INGRESSSUS.get().create(this.level());
            if (entity == null) return;
            double d0 = player.getX() - this.getX();
            double d1 = player.getY() - this.getY();
            double d2 = player.getZ() - this.getZ();
            entity.setPos(this.position());
            entity.setDeltaMovement(d0 * 0.2, d1 * 0.2 + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.16, d2 * 0.2);
            this.level().addFreshEntity(entity);
            this.discard();
            cir.setReturnValue(this.onGround() ? 2 : 1);
        }
    }
}
