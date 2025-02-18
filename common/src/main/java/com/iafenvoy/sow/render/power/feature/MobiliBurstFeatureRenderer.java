package com.iafenvoy.sow.render.power.feature;

import com.iafenvoy.neptune.render.RenderConstants;
import com.iafenvoy.neptune.render.model.CircleShieldModel;
import com.iafenvoy.sow.render.power.PowerAnimationManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;

public class MobiliBurstFeatureRenderer<T extends PlayerEntity, M extends PlayerEntityModel<T>> extends FeatureRenderer<T, M> {
    private final CircleShieldModel<T> model;
    private float alpha = 0;

    public MobiliBurstFeatureRenderer(FeatureRendererContext<T, M> context) {
        super(context);
        this.model = new CircleShieldModel<>(CircleShieldModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.push();
        if (PowerAnimationManager.enableMobiliburst(entity)) this.alpha += 0.005f;
        else this.alpha = 0;
        if (this.alpha > 0)
            this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(RenderConstants.WHITE_TEXTURE)), light, OverlayTexture.DEFAULT_UV, 1, 1, 0, Math.min(this.alpha, 0.1f));
        matrices.pop();
    }
}
