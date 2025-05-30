package com.iafenvoy.sow.item;

import com.iafenvoy.sow.registry.SowItemGroups;
import dev.architectury.platform.Platform;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class PeasDelightItem extends Item {
    private static final boolean DEPENDENCY_LOADED = Platform.isModLoaded("farmersdelight");

    public PeasDelightItem(Function<Settings, Settings> settings) {
        super(settings.apply(new Settings().arch$tab(SowItemGroups.PEAS_DELIGHT)));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (!DEPENDENCY_LOADED)
            tooltip.add(Text.translatable("item.sow.tooltip.require.delight"));
    }
}
