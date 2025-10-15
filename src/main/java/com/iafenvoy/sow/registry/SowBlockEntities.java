package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.block.entity.ArdoniGraveBlockEntity;
import com.iafenvoy.sow.item.block.entity.SongCubeBlockEntity;
import com.iafenvoy.sow.item.block.entity.TemporaryTransparentBlockEntity;
import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class SowBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, SongsOfWar.MOD_ID);
    //Block Entity
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ArdoniGraveBlockEntity>> ARDONI_GRAVE = register("ardoni_grave", () -> BlockEntityType.Builder.of(ArdoniGraveBlockEntity::new, SowBlocks.ARDONI_GRAVE.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WallsOfTimeBlockEntity>> WALLS_OF_TIME = register("walls_of_time", () -> BlockEntityType.Builder.of(WallsOfTimeBlockEntity::new, SowBlocks.WALLS_OF_TIME.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SongCubeBlockEntity>> SONG_CUBE = register("song_cube", () -> BlockEntityType.Builder.of(SongCubeBlockEntity::new, SowBlocks.AGGRESSIUM_SONG.get(), SowBlocks.MOBILIUM_SONG.get(), SowBlocks.PROTISIUM_SONG.get(), SowBlocks.SUPPORTIUM_SONG.get()).build(null));
    //Fake Blocks, should not use in game without song power.
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TemporaryTransparentBlockEntity>> TEMPORARY = register("temporary", () -> BlockEntityType.Builder.of(TemporaryTransparentBlockEntity::new, SowBlocks.MOBILIBOUNCE_PLATFORM.get(), SowBlocks.PROTE_BARRIER.get()).build(null));

    private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String id, Supplier<BlockEntityType<T>> block) {
        return REGISTRY.register(id, block);
    }
}
