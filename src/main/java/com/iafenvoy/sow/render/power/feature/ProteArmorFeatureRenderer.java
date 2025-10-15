package com.iafenvoy.sow.render.power.feature;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.render.RenderConstants;
import com.iafenvoy.sow.registry.power.ProtisiumPowers;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
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
public class ProteArmorFeatureRenderer<T extends Player, M extends PlayerModel<T>, A extends HumanoidModel<T>> extends RenderLayer<T, M> {
    private final A model;

    public ProteArmorFeatureRenderer(RenderLayerParent<T, M> context, A model) {
        super(context);
        this.model = model;
        this.model.hat.visible = false;
    }

    @Override
    public void render(@NotNull PoseStack matrices, @NotNull MultiBufferSource vertexConsumers, int light, @NotNull T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (AbilityData.get(entity).abilityEnabled(ProtisiumPowers.PROTEARMOR.get())) {
            matrices.pushPose();
            this.getParentModel().copyPropertiesTo(this.model);
            VertexConsumer consumer = vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(RenderConstants.WHITE_TEXTURE));
            this.model.renderToBuffer(matrices, consumer, light, OverlayTexture.NO_OVERLAY, 0x1B007FFF);
            matrices.popPose();
        }
    }
}
