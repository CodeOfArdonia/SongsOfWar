package com.iafenvoy.sow.item.block;

import com.iafenvoy.sow.Proxies;
import com.iafenvoy.sow.item.block.entity.AbstractSongCubeBlockEntity;
import com.iafenvoy.sow.power.PowerCategory;
import com.iafenvoy.sow.power.type.AbstractSongPower;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractSongCubeBlock extends BlockWithEntity {
    public static final Map<PowerCategory, ItemConvertible> SONGS = new HashMap<>();
    public static final String POWER_TYPE_KEY = "power_type";
    private final PowerCategory category;

    public AbstractSongCubeBlock(PowerCategory category) {
        super(Settings.copy(Blocks.BEDROCK).nonOpaque().emissiveLighting((state, world, pos) -> true).luminance(state -> 15).breakInstantly().dropsNothing());
        this.category = category;
        SONGS.put(category, this);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.afterBreak(world, player, pos, state, blockEntity, tool);
        if (blockEntity instanceof AbstractSongCubeBlockEntity songCubeBlockEntity)
            dropStack(world, pos, songCubeBlockEntity.getPower().getStack());
    }

    public PowerCategory getCategory() {
        return this.category;
    }

    public AbstractSongPower<?> getPower(ItemStack stack) {
        return this.category.getPowerById(stack.getOrCreateNbt().getString(POWER_TYPE_KEY));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.375, 0, 0.375, 0.625, 0.25, 0.625);
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.cuboid(0.375, 0, 0.375, 0.625, 0.25, 0.625);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        super.appendTooltip(stack, world, tooltip, options);
        AbstractSongPower<?> power = this.getPower(stack);
        tooltip.add(this.category.appendColor(Text.translatable(power.getTranslateKey())));
        if (power.isExperimental())
            tooltip.add(Text.translatable("item.sow.song.experimental"));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (world.getBlockEntity(pos) instanceof AbstractSongCubeBlockEntity blockEntity)
            blockEntity.setPower(this.getPower(itemStack));
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        ItemStack stack = super.getPickStack(world, pos, state);
        if (world.getBlockEntity(pos) instanceof AbstractSongCubeBlockEntity blockEntity)
            blockEntity.getPower().appendNbt(stack);
        return stack;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof AbstractSongCubeBlockEntity songCubeBlockEntity)
                Proxies.songCubeSoundManager.startPlaying(songCubeBlockEntity.getPos(), songCubeBlockEntity.getCategory());
        };
    }
}
