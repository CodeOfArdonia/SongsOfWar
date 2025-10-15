package com.iafenvoy.sow.particle;

import com.iafenvoy.sow.mixin.LevelAccessor;
import com.iafenvoy.sow.registry.SowParticles;
import com.iafenvoy.sow.util.SowMath;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;

import java.util.UUID;

public class LaserParticleBuilder extends ParticleType<LaserParticleBuilder> implements ParticleOptions {
    public static final MapCodec<LaserParticleBuilder> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
            UUIDUtil.AUTHLIB_CODEC.optionalFieldOf("owner", null).forGetter(LaserParticleBuilder::getOwner),
            Codec.DOUBLE.fieldOf("pitch").forGetter(LaserParticleBuilder::getPitch),
            Codec.DOUBLE.fieldOf("yaw").forGetter(LaserParticleBuilder::getYaw),
            Codec.DOUBLE.fieldOf("distance").forGetter(LaserParticleBuilder::getDistance),
            Codec.DOUBLE.fieldOf("offset").forGetter(LaserParticleBuilder::getOffset),
            Codec.FLOAT.fieldOf("energyScale").forGetter(LaserParticleBuilder::getEnergyScale)
    ).apply(i, LaserParticleBuilder::new));
    //FIXME::To direct creation
    public static final StreamCodec<RegistryFriendlyByteBuf, LaserParticleBuilder> STREAM_CODEC = ByteBufCodecs.fromCodecWithRegistries(CODEC.codec());

    @Nullable
    private final UUID owner;
    private double pitch, yaw;
    private final double distance, offset;
    private final float energyScale;

    public LaserParticleBuilder(@Nullable UUID owner, double pitch, double yaw, double distance, double offset, float energyScale) {
        super(true);
        this.owner = owner;
        this.pitch = pitch;
        this.yaw = yaw;
        this.distance = distance;
        this.offset = offset;
        this.energyScale = energyScale;
    }

    @NotNull
    @Override
    public ParticleType<?> getType() {
        return SowParticles.LASER.get();
    }

    @Nullable
    public UUID getOwner() {
        return this.owner;
    }

    @Override
    public @NotNull MapCodec<LaserParticleBuilder> codec() {
        return CODEC;
    }

    @Override
    public @NotNull StreamCodec<? super RegistryFriendlyByteBuf, LaserParticleBuilder> streamCodec() {
        return STREAM_CODEC;
    }

    public Quaternionf getRotationQuaternion(Level world, Entity.MoveFunction positionUpdater) {
        if (this.owner != null && world != null) {
            Entity entity = ((LevelAccessor) world).sow$getEntities().get(this.owner);
            if (entity != null) {
                this.pitch = Math.toRadians(entity.getXRot() + 90);
                this.yaw = Math.toRadians(-entity.getYHeadRot());
                Vec3 rotation = SowMath.getRotationVectorUnit(entity.getXRot(), entity.getYHeadRot());
                Vec3 pos = entity.position().add(0, 1, 0).add(rotation.scale(this.offset));
                positionUpdater.accept(entity, pos.x(), pos.y(), pos.z());
            }
        }
        return new Quaternionf().rotateX((float) this.pitch).rotateLocalY((float) this.yaw);
    }

    public double getPitch() {
        return this.pitch;
    }

    public double getYaw() {
        return this.yaw;
    }

    public double getDistance() {
        return this.distance;
    }

    public double getOffset() {
        return this.offset;
    }

    public float getEnergyScale() {
        return this.energyScale;
    }
}