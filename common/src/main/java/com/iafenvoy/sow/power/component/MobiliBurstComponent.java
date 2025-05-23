package com.iafenvoy.sow.power.component;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.util.Serializable;
import com.iafenvoy.neptune.util.Tickable;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import com.iafenvoy.sow.util.SowMath;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class MobiliBurstComponent implements Serializable, Tickable {
    public static final Identifier ID = Identifier.of(SongsOfWar.MOD_ID, "mobiliburst");
    private final PlayerEntity player;
    private boolean activate;
    private int tick = -1;

    public MobiliBurstComponent(PlayerEntity player) {
        this.player = player;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public void setMaxTick(int tick) {
        this.tick = tick;
    }

    @Override
    public void encode(NbtCompound nbt) {
        nbt.putBoolean("activate", this.activate);
        nbt.putInt("tick", this.tick);
    }

    @Override
    public void decode(NbtCompound nbt) {
        this.activate = nbt.getBoolean("activate");
        this.tick = nbt.getInt("tick");
    }

    @Override
    public void tick() {
        if (!this.activate) return;
        if (this.player.getVelocity().length() <= 0.1) this.tick = 0;
        else {
            Vec3d pos = this.player.getPos();
            double r = 1.5;
            List<Entity> entities = this.player.getWorld().getOtherEntities(this.player, new Box(pos.add(new Vec3d(r, r, r)), pos.subtract(new Vec3d(r, r, r))), entity -> true);
            entities.forEach(entity -> {
                Vec3d dir = entity.getPos().subtract(this.player.getPos()).add(this.player.getVelocity());
                entity.setVelocity(SowMath.toUnit(dir.add(0, 0.5, 0)).multiply(this.player.getVelocity().length()));
                entity.velocityModified = true;
                if (entity instanceof LivingEntity living)
                    living.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 2 * 20, 0), this.player);
            });
        }
        if (this.tick == 0) {
            this.activate = false;
            AbilityData.byPlayer(this.player).removeComponent(ID);
            MobiliumPowers.MOBILIBURST.sendApplyMessage(this.player, false);
        }
        this.tick--;
    }
}
