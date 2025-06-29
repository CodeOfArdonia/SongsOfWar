package com.iafenvoy.sow;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public final class Constants {
    public static final Identifier BEACON_TELEPORT = Identifier.of(SongsOfWar.MOD_ID, "beacon_teleport");
    public static final Identifier JUMP_PRESS = Identifier.of(SongsOfWar.MOD_ID, "jump_press");
    public static final UUID PROTESPHERE_UUID = UUID.fromString("babda2da-13e9-4096-baba-933bb695e319");
    public static final UUID MOBILIGLIDE_UUID = UUID.fromString("3db28b1d-3fec-4a31-9f50-6c04f30e33f1");
    @Nullable
    public static String LAST_SONG_POWER_TOOLTIP;
}
