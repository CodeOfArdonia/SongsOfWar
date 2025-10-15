package com.iafenvoy.sow.item;

import com.iafenvoy.sow.world.ShrineStructureHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ShrineDebugItem extends Item {
    public ShrineDebugItem() {
        super(new Properties().rarity(Rarity.EPIC).stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player user, @NotNull InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);
        if (!(world instanceof ServerLevel serverWorld)) return InteractionResultHolder.success(stack);
        if (user.isShiftKeyDown() && user.isCreative())
            ShrineStructureHelper.generate(user.blockPosition(), serverWorld);
        else
            user.sendSystemMessage(Component.literal(ShrineStructureHelper.match(user.blockPosition(), serverWorld) ? "Match" : "Not Match"));
        user.getCooldowns().addCooldown(this, 20 * 5);
        return super.use(world, user, hand);
    }
}
