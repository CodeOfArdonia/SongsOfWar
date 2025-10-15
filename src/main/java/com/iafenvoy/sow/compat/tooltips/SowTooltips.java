package com.iafenvoy.sow.compat.tooltips;

import com.iafenvoy.integration.entrypoint.EntryPointProvider;
import com.iafenvoy.sow.Constants;
import com.iafenvoy.tooltipsreforged.api.TooltipsReforgeEntrypoint;
import com.iafenvoy.tooltipsreforged.util.ExtendedTextVisitor;
import com.iafenvoy.tooltipsreforged.util.TextUtil;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTextTooltip;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;

import java.util.List;

@EntryPointProvider(slug = "tooltips_reforged")
public class SowTooltips implements TooltipsReforgeEntrypoint {
    @Override
    public void appendTooltip(ItemStack itemStack, List<ClientTooltipComponent> list, RegistryAccess access) {
        if (Constants.LAST_SONG_POWER_TOOLTIP == null) return;
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) instanceof ClientTextTooltip c && ExtendedTextVisitor.getText(TextUtil.getTextFromComponent(c)).getString().equals(I18n.get(Constants.LAST_SONG_POWER_TOOLTIP))) {
                list.set(i, new SongPowerComponent(itemStack));
                break;
            }
    }
}
