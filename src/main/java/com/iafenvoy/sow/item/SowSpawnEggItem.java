package com.iafenvoy.sow.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class SowSpawnEggItem extends DeferredSpawnEggItem {
    public SowSpawnEggItem(DeferredHolder<EntityType<?>, ? extends EntityType<? extends Mob>> entityType, int backgroundColor, int highlightColor) {
        super(entityType, backgroundColor, highlightColor, new Properties());
    }

    public static Supplier<SowSpawnEggItem> create(DeferredHolder<EntityType<?>, ? extends EntityType<? extends Mob>> entityType, final int backgroundColor, final int highlightColor) {
        return () -> new SowSpawnEggItem(entityType, backgroundColor, highlightColor);
    }
}
