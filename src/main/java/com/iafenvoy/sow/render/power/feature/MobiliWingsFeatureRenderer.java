package com.iafenvoy.sow.render.power.feature;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
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
public class MobiliWingsFeatureRenderer<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/elytra.png");
    private final ElytraModel<T> elytra;

    public MobiliWingsFeatureRenderer(RenderLayerParent<T, M> context, EntityModelSet loader) {
        super(context);
        this.elytra = new ElytraModel<>(loader.bakeLayer(ModelLayers.ELYTRA));
    }

    @Override
    public void render(@NotNull PoseStack matrixStack, @NotNull MultiBufferSource vertexConsumerProvider, int i, @NotNull T entity, float f, float g, float h, float j, float k, float l) {
        if (AbilityData.get(entity).abilityEnabled(MobiliumPowers.MOBILIWINGS.get())) {
            matrixStack.pushPose();
            matrixStack.translate(0.0F, 0.0F, 0.125F);
            this.getParentModel().copyPropertiesTo(this.elytra);
            this.elytra.setupAnim(entity, f, g, j, k, l);
            VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderType.entityTranslucentEmissive(TEXTURE));
            this.elytra.renderToBuffer(matrixStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 0x7FFFFF00);
            matrixStack.popPose();
        }
    }
}
