package com.iafenvoy.sow.render.entity.feature.player;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.ArdoniGraveItem;
import com.iafenvoy.sow.render.entity.feature.ArdoniSkinHelper;
import com.iafenvoy.sow.render.entity.feature.ardoni.ArdoniSkinFeatureRenderer;
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
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class PlayerArdoniEyeFeatureRenderer<T extends PlayerEntity, M extends PlayerEntityModel<T>> extends FeatureRenderer<T, M> {
    private static final Identifier EYE_MALE = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_eye_male.png");
    private static final Identifier EYE_FEMALE = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_eye_female.png");
    private static final Identifier PUPIL_MALE = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_pupil_male.png");
    private static final Identifier PUPIL_FEMALE = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_pupil_female.png");

    public PlayerArdoniEyeFeatureRenderer(FeatureRendererContext<T, M> context) {
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
            Identifier pupil = data.female() ? PUPIL_FEMALE : PUPIL_MALE;
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(pupil)), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), 1);
            if (!data.fixed()) {
                Identifier eye = data.female() ? EYE_FEMALE : EYE_MALE;
                double darkness = ArdoniSkinFeatureRenderer.getDarkness(data.dark(), data.seed());
                model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(eye)), light, OverlayTexture.DEFAULT_UV, (float) darkness, (float) darkness, (float) darkness, 1);
            }
        }
        matrices.pop();
    }
}
