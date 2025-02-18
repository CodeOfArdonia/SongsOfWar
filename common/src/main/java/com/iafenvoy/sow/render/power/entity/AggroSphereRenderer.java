package com.iafenvoy.sow.render.power.entity;

import com.iafenvoy.neptune.render.model.SphereModel;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.power.AggroSphereEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AggroSphereRenderer extends EntityRenderer<AggroSphereEntity> {
    private static final Identifier TEXTURE = Identifier.of(SongsOfWar.MOD_ID, "textures/sphere/aggrosphere.png");
    private final SphereModel<AggroSphereEntity> sphereModel;

    public AggroSphereRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.sphereModel = new SphereModel<>(SphereModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(AggroSphereEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        VertexConsumer consumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(TEXTURE));
        matrices.translate(0, -0.5, 0);
        matrices.scale(0.5f, 0.5f, 0.5f);
        this.sphereModel.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 0.15f);
        matrices.translate(0, 0.375, 0);
        matrices.scale(0.75f, 0.75f, 0.75f);
        this.sphereModel.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 0.4f);
        matrices.pop();
    }

    @Override
    public Identifier getTexture(AggroSphereEntity entity) {
        return TEXTURE;
    }
}
