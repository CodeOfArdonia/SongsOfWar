package com.iafenvoy.sow.render.entity;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.KikiEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.GhastEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class KikiEntityRenderer extends MobEntityRenderer<KikiEntity, GhastEntityModel<KikiEntity>> {
    private static final Identifier TEXTURE = Identifier.of(SongsOfWar.MOD_ID, "textures/entity/kiki.png");

    public KikiEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new GhastEntityModel<>(context.getPart(EntityModelLayers.GHAST)), 0.3F);
    }

    @Override
    public Identifier getTexture(KikiEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(KikiEntity entity, MatrixStack matrices, float amount) {
        matrices.scale(0.5F, 0.5F, 0.5F);
    }
}
