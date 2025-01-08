package com.iafenvoy.sow.item;

import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import com.iafenvoy.sow.registry.SowItemGroups;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WallsOfTimeEditItem extends Item {
    private static final String EDIT_TYPE_KEY = "edit_type";

    public WallsOfTimeEditItem() {
        super(new Settings().rarity(Rarity.EPIC).maxCount(1).arch$tab(SowItemGroups.ITEMS));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!stack.getOrCreateNbt().contains(EDIT_TYPE_KEY))
            stack.getOrCreateNbt().putString(EDIT_TYPE_KEY, WallsOfTimeBlockEntity.EditType.OFFSET_X_PLUS.name());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (user.isSneaking() && stack.getOrCreateNbt().contains(EDIT_TYPE_KEY)) {
            WallsOfTimeBlockEntity.EditType next = WallsOfTimeBlockEntity.EditType.valueOf(stack.getOrCreateNbt().getString(EDIT_TYPE_KEY)).next();
            stack.getOrCreateNbt().putString(EDIT_TYPE_KEY, next.name());
            user.sendMessage(Text.translatable("item.sow.walls_of_time_edit.mode", next.name()), true);
            return TypedActionResult.success(stack);
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("item.sow.walls_of_time_edit.mode", stack.getOrCreateNbt().getString(EDIT_TYPE_KEY)));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);
        if (world.getBlockEntity(pos) instanceof WallsOfTimeBlockEntity blockEntity) {
            WallsOfTimeBlockEntity.EditType.valueOf(context.getStack().getOrCreateNbt().getString(EDIT_TYPE_KEY)).getProcess().accept(blockEntity.getContents());
            world.updateListeners(pos, state, state, 0);
            return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }
}
