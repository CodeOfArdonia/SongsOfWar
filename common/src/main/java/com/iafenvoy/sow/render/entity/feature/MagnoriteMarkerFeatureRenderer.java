package com.iafenvoy.sow.render.entity.feature;

import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.magnorite.AbstractMagnoriteEntity;
import com.iafenvoy.sow.entity.magnorite.MagnoriteEntity;
import com.iafenvoy.sow.render.generator.MagnoriteSkinGenerator;
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
import net.minecraft.util.Identifier;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public class MagnoriteMarkerFeatureRenderer extends FeatureRenderer<AbstractMagnoriteEntity, PlayerEntityModel<AbstractMagnoriteEntity>> {
    public MagnoriteMarkerFeatureRenderer(FeatureRendererContext<AbstractMagnoriteEntity, PlayerEntityModel<AbstractMagnoriteEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractMagnoriteEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        Optional<Identifier> marker = entity.getMarkerTextureId();
        PlayerEntityModel<AbstractMagnoriteEntity> model = new PlayerEntityModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EntityModelLayers.PLAYER), false);
        if (marker.isPresent())
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(marker.get())), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        else if (entity instanceof MagnoriteEntity magnorite)
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(MagnoriteSkinGenerator.getOrCreate(magnorite.getMarkerSeed()).getForMarker())), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }
}
