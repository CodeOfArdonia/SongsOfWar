package com.iafenvoy.sow.render.power.entity;

import com.iafenvoy.sow.entity.power.SupporoSpikeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Transformation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Display;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class SupporoSpikeRenderer extends EntityRenderer<SupporoSpikeEntity> {
    private final BlockRenderDispatcher blockRenderManager;

    public SupporoSpikeRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
        this.blockRenderManager = ctx.getBlockRenderDispatcher();
    }

    @Override
    public void render(@NotNull SupporoSpikeEntity entity, float f, float g, @NotNull PoseStack matrices, @NotNull MultiBufferSource vertexConsumerProvider, int i) {
        this.shadowRadius = 0;
        this.shadowStrength = 1;
        super.render(entity, f, g, matrices, vertexConsumerProvider, i);
        matrices.pushPose();
        matrices.translate(-0.5, 0, -0.5);
        matrices.mulPose(entity.getRotationQuaternion());
        Display.GenericInterpolator<Transformation> interpolator = Display.GenericInterpolator.constant(getTransformation(entity));
        Transformation affineTransformation = interpolator.get(1);
        matrices.mulPose(affineTransformation.getMatrix());
        matrices.last().normal().rotate(affineTransformation.getLeftRotation()).rotate(affineTransformation.getRightRotation());
        this.blockRenderManager.renderSingleBlock(entity.getBlockState(), matrices, vertexConsumerProvider, i, OverlayTexture.NO_OVERLAY);
        matrices.popPose();
    }

    private static Transformation getTransformation(SupporoSpikeEntity entity) {
        Vector3f vector3f = new Vector3f();
        Quaternionf quaternionf = new Quaternionf();
        Vector3f vector3f2 = new Vector3f(entity.getScale());
        Quaternionf quaternionf2 = new Quaternionf();
        return new Transformation(vector3f, quaternionf, vector3f2, quaternionf2);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull SupporoSpikeEntity displayEntity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
