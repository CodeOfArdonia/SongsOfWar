package com.iafenvoy.sow.render.block;

import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.item.block.entity.SongCubeBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

@Environment(EnvType.CLIENT)
public class SongCubeBlockEntityRenderer implements BlockEntityRenderer<SongCubeBlockEntity> {
    protected final ItemRenderer itemRenderer;

    public SongCubeBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
    }

    @Override
    public void render(SongCubeBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.translate(0.5, 0.125, 0.5);
        this.itemRenderer.renderItem(new ItemStack(SongCubeBlock.BLOCKS_MAP.get(entity.getCategory())), ModelTransformationMode.FIXED, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
        matrices.pop();
    }
}
