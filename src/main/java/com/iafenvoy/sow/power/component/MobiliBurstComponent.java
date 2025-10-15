package com.iafenvoy.sow.power.component;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.util.Serializable;
import com.iafenvoy.neptune.util.Tickable;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import com.iafenvoy.sow.util.SowMath;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class MobiliBurstComponent implements Serializable, Tickable {
    public static final ResourceLocation ID = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "mobiliburst");
    private boolean activate;
    private int tick = -1;

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public void setMaxTick(int tick) {
        this.tick = tick;
    }

    @Override
    public void encode(CompoundTag nbt) {
        nbt.putBoolean("activate", this.activate);
        nbt.putInt("tick", this.tick);
    }

    @Override
    public void decode(CompoundTag nbt) {
        this.activate = nbt.getBoolean("activate");
        this.tick = nbt.getInt("tick");
    }

    @Override
    public void tick(LivingEntity living) {
        if (!this.activate) return;
        if (living.getDeltaMovement().length() <= 0.1) this.tick = 0;
        else {
            Vec3 pos = living.position();
            double r = 1.5;
            List<Entity> entities = living.level().getEntities(living, new AABB(pos.add(new Vec3(r, r, r)), pos.subtract(new Vec3(r, r, r))), entity -> true);
            entities.forEach(entity -> {
                Vec3 dir = entity.position().subtract(living.position()).add(living.getDeltaMovement());
                entity.setDeltaMovement(SowMath.toUnit(dir.add(0, 0.5, 0)).scale(living.getDeltaMovement().length()));
                entity.hurtMarked = true;
                if (entity instanceof LivingEntity l)
                    l.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 2 * 20, 0), living);
            });
        }
        if (this.tick == 0) {
            this.activate = false;
            AbilityData.get(living).removeComponent(ID);
            MobiliumPowers.MOBILIBURST.get().sendApplyMessage(living, false);
        }
        this.tick--;
    }
}
