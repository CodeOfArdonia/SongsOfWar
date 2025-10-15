package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.ability.type.Ability;
import com.iafenvoy.neptune.ability.type.DelayAbility;
import com.iafenvoy.neptune.ability.type.InstantAbility;
import com.iafenvoy.neptune.ability.type.PersistAbility;
import com.iafenvoy.neptune.object.DamageUtil;
import com.iafenvoy.neptune.object.EntityUtil;
import com.iafenvoy.neptune.registry.NeptuneRegistries;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.neptune.util.Timeout;
import com.iafenvoy.neptune.world.RaycastHelper;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.entity.power.AggroDetonateEntity;
import com.iafenvoy.sow.entity.power.AggroShardEntity;
import com.iafenvoy.sow.entity.power.AggroSphereEntity;
import com.iafenvoy.sow.particle.LaserParticleBuilder;
import com.iafenvoy.sow.registry.SowDamageTypes;
import com.iafenvoy.sow.registry.SowEntities;
import com.iafenvoy.sow.registry.SowParticles;
import com.iafenvoy.sow.registry.SowSounds;
import com.iafenvoy.sow.util.SowMath;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Random;

@SuppressWarnings("unused")
public final class AggressiumPowers {
    public static final DeferredRegister<Ability<?>> REGISTRY = DeferredRegister.create(NeptuneRegistries.ABILITY, SongsOfWar.MOD_ID);

    public static final DeferredHolder<Ability<?>, PersistAbility> AGGROBEAM = REGISTRY.register("aggrobeam", () -> new PersistAbility(SowAbilityCategory.AGGRESSIUM.getCategory()).experimental()
            .setApplySound(SowSounds.AGGROBEAM)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggrobeamExhaustion.getValue())
            .onTick(holder -> {
                LivingEntity living = holder.getEntity();
                Level world = holder.getWorld();
                double maxDistance = SowCommonConfig.INSTANCE.aggressium.aggrobeamMaxDistance.getValue();
                Vec3 rotation = SowMath.getRotationVectorUnit(living.getXRot(), living.getYHeadRot());
                Vec3 pos = living.position().add(0, 1, 0), end = pos.add(rotation.scale(maxDistance));
                BlockHitResult result = world.clip(new ClipContext(pos, end, ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, living));
                double d = result.getLocation().subtract(pos).length();
                if (holder.getWorld() instanceof ServerLevel serverWorld) {
                    final double OFFSET = 1;
                    Vec3 p = pos.add(rotation.scale(OFFSET));
                    serverWorld.sendParticles(new LaserParticleBuilder(living.getUUID(), 0, 0, result.getType() == HitResult.Type.BLOCK ? d : maxDistance, OFFSET, 0.1F), p.x(), p.y(), p.z(), 0, 1, 0, 0, 1);
                }
                List<EntityHitResult> results = RaycastHelper.raycastAll(living, pos, end, new AABB(pos, end), entity -> entity instanceof LivingEntity, d * d);
                DamageSource source = DamageUtil.build(living, SowDamageTypes.AGGROBEAM);
                for (EntityHitResult r : results)
                    r.getEntity().hurt(source, holder.processDamage(SowCommonConfig.INSTANCE.aggressium.aggrobeamDamage.getValue().floatValue()));
            }));
    public static final DeferredHolder<Ability<?>, DelayAbility> AGGROBLAST = REGISTRY.register("aggroblast", () -> new DelayAbility(SowAbilityCategory.AGGRESSIUM.getCategory())
            .setApplySound(SowSounds.AGGROBLAST)
            .setDelay(8)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroblastPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroblastSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggroblastExhaustion.getValue())
            .onApply(holder -> {
                LivingEntity living = holder.getEntity();
                double maxDistance = SowCommonConfig.INSTANCE.aggressium.aggroblastRange.getValue();
                EntityHitResult result = RaycastHelper.raycastNearest(living, maxDistance);
                if (result != null && result.getEntity() instanceof LivingEntity l) {
                    double speed = SowCommonConfig.INSTANCE.aggressium.aggroblastSpeed.getValue();
                    Vec3 dir = l.position().subtract(living.position()).scale(speed);
                    l.setDeltaMovement(dir.add(0, 0.3, 0));
                    l.hurtMarked = true;
                    if (holder.getWorld() instanceof ServerLevel serverWorld) {
                        Vec3 d = SowMath.getRotationVector(living.getXRot(), living.getYHeadRot());
                        for (int i = 0; i < 30; i++)
                            serverWorld.sendParticles(SowParticles.AGGROBLAST.get(), living.getX(), living.getY() + 1, living.getZ(), 0, d.x, d.y, d.z, speed);
                    }
                    l.hurt(DamageUtil.build(living, SowDamageTypes.AGGROBLAST), holder.processDamage(SowCommonConfig.INSTANCE.aggressium.aggroblastDamage.getValue().floatValue()));
                } else holder.cancel();
            }));
    public static final DeferredHolder<Ability<?>, DelayAbility> AGGRODETONATE = REGISTRY.register("aggrodetonate", () -> new DelayAbility(SowAbilityCategory.AGGRESSIUM.getCategory())
            .setApplySound(SowSounds.AGGRODETONATE)
            .setDelay(12)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggrodetonatePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggrodetonateSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggrodetonateExhaustion.getValue())
            .onApply(holder -> {
                Level world = holder.getWorld();
                LivingEntity living = holder.getEntity();
                AggroDetonateEntity aggroDetonate = SowEntities.AGGRO_DETONATE.get().create(world);
                if (aggroDetonate != null) {
                    Vec3 dir = SowMath.getRotationVectorUnit(living.getXRot(), living.getYHeadRot());
                    aggroDetonate.setDeltaMovement(dir.scale(SowCommonConfig.INSTANCE.aggressium.aggrodetonateSpeed.getValue()));
                    holder.processProjectile(aggroDetonate);
                    world.addFreshEntity(aggroDetonate);
                }
            }));
    public static final DeferredHolder<Ability<?>, DelayAbility> AGGROQUAKE = REGISTRY.register("aggroquake", () -> new DelayAbility(SowAbilityCategory.AGGRESSIUM.getCategory())
            .setApplySound(SowSounds.AGGROQUAKE)
            .setDelay(8)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroquakePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroquakeSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggroquakeExhaustion.getValue())
            .onApply(holder -> {
                LivingEntity living = holder.getEntity();
                double r = SowCommonConfig.INSTANCE.aggressium.aggroquakeRange.getValue();
                Vec3 range = new Vec3(r, r, r);
                List<LivingEntity> entities = holder.getWorld().getEntitiesOfClass(LivingEntity.class, new AABB(living.position().add(range), living.position().subtract(range)), x -> x != living);
                for (LivingEntity l : entities) {
                    Vec3 dir = SowMath.reverse(living.position().subtract(l.position()), r).scale(-0.5);
                    l.hurt(DamageUtil.build(l, SowDamageTypes.AGGROQUAKE), holder.processDamage(SowCommonConfig.INSTANCE.aggressium.aggroquakeDamage.getValue().floatValue()));
                    l.setDeltaMovement(dir.add(0, 0.5, 0));
                    l.hurtMarked = true;
                }
            }));
    public static final DeferredHolder<Ability<?>, DelayAbility> AGGROSHARD = REGISTRY.register("aggroshard", () -> new DelayAbility(SowAbilityCategory.AGGRESSIUM.getCategory())
            .setApplySound(SowSounds.AGGROSHARD)
            .setDelay(12)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroshardPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroshardSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggroshardExhaustion.getValue())
            .onApply(holder -> {
                Level world = holder.getWorld();
                LivingEntity living = holder.getEntity();
                Random random = new Random();
                for (int i = 0; i < SowCommonConfig.INSTANCE.aggressium.aggroshardCount.getValue(); i++) {
                    Timeout.create(random.nextInt(25), () -> {
                        AggroShardEntity aggroShard = SowEntities.AGGRO_SHARD.get().create(world);
                        if (aggroShard != null) {
                            Vec3 dir = SowMath.getRotationVectorUnit(living.getXRot(), living.getYHeadRot());
                            final double MUL = 0.2, speed = SowCommonConfig.INSTANCE.aggressium.aggroshardSpeed.getValue();
                            aggroShard.setDeltaMovement(dir.scale(speed).add(RandomHelper.nextDouble(-speed * MUL, speed * MUL), RandomHelper.nextDouble(-speed * MUL, speed * MUL), RandomHelper.nextDouble(-speed * MUL, speed * MUL)));
                            holder.processProjectile(aggroShard);
                            world.addFreshEntity(aggroShard);
                        }
                    });
                }
            }));
    public static final DeferredHolder<Ability<?>, InstantAbility> AGGROSHOCK = REGISTRY.register("aggroshock", () -> new InstantAbility(SowAbilityCategory.AGGRESSIUM.getCategory()).experimental()
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroshockPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroshockSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggroshockExhaustion.getValue())
            .onApply(holder -> {
                if (!(holder.getWorld() instanceof ServerLevel serverWorld)) return;
                LivingEntity living = holder.getEntity();
                final Vec3 dir = SowMath.getRotationVectorUnit(living.getXRot(), living.getYHeadRot());
                Vec3 pos = living.position();
                for (int i = 0; i < SowCommonConfig.INSTANCE.aggressium.aggroshockDistance.getValue(); i++) {
                    pos = pos.add(dir);
                    EntityUtil.lightening(serverWorld, pos.x, pos.y, pos.z, false);
                }
            }));
    public static final DeferredHolder<Ability<?>, DelayAbility> AGGROSPHERE = REGISTRY.register("aggrosphere", () -> new DelayAbility(SowAbilityCategory.AGGRESSIUM.getCategory())
            .setApplySound(SowSounds.AGGROSPHERE)
            .setDelay(36)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggrospherePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggrosphereSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggrosphereExhaustion.getValue())
            .onApply(holder -> {
                Level world = holder.getWorld();
                LivingEntity living = holder.getEntity();
                AggroSphereEntity aggroSphere = SowEntities.AGGRO_SPHERE.get().create(world);
                if (aggroSphere != null) {
                    final Vec3 dir = SowMath.getRotationVectorUnit(living.getXRot(), living.getYHeadRot());
                    aggroSphere.setDeltaMovement(dir.scale(SowCommonConfig.INSTANCE.aggressium.aggrosphereSpeed.getValue()));
                    holder.processProjectile(aggroSphere);
                    world.addFreshEntity(aggroSphere);
                }
            }));
    public static final DeferredHolder<Ability<?>, PersistAbility> AGGROSTORM = REGISTRY.register("aggrostorm", () -> new PersistAbility(SowAbilityCategory.AGGRESSIUM.getCategory()).experimental()
            .setApplySound(SowSounds.AGGROSTORM)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggrostormExhaustion.getValue())
            .onTick(holder -> {
                LivingEntity living = holder.getEntity();
                double r = SowCommonConfig.INSTANCE.aggressium.aggrostormRange.getValue();
                Vec3 range = new Vec3(r, r, r);
                List<LivingEntity> entities = holder.getWorld().getEntitiesOfClass(LivingEntity.class, new AABB(living.position().add(range), living.position().subtract(range)), x -> x != living);
                for (LivingEntity l : entities) {
                    Vec3 v = living.position().subtract(l.position());
                    Vec3 dir = SowMath.reverse(v, r).scale(SowCommonConfig.INSTANCE.aggressium.aggrostormStrength.getValue());
                    if (v.length() <= r / 2)
                        l.hurt(DamageUtil.build(l, SowDamageTypes.AGGROSTORM), holder.processDamage(SowCommonConfig.INSTANCE.aggressium.aggrostormDamage.getValue().floatValue() / 20));
                    l.setDeltaMovement(dir);
                    l.hurtMarked = true;
                }
            }));

}
