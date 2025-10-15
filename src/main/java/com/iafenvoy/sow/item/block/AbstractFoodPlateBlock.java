package com.iafenvoy.sow.item.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public abstract class AbstractFoodPlateBlock<T extends Enum<T> & AbstractFoodPlateBlock.FoodType> extends HorizontalDirectionalBlock {
    protected static final IntegerProperty ITEM_COUNT = IntegerProperty.create("item_count", 0, 5);

    public AbstractFoodPlateBlock(Function<Properties, Properties> settings) {
        super(settings.apply(Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(ITEM_COUNT, 0).setValue(this.getFoodTypeProperty(), this.getDefaultFoodType()));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, ITEM_COUNT, this.getFoodTypeProperty());
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        ItemStack inHand = player.getItemInHand(hand);
        int i = state.getValue(ITEM_COUNT);
        EnumProperty<T> foodType = this.getFoodTypeProperty();
        T defaultType = this.getDefaultFoodType();
        FoodType type = state.getValue(foodType);
        if (inHand.isEmpty()) {
            if (type == defaultType || i == 0)
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            else {
                player.setItemInHand(hand, new ItemStack(type.getItem()));
                if (i > 1) level.setBlock(pos, state.setValue(ITEM_COUNT, i - 1), 3);
                else level.setBlock(pos, state.setValue(ITEM_COUNT, 0).setValue(foodType, defaultType), 3);
                return ItemInteractionResult.SUCCESS;
            }
        } else {
            T target = this.getFoodTypeFromItem(inHand.getItem());
            if (target != defaultType && (type == defaultType || type == target) && i < target.getMaxPlacement()) {
                level.setBlock(pos, state.setValue(ITEM_COUNT, i + 1).setValue(foodType, target), 3);
                inHand.shrink(1);
                return ItemInteractionResult.SUCCESS;
            }
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public void playerDestroy(@NotNull Level world, @NotNull Player player, @NotNull BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, @NotNull ItemStack tool) {
        popResource(world, pos, new ItemStack(state.getValue(this.getFoodTypeProperty()).getItem(), state.getValue(ITEM_COUNT)));
        super.playerDestroy(world, player, pos, state, blockEntity, tool);
    }

    protected abstract EnumProperty<T> getFoodTypeProperty();

    protected abstract T getDefaultFoodType();

    protected abstract T getFoodTypeFromItem(Item item);

    protected interface FoodType extends StringRepresentable {
        Item getItem();

        int getMaxPlacement();
    }
}
