package com.iafenvoy.sow.item;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowItemGroups;
import dev.architectury.platform.Platform;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnchantmentFragmentItem extends Item {
    private static final boolean DEPENDENCY_LOADED = Platform.isModLoaded("reforge_stone");

    public EnchantmentFragmentItem() {
        super(new Settings().maxCount(4).rarity(Rarity.UNCOMMON).arch$tab(SowItemGroups.ITEMS));
    }

    @Override
    public String getTranslationKey() {
        return "item." + SongsOfWar.MOD_ID + ".enchantment_fragment";
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (!DEPENDENCY_LOADED)
            tooltip.add(Text.translatable("item.sow.tooltip.require.reforge_stone"));
    }
}
