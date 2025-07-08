package com.iafenvoy.sow.render.entity.feature.ardoni;

import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.random.ArdoniEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.util.Random;

@Environment(EnvType.CLIENT)
public class ArdoniSkinFeatureRenderer extends FeatureRenderer<AbstractArdoniEntity, PlayerEntityModel<AbstractArdoniEntity>> {
    private static final Identifier ARDONI_SHADOW = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_shadow.png");

    public ArdoniSkinFeatureRenderer(FeatureRendererContext<AbstractArdoniEntity, PlayerEntityModel<AbstractArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.push();
        matrices.scale(1.001f, 1.001f, 1.001f);
        double darkness = entity instanceof ArdoniEntity ardoni ? getDarkness(ardoni.getArdoniType().dark(), ardoni.getMarkerSeed()) : 1;
        PlayerEntityModel<AbstractArdoniEntity> model = new PlayerEntityModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EntityModelLayers.PLAYER), false);
        this.getContextModel().copyBipedStateTo(model);
        model.render(matrices, vertexConsumers.getBuffer(model.getLayer(entity.getTextureId())), light, LivingEntityRenderer.getOverlay(entity, 0), (float) darkness, (float) darkness, (float) darkness, 1);
        if (entity instanceof ArdoniEntity ardoni && ardoni.getAge() >= 4)
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(ARDONI_SHADOW)), light, LivingEntityRenderer.getOverlay(entity, 0), (float) darkness, (float) darkness, (float) darkness, 1);
        matrices.pop();
    }

    public static double getDarkness(boolean dark, long seed) {
        return dark ? RandomHelper.nextDouble(new Random(seed), 0.45, 0.65) : RandomHelper.nextDouble(new Random(seed), 0.8, 1);
    }
}
