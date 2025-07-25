package com.iafenvoy.sow.render.entity.feature.ardoni;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.config.SowClientConfig;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.random.ArdoniEntity;
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

@Environment(EnvType.CLIENT)
public class ArdoniHairFeatureRenderer extends FeatureRenderer<AbstractArdoniEntity, PlayerEntityModel<AbstractArdoniEntity>> {
    private static final Identifier FEMALE_EXTRA_HAIR = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_female_extra.png");

    public ArdoniHairFeatureRenderer(FeatureRendererContext<AbstractArdoniEntity, PlayerEntityModel<AbstractArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.push();
        SowClientConfig.processEmissiveStack(matrices);
        PlayerEntityModel<AbstractArdoniEntity> model = new PlayerEntityModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EntityModelLayers.PLAYER), false);
        this.getContextModel().copyBipedStateTo(model);
        Color4i color = entity.getColor();
        if (entity instanceof ArdoniEntity ardoni) {
            int age = ardoni.getAge();
            Identifier hair = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_" + age + ".png");
            Identifier hairMarker = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_" + age + "_marker.png");
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(hair)), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(hairMarker)), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), 1);
            if (ardoni.isFemale())
                model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(FEMALE_EXTRA_HAIR)), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), 1);
        }
        matrices.pop();
    }
}
