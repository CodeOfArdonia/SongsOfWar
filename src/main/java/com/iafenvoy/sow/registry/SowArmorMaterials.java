package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.List;

public final class SowArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> REGISTRY = DeferredRegister.create(Registries.ARMOR_MATERIAL, SongsOfWar.MOD_ID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ENDER_KNIGHT = REGISTRY.register("ender_knight", () -> new ArmorMaterial(
            Util.make(new HashMap<>(), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
            }), 20, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(Items.OBSIDIAN), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "ender_knight"))), 3.5F, 0.5F
    ));
}
