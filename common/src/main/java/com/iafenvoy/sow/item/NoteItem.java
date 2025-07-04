package com.iafenvoy.sow.item;

import com.iafenvoy.sow.registry.SowItemGroups;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Rarity;

import java.util.HashMap;
import java.util.Map;

public class NoteItem extends Item {
    private static final Map<SowAbilityCategory, Item> ITEMS = new HashMap<>();
    private final SowAbilityCategory category;

    public NoteItem(SowAbilityCategory category) {
        super(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS));
        this.category = category;
        ITEMS.put(this.category, this);
    }

    public SowAbilityCategory getCategory() {
        return this.category;
    }

    public static Item getItem(SowAbilityCategory category) {
        return ITEMS.getOrDefault(category, Items.AIR);
    }
}
