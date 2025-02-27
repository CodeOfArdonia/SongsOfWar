package com.iafenvoy.sow.power.component;

import com.iafenvoy.neptune.util.Serializable;
import com.iafenvoy.neptune.util.Tickable;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

public class MobiliWingsComponent implements Serializable, Tickable {
    public static final Identifier ID = Identifier.of(SongsOfWar.MOD_ID, "mobiliwings");
    private final PlayerEntity player;
    private int tick = 0;

    public MobiliWingsComponent(PlayerEntity player) {
        this.player = player;
    }

    @Override
    public void encode(NbtCompound nbt) {
        nbt.putInt("tick", this.tick);
    }

    @Override
    public void decode(NbtCompound nbt) {
        this.tick = nbt.getInt("tick");
    }

    public void speedUp() {
        if (this.tick > 0) return;
        this.tick = 20;
        FireworkRocketEntity entity = new FireworkRocketEntity(this.player.getWorld(), new ItemStack(Items.AIR), this.player);
        this.player.getWorld().spawnEntity(entity);
    }

    @Override
    public void tick() {
        if (this.tick > 0) this.tick--;
    }
}
