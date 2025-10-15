package com.iafenvoy.sow.render.entity.feature.ardoni;

import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.random.ArdoniEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class ArdoniSkinFeatureRenderer extends RenderLayer<AbstractArdoniEntity, PlayerModel<AbstractArdoniEntity>> {
    private static final ResourceLocation ARDONI_SHADOW = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_shadow.png");

    public ArdoniSkinFeatureRenderer(RenderLayerParent<AbstractArdoniEntity, PlayerModel<AbstractArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(PoseStack matrices, MultiBufferSource vertexConsumers, int light, AbstractArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.pushPose();
        matrices.scale(1.001f, 1.001f, 1.001f);
        int darkness = entity instanceof ArdoniEntity ardoni ? getDarkness(ardoni.getArdoniType().dark(), ardoni.getMarkerSeed()) : 1;
        PlayerModel<AbstractArdoniEntity> model = new PlayerModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER), false);
        this.getParentModel().copyPropertiesTo(model);
        model.renderToBuffer(matrices, vertexConsumers.getBuffer(model.renderType(entity.getTextureId())), light, LivingEntityRenderer.getOverlayCoords(entity, 0), 0x010101 * darkness + 0xFF000000);
        if (entity instanceof ArdoniEntity ardoni && ardoni.getAge() >= 4)
            model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucent(ARDONI_SHADOW)), light, LivingEntityRenderer.getOverlayCoords(entity, 0), 0x010101 * darkness + 0xFF000000);
        matrices.popPose();
    }

    public static int getDarkness(boolean dark, long seed) {
//        return dark ? RandomHelper.nextDouble(new Random(seed), 0.45, 0.65) : RandomHelper.nextDouble(new Random(seed), 0.8, 1);
        return dark ? RandomHelper.nextInt(new Random(seed), 115, 166) : RandomHelper.nextInt(new Random(seed), 205, 255);
    }
}
