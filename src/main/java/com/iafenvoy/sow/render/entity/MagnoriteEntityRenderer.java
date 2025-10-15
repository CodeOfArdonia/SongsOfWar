package com.iafenvoy.sow.render.entity;

import com.iafenvoy.sow.entity.magnorite.AbstractMagnoriteEntity;
import com.iafenvoy.sow.entity.magnorite.MagnoriteEntity;
import com.iafenvoy.sow.render.entity.feature.MagnoriteMarkerFeatureRenderer;
import com.iafenvoy.sow.render.generator.MagnoriteSkinGenerator;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MagnoriteEntityRenderer extends HumanoidMobRenderer<AbstractMagnoriteEntity, PlayerModel<AbstractMagnoriteEntity>> {
    public MagnoriteEntityRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new PlayerModel<>(ctx.bakeLayer(ModelLayers.PLAYER), false), 0.5F);
        this.addLayer(new MagnoriteMarkerFeatureRenderer(this));
    }

    @Override
    public void render(@NotNull AbstractMagnoriteEntity mobEntity, float f, float g, PoseStack matrixStack, @NotNull MultiBufferSource vertexConsumerProvider, int i) {
        matrixStack.pushPose();
        matrixStack.scale(1.2f, 1.2f, 1.2f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
        matrixStack.popPose();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull AbstractMagnoriteEntity entity) {
        return entity instanceof MagnoriteEntity magnorite ? MagnoriteSkinGenerator.getOrCreate(magnorite.getMarkerSeed()).getForSkin() : entity.getTextureId();
    }
}
