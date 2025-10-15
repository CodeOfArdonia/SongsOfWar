package com.iafenvoy.sow.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@OnlyIn(Dist.CLIENT)
public class LaserParticle extends TextureSheetParticle {
    private static final float RADIAN_45 = (float) Math.toRadians(45);
    private static final float RADIAN_90 = (float) Math.toRadians(90);
    private final LaserParticleBuilder data;

    private LaserParticle(LaserParticleBuilder data, ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(world, x, y, z);
        this.data = data;
        this.setLifetime(5);
        this.setColor((float) vx, (float) vy, (float) vz);
        this.pickSprite(spriteSet);
        this.alpha = 0.11F;
        this.quadSize = data.getEnergyScale();
    }

    @Override
    public void render(@NotNull VertexConsumer vertexBuilder, Camera renderInfo, float partialTicks) {
        Vec3 view = renderInfo.getPosition();
        float newX = (float) (this.x - view.x);
        float newY = (float) (this.y - view.y);
        float newZ = (float) (this.z - view.z);
        float uMin = this.getU0();
        float uMax = this.getU1();
        float vMin = this.getV0();
        float vMax = this.getV1();
        Quaternionf quaternion = this.data.getRotationQuaternion(Minecraft.getInstance().level, (e, x, y, z) -> {
            this.x = x;
            this.y = y;
            this.z = z;
        });
        quaternion.mul(Axis.YP.rotation(RADIAN_45));
        this.drawComponent(vertexBuilder, this.getResultVector(quaternion, newX, newY, newZ), uMin, uMax, vMin, vMax);
        quaternion.mul(Axis.YP.rotation(RADIAN_90));
        this.drawComponent(vertexBuilder, this.getResultVector(quaternion, newX, newY, newZ), uMin, uMax, vMin, vMax);
    }

    private Vector3f[] getResultVector(Quaternionf quaternion, float newX, float newY, float newZ) {
        Vector3f[] resultVector = {
                new Vector3f(-this.quadSize, (float) -this.data.getOffset(), 0),
                new Vector3f(-this.quadSize, (float) (this.data.getDistance() - this.data.getOffset()), 0),
                new Vector3f(this.quadSize, (float) (this.data.getDistance() - this.data.getOffset()), 0),
                new Vector3f(this.quadSize, (float) -this.data.getOffset(), 0)
        };
        for (Vector3f vec : resultVector) {
            quaternion.transform(vec);
            vec.add(newX, newY, newZ);
        }
        return resultVector;
    }

    private void drawComponent(VertexConsumer vertexBuilder, Vector3f[] resultVector, float uMin, float uMax, float vMin, float vMax) {
        this.addVertex(vertexBuilder, resultVector[0], uMax, vMax);
        this.addVertex(vertexBuilder, resultVector[1], uMax, vMin);
        this.addVertex(vertexBuilder, resultVector[2], uMin, vMin);
        this.addVertex(vertexBuilder, resultVector[3], uMin, vMax);
        //Draw back faces
        this.addVertex(vertexBuilder, resultVector[1], uMax, vMin);
        this.addVertex(vertexBuilder, resultVector[0], uMax, vMax);
        this.addVertex(vertexBuilder, resultVector[3], uMin, vMax);
        this.addVertex(vertexBuilder, resultVector[2], uMin, vMin);
    }

    private void addVertex(VertexConsumer vertexBuilder, Vector3f pos, float u, float v) {
        vertexBuilder.addVertex(pos.x(), pos.y(), pos.z()).setUv(u, v).setColor(this.rCol, this.gCol, this.bCol, this.alpha).setUv2(240, 240);
    }

    @Override
    public int getLightColor(float partialTick) {
        return 15728880;
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static ParticleProvider<LaserParticleBuilder> create(SpriteSet sprite) {
        return (parameters, world, x, y, z, vx, vy, vz) -> new LaserParticle(parameters, world, x, y, z, vx, vy, vz, sprite);
    }
}
