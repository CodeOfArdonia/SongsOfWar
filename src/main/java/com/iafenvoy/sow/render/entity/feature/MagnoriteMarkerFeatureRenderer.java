package com.iafenvoy.sow.render.entity.feature;

import com.iafenvoy.sow.entity.magnorite.AbstractMagnoriteEntity;
import com.iafenvoy.sow.entity.magnorite.MagnoriteEntity;
import com.iafenvoy.sow.render.generator.MagnoriteSkinGenerator;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class MagnoriteMarkerFeatureRenderer extends RenderLayer<AbstractMagnoriteEntity, PlayerModel<AbstractMagnoriteEntity>> {
    public MagnoriteMarkerFeatureRenderer(RenderLayerParent<AbstractMagnoriteEntity, PlayerModel<AbstractMagnoriteEntity>> context) {
        super(context);
    }

    @Override
    public void render(@NotNull PoseStack matrices, @NotNull MultiBufferSource vertexConsumers, int light, AbstractMagnoriteEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        Optional<ResourceLocation> marker = entity.getMarkerTextureId();
        PlayerModel<AbstractMagnoriteEntity> model = new PlayerModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER), false);
        if (marker.isPresent())
            model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(marker.get())), light, OverlayTexture.NO_OVERLAY, -1);
        else if (entity instanceof MagnoriteEntity magnorite)
            model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(MagnoriteSkinGenerator.getOrCreate(magnorite.getMarkerSeed()).getForMarker())), light, OverlayTexture.NO_OVERLAY, -1);
    }
}
