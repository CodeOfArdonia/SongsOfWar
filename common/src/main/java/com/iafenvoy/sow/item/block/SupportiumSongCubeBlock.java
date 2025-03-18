package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.item.block.entity.SupportiumSongCubeBlockEntity;
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class SupportiumSongCubeBlock extends AbstractSongCubeBlock {
    public SupportiumSongCubeBlock() {
        super(SowAbilityCategories.SUPPORTIUM);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SupportiumSongCubeBlockEntity(pos, state);
    }
}
