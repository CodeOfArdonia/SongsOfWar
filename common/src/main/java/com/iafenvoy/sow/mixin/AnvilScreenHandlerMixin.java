package com.iafenvoy.sow.mixin;

import com.iafenvoy.sow.item.EnchantmentFragmentItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.screen.*;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin extends ForgingScreenHandler {
    @Shadow
    private int repairItemUsage;

    @Shadow
    @Final
    private Property levelCost;

    public AnvilScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, context);
    }

    @Inject(method = "updateResult", at = @At("HEAD"), cancellable = true)
    private void addSongStoneRecipe(CallbackInfo ci) {
        ItemStack weapon = this.input.getStack(0), stone = this.input.getStack(1);
        if (weapon.getNbt() != null && weapon.getNbt().contains("enchantment_fragment")) return;
        if ((weapon.getItem() instanceof SwordItem || weapon.getItem() instanceof AxeItem) && stone.getItem() instanceof EnchantmentFragmentItem fragment) {
            this.repairItemUsage = 1;
            this.levelCost.set(1);
            ItemStack result = weapon.copy();
            fragment.applyToStack(result);
            this.output.setStack(0, result);
            this.sendContentUpdates();
            ci.cancel();
        }
    }

    @Inject(method = "canTakeOutput", at = @At("HEAD"), cancellable = true)
    private void onTakeOutput(PlayerEntity player, boolean present, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stone = this.input.getStack(1);
        if (stone.getItem() instanceof EnchantmentFragmentItem)
            cir.setReturnValue(player.getAbilities().creativeMode || player.experienceLevel >= this.levelCost.get());
    }
}
