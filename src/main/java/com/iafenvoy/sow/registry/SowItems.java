package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.*;
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unused")
public final class SowItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(SongsOfWar.MOD_ID);

    public static final DeferredItem<Item> ENCHANTMENT_FRAGMENT_RED = REGISTRY.register("enchantment_fragment_red", EnchantmentFragmentItem::new);
    public static final DeferredItem<Item> ENCHANTMENT_FRAGMENT_YELLOW = REGISTRY.register("enchantment_fragment_yellow", EnchantmentFragmentItem::new);
    public static final DeferredItem<Item> ENCHANTMENT_FRAGMENT_BLUE = REGISTRY.register("enchantment_fragment_blue", EnchantmentFragmentItem::new);
    public static final DeferredItem<Item> ENCHANTMENT_FRAGMENT_ORANGE = REGISTRY.register("enchantment_fragment_orange", EnchantmentFragmentItem::new);
    public static final DeferredItem<Item> ENCHANTMENT_FRAGMENT_GREEN = REGISTRY.register("enchantment_fragment_green", EnchantmentFragmentItem::new);
    public static final DeferredItem<Item> ENCHANTMENT_FRAGMENT_PURPLE = REGISTRY.register("enchantment_fragment_purple", EnchantmentFragmentItem::new);
    public static final DeferredItem<Item> ENCHANTMENT_FRAGMENT_WHITE = REGISTRY.register("enchantment_fragment_white", EnchantmentFragmentItem::new);
    public static final DeferredItem<Item> ENCHANTMENT_FRAGMENT_PINK = REGISTRY.register("enchantment_fragment_pink", EnchantmentFragmentItem::new);
    public static final DeferredItem<Item> ENCHANTMENT_FRAGMENT_AQUA = REGISTRY.register("enchantment_fragment_aqua", EnchantmentFragmentItem::new);

    public static final DeferredItem<Item> WITHER_STAFF = REGISTRY.register("wither_staff", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<Item> ENDER_KNIGHT_HELMET = REGISTRY.register("ender_knight_helmet", () -> new ArmorItem(SowArmorMaterials.ENDER_KNIGHT, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> ENDER_KNIGHT_CHESTPLATE = REGISTRY.register("ender_knight_chestplate", () -> new ArmorItem(SowArmorMaterials.ENDER_KNIGHT, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> ENDER_KNIGHT_LEGGINGS = REGISTRY.register("ender_knight_leggings", () -> new ArmorItem(SowArmorMaterials.ENDER_KNIGHT, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> ENDER_KNIGHT_BOOTS = REGISTRY.register("ender_knight_boots", () -> new ArmorItem(SowArmorMaterials.ENDER_KNIGHT, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> SONG_STONE = REGISTRY.register("song_stone", SongStoneItem::new);
    public static final DeferredItem<Item> AGGRESSIUM_SONG_STONE = REGISTRY.register("aggressium_song_stone", () -> new AdjustedSongStoneItem(SowAbilityCategories.AGGRESSIUM));
    public static final DeferredItem<Item> MOBILIUM_SONG_STONE = REGISTRY.register("mobilium_song_stone", () -> new AdjustedSongStoneItem(SowAbilityCategories.MOBILIUM));
    public static final DeferredItem<Item> PROTISIUM_SONG_STONE = REGISTRY.register("protisium_song_stone", () -> new AdjustedSongStoneItem(SowAbilityCategories.PROTISIUM));
    public static final DeferredItem<Item> SUPPORTIUM_SONG_STONE = REGISTRY.register("supportium_song_stone", () -> new AdjustedSongStoneItem(SowAbilityCategories.SUPPORTIUM));
    public static final DeferredItem<Item> RED_NOTE = REGISTRY.register("red_note", () -> new NoteItem(SowAbilityCategories.AGGRESSIUM));
    public static final DeferredItem<Item> YELLOW_NOTE = REGISTRY.register("yellow_note", () -> new NoteItem(SowAbilityCategories.MOBILIUM));
    public static final DeferredItem<Item> BLUE_NOTE = REGISTRY.register("blue_note", () -> new NoteItem(SowAbilityCategories.PROTISIUM));
    public static final DeferredItem<Item> GREEN_NOTE = REGISTRY.register("green_note", () -> new NoteItem(SowAbilityCategories.SUPPORTIUM));

    public static final DeferredItem<ShrineDebugItem> SHRINE_DEBUG = REGISTRY.register("shrine_debug", ShrineDebugItem::new);
    public static final DeferredItem<WallsOfTimeEditItem> WALLS_OF_TIME_EDIT = REGISTRY.register("walls_of_time_edit", WallsOfTimeEditItem::new);
    //Fake Items, should not use in game without song power.
    public static final DeferredItem<Item> PROTEPOINT_SHIELD = REGISTRY.register("protepoint_shield", ProtepointShieldItem::new);
}
