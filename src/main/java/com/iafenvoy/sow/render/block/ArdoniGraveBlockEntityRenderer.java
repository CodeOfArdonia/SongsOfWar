package com.iafenvoy.sow.render.block;

import com.iafenvoy.neptune.render.RenderConstants;
import com.iafenvoy.sow.item.block.entity.ArdoniGraveBlockEntity;
import com.iafenvoy.sow.render.generator.ArdoniMarkerGenerator;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.platform.TextureUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ArdoniGraveBlockEntityRenderer implements BlockEntityRenderer<ArdoniGraveBlockEntity> {
    private static final List<ResourceLocation> REGISTERED = new LinkedList<>();

    @Override
    public void render(ArdoniGraveBlockEntity entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        matrices.pushPose();
        ModelPart part = getTexturedModelData().bakeRoot();
        long seed = entity.getSeed();
        ResourceLocation texture = entity.isFixed() ? getTexture(entity.getTexturePath()) : ArdoniMarkerGenerator.getOrCreate(seed).getForGrave();
        matrices.translate(0.5, 1.5, 0.5);
        matrices.mulPose(Axis.YP.rotationDegrees(entity.getRotationDegree()));
        matrices.mulPose(Axis.ZP.rotationDegrees(180));
        part.render(matrices, vertexConsumers.getBuffer(RenderType.entityCutout(RenderConstants.STONE_TEXTURE)), light, overlay);
        int color = entity.activated() ? entity.getArdoniType().getColor(seed) : 0xFF202020;
        part.render(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(texture)), light, overlay, color);
        matrices.popPose();
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        modelPartData.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(18, 18).addBox(-12.0F, -12.0F, 12.0F, 8.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));
        return LayerDefinition.create(modelData, 64, 64);
    }

    public static ResourceLocation getTexture(ResourceLocation base) {
        ArdoniGraveTexture texture = new ArdoniGraveTexture(base);
        ResourceLocation id = texture.getLocation().withSuffix("_grave");
        if (!REGISTERED.contains(base)) {
            REGISTERED.add(base);
            Minecraft.getInstance().getTextureManager().register(id, texture);
        }
        return id;
    }

    public static void reset() {
        REGISTERED.clear();
    }

    private static class ArdoniGraveTexture extends SimpleTexture {
        public ArdoniGraveTexture(ResourceLocation location) {
            super(location);
        }

        @Override
        public void load(@NotNull ResourceManager manager) throws IOException {
            TextureImage textureData = this.getTextureImage(manager);
            textureData.throwIfError();
            NativeImage nativeImage = textureData.getImage();
            NativeImage image = new NativeImage(nativeImage.getWidth(), nativeImage.getHeight(), true);
            fill(nativeImage, image);
            TextureUtil.prepareImage(this.getId(), 0, image.getWidth(), image.getHeight());
            image.upload(0, 0, 0, 0, 0, image.getWidth(), image.getHeight(), false, false, false, true);
        }

        private static void fill(NativeImage origin, NativeImage target) {
            for (int i = 20; i < 28; i++)
                for (int j = 20; j < 32; j++)
                    target.setPixelRGBA(i, j, origin.getPixelRGBA(i, j));
        }

        public ResourceLocation getLocation() {
            return this.location;
        }
    }
}
