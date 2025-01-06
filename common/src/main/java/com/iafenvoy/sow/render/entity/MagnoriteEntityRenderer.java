package com.iafenvoy.sow.render.entity;

import com.iafenvoy.sow.entity.magnorite.MagnoriteEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.util.Identifier;

public class MagnoriteEntityRenderer extends BipedEntityRenderer<MagnoriteEntity, BipedEntityModel<MagnoriteEntity>> {
    public MagnoriteEntityRenderer(EntityRendererFactory.Context ctx, BipedEntityModel<MagnoriteEntity> model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    @Override
    public Identifier getTexture(MagnoriteEntity entity) {
        return null;
    }
}
