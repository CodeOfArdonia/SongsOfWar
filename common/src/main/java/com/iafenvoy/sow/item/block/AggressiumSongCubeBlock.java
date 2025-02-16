package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.item.block.entity.AggressiumSongCubeBlockEntity;
import com.iafenvoy.sow.registry.power.SowPowerCategories;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class AggressiumSongCubeBlock extends AbstractSongCubeBlock {
    public AggressiumSongCubeBlock() {
        super(SowPowerCategories.AGGRESSIUM);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AggressiumSongCubeBlockEntity(pos, state);
    }
}
