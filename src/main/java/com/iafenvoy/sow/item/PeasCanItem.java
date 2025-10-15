package com.iafenvoy.sow.item;

import com.iafenvoy.sow.entity.ardoni.ThalleousEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PeasCanItem extends PeasDelightItem {
    public PeasCanItem() {
        super(p -> p.food(new FoodProperties.Builder().alwaysEdible().nutrition(4).saturationModifier(0.5f).fast().build()));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(Component.translatable("item.sow.peas_can.tooltip"));
    }


    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, @NotNull Player user, @NotNull LivingEntity entity, @NotNull InteractionHand hand) {
        if (entity instanceof ThalleousEntity thalleous) {
            thalleous.setItemSlot(EquipmentSlot.HEAD, stack.copyWithCount(1));
            return InteractionResult.SUCCESS;
        }
        return super.interactLivingEntity(stack, user, entity, hand);
    }
}
