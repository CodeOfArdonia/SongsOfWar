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
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.ArmorEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    public PlayerEntityRendererMixin(EntityRendererFactory.Context ctx, PlayerEntityModel<AbstractClientPlayerEntity> model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void addCustomRenderer(EntityRendererFactory.Context ctx, boolean slim, CallbackInfo ci) {
        this.addFeature(new MobiliBurstFeatureRenderer<>(this));
        this.addFeature(new MobiliWingsFeatureRenderer<>(this, ctx.getModelLoader()));
        this.addFeature(new ProteSphereFeatureRenderer<>(this));
        this.addFeature(new ProteArmorFeatureRenderer<>(this, new ArmorEntityModel<>(ctx.getPart(slim ? EntityModelLayers.PLAYER_SLIM_INNER_ARMOR : EntityModelLayers.PLAYER_INNER_ARMOR))));

        this.addFeature(new PlayerArdoniEyeFeatureRenderer<>(this));
        this.addFeature(new PlayerArdoniHairFeatureRenderer<>(this));
        this.addFeature(new PlayerArdoniMarkerFeatureRenderer<>(this));
    }

    @Inject(method = "renderArm", at = @At("RETURN"))
    private void renderArdoni(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractClientPlayerEntity player, ModelPart arm, ModelPart sleeve, CallbackInfo ci) {
        ArdoniGraveItem.ArdoniData data = ArdoniSkinHelper.getMarkerTexture(player);
        if (data == null) return;
        double darkness = ArdoniSkinFeatureRenderer.getDarkness(data.dark(), data.seed());
        Color4i color = data.color();
        arm.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntitySolid(player.getSkinTexture())), light, OverlayTexture.DEFAULT_UV, (float) darkness, (float) darkness, (float) darkness, 1);
        arm.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(data.marker())), light, OverlayTexture.DEFAULT_UV, color.getR(), color.getG(), color.getB(), color.getA());
    }
}
