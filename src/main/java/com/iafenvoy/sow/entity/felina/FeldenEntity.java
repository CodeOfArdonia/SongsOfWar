package com.iafenvoy.sow.entity.felina;

import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class FeldenEntity extends AbstractFelinaEntity {
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(FeldenEntity.class, EntityDataSerializers.INT);

    public FeldenEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 1);
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int type) {
        this.entityData.set(VARIANT, type);
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
        else this.setVariant(RandomHelper.nextInt(1, 2));
    }

    @Override
    public ResourceLocation getTextureId() {
        return ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/felina/felden_" + this.getVariant() + ".png");
    }

    @Override
    public float getScale() {
        return 1.05f;
    }
}
