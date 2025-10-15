package com.iafenvoy.sow.render.power.entity;

import com.iafenvoy.neptune.render.RenderConstants;
import com.iafenvoy.neptune.render.model.DetonateModel;
import com.iafenvoy.sow.entity.power.AggroDetonateEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class AggroDetonateRenderer extends EntityRenderer<AggroDetonateEntity> {
    private final DetonateModel<AggroDetonateEntity> detonateModel;

    public AggroDetonateRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
        this.detonateModel = new DetonateModel<>(DetonateModel.getTexturedModelData().bakeRoot());
    }

    @Override
    public void render(AggroDetonateEntity entity, float yaw, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light) {
        matrices.pushPose();
        matrices.scale(2, 2, 2);
        matrices.mulPose(Axis.YP.rotationDegrees(Mth.lerp(tickDelta, entity.yRotO, entity.getYRot()) - 90.0F));
        matrices.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(tickDelta, entity.xRotO, entity.getXRot())));
        matrices.translate(-0.125, 0, 0);
        VertexConsumer consumer = vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(this.getTextureLocation(entity)));
        this.detonateModel.renderToBuffer(matrices, consumer, light, OverlayTexture.NO_OVERLAY, 0xB3FF0000);
        matrices.popPose();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull AggroDetonateEntity entity) {
        return RenderConstants.WHITE_TEXTURE;
    }
}
