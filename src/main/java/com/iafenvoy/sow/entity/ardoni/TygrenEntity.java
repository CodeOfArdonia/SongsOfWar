package com.iafenvoy.sow.entity.ardoni;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.config.Anniversary;
import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.entity.util.Flatable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class TygrenEntity extends AbstractArdoniEntity implements Flatable {
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/tygren.png");
    public static final ResourceLocation TEXTURE_MARKER = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/ardoni/special/tygren_marker.png");
    public static final Color4i COLOR = new Color4i(255, 0, 0, 255);
    private static final EntityDataAccessor<Boolean> FLAT = SynchedEntityData.defineId(TygrenEntity.class, EntityDataSerializers.BOOLEAN);

    public TygrenEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(FLAT, false);
        if (Anniversary.shouldInvoke()) this.flat();
    }

    @Override
    public ResourceLocation getTextureId() {
        return TEXTURE;
    }

    @Override
    public Optional<ResourceLocation> getMarkerTextureId() {
        return Optional.ofNullable(TEXTURE_MARKER);
    }

    @Override
    public Color4i getColor() {
        return COLOR;
    }

    @Override
    public ArdoniType getArdoniType() {
        return ArdoniType.VOLTARIS;
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        boolean success = super.hurt(source, amount);
        if (success && source.is(DamageTypes.FALLING_ANVIL))
            this.flat();
        return success;
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putBoolean("Flat", this.isFlat());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.getBoolean("Flat")) this.flat();
    }

    private void flat() {
        this.entityData.set(FLAT, true);
    }

    @Override
    public boolean isFlat() {
        return this.entityData.get(FLAT);
    }
}
