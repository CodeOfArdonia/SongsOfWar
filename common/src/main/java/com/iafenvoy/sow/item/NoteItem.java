package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Rarity;

import java.util.HashMap;
import java.util.Map;

public class NoteItem extends Item {
    private static final Map<AbilityCategory, Item> ITEMS = new HashMap<>();
    private final AbilityCategory category;

    public NoteItem(AbilityCategory category) {
        super(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS));
        this.category = category;
        ITEMS.put(this.category, this);
    }

    public AbilityCategory getCategory() {
        return this.category;
    }

    public static Item getItem(AbilityCategory category) {
        return ITEMS.getOrDefault(category, Items.AIR);
    }
}
