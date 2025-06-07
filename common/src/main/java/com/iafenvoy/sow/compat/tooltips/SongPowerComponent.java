package com.iafenvoy.sow.compat.tooltips;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.type.AbstractAbility;
import com.iafenvoy.neptune.ability.type.DummyAbility;
import com.iafenvoy.sow.item.block.AbstractSongCubeBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class SongPowerComponent implements TooltipComponent {
    @Nullable
    private final AbilityCategory category;
    private final AbstractAbility<?> ability;

    public SongPowerComponent(ItemStack stack) {
        if (stack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof AbstractSongCubeBlock songCube) {
            this.category = songCube.getCategory();
            this.ability = songCube.getPower(stack);
        } else {
            this.category = null;
            this.ability = DummyAbility.EMPTY;
        }
    }

    @Override
    public int getHeight() {
        return 10;
    }

    @Override
    public int getWidth(TextRenderer textRenderer) {
        return 12 + textRenderer.getWidth(Text.translatable(this.ability.getTranslateKey()));
    }

    @Override
    public void drawItems(TextRenderer textRenderer, int x, int y, DrawContext context) {
        int lineY = y - textRenderer.fontHeight - 1;
        MutableText mutableText = Text.translatable(this.ability.getTranslateKey());
        if (this.category != null) mutableText = this.category.appendColor(mutableText);
        lineY += textRenderer.fontHeight + 1;
        context.drawTexture(this.ability.getIconTexture(), x, lineY, 10, 10, 0, 0, 16, 16, 16, 16);
        context.drawText(textRenderer, mutableText, x + 12, lineY, -1, true);
    }
}
