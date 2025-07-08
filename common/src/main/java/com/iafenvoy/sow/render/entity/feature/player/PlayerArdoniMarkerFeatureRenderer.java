package com.iafenvoy.sow.render.entity.feature.player;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.item.ArdoniGraveItem;
import com.iafenvoy.sow.render.entity.feature.ArdoniSkinHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;

@Environment(EnvType.CLIENT)
public class PlayerArdoniMarkerFeatureRenderer<T extends PlayerEntity, M extends PlayerEntityModel<T>> extends FeatureRenderer<T, M> {
    public PlayerArdoniMarkerFeatureRenderer(FeatureRendererContext<T, M> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.push();
        matrices.scale(1.0025f, 1.0025f, 1.0025f);
        PlayerEntityModel<T> model = new PlayerEntityModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EntityModelLayers.PLAYER), false);
        this.getContextModel().copyBipedStateTo(model);
        ArdoniGraveItem.ArdoniData data = ArdoniSkinHelper.getMarkerTexture(entity);
        if (data != null) {
            Color4i color = data.color();
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(data.marker())), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), color.getA());
        }
        matrices.pop();
    }
}
