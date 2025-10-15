package com.iafenvoy.sow.mixin;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.item.ArdoniGraveItem;
import com.iafenvoy.sow.render.entity.feature.ArdoniSkinHelper;
import com.iafenvoy.sow.render.entity.feature.ardoni.ArdoniSkinFeatureRenderer;
import com.iafenvoy.sow.render.entity.feature.player.PlayerArdoniEyeFeatureRenderer;
import com.iafenvoy.sow.render.entity.feature.player.PlayerArdoniHairFeatureRenderer;
import com.iafenvoy.sow.render.entity.feature.player.PlayerArdoniMarkerFeatureRenderer;
import com.iafenvoy.sow.render.power.feature.MobiliBurstFeatureRenderer;
import com.iafenvoy.sow.render.power.feature.MobiliWingsFeatureRenderer;
import com.iafenvoy.sow.render.power.feature.ProteArmorFeatureRenderer;
import com.iafenvoy.sow.render.power.feature.ProteSphereFeatureRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@OnlyIn(Dist.CLIENT)
@Mixin(PlayerRenderer.class)
public abstract class PlayerRendererMixin extends LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
    public PlayerRendererMixin(EntityRendererProvider.Context ctx, PlayerModel<AbstractClientPlayer> model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void addCustomRenderer(EntityRendererProvider.Context ctx, boolean slim, CallbackInfo ci) {
        this.addLayer(new MobiliBurstFeatureRenderer<>(this));
        this.addLayer(new MobiliWingsFeatureRenderer<>(this, ctx.getModelSet()));
        this.addLayer(new ProteSphereFeatureRenderer<>(this));
        this.addLayer(new ProteArmorFeatureRenderer<>(this, new HumanoidArmorModel<>(ctx.bakeLayer(slim ? ModelLayers.PLAYER_SLIM_INNER_ARMOR : ModelLayers.PLAYER_INNER_ARMOR))));

        this.addLayer(new PlayerArdoniEyeFeatureRenderer<>(this));
        this.addLayer(new PlayerArdoniHairFeatureRenderer<>(this));
        this.addLayer(new PlayerArdoniMarkerFeatureRenderer<>(this));
    }

    @Inject(method = "renderHand", at = @At("RETURN"))
    private void renderArdoni(PoseStack matrices, MultiBufferSource vertexConsumers, int light, AbstractClientPlayer player, ModelPart arm, ModelPart sleeve, CallbackInfo ci) {
        ArdoniGraveItem.ArdoniData data = ArdoniSkinHelper.getMarkerTexture(player);
        if (data == null) return;
        int darkness = ArdoniSkinFeatureRenderer.getDarkness(data.dark(), data.seed());
        Color4i color = data.color();
        arm.render(matrices, vertexConsumers.getBuffer(RenderType.entitySolid(player.getSkin().texture())), light, OverlayTexture.NO_OVERLAY, 0x010101 * darkness + 0xFF000000);
        arm.render(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(data.marker())), light, OverlayTexture.NO_OVERLAY, color.getIntValue());
    }
}
