package com.iafenvoy.sow.item;

import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import com.iafenvoy.sow.registry.SowDataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WallsOfTimeEditItem extends Item {
    public WallsOfTimeEditItem() {
        super(new Properties().rarity(Rarity.EPIC).stacksTo(1).component(SowDataComponents.WOT_EDIT_TYPE, WallsOfTimeBlockEntity.EditType.OFFSET_X_PLUS));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player user, @NotNull InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);
        WallsOfTimeBlockEntity.EditType type = stack.get(SowDataComponents.WOT_EDIT_TYPE);
        if (user.isShiftKeyDown() && type != null) {
            WallsOfTimeBlockEntity.EditType next = type.next();
            stack.set(SowDataComponents.WOT_EDIT_TYPE, next);
            user.displayClientMessage(Component.translatable("item.sow.walls_of_time_edit.mode", next.name()), true);
            return InteractionResultHolder.success(stack);
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(Component.translatable("item.sow.walls_of_time_edit.mode", stack.getOrDefault(SowDataComponents.WOT_EDIT_TYPE.get(), WallsOfTimeBlockEntity.EditType.OFFSET_X_PLUS).name()));
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);
        if (world.getBlockEntity(pos) instanceof WallsOfTimeBlockEntity blockEntity) {
            WallsOfTimeBlockEntity.EditType type = context.getItemInHand().get(SowDataComponents.WOT_EDIT_TYPE);
            if (type != null) {
                type.getProcess().accept(blockEntity.getContents());
                world.sendBlockUpdated(pos, state, state, 0);
                return InteractionResult.SUCCESS;
            }
        }
        return super.useOn(context);
    }
}
