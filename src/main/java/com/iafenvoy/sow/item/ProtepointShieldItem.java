package com.iafenvoy.sow.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ProtepointShieldItem extends ShieldItem {
    public ProtepointShieldItem() {
        super(new Properties().durability(10000));
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level world, @NotNull Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!stack.is(this)) return;
        if (entity instanceof Player player && player.getOffhandItem() == stack) return;
        stack.setDamageValue(this.getMaxDamage(stack) + 1);
        stack.setCount(0);
    }
}
