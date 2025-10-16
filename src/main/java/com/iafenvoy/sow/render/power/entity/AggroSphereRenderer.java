package com.iafenvoy.sow.render.power.entity;

import com.iafenvoy.neptune.render.model.SphereModel;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.power.AggroSphereEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class AggroSphereRenderer extends EntityRenderer<AggroSphereEntity> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/sphere/aggrosphere.png");
    private final SphereModel<AggroSphereEntity> sphereModel;

    public AggroSphereRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
        this.sphereModel = new SphereModel<>(SphereModel.getTexturedModelData().bakeRoot());
    }

    @Override
    public void render(@NotNull AggroSphereEntity entity, float yaw, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light) {
        matrices.pushPose();
        VertexConsumer consumer = vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(TEXTURE));
        matrices.translate(0, -0.5, 0);
        matrices.scale(0.5f, 0.5f, 0.5f);
        this.sphereModel.renderToBuffer(matrices, consumer, light, OverlayTexture.NO_OVERLAY, 0x30FFFFFF);
        matrices.translate(0, 0.375, 0);
        matrices.scale(0.75f, 0.75f, 0.75f);
        this.sphereModel.renderToBuffer(matrices, consumer, light, OverlayTexture.NO_OVERLAY, 0x66FFFFFF);
        matrices.popPose();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull AggroSphereEntity entity) {
        return TEXTURE;
    }
}
