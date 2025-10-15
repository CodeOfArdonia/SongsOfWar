package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.ArdoniGraveItem;
import com.iafenvoy.sow.item.SongCubeItem;
import com.iafenvoy.sow.item.TemporaryBlockItem;
import com.iafenvoy.sow.item.block.*;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public final class SowBlocks {
    public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(SongsOfWar.MOD_ID);

    public static final DeferredBlock<ArdoniGraveBlock> ARDONI_GRAVE = register("ardoni_grave", ArdoniGraveBlock::new, ArdoniGraveItem::new);
    public static final DeferredBlock<WallsOfTimeBlock> WALLS_OF_TIME = register("walls_of_time", () -> new WallsOfTimeBlock(BlockBehaviour.Properties.of()), block -> new BlockItem(block, new Item.Properties()));

    public static final DeferredBlock<SongCubeBlock> AGGRESSIUM_SONG = register("aggressium_song", () -> new SongCubeBlock(SowAbilityCategory.AGGRESSIUM), SongCubeItem::new);
    public static final DeferredBlock<SongCubeBlock> MOBILIUM_SONG = register("mobilium_song", () -> new SongCubeBlock(SowAbilityCategory.MOBILIUM), SongCubeItem::new);
    public static final DeferredBlock<SongCubeBlock> PROTISIUM_SONG = register("protisium_song", () -> new SongCubeBlock(SowAbilityCategory.PROTISIUM), SongCubeItem::new);
    public static final DeferredBlock<SongCubeBlock> SUPPORTIUM_SONG = register("supportium_song", () -> new SongCubeBlock(SowAbilityCategory.SUPPORTIUM), SongCubeItem::new);
    //Fake Blocks, should not use in game without song power.
    public static final DeferredBlock<TemporaryTransparentBlock> MOBILIBOUNCE_PLATFORM = register("mobilibounce_platform", () -> new TemporaryTransparentBlock(p -> p.jumpFactor(3)), TemporaryBlockItem::new);
    public static final DeferredBlock<TemporaryTransparentBlock> PROTE_BARRIER = register("prote_barrier", () -> new TemporaryTransparentBlock(p -> p), TemporaryBlockItem::new);

    private static <T extends Block> DeferredBlock<T> register(String id, Supplier<T> block, Function<T, Item> itemBuilder) {
        DeferredBlock<T> r = REGISTRY.register(id, block);
        SowItems.REGISTRY.register(id, () -> itemBuilder.apply(r.get()));
        return r;
    }
}
