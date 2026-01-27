package com.iafenvoy.sow.render.entity.feature.ardoni;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.ardoni.random.ArdoniEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArdoniEyeFeatureRenderer extends RenderLayer<AbstractArdoniEntity, PlayerModel<AbstractArdoniEntity>> {
    private static final ResourceLocation EYE_MALE = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_eye_male.png");
    private static final ResourceLocation EYE_FEMALE = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_eye_female.png");
    private static final ResourceLocation PUPIL_MALE = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_pupil_male.png");
    private static final ResourceLocation PUPIL_FEMALE = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_pupil_female.png");

    public ArdoniEyeFeatureRenderer(RenderLayerParent<AbstractArdoniEntity, PlayerModel<AbstractArdoniEntity>> context) {
        super(context);
    }

    @Override
    public void render(PoseStack matrices, MultiBufferSource vertexConsumers, int light, AbstractArdoniEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.pushPose();
        PlayerModel<AbstractArdoniEntity> model = this.getParentModel();
        int color = entity.getColor();
        ResourceLocation pupil = entity.isFemale() ? PUPIL_FEMALE : PUPIL_MALE;
        model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(pupil)), light, OverlayTexture.NO_OVERLAY, color);
        if (entity instanceof ArdoniEntity ardoni) {
            ResourceLocation eye = entity.isFemale() ? EYE_FEMALE : EYE_MALE;
            int darkness = ArdoniSkinFeatureRenderer.getDarkness(ardoni.getArdoniType().dark(), ardoni.getMarkerSeed());
            model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityCutout(eye)), light, OverlayTexture.NO_OVERLAY, 0x010101 * darkness | 0xFF000000);
        }
        matrices.popPose();
    }
}
