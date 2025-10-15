package com.iafenvoy.sow.render.power.feature;

import com.iafenvoy.neptune.render.RenderConstants;
import com.iafenvoy.neptune.render.model.CircleShieldModel;
import com.iafenvoy.sow.render.power.PowerAnimationManager;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class MobiliBurstFeatureRenderer<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {
    private final CircleShieldModel<T> model;
    private float alpha = 0;

    public MobiliBurstFeatureRenderer(RenderLayerParent<T, M> context) {
        super(context);
        this.model = new CircleShieldModel<>(CircleShieldModel.getTexturedModelData().bakeRoot());
    }

    @Override
    public void render(PoseStack matrices, @NotNull MultiBufferSource vertexConsumers, int light, @NotNull T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.pushPose();
        if (PowerAnimationManager.enableMobiliburst(entity)) this.alpha += 0.005f;
        else this.alpha = 0;
        if (this.alpha > 0)
            this.model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(RenderConstants.WHITE_TEXTURE)), light, OverlayTexture.NO_OVERLAY, (int) (Math.min(this.alpha, 0.1f) * 0xFF000000) + 0xFFFF00);
        matrices.popPose();
    }
}
