package com.iafenvoy.sow.entity;

import com.iafenvoy.sow.registry.SowTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.ServerConfigHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Optional;
import java.util.UUID;

public class KikiEntity extends FlyingEntity implements Tameable {
    protected static final TrackedData<Optional<UUID>> OWNER_UUID = DataTracker.registerData(KikiEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);

    public KikiEntity(EntityType<? extends KikiEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
        this.moveControl = new GhastMoveControl(this);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new KikiFollowOwnerGoal(this, 5, 8, 2, false));
        this.goalSelector.add(5, new FlyRandomlyGoal(this));
        this.goalSelector.add(7, new LookAtTargetGoal(this));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(OWNER_UUID, Optional.empty());
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100.0);
    }

    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_GHAST_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_GHAST_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GHAST_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 5.0F;
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.12f;
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        if (this.getOwnerUuid() != null) nbt.putUuid("Owner", this.getOwnerUuid());
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        UUID uuid;
        if (nbt.containsUuid("Owner")) uuid = nbt.getUuid("Owner");
        else {
            String s = nbt.getString("Owner");
            uuid = ServerConfigHandler.getPlayerUuidByName(this.getServer(), s);
        }
        if (uuid != null) this.setOwnerUuid(uuid);
    }

    @Nullable
    public UUID getOwnerUuid() {
        return this.dataTracker.get(OWNER_UUID).orElse(null);
    }

    public void setOwnerUuid(@Nullable UUID uuid) {
        this.dataTracker.set(OWNER_UUID, Optional.ofNullable(uuid));
    }

    @Override
    public EntityView method_48926() {
        return this.getEntityWorld();
    }

    public boolean isOwner(LivingEntity entity) {
        return entity == this.getOwner();
    }

    public boolean isTamed() {
        return this.getOwnerUuid() != null;
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (this.getWorld().isClient) {
            boolean bl = this.isOwner(player) || this.isTamed() || itemStack.isIn(SowTags.KIKI_FOOD) && !this.isTamed();
            return bl ? ActionResult.CONSUME : ActionResult.PASS;
        } else {
            if (this.isTamed()) {
                if (itemStack.isIn(SowTags.KIKI_FOOD) && this.getHealth() < this.getMaxHealth()) {
                    if (!player.getAbilities().creativeMode) itemStack.decrement(1);
                    this.heal(1);
                    return ActionResult.SUCCESS;
                }
            } else if (itemStack.isIn(SowTags.KIKI_FOOD)) {
                if (!player.getAbilities().creativeMode) itemStack.decrement(1);
                if (this.random.nextInt(3) == 0) {
                    this.setOwnerUuid(player.getUuid());
                    this.navigation.stop();
                    this.setTarget(null);
                    this.getWorld().sendEntityStatus(this, (byte) 7);
                } else this.getWorld().sendEntityStatus(this, (byte) 6);
                return ActionResult.SUCCESS;
            }
            return super.interactMob(player, hand);
        }
    }

    @Override
    public void handleStatus(byte status) {
        if (status == 7) this.showEmoteParticle(true);
        else if (status == 6) this.showEmoteParticle(false);
        else super.handleStatus(status);
    }

    protected void showEmoteParticle(boolean positive) {
        ParticleEffect particleEffect = ParticleTypes.HEART;
        if (!positive) particleEffect = ParticleTypes.SMOKE;
        for (int i = 0; i < 7; ++i) {
            double d = this.random.nextGaussian() * 0.02;
            double e = this.random.nextGaussian() * 0.02;
            double f = this.random.nextGaussian() * 0.02;
            this.getWorld().addParticle(particleEffect, this.getParticleX(1.0), this.getRandomBodyY() + 0.5, this.getParticleZ(1.0), d, e, f);
        }
    }

    private static class GhastMoveControl extends MoveControl {
        private final KikiEntity kiki;
        private int collisionCheckCooldown;

        public GhastMoveControl(KikiEntity kiki) {
            super(kiki);
            this.kiki = kiki;
        }

        @Override
        public void tick() {
            if (this.state == State.MOVE_TO) {
                if (this.collisionCheckCooldown-- <= 0) {
                    this.collisionCheckCooldown += this.kiki.getRandom().nextInt(5) + 2;
                    Vec3d vec3d = new Vec3d(this.targetX - this.kiki.getX(), this.targetY - this.kiki.getY(), this.targetZ - this.kiki.getZ());
                    double d = vec3d.length();
                    vec3d = vec3d.normalize();
                    if (this.willCollide(vec3d, MathHelper.ceil(d)))
                        this.kiki.setVelocity(this.kiki.getVelocity().add(vec3d.multiply(0.02)));
                    else
                        this.state = State.WAIT;
                }
            }
        }

        private boolean willCollide(Vec3d direction, int steps) {
            Box box = this.kiki.getBoundingBox();
            for (int i = 1; i < steps; ++i) {
                box = box.offset(direction);
                if (!this.kiki.getWorld().isSpaceEmpty(this.kiki, box))
                    return false;
            }
            return true;
        }
    }

    private static class FlyRandomlyGoal extends Goal {
        private final KikiEntity kiki;

        public FlyRandomlyGoal(KikiEntity kiki) {
            this.kiki = kiki;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart() {
            MoveControl moveControl = this.kiki.getMoveControl();
            if (!moveControl.isMoving()) {
                return true;
            } else {
                double d = moveControl.getTargetX() - this.kiki.getX();
                double e = moveControl.getTargetY() - this.kiki.getY();
                double f = moveControl.getTargetZ() - this.kiki.getZ();
                double g = d * d + e * e + f * f;
                return g < 1.0 || g > 3600.0;
            }
        }

        @Override
        public boolean shouldContinue() {
            return false;
        }

        @Override
        public void start() {
            Random random = this.kiki.getRandom();
            double d = this.kiki.getX() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double e = this.kiki.getY() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double f = this.kiki.getZ() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.kiki.getMoveControl().moveTo(d, e, f, 1.0);
        }
    }

    private static class LookAtTargetGoal extends Goal {
        private final KikiEntity kiki;

        public LookAtTargetGoal(KikiEntity kiki) {
            this.kiki = kiki;
            this.setControls(EnumSet.of(Control.LOOK));
        }

        public boolean canStart() {
            return true;
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            if (this.kiki.getTarget() == null) {
                Vec3d vec3d = this.kiki.getVelocity();
                this.kiki.setYaw(-((float) MathHelper.atan2(vec3d.x, vec3d.z)) * 57.295776F);
                this.kiki.bodyYaw = this.kiki.getYaw();
            } else {
                LivingEntity livingEntity = this.kiki.getTarget();
                double d = 64.0;
                if (livingEntity.squaredDistanceTo(this.kiki) < 4096.0) {
                    double e = livingEntity.getX() - this.kiki.getX();
                    double f = livingEntity.getZ() - this.kiki.getZ();
                    this.kiki.setYaw(-((float) MathHelper.atan2(e, f)) * 57.295776F);
                    this.kiki.bodyYaw = this.kiki.getYaw();
                }
            }

        }
    }

    private static class KikiFollowOwnerGoal extends Goal {
        private final KikiEntity kiki;
        private LivingEntity owner;
        private final WorldView world;
        private final double speed;
        private final EntityNavigation navigation;
        private int updateCountdownTicks;
        private final float maxDistance;
        private final float minDistance;
        private float oldWaterPathfindingPenalty;
        private final boolean leavesAllowed;

        public KikiFollowOwnerGoal(KikiEntity kiki, double speed, float minDistance, float maxDistance, boolean leavesAllowed) {
            this.kiki = kiki;
            this.world = kiki.getWorld();
            this.speed = speed;
            this.navigation = kiki.getNavigation();
            this.minDistance = minDistance;
            this.maxDistance = maxDistance;
            this.leavesAllowed = leavesAllowed;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
            if (!(kiki.getNavigation() instanceof MobNavigation) && !(kiki.getNavigation() instanceof BirdNavigation)) {
                throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
            }
        }

        @Override
        public boolean canStart() {
            LivingEntity livingEntity = this.kiki.getOwner();
            if (livingEntity == null) return false;
            else if (livingEntity.isSpectator()) return false;
            else if (this.cannotFollow()) return false;
            else if (this.kiki.squaredDistanceTo(livingEntity) < (double) (this.minDistance * this.minDistance))
                return false;
            else {
                this.owner = livingEntity;
                return true;
            }
        }

        @Override
        public boolean shouldContinue() {
            if (this.navigation.isIdle()) return false;
            else if (this.cannotFollow()) return false;
            else
                return this.kiki.squaredDistanceTo(this.owner) > (double) (this.maxDistance * this.maxDistance);
        }

        private boolean cannotFollow() {
            return this.kiki.hasVehicle() || this.kiki.isLeashed();
        }

        @Override
        public void start() {
            this.updateCountdownTicks = 0;
            this.oldWaterPathfindingPenalty = this.kiki.getPathfindingPenalty(PathNodeType.WATER);
            this.kiki.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
            this.kiki.getMoveControl().moveTo(this.owner.getX(), this.owner.getY() + 1, this.owner.getZ(), 1);
        }

        @Override
        public void stop() {
            this.owner = null;
            this.navigation.stop();
            this.kiki.setPathfindingPenalty(PathNodeType.WATER, this.oldWaterPathfindingPenalty);
        }

        @Override
        public void tick() {
            this.kiki.getLookControl().lookAt(this.owner, 10.0F, (float) this.kiki.getMaxLookPitchChange());
            if (--this.updateCountdownTicks <= 0) {
                this.updateCountdownTicks = this.getTickCount(10);
                if (this.kiki.squaredDistanceTo(this.owner) >= 144.0) this.tryTeleport();
                else this.navigation.startMovingTo(this.owner, this.speed);
            }
        }

        private void tryTeleport() {
            BlockPos blockPos = this.owner.getBlockPos();
            for (int i = 0; i < 10; ++i) {
                int j = this.getRandomInt(-3, 3);
                int k = this.getRandomInt(-1, 1);
                int l = this.getRandomInt(-3, 3);
                boolean bl = this.tryTeleportTo(blockPos.getX() + j, blockPos.getY() + k, blockPos.getZ() + l);
                if (bl) return;
            }
        }

        private boolean tryTeleportTo(int x, int y, int z) {
            if (Math.abs((double) x - this.owner.getX()) < 2.0 && Math.abs((double) z - this.owner.getZ()) < 2.0)
                return false;
            else if (!this.canTeleportTo(new BlockPos(x, y, z)))
                return false;
            else {
                this.kiki.refreshPositionAndAngles(x + 0.5, y + 1, z + 0.5, this.kiki.getYaw(), this.kiki.getPitch());
                this.navigation.stop();
                return true;
            }
        }

        private boolean canTeleportTo(BlockPos pos) {
            PathNodeType pathNodeType = LandPathNodeMaker.getLandNodeType(this.world, pos.mutableCopy());
            if (pathNodeType != PathNodeType.WALKABLE) return false;
            else {
                BlockState blockState = this.world.getBlockState(pos.down());
                if (!this.leavesAllowed && blockState.getBlock() instanceof LeavesBlock) return false;
                else {
                    BlockPos blockPos = pos.subtract(this.kiki.getBlockPos());
                    return this.world.isSpaceEmpty(this.kiki, this.kiki.getBoundingBox().offset(blockPos));
                }
            }
        }

        private int getRandomInt(int min, int max) {
            return this.kiki.getRandom().nextInt(max - min + 1) + min;
        }
    }
}
