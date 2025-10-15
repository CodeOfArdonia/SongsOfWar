package com.iafenvoy.sow.item.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.fml.ModList;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;

public class FoodBlockWithPiece extends Block {
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 3);
    private final int maxBite;
    private final FoodProperties food;

    public FoodBlockWithPiece(Function<Properties, Properties> settings, int maxBite, FoodProperties food) {
        super(settings.apply(Properties.ofFullCopy(Blocks.CAKE)));
        this.maxBite = maxBite;
        this.food = food;
        this.registerDefaultState(this.getStateDefinition().any().setValue(BITES, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BITES);
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull BlockHitResult hitResult) {
        if (!player.canEat(this.food.canAlwaysEat()))
            return InteractionResult.PASS;
        else {
            player.getFoodData().eat(this.food.nutrition(), this.food.saturation());
            for (FoodProperties.PossibleEffect pair : this.food.effects())
                if (player.getRandom().nextDouble() < pair.probability())
                    player.addEffect(pair.effect());
            int i = state.getValue(BITES);
            level.gameEvent(player, GameEvent.EAT, pos);
            if (i < this.maxBite)
                level.setBlock(pos, state.setValue(BITES, i + 1), 3);
            else {
                level.removeBlock(pos, false);
                level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        if (!ModList.get().isLoaded("farmersdelight"))
            tooltipComponents.add(Component.translatable("item.sow.tooltip.require.delight"));
    }
}
