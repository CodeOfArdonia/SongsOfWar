package com.iafenvoy.sow.render;

import com.iafenvoy.sow.SongsOfWar;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public final class RenderConstants {
    public static final Identifier WHITE_TEXTURE = Identifier.of(SongsOfWar.MOD_ID, "textures/white.png");
    public static final Identifier STONE_TEXTURE = Identifier.of(Identifier.DEFAULT_NAMESPACE, "textures/block/stone.png");
}
