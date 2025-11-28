package com.iafenvoy.sow.render.entity.feature.player;

import com.iafenvoy.sow.config.SowClientConfig;
import com.iafenvoy.sow.item.ArdoniGraveItem;
import com.iafenvoy.sow.render.entity.feature.ArdoniSkinHelper;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class PlayerArdoniMarkerFeatureRenderer<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {
    public PlayerArdoniMarkerFeatureRenderer(RenderLayerParent<T, M> context) {
        super(context);
    }

    @Override
    public void render(PoseStack matrices, @NotNull MultiBufferSource vertexConsumers, int light, @NotNull T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.pushPose();
        SowClientConfig.processEmissiveStack(matrices);
        PlayerModel<T> model = new PlayerModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER), false);
        this.getParentModel().copyPropertiesTo(model);
        ArdoniGraveItem.ArdoniData data = ArdoniSkinHelper.getMarkerTexture(entity);
        if (data != null) {
            int color = data.color();
            model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(data.marker())), light, OverlayTexture.NO_OVERLAY, color);
        }
        matrices.popPose();
    }
}
