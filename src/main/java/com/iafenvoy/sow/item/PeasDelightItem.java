package com.iafenvoy.sow.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.fml.ModList;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;

public class PeasDelightItem extends Item {
    private static final boolean DEPENDENCY_LOADED = ModList.get().isLoaded("farmersdelight");

    public PeasDelightItem(Function<Properties, Properties> settings) {
        super(settings.apply(new Properties()));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        if (!DEPENDENCY_LOADED) tooltipComponents.add(Component.translatable("item.sow.tooltip.require.delight"));
    }
}
