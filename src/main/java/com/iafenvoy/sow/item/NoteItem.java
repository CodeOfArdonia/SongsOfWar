package com.iafenvoy.sow.item;

import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;

import java.util.HashMap;
import java.util.Map;

public class NoteItem extends Item {
    private static final Map<SowAbilityCategory, Item> ITEMS = new HashMap<>();
    private final SowAbilityCategory category;

    public NoteItem(SowAbilityCategory category) {
        super(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON));
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
