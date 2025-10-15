package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.registry.NeptuneDataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class SowCanActiveSwordItem extends SwordItem implements SowWeapon {
    public SowCanActiveSwordItem(Tier toolMaterial, int attackDamage, float attackSpeed, Function<Properties, Properties> settings) {
        super(toolMaterial, settings.apply(new Properties().component(NeptuneDataComponents.ACTIVE, false).attributes(createAttributes(toolMaterial, attackDamage, attackSpeed))));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        stack.set(NeptuneDataComponents.ACTIVE, stack.getOrDefault(NeptuneDataComponents.ACTIVE, false));
        return InteractionResultHolder.success(stack);
    }
}
