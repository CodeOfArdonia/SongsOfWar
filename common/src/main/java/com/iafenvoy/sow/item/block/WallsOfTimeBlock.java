package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WallsOfTimeBlock extends BlockWithEntity {
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

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        Direction direction = hit.getSide();
        if (world.getBlockEntity(pos) instanceof WallsOfTimeBlockEntity blockEntity)
            if (stack.isOf(Items.WRITTEN_BOOK) && direction.getAxis() != Direction.Axis.Y) {
                NbtList nbtList = stack.getOrCreateNbt().getList("pages", 8);
                if (nbtList != null) {
                    blockEntity.getContents().withContent(stack.copy()).withDirection(hit.getSide());
                    return ActionResult.SUCCESS;
                }
            } else if (stack.isOf(Items.WRITABLE_BOOK)) {
                player.setStackInHand(hand, blockEntity.getContents().getContent().copy());
                return ActionResult.SUCCESS;
            }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.afterBreak(world, player, pos, state, blockEntity, tool);
    }
}
