package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.WrittenBookContent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WallsOfTimeBlock extends BaseEntityBlock {
    private static final MapCodec<WallsOfTimeBlock> CODEC = simpleCodec(WallsOfTimeBlock::new);

    public WallsOfTimeBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new WallsOfTimeBlockEntity(pos, state);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, BlockHitResult hitResult) {
        Direction direction = hitResult.getDirection();
        if (level.getBlockEntity(pos) instanceof WallsOfTimeBlockEntity blockEntity)
            if (stack.is(Items.WRITTEN_BOOK) && direction.getAxis() != Direction.Axis.Y) {
                WrittenBookContent content = stack.get(DataComponents.WRITTEN_BOOK_CONTENT);
                if (content != null) {
                    blockEntity.getContents().withContent(stack.copy()).withDirection(hitResult.getDirection());
                    level.sendBlockUpdated(pos, state, state, 0);
                    return ItemInteractionResult.SUCCESS;
                }
            } else if (stack.is(Items.WRITABLE_BOOK)) {
                player.setItemInHand(hand, blockEntity.getContents().getContent().copy());
                return ItemInteractionResult.SUCCESS;
            }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
}
