package com.iafenvoy.sow.data;

import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.item.SowSpawnEggItem;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public record ArdoniType(String id, boolean dark, int primaryColor, IntList altColors) {
    private static final Map<String, ArdoniType> BY_ID = new HashMap<>();
    public static final ArdoniType NONE;
    public static final ArdoniType VOLTARIS;
    public static final ArdoniType SENDARIS;
    public static final ArdoniType NESTORIS;
    public static final ArdoniType KALTARIS;
    public static final ArdoniType MENDORIS;

    public ArdoniType(String id, boolean dark, int primaryColor, int... altColors) {
        this(id, dark, primaryColor, IntList.of(altColors));
        BY_ID.put(id, this);
    }

    public int getColor(long seed) {
        Random random = new Random(seed);
        if (this.altColors.isEmpty() || random.nextInt(3) > 0) return this.primaryColor;
        return RandomHelper.randomOne(random, this.altColors);
    }

    public static ArdoniType byId(String id) {
        return BY_ID.getOrDefault(id, NONE);
    }

    public static ArdoniType random() {
        return RandomHelper.randomOne(new ArrayList<>(BY_ID.values()));
    }

    public SowSpawnEggItem createSpawnEgg(DeferredHolder<EntityType<?>, ? extends EntityType<? extends Mob>> type) {
        return new SowSpawnEggItem(type, 0xFF888888, this.primaryColor);
    }

    public Component formatName(String prefix) {
        if (this == NONE || this.id.isEmpty()) return Component.literal(prefix);
        return Component.translatable("ardoniType.sow.%s".formatted(this.id), Component.literal(prefix));
    }

    static {
        NONE = new ArdoniType("none", false, 0xFFFFFFFF);
        VOLTARIS = new ArdoniType("voltaris", true, 0xFFFF0000);
        SENDARIS = new ArdoniType("sendaris", false, 0xFF0000FF, 0xFF00FFFF);
        NESTORIS = new ArdoniType("nestoris", false, 0xFFFFFF00, 0xFFF09B59);
        KALTARIS = new ArdoniType("kaltaris", false, 0xFF00FF00);
        MENDORIS = new ArdoniType("mendoris", false, 0xFFA020F0, 0xFFEA3FF7);
    }
}
