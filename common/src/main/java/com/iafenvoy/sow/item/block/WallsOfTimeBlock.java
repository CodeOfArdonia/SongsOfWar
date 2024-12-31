package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import com.iafenvoy.sow.util.BookUtils;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
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
        if (stack.isOf(Items.WRITTEN_BOOK)) {
            NbtList nbtList = stack.getOrCreateNbt().getList("pages", 8);
            if (nbtList != null) {
                SongsOfWar.LOGGER.info(BookUtils.nbtToString(nbtList));
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
