package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class SowDataComponents {
    public static final DeferredRegister<DataComponentType<?>> REGISTRY = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, SongsOfWar.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Float>> SONG_STONE_NEAR = REGISTRY.register("song_stone_near", () -> DataComponentType.<Float>builder().persistent(Codec.FLOAT).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<WallsOfTimeBlockEntity.EditType>> WOT_EDIT_TYPE = REGISTRY.register("wot_edit_type", () -> DataComponentType.<WallsOfTimeBlockEntity.EditType>builder().persistent(WallsOfTimeBlockEntity.EditType.CODEC).build());
}
