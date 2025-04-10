package com.iafenvoy.sow.item.impl.fabric;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ProtepointShieldItemImpl extends FabricShieldItem {
    private ProtepointShieldItemImpl() {
        super(new Settings().maxDamage(10000), 5 * 20, 0);
    }

    public static Item create(){
        return new ProtepointShieldItemImpl();
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!stack.isOf(this)) return;
        if (entity instanceof PlayerEntity player && player.getOffHandStack() == stack) return;
        stack.setDamage(this.getMaxDamage() + 1);
        stack.setCount(0);
    }
}
