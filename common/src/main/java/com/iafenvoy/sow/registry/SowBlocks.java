package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.ArdoniGraveItem;
import com.iafenvoy.sow.item.SongCubeItem;
import com.iafenvoy.sow.item.TemporaryBlockItem;
import com.iafenvoy.sow.item.block.*;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;
import java.util.function.Supplier;

public final class SowBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.BLOCK);
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.ITEM);

    public static final RegistrySupplier<PeasBlock> PEAS = register("peas", PeasBlock::new, block -> new BlockItem(block, new Item.Settings().arch$tab(SowItemGroups.PEAS_DELIGHT)));
    public static final RegistrySupplier<ArdoniGraveBlock> ARDONI_GRAVE = register("ardoni_grave", ArdoniGraveBlock::new, ArdoniGraveItem::new);
    public static final RegistrySupplier<WallsOfTimeBlock> WALLS_OF_TIME = register("walls_of_time", () -> new WallsOfTimeBlock(AbstractBlock.Settings.create()), block -> new BlockItem(block, new Item.Settings().arch$tab(SowItemGroups.ITEMS)));

    public static final RegistrySupplier<SongCubeBlock> AGGRESSIUM_SONG = register("aggressium_song", () -> new SongCubeBlock(SowAbilityCategory.AGGRESSIUM), SongCubeItem::new);
    public static final RegistrySupplier<SongCubeBlock> MOBILIUM_SONG = register("mobilium_song", () -> new SongCubeBlock(SowAbilityCategory.MOBILIUM), SongCubeItem::new);
    public static final RegistrySupplier<SongCubeBlock> PROTISIUM_SONG = register("protisium_song", () -> new SongCubeBlock(SowAbilityCategory.PROTISIUM), SongCubeItem::new);
    public static final RegistrySupplier<SongCubeBlock> SUPPORTIUM_SONG = register("supportium_song", () -> new SongCubeBlock(SowAbilityCategory.SUPPORTIUM), SongCubeItem::new);
    //Fake Blocks, should not use in game without song power.
    public static final RegistrySupplier<TemporaryTransparentBlock> MOBILIBOUNCE_PLATFORM = register("mobilibounce_platform", () -> new TemporaryTransparentBlock(p -> p.jumpVelocityMultiplier(3)), TemporaryBlockItem::new);
    public static final RegistrySupplier<TemporaryTransparentBlock> PROTE_BARRIER = register("prote_barrier", () -> new TemporaryTransparentBlock(p -> p), TemporaryBlockItem::new);

    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> block, Function<T, Item> itemBuilder) {
        RegistrySupplier<T> r = REGISTRY.register(id, block);
        ITEM_REGISTRY.register(id, () -> itemBuilder.apply(r.get()));
        return r;
    }
}
