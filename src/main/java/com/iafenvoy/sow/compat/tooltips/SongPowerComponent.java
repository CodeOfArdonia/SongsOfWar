package com.iafenvoy.sow.compat.tooltips;

import com.iafenvoy.neptune.ability.type.Ability;
import com.iafenvoy.neptune.ability.type.DummyAbility;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class SongPowerComponent implements ClientTooltipComponent {
    @Nullable
    private final SowAbilityCategory category;
    private final Ability<?> ability;

    public SongPowerComponent(ItemStack stack) {
        if (stack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof SongCubeBlock songCube) {
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
    public int getWidth(Font textRenderer) {
        return 12 + textRenderer.width(Component.translatable(this.ability.getTranslateKey()));
    }

    @Override
    public void renderImage(Font textRenderer, int x, int y, @NotNull GuiGraphics context) {
        int lineY = y - textRenderer.lineHeight - 1;
        MutableComponent mutableText = Component.translatable(this.ability.getTranslateKey());
        if (this.category != null) mutableText = this.category.getCategory().appendColor(mutableText);
        lineY += textRenderer.lineHeight + 1;
        context.blit(this.ability.getIconTexture(), x, lineY - 1, 10, 10, 0, 0, 16, 16, 16, 16);
        context.drawString(textRenderer, mutableText, x + 12, lineY, -1, true);
    }
}
