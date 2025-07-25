package com.iafenvoy.sow.render.entity.feature.ardoni;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.config.SowClientConfig;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.random.ArdoniEntity;
import com.iafenvoy.sow.render.generator.ArdoniMarkerGenerator;
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
public class ArdoniMarkerFeatureRenderer extends FeatureRenderer<AbstractArdoniEntity, PlayerEntityModel<AbstractArdoniEntity>> {
    public ArdoniMarkerFeatureRenderer(FeatureRendererContext<AbstractArdoniEntity, PlayerEntityModel<AbstractArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.push();
        SowClientConfig.processEmissiveStack(matrices);
        Optional<Identifier> marker = entity.getMarkerTextureId();
        PlayerEntityModel<AbstractArdoniEntity> model = new PlayerEntityModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EntityModelLayers.PLAYER), false);
        this.getContextModel().copyBipedStateTo(model);
        if (marker.isPresent())
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(marker.get())), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        else if (entity instanceof ArdoniEntity ardoni) {
            ArdoniMarkerGenerator generator = ArdoniMarkerGenerator.getOrCreate(ardoni.getMarkerSeed());
            Color4i color = entity.getColor();
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(generator.getForSkin())), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), 1);
        }
        matrices.pop();
    }
}
