package com.iafenvoy.sow.item;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class EnchantmentFragmentItem extends Item {
    public EnchantmentFragmentItem() {
        super(new Settings().maxCount(4).rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS));
    }

    @Override
    public String getTranslationKey() {
        return "item." + SongsOfWar.MOD_ID + ".enchantment_fragment";
    }
}
