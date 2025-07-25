package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class SowWeapons {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM);

    //diamond weapons
    public static final RegistrySupplier<SowSwordItem> ARMORED_DIAMOND_SPEAR = register("armored_diamond_spear", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 2, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> LAURA_STIMPSON_BLADE_DIAMOND = register("laura_stimpson_blade_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -2f, s -> s));
    public static final RegistrySupplier<SowAxeItem> BATTLE_AXE_DIAMOND = register("battle_axe_diamond", () ->
            new SowAxeItem(ToolMaterials.DIAMOND, 4, -3, s -> s));
    public static final RegistrySupplier<SowAxeItem> BATTLE_AXE_DIAMOND_1 = register("battle_axe_diamond_1", () ->
            new SowAxeItem(ToolMaterials.DIAMOND, 4, -3, s -> s));
    public static final RegistrySupplier<SowSwordItem> BLADE_DIAMOND = register("blade_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> BLADE_STAFF_DIAMOND = register("blade_staff_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> BLUNT_DIAMOND_SPEAR = register("blunt_diamond_spear", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> DAGGER_DIAMOND = register("dagger_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> ZERU_HALBERD_DIAMOND = register("zeru_halberd_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 2, -1, s -> s));
    public static final RegistrySupplier<SowSwordItem> ZERU_LONG_SWORD_DIAMOND = register("zeru_long_sword_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 2, -1, s -> s));
    public static final RegistrySupplier<SowSwordItem> ZERU_SWORD_DIAMOND = register("zeru_sword_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 2, -1, s -> s));
    public static final RegistrySupplier<SowSwordItem> ZERU_SWORD_DIAMOND_1 = register("zeru_sword_diamond_1", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 2, -1, s -> s));
    public static final RegistrySupplier<SowSwordItem> GREAT_SWORD_DIAMOND = register("great_sword_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 2, -1, s -> s));
    public static final RegistrySupplier<SowSwordItem> HALBERD_DIAMOND = register("halberd_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 4, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> HALBERD_DIAMOND_1 = register("halberd_diamond_1", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 4, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> HALBERD_DIAMOND_2 = register("halberd_diamond_2", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 4, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> HALBERD_DOUBLE_DIAMOND = register("halberd_double_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 5, -3, s -> s));
    public static final RegistrySupplier<SowSwordItem> HATCHER_DIAMOND = register("hatcher_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> HATCHER_DIAMOND_1 = register("hatcher_diamond_1", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> CHRONOS0117_SWORD_DIAMOND = register("chronos0117_sword_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 2, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> KALTAR = register("kaltar", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 5, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> BLACKSMITH_HAMMER_DIAMOND = register("blacksmith_hammer_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> MENDOR = register("mendor", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 5, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> NESTOR = register("nestor", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 5, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> TRB_GRAPHICS_SPEAR_DIAMOND = register("trb_graphics_spear_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> TRB_GRAPHICS_SPIKE_MACE_DIAMOND = register("trb_graphics_spike_mace_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> TRB_GRAPHICS_SWORD_DIAMOND = register("trb_graphics_sword_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> REAT_SWORD_DIAMOND = register("reat_sword_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SCARRED_DIAMOND_SWORD = register("scarred_diamond_sword", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 2, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SCYTHE_DIAMOND = register("scythe_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, 1.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SENDAR = register("sendar", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 5, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SHADOW_SPEAR_DIAMOND = register("shadow_spear_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SHINING_DIAMOND_SWORD = register("shining_diamond_sword", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SOUL_SEEKER = register("soul_seeker", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 2, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SOUL_SEEKER_SINGLE = register("soul_seeker_single", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 5, -2, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_DIAMOND = register("spear_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -2, 1.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_DIAMOND_1 = register("spear_diamond_1", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_DIAMOND_3 = register("spear_diamond_3", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_DIAMOND_4 = register("spear_diamond_4", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_HEAVY_DIAMOND = register("spear_heavy_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_LIGHT_DIAMOND = register("spear_light_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_DIAMOND = register("staff_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_DIAMOND_2 = register("staff_diamond_2", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_DIAMOND_3 = register("staff_diamond_3", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_DIAMOND_4 = register("staff_diamond_4", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_DIAMOND_5 = register("staff_diamond_5", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_DIAMOND_8 = register("staff_diamond_8", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_HONOR_GUARD_DIAMOND = register("staff_honor_guard_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_INGRESSSUS = register("sword_ingresssus", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 6, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_DIAMOND_13 = register("sword_diamond_13", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_DIAMOND_14 = register("sword_diamond_14", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_DIAMOND_15 = register("sword_diamond_15", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_THALLEOUS = register("sword_thalleous", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, 4, -0.5f, s -> s));
    public static final RegistrySupplier<SowCanActiveSwordItem> STAFF_ACHILLEAN = register("staff_achillean", () ->
            new SowCanActiveSwordItem(ToolMaterials.DIAMOND, 6, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_ARDONI_HONOR_DIAMOND = register("staff_ardoni_honor_diamond", () ->
            new SowSwordItem(ToolMaterials.DIAMOND, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowCanActiveSwordItem> VOLTAR = register("voltar", () ->
            new SowCanActiveSwordItem(ToolMaterials.DIAMOND, 1, -0.5f, s -> s));

    //iron weapons
    public static final RegistrySupplier<SowSwordItem> ARM_BLADE = register("arm_blade", () ->
            new SowSwordItem(ToolMaterials.IRON, 3, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> MAROON_LEOPARD = register("maroon_leopard", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> ARMORED_IRON_SWORD = register("armored_iron_sword", () ->
            new SowSwordItem(ToolMaterials.IRON, 2, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> LAURA_STIMPSON_BLADE_IRON = register("laura_stimpson_blade_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -2f, s -> s));
    public static final RegistrySupplier<SowAxeItem> BATTLE_AXE_IRON = register("battle_axe_iron", () ->
            new SowAxeItem(ToolMaterials.IRON, 4, -3, s -> s));
    public static final RegistrySupplier<SowAxeItem> BATTLE_AXE_IRON_1 = register("battle_axe_iron_1", () ->
            new SowAxeItem(ToolMaterials.IRON, 4, -3, s -> s));
    public static final RegistrySupplier<SowAxeItem> BATTLE_AXE_IRON_2 = register("battle_axe_iron_2", () ->
            new SowAxeItem(ToolMaterials.IRON, 4, -3, s -> s));
    public static final RegistrySupplier<SowSwordItem> BLADE_IRON = register("blade_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> BLADE_STAFF_IRON = register("blade_staff_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> BLUNT_IRON_SPEAR = register("blunt_iron_spear", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> BROKEN_IRON_SWORD = register("broken_iron_sword", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> CHIPPED_IRON_SWORD = register("chipped_iron_sword", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> CHISEL = register("chisel", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> CLAW_IRON = register("claw_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 2, -3, s -> s));
    public static final RegistrySupplier<SowSwordItem> DAGGER_IRON = register("dagger_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> ZERU_HALBERD_IRON = register("zeru_halberd_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> ZERU_LONG_SWORD_IRON = register("zeru_long_sword_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> ZERU_LONG_SWORD_IRON_1 = register("zeru_long_sword_iron_1", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> ZERU_SWORD_IRON = register("zeru_sword_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> ZERU_SWORD_IRON_1 = register("zeru_sword_iron_1", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowAxeItem> GREAT_AXE_IRON = register("great_axe_iron", () ->
            new SowAxeItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> GREAT_SWORD_IRON = register("great_sword_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> HALBERD_DOUBLE_IRON = register("halberd_double_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 4, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> HALBERD_IRON = register("halberd_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 4, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> HALBERD_IRON_1 = register("halberd_iron_1", () ->
            new SowSwordItem(ToolMaterials.IRON, 4, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> HALBERD_IRON_2 = register("halberd_iron_2", () ->
            new SowSwordItem(ToolMaterials.IRON, 4, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> HATCHER_IRON = register("hatcher_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> HATCHER_IRON_1 = register("hatcher_iron_1", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> HOOK_IRON = register("hook_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> CHRONOS0117_SWORD_IRON = register("chronos0117_sword_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> BLACKSMITH_HAMMER_IRON = register("blacksmith_hammer_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> MACE_IRON = register("mace_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> PLATED_IRON_SWORD = register("plated_iron_sword", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> TRB_GRAPHICS_SPEAR_IRON = register("trb_graphics_spear_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> TRB_GRAPHICS_SPIKE_MACE_IRON = register("trb_graphics_spike_mace_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 0, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> TRB_GRAPHICS_SWORD_IRON = register("trb_graphics_sword_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> RAPIER_IRON = register("rapier_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowAxeItem> REAT_AXE_IRON = register("reat_axe_iron", () ->
            new SowAxeItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> REAT_SWORD_IRON = register("reat_sword_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowAxeItem> SCARRED_GREAT_AXE_IRON = register("scarred_great_axe_iron", () ->
            new SowAxeItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SCARRED_IRON_SWORD = register("scarred_iron_sword", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SCYTHE_IRON = register("scythe_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, 1.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SHADOW_BLAZER_CLAW = register("shadow_blazer_claw", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -2.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SHADOW_SPEAR_IRON = register("shadow_spear_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SHORT_SWORD_IRON = register("short_sword_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 0, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SICKLE_IRON = register("sickle_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowAxeItem> SINGLE_HEADED_BATTLE_AXE_IRON = register("single_headed_battle_axe_iron", () ->
            new SowAxeItem(ToolMaterials.IRON, 2, -2f, s -> s));
    public static final RegistrySupplier<SowAxeItem> SMALL_IRON_AXE = register("small_iron_axe", () ->
            new SowAxeItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowAxeItem> SMALL_IRON_BATTLEAXE = register("small_iron_battleaxe", () ->
            new SowAxeItem(ToolMaterials.IRON, 2, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SMALL_IRON_SCYTHE = register("small_iron_scythe", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_BLADE_IRON = register("spear_blade_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_HEAVY_IRON = register("spear_heavy_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_IRON = register("spear_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_IRON_1 = register("spear_iron_1", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_IRON_3 = register("spear_iron_3", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_IRON_4 = register("spear_iron_4", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_LIGHT_IRON = register("spear_light_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPLIT_IRON_SWORD = register("split_iron_sword", () ->
            new SowSwordItem(ToolMaterials.IRON, 2, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_HONOR_GUARD_IRON = register("staff_honor_guard_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON = register("staff_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON_1 = register("staff_iron_1", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON_10 = register("staff_iron_10", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON_11 = register("staff_iron_11", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON_12 = register("staff_iron_12", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON_2 = register("staff_iron_2", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON_3 = register("staff_iron_3", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON_4 = register("staff_iron_4", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON_5 = register("staff_iron_5", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON_6 = register("staff_iron_6", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON_7 = register("staff_iron_7", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON_8 = register("staff_iron_8", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_IRON_9 = register("staff_iron_9", () ->
            new SowSwordItem(ToolMaterials.IRON, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_GUARD_IRON = register("sword_guard_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON = register("sword_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_1 = register("sword_iron_1", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_10 = register("sword_iron_10", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_11 = register("sword_iron_11", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_12 = register("sword_iron_12", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_13 = register("sword_iron_13", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_14 = register("sword_iron_14", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_15 = register("sword_iron_15", () ->
            new SowSwordItem(ToolMaterials.IRON, 0, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_2 = register("sword_iron_2", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_3 = register("sword_iron_3", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_4 = register("sword_iron_4", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_5 = register("sword_iron_5", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_6 = register("sword_iron_6", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_7 = register("sword_iron_7", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_8 = register("sword_iron_8", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_IRON_9 = register("sword_iron_9", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_SPLIT_IRON = register("sword_split_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> AXE_STUBBY = register("axe_stubby", () ->
            new SowSwordItem(ToolMaterials.IRON, 2, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_ARDONI_HONOR_IRON = register("staff_ardoni_honor_iron", () ->
            new SowSwordItem(ToolMaterials.IRON, 1, -1, s -> s));

    //golden weapons
    public static final RegistrySupplier<SowSwordItem> TRB_GRAPHICS_SWORD_GOLD = register("trb_graphics_sword_gold", () ->
            new SowSwordItem(ToolMaterials.GOLD, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_GOLD = register("staff_gold", () ->
            new SowSwordItem(ToolMaterials.GOLD, 0, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> STAFF_HONOR_GUARD_GOLD = register("staff_honor_guard_gold", () ->
            new SowSwordItem(ToolMaterials.GOLD, 0, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_GOLD = register("sword_gold", () ->
            new SowSwordItem(ToolMaterials.GOLD, 1, -0.5f, s -> s));

    //stone weapons
    public static final RegistrySupplier<SowSwordItem> DAGGER_STONE = register("dagger_stone", () ->
            new SowSwordItem(ToolMaterials.STONE, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> HALBERD_STONE = register("halberd_stone", () ->
            new SowSwordItem(ToolMaterials.STONE, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> TRB_GRAPHICS_SPIKE_MACE_STONE = register("trb_graphics_spike_mace_stone", () ->
            new SowSwordItem(ToolMaterials.STONE, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SPEAR_LIGHT_STONE = register("spear_light_stone", () ->
            new SowSwordItem(ToolMaterials.STONE, -1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_STONE = register("sword_stone", () ->
            new SowSwordItem(ToolMaterials.STONE, 1, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_STONE_1 = register("sword_stone_1", () ->
            new SowSwordItem(ToolMaterials.STONE, 0, -0.5f, s -> s));
    public static final RegistrySupplier<SowSwordItem> SWORD_STONE_2 = register("sword_stone_2", () ->
            new SowSwordItem(ToolMaterials.STONE, 1, -0.5f, s -> s));

    //other weapons
    public static final RegistrySupplier<SowSwordItem> ENDER_BLADE = register("ender_blade", () ->
            new SowSwordItem(ToolMaterials.NETHERITE, 1, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> ENDER_SWORD = register("ender_sword", () ->
            new SowSwordItem(ToolMaterials.NETHERITE, 1, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> FIRE_SWORD = register("fire_sword", () ->
            new SowSwordItem(ToolMaterials.NETHERITE, 1, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> FIRE_SWORD_1 = register("fire_sword_1", () ->
            new SowSwordItem(ToolMaterials.NETHERITE, 1, -2f, s -> s));
    public static final RegistrySupplier<SowSwordItem> NETHER_BLADE = register("nether_blade", () ->
            new SowSwordItem(ToolMaterials.NETHERITE, 1, -2f, s -> s));

    public static <T extends Item & SowWeapon> RegistrySupplier<T> register(String id, Supplier<T> weapon) {
        return REGISTRY.register(id, weapon);
    }
}
