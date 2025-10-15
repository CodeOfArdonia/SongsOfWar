package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.particle.LaserParticleBuilder;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class SowParticles {
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, SongsOfWar.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SONG_EFFECT = register("song_effect", () -> new SimpleParticleType(false) {
    });
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> AGGROBLAST = register("aggroblast", () -> new SimpleParticleType(false) {
    });
    public static final DeferredHolder<ParticleType<?>, LaserParticleBuilder> LASER = register("laser", () -> new LaserParticleBuilder(null, 0, 0, 1, 0, 1));

    private static <T extends ParticleType<?>> DeferredHolder<ParticleType<?>, T> register(String id, Supplier<T> type) {
        return REGISTRY.register(id, type);
    }
}
