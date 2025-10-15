package com.iafenvoy.sow.entity;

import com.iafenvoy.neptune.render.EntityTextureProvider;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GlacianEntity extends Monster implements EntityTextureProvider {
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(GlacianEntity.class, EntityDataSerializers.INT);

    public GlacianEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.ARMOR, 10.0)
                .add(Attributes.ATTACK_DAMAGE, 4.0)
                .add(Attributes.FOLLOW_RANGE, 64.0)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, false) {
            //TODO
            private double getAttackReachSqr(LivingEntity entity) {
                return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
            }
        });
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.5));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new OpenDoorGoal(this, false));
        this.goalSelector.addGoal(5, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(6, new BreakDoorGoal(this, e -> true));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new FloatGoal(this));
    }

    @Override
    public boolean removeWhenFarAway(double distanceSquared) {
        return false;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 1);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("variant", this.getVariant());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("variant")) this.setVariant(nbt.getInt("variant"));
        else this.setVariant(RandomHelper.nextInt(1, 4));
    }

    //FIXME
    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor world, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnReason, @Nullable SpawnGroupData entityData) {
        SpawnGroupData data = super.finalizeSpawn(world, difficulty, spawnReason, entityData);
        this.setVariant(RandomHelper.nextInt(1, 4));
        return data;
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    @Override
    public ResourceLocation getTextureId() {
        return ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/glacian/glacian_" + this.getVariant() + ".png");
    }

    @Override
    public float getScale() {
        return 0.8f;
    }
}
