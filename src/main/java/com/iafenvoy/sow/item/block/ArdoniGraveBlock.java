package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.item.block.entity.ArdoniGraveBlockEntity;
import com.iafenvoy.sow.registry.SowTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArdoniGraveBlock extends HorizontalDirectionalBlock implements EntityBlock {
    private static final MapCodec<ArdoniGraveBlock> CODEC = simpleCodec(x -> new ArdoniGraveBlock());
    public static final BooleanProperty ACTIVATED = BooleanProperty.create("activated");

    public ArdoniGraveBlock() {
        super(Properties.ofFullCopy(Blocks.STONE).lightLevel(state -> state.getValue(ACTIVATED) ? 15 : 0).emissiveRendering((state, world, pos) -> state.getValue(ACTIVATED)));
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(ACTIVATED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, ACTIVATED);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new ArdoniGraveBlockEntity(pos, state);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (player.getItemInHand(hand).is(SowTags.MASTER_STAFF)) {
            boolean activated = state.getValue(ACTIVATED);
            level.setBlockAndUpdate(pos, state.setValue(ACTIVATED, !activated));
            return ItemInteractionResult.SUCCESS;
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> Shapes.box(0.25, 0, 0.75, 0.75, 0.75, 0.875);
            case SOUTH -> Shapes.box(0.25, 0, 0.125, 0.75, 0.75, 0.25);
            case WEST -> Shapes.box(0.75, 0, 0.25, 0.875, 0.75, 0.75);
            case EAST -> Shapes.box(0.125, 0, 0.25, 0.25, 0.75, 0.75);
            case DOWN, UP -> Shapes.empty();
        };
    }

    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
}
