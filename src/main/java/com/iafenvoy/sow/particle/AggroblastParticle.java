package com.iafenvoy.sow.particle;

import com.iafenvoy.neptune.util.RandomHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class AggroblastParticle extends TextureSheetParticle {
    private final SpriteSet spriteSet;

    protected AggroblastParticle(ClientLevel clientWorld, double d, double e, double f, double g, double h, double i, SpriteSet sprite) {
        super(clientWorld, d, e, f);
        this.spriteSet = sprite;
        this.setParticleSpeed(g + RandomHelper.nextDouble(-0.5, 0.5), h + RandomHelper.nextDouble(-0.5, 0.5), i + RandomHelper.nextDouble(-0.5, 0.5));
        this.setSpriteFromAge(sprite);
        this.setSize(0.2F, 0.2F);
        this.lifetime = 14 + this.random.nextInt(42);
        this.gravity = 0.0F;
        this.hasPhysics = false;
    }

    @Override
    public int getLightColor(float partialTick) {
        return 15728880;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.removed) this.setSprite(this.spriteSet.get(this.age / 2 % 7, 6));
    }

    public static ParticleProvider<SimpleParticleType> create(SpriteSet sprite) {
        return (parameters, world, x, y, z, r, g, b) -> new AggroblastParticle(world, x, y, z, r, g, b, sprite);
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }
}
