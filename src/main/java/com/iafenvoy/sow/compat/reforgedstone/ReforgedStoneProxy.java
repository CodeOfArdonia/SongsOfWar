package com.iafenvoy.sow.compat.reforgedstone;

import net.minecraft.world.item.ItemStack;

public interface ReforgedStoneProxy {
    ItemStack apply(ItemStack stack, String glint, boolean always);

    enum Empty implements ReforgedStoneProxy {
        INSTANCE;

        @Override
        public ItemStack apply(ItemStack stack, String glint, boolean always) {
            return stack;
        }
    }
}
