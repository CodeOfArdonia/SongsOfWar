package com.iafenvoy.sow.render.entity.feature.player;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.config.SowClientConfig;
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
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class PlayerArdoniHairFeatureRenderer<T extends PlayerEntity, M extends PlayerEntityModel<T>> extends FeatureRenderer<T, M> {
    private static final Identifier FEMALE_EXTRA_HAIR = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_female_extra.png");

    public PlayerArdoniHairFeatureRenderer(FeatureRendererContext<T, M> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.push();
        SowClientConfig.processEmissiveStack(matrices);
        PlayerEntityModel<T> model = new PlayerEntityModel<>(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(EntityModelLayers.PLAYER), false);
        this.getContextModel().copyBipedStateTo(model);
        ArdoniGraveItem.ArdoniData data = ArdoniSkinHelper.getMarkerTexture(entity);
        if (data != null && !data.fixed()) {
            Color4i color = data.color();
            int age = data.age();
            Identifier hair = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_" + age + ".png");
            Identifier hairMarker = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_" + age + "_marker.png");
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(hair)), light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
            model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(hairMarker)), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), 1);
            if (data.female())
                model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(FEMALE_EXTRA_HAIR)), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), 1);
        }
        matrices.pop();
    }
}
