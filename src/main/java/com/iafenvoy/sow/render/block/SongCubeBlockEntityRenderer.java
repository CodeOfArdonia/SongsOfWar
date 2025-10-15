package com.iafenvoy.sow.render.block;

import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.item.block.entity.SongCubeBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class SongCubeBlockEntityRenderer implements BlockEntityRenderer<SongCubeBlockEntity> {
    protected final ItemRenderer itemRenderer;

    public SongCubeBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
    }

    @Override
    public void render(SongCubeBlockEntity entity, float tickDelta, PoseStack matrices, @NotNull MultiBufferSource vertexConsumers, int light, int overlay) {
        matrices.pushPose();
        matrices.translate(0.5, 0.125, 0.5);
        this.itemRenderer.renderStatic(new ItemStack(SongCubeBlock.BLOCKS_MAP.get(entity.getCategory())), ItemDisplayContext.FIXED, light, overlay, matrices, vertexConsumers, entity.getLevel(), 0);
        matrices.popPose();
    }
}
