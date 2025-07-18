package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.compat.ReforgeStoneApi;
import com.iafenvoy.sow.SongsOfWar;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public final class SowItemGroups {
    public static final DeferredRegister<ItemGroup> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM_GROUP);

    public static final RegistrySupplier<ItemGroup> ITEMS = REGISTRY.register("items", () -> CreativeTabRegistry.create(Text.translatable("itemGroup." + SongsOfWar.MOD_ID + ".items"), () -> new ItemStack(SowItems.ENCHANTMENT_FRAGMENT_RED.get())));
    public static final RegistrySupplier<ItemGroup> WEAPONS = REGISTRY.register("weapons", () -> CreativeTabRegistry.create(Text.translatable("itemGroup." + SongsOfWar.MOD_ID + ".weapons"), () -> {
        ItemStack stack = new ItemStack(SowWeapons.SWORD_INGRESSSUS.get());
        return ReforgeStoneApi.apply(stack, "red", true);
    }));
    public static final RegistrySupplier<ItemGroup> MOBS = REGISTRY.register("mobs", () -> CreativeTabRegistry.create(Text.translatable("itemGroup." + SongsOfWar.MOD_ID + ".mobs"), () -> new ItemStack(SowSkulls.INGRESSSUS_HEAD.get())));
    public static final RegistrySupplier<ItemGroup> POWER = REGISTRY.register("power", () -> CreativeTabRegistry.create(Text.translatable("itemGroup." + SongsOfWar.MOD_ID + ".power"), () -> new ItemStack(SowBlocks.AGGRESSIUM_SONG.get())));
    public static final RegistrySupplier<ItemGroup> PEAS_DELIGHT = REGISTRY.register("peas_delight", () -> CreativeTabRegistry.create(Text.translatable("itemGroup." + SongsOfWar.MOD_ID + ".peas_delight"), () -> new ItemStack(SowBlocks.PEAS.get())));
}
