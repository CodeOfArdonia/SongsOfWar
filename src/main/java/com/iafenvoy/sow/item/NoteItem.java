package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.ability.AbilityCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.LinkedList;
import java.util.List;

public class NoteItem extends Item {
    private static final List<NoteItem> ITEMS = new LinkedList<>();
    private final DeferredHolder<AbilityCategory, AbilityCategory> category;

    public NoteItem(DeferredHolder<AbilityCategory, AbilityCategory> category) {
        super(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON));
        this.category = category;
        ITEMS.add(this);
    }

    public AbilityCategory getCategory() {
        return this.category.get();
    }

    public static Item getItem(AbilityCategory category) {
        return ITEMS.stream().filter(x -> x.category.get() == category).findFirst().map(Item.class::cast).orElse(Items.AIR);
    }
}
