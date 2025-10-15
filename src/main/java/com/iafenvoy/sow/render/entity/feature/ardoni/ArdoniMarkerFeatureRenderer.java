package com.iafenvoy.sow.render.entity.feature.ardoni;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.config.SowClientConfig;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.random.ArdoniEntity;
import com.iafenvoy.sow.render.generator.ArdoniMarkerGenerator;
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
public class ArdoniMarkerFeatureRenderer extends RenderLayer<AbstractArdoniEntity, PlayerModel<AbstractArdoniEntity>> {
    public ArdoniMarkerFeatureRenderer(RenderLayerParent<AbstractArdoniEntity, PlayerModel<AbstractArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(PoseStack matrices, @NotNull MultiBufferSource vertexConsumers, int light, AbstractArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.pushPose();
        SowClientConfig.processEmissiveStack(matrices);
        Optional<ResourceLocation> marker = entity.getMarkerTextureId();
        PlayerModel<AbstractArdoniEntity> model = new PlayerModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER), false);
        this.getParentModel().copyPropertiesTo(model);
        if (marker.isPresent())
            model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(marker.get())), light, OverlayTexture.NO_OVERLAY, -1);
        else if (entity instanceof ArdoniEntity ardoni) {
            ArdoniMarkerGenerator generator = ArdoniMarkerGenerator.getOrCreate(ardoni.getMarkerSeed());
            Color4i color = entity.getColor();
            model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(generator.getForSkin())), light, OverlayTexture.NO_OVERLAY, Color4i.copy(color, 0xFF).getIntValue());
        }
        matrices.popPose();
    }
}
