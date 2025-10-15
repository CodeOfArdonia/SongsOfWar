package com.iafenvoy.sow.render.entity;

import com.iafenvoy.sow.entity.ardoni.AbstractArdoniEntity;
import com.iafenvoy.sow.entity.util.Flatable;
import com.iafenvoy.sow.render.entity.feature.ardoni.ArdoniEyeFeatureRenderer;
import com.iafenvoy.sow.render.entity.feature.ardoni.ArdoniHairFeatureRenderer;
import com.iafenvoy.sow.render.entity.feature.ardoni.ArdoniMarkerFeatureRenderer;
import com.iafenvoy.sow.render.entity.feature.ardoni.ArdoniSkinFeatureRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ArdoniEntityRenderer extends HumanoidMobRenderer<AbstractArdoniEntity, PlayerModel<AbstractArdoniEntity>> {
    public ArdoniEntityRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new PlayerModel<>(ctx.bakeLayer(ModelLayers.PLAYER), false), 0.5F);
        this.addLayer(new ArdoniSkinFeatureRenderer(this));
        this.addLayer(new ArdoniEyeFeatureRenderer(this));
        this.addLayer(new ArdoniHairFeatureRenderer(this));
        this.addLayer(new ArdoniMarkerFeatureRenderer(this));
    }

    @Override
    public void render(@NotNull AbstractArdoniEntity entity, float f, float g, PoseStack matrices, @NotNull MultiBufferSource vertexConsumers, int i) {
        matrices.pushPose();
        matrices.scale(1.1f, 1.1f, 1.1f);
        if (entity instanceof Flatable flatable && flatable.isFlat())
            matrices.scale(1, 0.001f, 1);
        super.render(entity, f, g, matrices, vertexConsumers, i);
        matrices.popPose();
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(AbstractArdoniEntity entity) {
        return entity.getTextureId();
    }
}
