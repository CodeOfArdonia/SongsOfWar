package com.iafenvoy.sow.render.power.entity;

import com.iafenvoy.neptune.render.RenderConstants;
import com.iafenvoy.sow.entity.power.ProteCloneEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class ProteCloneRenderer extends HumanoidMobRenderer<ProteCloneEntity, HumanoidModel<ProteCloneEntity>> {
    public ProteCloneRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER), RenderType::entityTranslucentEmissive), 0);
    }

    @Override
    public void render(@NotNull ProteCloneEntity entity, float yaw, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light) {
        matrices.pushPose();
        matrices.scale(1.85F, -1.85F, 1.85F);
        matrices.translate(0, -1.5, 0);
        VertexConsumer consumer = vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(this.getTextureLocation(entity)));
        this.model.head.xScale = this.model.head.yScale = this.model.head.zScale = 0.7F;
        this.model.renderToBuffer(matrices, consumer, light, OverlayTexture.NO_OVERLAY, 0x4d007FFF);
        matrices.popPose();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull ProteCloneEntity entity) {
        return RenderConstants.WHITE_TEXTURE;
    }
}
