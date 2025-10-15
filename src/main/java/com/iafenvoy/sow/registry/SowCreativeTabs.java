package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.sow.Proxies;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;
import java.util.stream.Stream;

public final class SowCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SongsOfWar.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEMS = REGISTRY.register("items", () -> CreativeModeTab
            .builder()
            .title(Component.translatable("itemGroup." + SongsOfWar.MOD_ID + ".items"))
            .icon(() -> new ItemStack(SowItems.ENCHANTMENT_FRAGMENT_RED.get()))
            .displayItems((params, builder) -> {
                SowItems.REGISTRY.getEntries().stream().map(DeferredHolder::get).forEach(builder::accept);
                SowBanners.ALL.stream().map(x -> x.apply(params.holders().lookupOrThrow(Registries.BANNER_PATTERN))).forEach(builder::accept);
            })
            .build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WEAPONS = REGISTRY.register("weapons", () -> CreativeModeTab
            .builder()
            .title(Component.translatable("itemGroup." + SongsOfWar.MOD_ID + ".weapons"))
            .icon(() -> {
                ItemStack stack = new ItemStack(SowWeapons.SWORD_INGRESSSUS.get());
                return Proxies.reforgedStoneProxy.apply(stack, "red", true);
            })
            .displayItems(SowWeapons.REGISTRY.getEntries())
            .build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOBS = REGISTRY.register("mobs", () -> CreativeModeTab
            .builder()
            .title(Component.translatable("itemGroup." + SongsOfWar.MOD_ID + ".mobs"))
            .icon(() -> new ItemStack(SowSkulls.INGRESSSUS_HEAD.get()))
            .displayItems(Stream.concat(SowSpawnEggs.REGISTRY.getEntries().stream(), SowSkulls.ITEM_REGISTRY.getEntries().stream()).toList())
            .build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> POWER = REGISTRY.register("power", () -> CreativeModeTab
            .builder()
            .title(Component.translatable("itemGroup." + SongsOfWar.MOD_ID + ".power"))
            .icon(() -> new ItemStack(SowBlocks.AGGRESSIUM_SONG.get()))
            .displayItems((params, builder) -> SowAbilityCategories.REGISTRY.getEntries()
                    .stream()
                    .map(DeferredHolder::get)
                    .map(AbilityCategory::getAbilities)
                    .flatMap(Collection::stream)
                    .map(SongCubeBlock::getStack)
                    .forEach(builder::accept)
            ).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PEAS_DELIGHT = REGISTRY.register("peas_delight", () -> CreativeModeTab
            .builder()
            .title(Component.translatable("itemGroup." + SongsOfWar.MOD_ID + ".peas_delight"))
            .icon(() -> new ItemStack(SowDelight.PEAS.get()))
            .displayItems(SowDelight.ITEM_REGISTRY.getEntries())
            .build());
}
