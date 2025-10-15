package com.iafenvoy.sow.render.power.feature;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.render.model.SphereModel;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.power.ProtisiumPowers;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
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
public class ProteSphereFeatureRenderer<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/sphere/protesphere.png");
    private final SphereModel<T> sphereModel;

    public ProteSphereFeatureRenderer(RenderLayerParent<T, M> context) {
        super(context);
        this.sphereModel = new SphereModel<>(SphereModel.getTexturedModelData().bakeRoot());
    }

    @Override
    public void render(@NotNull PoseStack matrices, @NotNull MultiBufferSource vertexConsumers, int light, @NotNull T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (AbilityData.get(entity).abilityEnabled(ProtisiumPowers.PROTESPHERE.get())) {
            matrices.pushPose();
            matrices.scale(2.5f, 2.5f, 2.5f);
            matrices.translate(0, -1.3, 0);
            VertexConsumer consumer = vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(TEXTURE));
            this.sphereModel.renderToBuffer(matrices, consumer, light, OverlayTexture.NO_OVERLAY, 0x1B007FFF);
            matrices.popPose();
        }
    }
}
