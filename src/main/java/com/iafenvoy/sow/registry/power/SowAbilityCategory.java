package com.iafenvoy.sow.registry.power;

import com.google.common.base.Suppliers;
import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.registry.SowSounds;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

//TODO::Remove this
public enum SowAbilityCategory {
    AGGRESSIUM(new AbilityCategory(new Color4i(237, 28, 36, 255), () -> true), 231, SowSounds.AGGRESSIUM),
    MOBILIUM(new AbilityCategory(new Color4i(255, 242, 0, 255), () -> true), 9035, SowSounds.MOBILIUM),
    PROTISIUM(new AbilityCategory(new Color4i(115, 251, 253, 255), () -> true), 4290, SowSounds.PROTISIUM),
    SUPPORTIUM(new AbilityCategory(new Color4i(117, 249, 77, 255), () -> true), 10, SowSounds.SUPPORTIUM);
    public static final Supplier<List<AbilityCategory>> ALL = Suppliers.memoize(() -> Arrays.stream(SowAbilityCategory.values()).map(SowAbilityCategory::getCategory).toList());

    private final AbilityCategory category;
    private final int seed;
    private final Supplier<SoundEvent> sound;

    SowAbilityCategory(AbilityCategory category, int seed, Supplier<SoundEvent> sound) {
        this.category = category;
        this.seed = seed;
        this.sound = sound;
    }

    public AbilityCategory getCategory() {
        return this.category;
    }

    public int getSeed() {
        return this.seed;
    }

    public SoundEvent getSound() {
        return this.sound.get();
    }

    @Nullable
    public static SowAbilityCategory byCategory(AbilityCategory category) {
        return Arrays.stream(values()).filter(x -> x.getCategory() == category).findFirst().orElse(null);
    }
}
