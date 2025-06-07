package com.iafenvoy.sow.compat.tooltips;

import com.iafenvoy.sow.Cache;
import com.iafenvoy.tooltipsreforged.api.TooltipsProvider;
import com.iafenvoy.tooltipsreforged.api.TooltipsReforgeEntrypoint;
import com.iafenvoy.tooltipsreforged.util.ExtendedTextVisitor;
import com.iafenvoy.tooltipsreforged.util.TextUtil;
import net.minecraft.client.gui.tooltip.OrderedTextTooltipComponent;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.item.ItemStack;

import java.util.List;

@TooltipsProvider
public class SowTooltips implements TooltipsReforgeEntrypoint {
    @Override
    public void appendTooltip(ItemStack itemStack, List<TooltipComponent> list) {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) instanceof OrderedTextTooltipComponent c && ExtendedTextVisitor.getText(TextUtil.getTextFromComponent(c)).getString().equals(I18n.translate(Cache.lastSongPowerTooltip))) {
                list.set(i, new SongPowerComponent(itemStack));
                break;
            }
    }
}
