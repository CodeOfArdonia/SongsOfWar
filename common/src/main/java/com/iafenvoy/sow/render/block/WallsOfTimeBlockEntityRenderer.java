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
        matrices.scale(0.03125F, 0.03125F, 0.03125F);
        matrices.translate(0, 0, -0.1);
        this.renderSingle("abcdefghijklmn", matrices, vertexConsumers, light);
        matrices.pop();
    }

    private void renderSingle(String string, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        List<OrderedText> texts = this.textRenderer.wrapLines(Text.literal(string).fillStyle(STYLE), 32);
        for (int i = 0; i < texts.size(); i++)
            this.textRenderer.draw(texts.get(i), 0, i * 8, 0x777777, false, matrices.peek().getPositionMatrix(), vertexConsumers, TextRenderer.TextLayerType.NORMAL, 0, light);
    }
}
