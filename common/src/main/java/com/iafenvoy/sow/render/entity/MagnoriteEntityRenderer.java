package com.iafenvoy.sow.render.entity;

import com.iafenvoy.sow.entity.magnorite.AbstractMagnoriteEntity;
import com.iafenvoy.sow.entity.magnorite.MagnoriteEntity;
import com.iafenvoy.sow.render.entity.feature.MagnoriteMarkerFeatureRenderer;
import com.iafenvoy.sow.render.util.MagnoriteSkinGenerator;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MagnoriteEntityRenderer extends BipedEntityRenderer<AbstractMagnoriteEntity, PlayerEntityModel<AbstractMagnoriteEntity>> {
    public MagnoriteEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new PlayerEntityModel<>(ctx.getPart(EntityModelLayers.PLAYER), false), 0.5F);
        this.addFeature(new MagnoriteMarkerFeatureRenderer(this));
        this.model.setVisible(true);
    }

    @Override
    public void render(AbstractMagnoriteEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.scale(1.2f, 1.2f, 1.2f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
        matrixStack.pop();
    }

    @Override
    public Identifier getTexture(AbstractMagnoriteEntity entity) {
        return entity instanceof MagnoriteEntity magnorite ? MagnoriteSkinGenerator.getOrCreate(magnorite.getMarkerSeed()).getForSkin() : entity.getTextureId();
    }
}
