package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.ability.type.DelayAbility;
import com.iafenvoy.neptune.ability.type.InstantAbility;
import com.iafenvoy.neptune.ability.type.PersistAbility;
import com.iafenvoy.neptune.object.DamageUtil;
import com.iafenvoy.neptune.object.EntityUtil;
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
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

@SuppressWarnings("unused")
public final class AggressiumPowers {
    public static final PersistAbility AGGROBEAM = new PersistAbility(Identifier.of(SongsOfWar.MOD_ID, "aggrobeam"), SowAbilityCategories.AGGRESSIUM).experimental()
            .setApplySound(SowSounds.AGGROBEAM)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggrobeamExhaustion.getValue())
            .onTick(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                double maxDistance = SowCommonConfig.INSTANCE.aggressium.aggrobeamMaxDistance.getValue();
                Vec3d rotation = SowMath.getRotationVectorUnit(player.getPitch(), player.getHeadYaw());
                Vec3d pos = player.getPos().add(0, 1, 0), end = pos.add(rotation.multiply(maxDistance));
                BlockHitResult result = world.raycast(new RaycastContext(pos, end, RaycastContext.ShapeType.VISUAL, RaycastContext.FluidHandling.NONE, player));
                double d = result.getPos().subtract(pos).length();
                if (holder.getWorld() instanceof ServerWorld serverWorld) {
                    final double OFFSET = 1;
                    Vec3d p = pos.add(rotation.multiply(OFFSET));
                    serverWorld.spawnParticles(new LaserParticleBuilder(player.getUuid(), 0, 0, result.getType() == HitResult.Type.BLOCK ? d : maxDistance, OFFSET, 0.1F), p.getX(), p.getY(), p.getZ(), 0, 1, 0, 0, 1);
                }
                List<EntityHitResult> results = RaycastHelper.raycastAll(player, pos, end, new Box(pos, end), entity -> entity instanceof LivingEntity, d * d);
                DamageSource source = DamageUtil.build(player, SowDamageTypes.AGGROBEAM);
                for (EntityHitResult r : results)
                    r.getEntity().damage(source, holder.processDamage(SowCommonConfig.INSTANCE.aggressium.aggrobeamDamage.getValue().floatValue()));
            });
    public static final DelayAbility AGGROBLAST = new DelayAbility(Identifier.of(SongsOfWar.MOD_ID, "aggroblast"), SowAbilityCategories.AGGRESSIUM)
            .setApplySound(SowSounds.AGGROBLAST)
            .setDelay(8)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroblastPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroblastSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggroblastExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                double maxDistance = SowCommonConfig.INSTANCE.aggressium.aggroblastRange.getValue();
                EntityHitResult result = RaycastHelper.raycastNearest(player, maxDistance);
                if (result != null && result.getEntity() instanceof LivingEntity living) {
                    double speed = SowCommonConfig.INSTANCE.aggressium.aggroblastSpeed.getValue();
                    Vec3d dir = living.getPos().subtract(player.getPos()).multiply(speed);
                    living.setVelocity(dir.add(0, 0.3, 0));
                    living.velocityModified = true;
                    if (holder.getWorld() instanceof ServerWorld serverWorld) {
                        Vec3d d = SowMath.getRotationVector(player.getPitch(), player.getHeadYaw());
                        for (int i = 0; i < 30; i++)
                            serverWorld.spawnParticles(SowParticles.AGGROBLAST.get(), player.getX(), player.getY() + 1, player.getZ(), 0, d.x, d.y, d.z, speed);
                    }
                    living.damage(DamageUtil.build(player, SowDamageTypes.AGGROBLAST), holder.processDamage(SowCommonConfig.INSTANCE.aggressium.aggroblastDamage.getValue().floatValue()));
                } else holder.cancel();
            });
    public static final DelayAbility AGGRODETONATE = new DelayAbility(Identifier.of(SongsOfWar.MOD_ID, "aggrodetonate"), SowAbilityCategories.AGGRESSIUM)
            .setApplySound(SowSounds.AGGRODETONATE)
            .setDelay(12)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggrodetonatePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggrodetonateSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggrodetonateExhaustion.getValue())
            .onApply(holder -> {
                World world = holder.getWorld();
                PlayerEntity player = holder.getPlayer();
                AggroDetonateEntity aggroDetonate = SowEntities.AGGRO_DETONATE.get().create(world);
                if (aggroDetonate != null) {
                    Vec3d dir = SowMath.getRotationVectorUnit(player.getPitch(), player.getHeadYaw());
                    aggroDetonate.setVelocity(dir.multiply(SowCommonConfig.INSTANCE.aggressium.aggrodetonateSpeed.getValue()));
                    holder.processProjectile(aggroDetonate);
                    world.spawnEntity(aggroDetonate);
                }
            });
    public static final DelayAbility AGGROQUAKE = new DelayAbility(Identifier.of(SongsOfWar.MOD_ID, "aggroquake"), SowAbilityCategories.AGGRESSIUM)
            .setApplySound(SowSounds.AGGROQUAKE)
            .setDelay(8)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroquakePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroquakeSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggroquakeExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                double r = SowCommonConfig.INSTANCE.aggressium.aggroquakeRange.getValue();
                Vec3d range = new Vec3d(r, r, r);
                List<LivingEntity> entities = holder.getWorld().getEntitiesByClass(LivingEntity.class, new Box(player.getPos().add(range), player.getPos().subtract(range)), x -> x != player);
                for (LivingEntity living : entities) {
                    Vec3d dir = SowMath.reverse(player.getPos().subtract(living.getPos()), r).multiply(-0.5);
                    living.damage(DamageUtil.build(living, SowDamageTypes.AGGROQUAKE), holder.processDamage(SowCommonConfig.INSTANCE.aggressium.aggroquakeDamage.getValue().floatValue()));
                    living.setVelocity(dir.add(0, 0.5, 0));
                    living.velocityModified = true;
                }
            });
    public static final DelayAbility AGGROSHARD = new DelayAbility(Identifier.of(SongsOfWar.MOD_ID, "aggroshard"), SowAbilityCategories.AGGRESSIUM)
            .setApplySound(SowSounds.AGGROSHARD)
            .setDelay(12)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroshardPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroshardSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggroshardExhaustion.getValue())
            .onApply(holder -> {
                World world = holder.getWorld();
                PlayerEntity player = holder.getPlayer();
                Random random = new Random();
                for (int i = 0; i < SowCommonConfig.INSTANCE.aggressium.aggroshardCount.getValue(); i++) {
                    Timeout.create(random.nextInt(25), () -> {
                        AggroShardEntity aggroShard = SowEntities.AGGRO_SHARD.get().create(world);
                        if (aggroShard != null) {
                            Vec3d dir = SowMath.getRotationVectorUnit(player.getPitch(), player.getHeadYaw());
                            final double MUL = 0.2, speed = SowCommonConfig.INSTANCE.aggressium.aggroshardSpeed.getValue();
                            aggroShard.setVelocity(dir.multiply(speed).add(RandomHelper.nextDouble(-speed * MUL, speed * MUL), RandomHelper.nextDouble(-speed * MUL, speed * MUL), RandomHelper.nextDouble(-speed * MUL, speed * MUL)));
                            holder.processProjectile(aggroShard);
                            world.spawnEntity(aggroShard);
                        }
                    });
                }
            });
    public static final InstantAbility AGGROSHOCK = new InstantAbility(Identifier.of(SongsOfWar.MOD_ID, "aggroshock"), SowAbilityCategories.AGGRESSIUM).experimental()
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroshockPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggroshockSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggroshockExhaustion.getValue())
            .onApply(holder -> {
                if (!(holder.getWorld() instanceof ServerWorld serverWorld)) return;
                PlayerEntity player = holder.getPlayer();
                final Vec3d dir = SowMath.getRotationVectorUnit(player.getPitch(), player.getHeadYaw());
                Vec3d pos = player.getPos();
                for (int i = 0; i < SowCommonConfig.INSTANCE.aggressium.aggroshockDistance.getValue(); i++) {
                    pos = pos.add(dir);
                    EntityUtil.lightening(serverWorld, pos.x, pos.y, pos.z, false);
                }
            });
    public static final DelayAbility AGGROSPHERE = new DelayAbility(Identifier.of(SongsOfWar.MOD_ID, "aggrosphere"), SowAbilityCategories.AGGRESSIUM)
            .setApplySound(SowSounds.AGGROSPHERE)
            .setDelay(36)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggrospherePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.aggressium.aggrosphereSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggrosphereExhaustion.getValue())
            .onApply(holder -> {
                World world = holder.getWorld();
                PlayerEntity player = holder.getPlayer();
                AggroSphereEntity aggroSphere = SowEntities.AGGRO_SPHERE.get().create(world);
                if (aggroSphere != null) {
                    final Vec3d dir = SowMath.getRotationVectorUnit(player.getPitch(), player.getHeadYaw());
                    aggroSphere.setVelocity(dir.multiply(SowCommonConfig.INSTANCE.aggressium.aggrosphereSpeed.getValue()));
                    holder.processProjectile(aggroSphere);
                    world.spawnEntity(aggroSphere);
                }
            });
    public static final PersistAbility AGGROSTORM = new PersistAbility(Identifier.of(SongsOfWar.MOD_ID, "aggrostorm"), SowAbilityCategories.AGGRESSIUM).experimental()
            .setApplySound(SowSounds.AGGROSTORM)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.aggressium.aggrostormExhaustion.getValue())
            .onTick(holder -> {
                PlayerEntity player = holder.getPlayer();
                double r = SowCommonConfig.INSTANCE.aggressium.aggrostormRange.getValue();
                Vec3d range = new Vec3d(r, r, r);
                List<LivingEntity> entities = holder.getWorld().getEntitiesByClass(LivingEntity.class, new Box(player.getPos().add(range), player.getPos().subtract(range)), x -> x != player);
                for (LivingEntity living : entities) {
                    Vec3d v = player.getPos().subtract(living.getPos());
                    Vec3d dir = SowMath.reverse(v, r).multiply(SowCommonConfig.INSTANCE.aggressium.aggrostormStrength.getValue());
                    if (v.length() <= r / 2)
                        living.damage(DamageUtil.build(living, SowDamageTypes.AGGROSTORM), holder.processDamage(SowCommonConfig.INSTANCE.aggressium.aggrostormDamage.getValue().floatValue() / 20));
                    living.setVelocity(dir);
                    living.velocityModified = true;
                }
            });

    public static void init() {
    }
}
