package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowSounds;
import it.unimi.dsi.fastutil.ints.IntObjectImmutablePair;
import it.unimi.dsi.fastutil.ints.IntObjectPair;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SowAbilityCategories {
    public static final AbilityCategory AGGRESSIUM = new AbilityCategory(Identifier.of(SongsOfWar.MOD_ID, "aggressium"), new Color4i(237, 28, 36, 255), () -> true);
    public static final AbilityCategory MOBILIUM = new AbilityCategory(Identifier.of(SongsOfWar.MOD_ID, "mobilium"), new Color4i(255, 242, 0, 255), () -> true);
    public static final AbilityCategory PROTISIUM = new AbilityCategory(Identifier.of(SongsOfWar.MOD_ID, "protisium"), new Color4i(115, 251, 253, 255), () -> true);
    public static final AbilityCategory SUPPORTIUM = new AbilityCategory(Identifier.of(SongsOfWar.MOD_ID, "supportium"), new Color4i(117, 249, 77, 255), () -> true);
    public static final Map<AbilityCategory, IntObjectPair<Supplier<SoundEvent>>> EXTRA_DATA = new HashMap<>();
    public static final AbilityCategory[] ALL = {SowAbilityCategories.AGGRESSIUM, SowAbilityCategories.MOBILIUM, SowAbilityCategories.PROTISIUM, SowAbilityCategories.SUPPORTIUM};

    static {
        EXTRA_DATA.put(AGGRESSIUM, new IntObjectImmutablePair<>(231, SowSounds.AGGRESSIUM));
        EXTRA_DATA.put(MOBILIUM, new IntObjectImmutablePair<>(9035, SowSounds.MOBILIUM));
        EXTRA_DATA.put(PROTISIUM, new IntObjectImmutablePair<>(4290, SowSounds.PROTISIUM));
        EXTRA_DATA.put(SUPPORTIUM, new IntObjectImmutablePair<>(10, SowSounds.SUPPORTIUM));
    }
}
