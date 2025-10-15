package com.iafenvoy.sow.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class TemporaryBlockItem extends BlockItem {
    public TemporaryBlockItem(Block block) {
        super(block, new Properties());
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level world, @NotNull Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!stack.is(this)) return;
        stack.setCount(0);
    }
}
