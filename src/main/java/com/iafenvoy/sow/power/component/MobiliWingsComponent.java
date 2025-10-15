package com.iafenvoy.sow.power.component;

import com.iafenvoy.neptune.util.Serializable;
import com.iafenvoy.neptune.util.Tickable;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MobiliWingsComponent implements Serializable, Tickable {
    public static final ResourceLocation ID = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "mobiliwings");
    private int tick = 0;

    @Override
    public void encode(CompoundTag nbt) {
        nbt.putInt("tick", this.tick);
    }

    @Override
    public void decode(CompoundTag nbt) {
        this.tick = nbt.getInt("tick");
    }

    public void speedUp(LivingEntity living) {
        if (this.tick > 0) return;
        this.tick = 20;
        FireworkRocketEntity entity = new FireworkRocketEntity(living.level(), new ItemStack(Items.AIR), living);
        living.level().addFreshEntity(entity);
    }

    @Override
    public void tick(LivingEntity living) {
        if (this.tick > 0) this.tick--;
    }
}
