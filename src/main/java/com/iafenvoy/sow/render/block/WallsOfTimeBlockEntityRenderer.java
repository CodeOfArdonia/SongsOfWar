package com.iafenvoy.sow.render.block;

import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class WallsOfTimeBlockEntityRenderer implements BlockEntityRenderer<WallsOfTimeBlockEntity> {
    private static final ResourceLocation FONT_ID = ResourceLocation.tryBuild("minecraft", "alt");
    private static final Style STYLE = Style.EMPTY.withFont(FONT_ID);
    private final Font textRenderer;

    public WallsOfTimeBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.textRenderer = ctx.getFont();
    }

    @Override
    public void render(WallsOfTimeBlockEntity entity, float tickDelta, PoseStack matrices, @NotNull MultiBufferSource vertexConsumers, int light, int overlay) {
        matrices.pushPose();
        WallsOfTimeBlockEntity.WotContents contents = entity.getContents();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.mulPose(Axis.YP.rotationDegrees(180 - contents.getDirection().get2DDataValue() * 90));
        matrices.translate(0.5, 0.5, -0.501F);
        matrices.scale(-0.03125F, -0.03125F, 0.03125F);
        List<FormattedCharSequence> texts = this.textRenderer.split(contents.getContentString().withStyle(STYLE), Math.max(0, contents.getSizeX()) * 32);
        for (int i = 0; i < texts.size() && i < contents.getSizeY() * 3; i++)
            this.textRenderer.drawInBatch(texts.get(i), 2 + contents.getOffsetX() * 32, 2 + (int) (i * 10.6) + contents.getOffsetY() * 32, 0x777777, false, matrices.last().pose(), vertexConsumers, Font.DisplayMode.NORMAL, 0, light);
        matrices.popPose();
    }
}
