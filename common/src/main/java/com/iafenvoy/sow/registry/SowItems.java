package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.*;
import com.iafenvoy.sow.item.impl.ProtepointShieldItem;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

@SuppressWarnings("unused")
public final class SowItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM);

    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_RED = REGISTRY.register("enchantment_fragment_red", EnchantmentFragmentItem::new);
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_YELLOW = REGISTRY.register("enchantment_fragment_yellow", EnchantmentFragmentItem::new);
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_BLUE = REGISTRY.register("enchantment_fragment_blue", EnchantmentFragmentItem::new);
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_ORANGE = REGISTRY.register("enchantment_fragment_orange", EnchantmentFragmentItem::new);
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_GREEN = REGISTRY.register("enchantment_fragment_green", EnchantmentFragmentItem::new);
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_PURPLE = REGISTRY.register("enchantment_fragment_purple", EnchantmentFragmentItem::new);
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_WHITE = REGISTRY.register("enchantment_fragment_white", EnchantmentFragmentItem::new);
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_PINK = REGISTRY.register("enchantment_fragment_pink", EnchantmentFragmentItem::new);
    public static final RegistrySupplier<Item> ENCHANTMENT_FRAGMENT_AQUA = REGISTRY.register("enchantment_fragment_aqua", EnchantmentFragmentItem::new);

    public static final RegistrySupplier<Item> WITHER_STAFF = REGISTRY.register("wither_staff", () -> new Item(new Item.Settings().fireproof().rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS)));

    public static final RegistrySupplier<Item> ENDER_KNIGHT_HELMET = REGISTRY.register("ender_knight_helmet", () -> new EnderKnightArmorItem(ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> ENDER_KNIGHT_CHESTPLATE = REGISTRY.register("ender_knight_chestplate", () -> new EnderKnightArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistrySupplier<Item> ENDER_KNIGHT_LEGGINGS = REGISTRY.register("ender_knight_leggings", () -> new EnderKnightArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistrySupplier<Item> ENDER_KNIGHT_BOOTS = REGISTRY.register("ender_knight_boots", () -> new EnderKnightArmorItem(ArmorItem.Type.BOOTS));

    public static final RegistrySupplier<Item> SONG_STONE = REGISTRY.register("song_stone", SongStoneItem::new);
    public static final RegistrySupplier<Item> AGGRESSIUM_SONG_STONE = REGISTRY.register("aggressium_song_stone", () -> new AdjustedSongStoneItem(SowAbilityCategory.AGGRESSIUM));
    public static final RegistrySupplier<Item> MOBILIUM_SONG_STONE = REGISTRY.register("mobilium_song_stone", () -> new AdjustedSongStoneItem(SowAbilityCategory.MOBILIUM));
    public static final RegistrySupplier<Item> PROTISIUM_SONG_STONE = REGISTRY.register("protisium_song_stone", () -> new AdjustedSongStoneItem(SowAbilityCategory.PROTISIUM));
    public static final RegistrySupplier<Item> SUPPORTIUM_SONG_STONE = REGISTRY.register("supportium_song_stone", () -> new AdjustedSongStoneItem(SowAbilityCategory.SUPPORTIUM));
    public static final RegistrySupplier<Item> RED_NOTE = REGISTRY.register("red_note", () -> new NoteItem(SowAbilityCategory.AGGRESSIUM));
    public static final RegistrySupplier<Item> YELLOW_NOTE = REGISTRY.register("yellow_note", () -> new NoteItem(SowAbilityCategory.MOBILIUM));
    public static final RegistrySupplier<Item> BLUE_NOTE = REGISTRY.register("blue_note", () -> new NoteItem(SowAbilityCategory.PROTISIUM));
    public static final RegistrySupplier<Item> GREEN_NOTE = REGISTRY.register("green_note", () -> new NoteItem(SowAbilityCategory.SUPPORTIUM));

    public static final RegistrySupplier<ShrineDebugItem> SHRINE_DEBUG = REGISTRY.register("shrine_debug", ShrineDebugItem::new);
    public static final RegistrySupplier<WallsOfTimeEditItem> WALLS_OF_TIME_EDIT = REGISTRY.register("walls_of_time_edit", WallsOfTimeEditItem::new);
    //Fake Items, should not use in game without song power.
    public static final RegistrySupplier<Item> PROTEPOINT_SHIELD = REGISTRY.register("protepoint_shield", ProtepointShieldItem::create);
}
