package com.iafenvoy.sow.render.entity;

import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.util.Flatable;
import com.iafenvoy.sow.render.entity.feature.ardoni.ArdoniEyeFeatureRenderer;
import com.iafenvoy.sow.render.entity.feature.ardoni.ArdoniHairFeatureRenderer;
import com.iafenvoy.sow.render.entity.feature.ardoni.ArdoniMarkerFeatureRenderer;
import com.iafenvoy.sow.render.entity.feature.ardoni.ArdoniSkinFeatureRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ArdoniEntityRenderer extends BipedEntityRenderer<AbstractArdoniEntity, PlayerEntityModel<AbstractArdoniEntity>> {
    public ArdoniEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new PlayerEntityModel<>(ctx.getPart(EntityModelLayers.PLAYER), false), 0.5F);
        this.addFeature(new ArdoniSkinFeatureRenderer(this));
        this.addFeature(new ArdoniEyeFeatureRenderer(this));
        this.addFeature(new ArdoniHairFeatureRenderer(this));
        this.addFeature(new ArdoniMarkerFeatureRenderer(this));
    }

    @Override
    public void render(AbstractArdoniEntity entity, float f, float g, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int i) {
        matrices.push();
        matrices.scale(1.1f, 1.1f, 1.1f);
        if (entity instanceof Flatable flatable && flatable.isFlat())
            matrices.scale(1, 0.001f, 1);
        super.render(entity, f, g, matrices, vertexConsumers, i);
        matrices.pop();
    }

    @Override
    public Identifier getTexture(AbstractArdoniEntity entity) {
        return entity.getTextureId();
    }
}
