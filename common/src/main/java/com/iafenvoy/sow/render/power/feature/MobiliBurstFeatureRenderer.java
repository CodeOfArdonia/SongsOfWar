package com.iafenvoy.sow.render.power.feature;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.power.SongPowerData;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import com.iafenvoy.sow.render.power.test.MobiliBurstModel;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class MobiliBurstFeatureRenderer<T extends PlayerEntity, M extends PlayerEntityModel<T>> extends FeatureRenderer<T, M> {
    private static final Identifier TEXTURE = Identifier.of(SongsOfWar.MOD_ID, "textures/block/mobilibounce_platform.png");
    private final MobiliBurstModel<T> model;
    private float alpha = 0;

    public MobiliBurstFeatureRenderer(FeatureRendererContext<T, M> context) {
        super(context);
        this.model = new MobiliBurstModel<>(MobiliBurstModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.push();
        if (SongPowerData.byPlayer(entity).powerEnabled(MobiliumPowers.MOBILIBURST))
            this.alpha += 0.05f;
        else this.alpha = 0;
        if (this.alpha > 0)
            this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(TEXTURE)), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, Math.min(this.alpha, 1));
        matrices.pop();
    }
}
