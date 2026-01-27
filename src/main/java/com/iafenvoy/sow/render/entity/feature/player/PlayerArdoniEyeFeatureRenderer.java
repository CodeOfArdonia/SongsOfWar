package com.iafenvoy.sow.render.entity.feature.player;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.ArdoniGraveItem;
import com.iafenvoy.sow.render.entity.feature.ArdoniSkinHelper;
import com.iafenvoy.sow.render.entity.feature.ardoni.ArdoniSkinFeatureRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class PlayerArdoniEyeFeatureRenderer<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation EYE_MALE = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_eye_male.png");
    private static final ResourceLocation EYE_FEMALE = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_eye_female.png");
    private static final ResourceLocation PUPIL_MALE = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_pupil_male.png");
    private static final ResourceLocation PUPIL_FEMALE = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_pupil_female.png");

    public PlayerArdoniEyeFeatureRenderer(RenderLayerParent<T, M> context) {
        super(context);
    }

    @Override
    public void render(PoseStack matrices, @NotNull MultiBufferSource vertexConsumers, int light, @NotNull T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.pushPose();
        M model = this.getParentModel();
        ArdoniGraveItem.ArdoniData data = ArdoniSkinHelper.getMarkerTexture(entity);
        if (data != null) {
            int color = data.color();
            ResourceLocation pupil = data.female() ? PUPIL_FEMALE : PUPIL_MALE;
            model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(pupil)), light, OverlayTexture.NO_OVERLAY, color | 0xFF000000);
            if (!data.fixed()) {
                ResourceLocation eye = data.female() ? EYE_FEMALE : EYE_MALE;
                int darkness = ArdoniSkinFeatureRenderer.getDarkness(data.dark(), data.seed());
                model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityCutout(eye)), light, OverlayTexture.NO_OVERLAY, 0x010101 * darkness | 0xFF000000);
            }
        }
        matrices.popPose();
    }
}
