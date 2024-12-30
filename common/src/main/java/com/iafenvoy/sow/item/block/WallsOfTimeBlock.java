package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class WallsOfTimeBlock extends BlockWithEntity {
    private static final Identifier FONT_ID = Identifier.of("minecraft", "alt");

    public WallsOfTimeBlock(Settings settings) {
        super(settings);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WallsOfTimeBlockEntity(pos, state);
    }
}
