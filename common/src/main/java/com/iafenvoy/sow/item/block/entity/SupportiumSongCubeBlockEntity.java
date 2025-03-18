package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.sow.registry.SowBlockEntities;
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class SupportiumSongCubeBlockEntity extends AbstractSongCubeBlockEntity {
    public SupportiumSongCubeBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.SUPPORTIUM_SONG_TYPE.get(), pos, state);
    }

    @Override
    public AbilityCategory getCategory() {
        return SowAbilityCategories.SUPPORTIUM;
    }
}
