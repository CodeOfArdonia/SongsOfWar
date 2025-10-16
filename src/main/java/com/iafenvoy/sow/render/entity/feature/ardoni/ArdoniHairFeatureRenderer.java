package com.iafenvoy.sow.render.entity.feature.ardoni;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.config.SowClientConfig;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.random.ArdoniEntity;
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

@OnlyIn(Dist.CLIENT)
public class ArdoniHairFeatureRenderer extends RenderLayer<AbstractArdoniEntity, PlayerModel<AbstractArdoniEntity>> {
    private static final ResourceLocation FEMALE_EXTRA_HAIR = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_female_extra.png");

    public ArdoniHairFeatureRenderer(RenderLayerParent<AbstractArdoniEntity, PlayerModel<AbstractArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(PoseStack matrices, @NotNull MultiBufferSource vertexConsumers, int light, AbstractArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.pushPose();
        SowClientConfig.processEmissiveStack(matrices);
        PlayerModel<AbstractArdoniEntity> model = new PlayerModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER), false);
        this.getParentModel().copyPropertiesTo(model);
        Color4i color = entity.getColor();
        if (entity instanceof ArdoniEntity ardoni) {
            int age = ardoni.getAge();
            ResourceLocation hair = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_" + age + ".png");
            ResourceLocation hairMarker = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_" + age + "_marker.png");
            model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityCutout(hair)), light, OverlayTexture.NO_OVERLAY, -1);
            model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(hairMarker)), light, OverlayTexture.NO_OVERLAY, Color4i.copy(color, 0xFF).getIntValue());
            if (ardoni.isFemale())
                model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(FEMALE_EXTRA_HAIR)), light, OverlayTexture.NO_OVERLAY, Color4i.copy(color, 0xFF).getIntValue());
        }
        matrices.popPose();
    }
}
