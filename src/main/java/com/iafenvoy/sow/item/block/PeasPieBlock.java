package com.iafenvoy.sow.item.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PeasPieBlock extends FoodBlockWithPiece {
    private static final List<VoxelShape> SHAPES = List.of(
            Shapes.box(0.5, 0, 0.125, 0.875, 0.25, 0.5),
            Shapes.box(0.125, 0, 0.125, 0.5, 0.25, 0.5),
            Shapes.box(0.125, 0, 0.5, 0.5, 0.25, 0.875),
            Shapes.box(0.5, 0, 0.5, 0.875, 0.25, 0.875)
    );

    public PeasPieBlock() {
        super(p -> p, 3, new FoodProperties.Builder().nutrition(6).saturationModifier(0.33f).build());
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        VoxelShape shape = Shapes.empty();
        for (int i = 3 - state.getValue(BITES); i >= 0; i--)
            shape = Shapes.or(shape, SHAPES.get(i));
        return shape;
    }

    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos) {
        return Shapes.box(0, 0, 0, 0, 0, 0);
    }
}
