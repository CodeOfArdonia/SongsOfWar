package com.iafenvoy.sow.entity.human;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.entity.felina.NiikaEntity;
import com.iafenvoy.sow.entity.necromancer.AbstractNecromancerEntity;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

public class LucanEntity extends AbstractHumanEntity {
    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(LucanEntity.class, EntityDataSerializers.INT);
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/human/lucan/lucan.png");

    public LucanEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(STATE, 0);
    }

    public int getState() {
        return this.entityData.get(STATE);
    }

    public void setState(int state) {
        this.entityData.set(STATE, state);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getCommandSenderWorld().getEntitiesOfClass(AbstractNecromancerEntity.class, new AABB(this.position().add(20, 10, 20), this.position().subtract(20, 10, 20)), LivingEntity::isAlive).isEmpty()) {
            if (!this.getCommandSenderWorld().getEntitiesOfClass(NiikaEntity.class, new AABB(this.position().add(10, 5, 10), this.position().subtract(20, 5, 20)), LivingEntity::isAlive).isEmpty())
                this.setState(2);
            else this.setState(1);
        } else this.setState(0);
    }

    @Override
    public ResourceLocation getTextureId() {
        if (this.getState() == 0) {
            if (this.getHealth() <= this.getMaxHealth() / 2)
                return ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/human/lucan/lucan_bandaged.png");
            return TEXTURE;
        } else if (this.getState() == 1)
            return ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/human/lucan/lucan_necro.png");
        else if (this.getState() == 2)
            return ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/entity/human/lucan/lucan_necro_hoodless.png");
        return TEXTURE;
    }
}
