package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.block.entity.ArdoniGraveBlockEntity;
import com.iafenvoy.sow.item.block.entity.SongCubeBlockEntity;
import com.iafenvoy.sow.item.block.entity.TemporaryTransparentBlockEntity;
import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Supplier;

public final class SowBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(SongsOfWar.MOD_ID, RegistryKeys.BLOCK_ENTITY_TYPE);
    //Block Entity
    public static final RegistrySupplier<BlockEntityType<ArdoniGraveBlockEntity>> ARDONI_GRAVE = register("ardoni_grave", () -> BlockEntityType.Builder.create(ArdoniGraveBlockEntity::new, SowBlocks.ARDONI_GRAVE.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<WallsOfTimeBlockEntity>> WALLS_OF_TIME = register("walls_of_time", () -> BlockEntityType.Builder.create(WallsOfTimeBlockEntity::new, SowBlocks.WALLS_OF_TIME.get()).build(null));

    public static final RegistrySupplier<BlockEntityType<SongCubeBlockEntity>> SONG_CUBE = register("song_cube", () -> BlockEntityType.Builder.create(SongCubeBlockEntity::new, SowBlocks.AGGRESSIUM_SONG.get(), SowBlocks.MOBILIUM_SONG.get(), SowBlocks.PROTISIUM_SONG.get(), SowBlocks.SUPPORTIUM_SONG.get()).build(null));
    //Fake Blocks, should not use in game without song power.
    public static final RegistrySupplier<BlockEntityType<TemporaryTransparentBlockEntity>> TEMPORARY = register("temporary", () -> BlockEntityType.Builder.create(TemporaryTransparentBlockEntity::new, SowBlocks.MOBILIBOUNCE_PLATFORM.get(), SowBlocks.PROTE_BARRIER.get()).build(null));

    private static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(String id, Supplier<BlockEntityType<T>> block) {
        return REGISTRY.register(id, block);
    }
}
