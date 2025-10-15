package com.iafenvoy.sow.item;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.fml.ModList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EnchantmentFragmentItem extends Item {
    private static final boolean DEPENDENCY_LOADED = ModList.get().isLoaded("reforge_stone");

    public EnchantmentFragmentItem() {
        super(new Properties().stacksTo(4).rarity(Rarity.UNCOMMON));
    }

    @Override
    public @NotNull String getDescriptionId() {
        return "item." + SongsOfWar.MOD_ID + ".enchantment_fragment";
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        if (!DEPENDENCY_LOADED) tooltipComponents.add(Component.translatable("item.sow.tooltip.require.reforge_stone"));
    }
}
