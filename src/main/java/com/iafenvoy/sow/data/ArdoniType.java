package com.iafenvoy.sow.data;

import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.sow.item.SowSpawnEggItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.*;

public record ArdoniType(String id, boolean dark, Color4i primaryColor, List<Color4i> altColors) {
    private static final Map<String, ArdoniType> BY_ID = new HashMap<>();
    public static final ArdoniType NONE;
    public static final ArdoniType VOLTARIS;
    public static final ArdoniType SENDARIS;
    public static final ArdoniType NESTORIS;
    public static final ArdoniType KALTARIS;
    public static final ArdoniType MENDORIS;

    public ArdoniType(String id, boolean dark, Color4i primaryColor, Color4i... altColors) {
        this(id, dark, primaryColor, List.of(altColors));
        BY_ID.put(id, this);
    }

    public Color4i getColor(long seed) {
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
        return new SowSpawnEggItem(type, 0xFF888888, this.primaryColor.getIntValue());
    }

    public Component formatName(String prefix) {
        if (this == NONE || this.id.isEmpty()) return Component.literal(prefix);
        return Component.translatable("ardoniType.sow.%s".formatted(this.id), Component.literal(prefix));
    }

    static {
        NONE = new ArdoniType("none", false, new Color4i(255, 255, 255, 255));
        VOLTARIS = new ArdoniType("voltaris", true, new Color4i(255, 0, 0, 255));
        SENDARIS = new ArdoniType("sendaris", false, new Color4i(0, 0, 255, 255), new Color4i(0, 255, 255, 255));
        NESTORIS = new ArdoniType("nestoris", false, new Color4i(255, 255, 0, 255), new Color4i(240, 155, 89, 255));
        KALTARIS = new ArdoniType("kaltaris", false, new Color4i(0, 255, 0, 255));
        MENDORIS = new ArdoniType("mendoris", false, new Color4i(160, 32, 240, 255), new Color4i(234, 63, 247, 255));
    }
}
