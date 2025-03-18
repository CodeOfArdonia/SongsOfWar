package com.iafenvoy.sow.render.power.feature;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.render.model.SphereModel;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.power.ProtisiumPowers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ProteSphereFeatureRenderer<T extends PlayerEntity, M extends PlayerEntityModel<T>> extends FeatureRenderer<T, M> {
    private static final Identifier TEXTURE = Identifier.of(SongsOfWar.MOD_ID, "textures/sphere/protesphere.png");
    private final SphereModel<T> sphereModel;

    public ProteSphereFeatureRenderer(FeatureRendererContext<T, M> context) {
        super(context);
        this.sphereModel = new SphereModel<>(SphereModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (AbilityData.byPlayer(entity).abilityEnabled(ProtisiumPowers.PROTESPHERE)) {
            matrices.push();
            matrices.scale(2.5f, 2.5f, 2.5f);
            matrices.translate(0, -1.3, 0);
            VertexConsumer consumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(TEXTURE));
            this.sphereModel.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV, 0, 0.5f, 1, 0.1f);
            matrices.pop();
        }
    }
}
