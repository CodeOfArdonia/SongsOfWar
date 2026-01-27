package com.iafenvoy.sow.render.entity.feature.player;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.ArdoniGraveItem;
import com.iafenvoy.sow.render.entity.feature.ArdoniSkinHelper;
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
public class PlayerArdoniHairFeatureRenderer<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation FEMALE_EXTRA_HAIR = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_female_extra.png");

    public PlayerArdoniHairFeatureRenderer(RenderLayerParent<T, M> context) {
        super(context);
    }

    @Override
    public void render(PoseStack matrices, @NotNull MultiBufferSource vertexConsumers, int light, @NotNull T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.pushPose();
        M model = this.getParentModel();
        ArdoniGraveItem.ArdoniData data = ArdoniSkinHelper.getMarkerTexture(entity);
        if (data != null && !data.fixed()) {
            int color = data.color();
            int age = data.age();
            ResourceLocation hair = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_" + age + ".png");
            ResourceLocation hairMarker = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "textures/entity/ardoni/ardoni_hair_" + age + "_marker.png");
            model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityCutout(hair)), light, OverlayTexture.NO_OVERLAY, -1);
            model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(hairMarker)), light, OverlayTexture.NO_OVERLAY, color | 0xFF000000);
            if (data.female())
                model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(FEMALE_EXTRA_HAIR)), light, OverlayTexture.NO_OVERLAY, color | 0xFF000000);
        }
        matrices.popPose();
    }
}
