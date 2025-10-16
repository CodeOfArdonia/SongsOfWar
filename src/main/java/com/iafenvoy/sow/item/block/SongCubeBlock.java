package com.iafenvoy.sow.item.block;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.type.Ability;
import com.iafenvoy.sow.Constants;
import com.iafenvoy.sow.Proxies;
import com.iafenvoy.sow.item.SongCubeItem;
import com.iafenvoy.sow.item.block.entity.SongCubeBlockEntity;
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;

public class SongCubeBlock extends BaseEntityBlock {
    private static final MapCodec<SongCubeBlock> CODEC = simpleCodec(x -> new SongCubeBlock(SowAbilityCategories.AGGRESSIUM));
    public static final List<SongCubeBlock> BLOCKS = new LinkedList<>();
    private final DeferredHolder<AbilityCategory, AbilityCategory> category;

    public SongCubeBlock(DeferredHolder<AbilityCategory, AbilityCategory> category) {
        super(Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion().emissiveRendering((state, world, pos) -> true).lightLevel(state -> 15).instabreak().noLootTable());
        this.category = category;
        BLOCKS.add(this);
    }

    @Override
    public void playerDestroy(@NotNull Level world, @NotNull Player player, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable BlockEntity blockEntity, @NotNull ItemStack tool) {
        super.playerDestroy(world, player, pos, state, blockEntity, tool);
        if (blockEntity instanceof SongCubeBlockEntity songCubeBlockEntity) {
            Ability<?> power = songCubeBlockEntity.getPower();
            popResource(world, pos, SongCubeItem.getStack(power));
        }
    }

    public AbilityCategory getCategory() {
        return this.category.get();
    }

    public static Block getBlock(AbilityCategory category) {
        return BLOCKS.stream().filter(x -> x.category.get() == category).findFirst().map(Block.class::cast).orElse(Blocks.AIR);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Shapes.box(0.375, 0, 0.375, 0.625, 0.25, 0.625);
    }

    @Override
    public @NotNull VoxelShape getInteractionShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos) {
        return Shapes.box(0.375, 0, 0.375, 0.625, 0.25, 0.625);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        Ability<?> power = SongCubeItem.getPower(stack);
        tooltipComponents.add(this.category.get().appendColor(Component.translatable(power.getTranslateKey())));
        Constants.LAST_SONG_POWER_TOOLTIP = power.getTranslateKey();
        if (power.isExperimental()) tooltipComponents.add(Component.translatable("item.sow.song.experimental"));
    }

    @Override
    public void setPlacedBy(@NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity placer, @NotNull ItemStack itemStack) {
        super.setPlacedBy(world, pos, state, placer, itemStack);
        if (world.getBlockEntity(pos) instanceof SongCubeBlockEntity blockEntity)
            blockEntity.setPower(SongCubeItem.getPower(itemStack));
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull BlockState state, @NotNull HitResult target, @NotNull LevelReader level, @NotNull BlockPos pos, @NotNull Player player) {
        ItemStack stack = super.getCloneItemStack(state, target, level, pos, player);
        if (level.getBlockEntity(pos) instanceof SongCubeBlockEntity blockEntity)
            SongCubeItem.appendComponent(blockEntity.getPower(), stack);
        return stack;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new SongCubeBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level world, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof SongCubeBlockEntity songCubeBlockEntity)
                Proxies.songCubeSoundManager.startPlaying(songCubeBlockEntity.getBlockPos(), songCubeBlockEntity.getCategory());
        };
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
}
