package com.iafenvoy.sow.world;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.mixin.StructureTemplateAccessor;
import com.iafenvoy.sow.registry.SowTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.List;
import java.util.Optional;

public class ShrineStructureHelper {
    private static List<StructureTemplate.StructureBlockInfo> getBlocks(ServerLevel world) {
        Optional<StructureTemplate> optional = world.getServer().getStructureManager().get(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "shrine"));
        if (optional.isEmpty()) {
            SongsOfWar.LOGGER.error("Cannot get shrine structure file!");
            return List.of();
        }
        List<StructureTemplate.Palette> templates = ((StructureTemplateAccessor) optional.get()).getPalettes();
        if (templates.isEmpty()) {
            SongsOfWar.LOGGER.error("Wait what? Where is my shrine structure?");
            return List.of();
        }
        return templates.getFirst().blocks();
    }

    public static boolean match(BlockPos playerPos, ServerLevel world) {
        if (!world.getBlockState(playerPos.below()).is(Blocks.CHISELED_STONE_BRICKS)) return false;
        List<StructureTemplate.StructureBlockInfo> blocks = getBlocks(world);
        if (blocks.isEmpty()) return false;
        playerPos = playerPos.offset(-7, -1, -7);
        for (StructureTemplate.StructureBlockInfo block : blocks) {
            BlockPos pos = playerPos.offset(block.pos());
            BlockState state = world.getBlockState(pos);
            if (block.state().isAir()) {
                if (state.isCollisionShapeFullBlock(world, pos) && !state.is(BlockTags.LEAVES)) return false;
            } else if (block.state().is(Blocks.STONE_BRICKS)) {
                if (!state.is(SowTags.STONE_BRICKS)) return false;
            } else if (block.state().is(Blocks.STONE_BRICK_STAIRS)) {
                if (!state.is(SowTags.STONE_BRICK_STAIRS) || !stateEqual(block.state(), state)) return false;
            } else {
                if (!state.is(block.state().getBlock())) return false;
            }
        }
        return true;
    }

    public static void generate(BlockPos origin, ServerLevel world) {
        List<StructureTemplate.StructureBlockInfo> blocks = getBlocks(world);
        origin = origin.offset(-7, -1, -7);
        for (StructureTemplate.StructureBlockInfo block : blocks) {
            BlockPos pos = origin.offset(block.pos());
            world.setBlockAndUpdate(pos, block.state());
        }
    }

    public static boolean stateEqual(BlockState state1, BlockState state2) {
        if (!(state1.getBlock() instanceof StairBlock) || !(state2.getBlock() instanceof StairBlock)) return false;
        if (state1.getValue(StairBlock.WATERLOGGED) ^ state2.getValue(StairBlock.WATERLOGGED)) return false;
        if (state1.getValue(StairBlock.HALF) != state2.getValue(StairBlock.HALF)) return false;
        Direction dir1 = state1.getValue(StairBlock.FACING), dir2 = state2.getValue(StairBlock.FACING);
        StairsShape shape1 = state1.getValue(StairBlock.SHAPE), shape2 = state2.getValue(StairBlock.SHAPE);
        if (shape1 == shape2) return dir1 == dir2;
        if (shape1 == StairsShape.STRAIGHT || shape2 == StairsShape.STRAIGHT) return false;
        if (shape1 == StairsShape.INNER_LEFT) {
            if (shape2 != StairsShape.INNER_RIGHT) return false;
            return dir1.getCounterClockWise() == dir2;
        }
        if (shape1 == StairsShape.INNER_RIGHT) {
            if (shape2 != StairsShape.INNER_LEFT) return false;
            return dir1.getClockWise() == dir2;
        }
        if (shape1 == StairsShape.OUTER_LEFT) {
            if (shape2 != StairsShape.OUTER_RIGHT) return false;
            return dir1.getCounterClockWise() == dir2;
        }
        if (shape1 == StairsShape.OUTER_RIGHT) {
            if (shape2 != StairsShape.OUTER_LEFT) return false;
            return dir1.getClockWise() == dir2;
        }
        return false;
    }
}
