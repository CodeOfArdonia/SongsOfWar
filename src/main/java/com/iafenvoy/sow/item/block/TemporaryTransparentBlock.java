package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.item.block.entity.TemporaryTransparentBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class TemporaryTransparentBlock extends TransparentBlock implements EntityBlock {
    public TemporaryTransparentBlock(Function<Properties, Properties> settings) {
        super(settings.apply(Properties.ofFullCopy(Blocks.GLASS)));
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new TemporaryTransparentBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level world, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> TemporaryTransparentBlockEntity.tick(world1, pos, state1, (TemporaryTransparentBlockEntity) blockEntity);
    }

    public static void place(Level world, BlockPos pos, BlockState state, int tick) {
        BlockState s = world.getBlockState(pos);
        world.setBlockAndUpdate(pos, state);
        if (world.getBlockEntity(pos) instanceof TemporaryTransparentBlockEntity blockEntity) {
            blockEntity.setTick(tick);
            blockEntity.setState(s);
        }
    }

    @Override
    public void fallOn(@NotNull Level world, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull Entity entity, float fallDistance) {
        if (this.getJumpFactor() <= 2) super.fallOn(world, state, pos, entity, fallDistance);
    }
}
