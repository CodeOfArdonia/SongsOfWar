package com.iafenvoy.sow.render.block;

import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import java.util.List;

@Environment(EnvType.CLIENT)
public class WallsOfTimeBlockEntityRenderer implements BlockEntityRenderer<WallsOfTimeBlockEntity> {
    private static final Identifier FONT_ID = Identifier.of("minecraft", "alt");
    private static final Style STYLE = Style.EMPTY.withFont(FONT_ID);
    private final TextRenderer textRenderer;

    public WallsOfTimeBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.textRenderer = ctx.getTextRenderer();
    }

    @Override
    public void render(WallsOfTimeBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        WallsOfTimeBlockEntity.WotContents contents = entity.getContents();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180 - contents.getDirection().getHorizontal() * 90));
        matrices.translate(0.5, 0.5, -0.501F);
        matrices.scale(-0.03125F, -0.03125F, 0.03125F);
        List<OrderedText> texts = this.textRenderer.wrapLines(Text.literal(contents.getContentString()).fillStyle(STYLE), Math.max(0, contents.getSizeX()) * 32);
        for (int i = 0; i < texts.size() && i < contents.getSizeY() * 3; i++)
            this.textRenderer.draw(texts.get(i), 2 + contents.getOffsetX() * 32, 2 + (int) (i * 10.6) + contents.getOffsetY() * 32, 0x777777, false, matrices.peek().getPositionMatrix(), vertexConsumers, TextRenderer.TextLayerType.NORMAL, 0, light);
        matrices.pop();
    }
}
