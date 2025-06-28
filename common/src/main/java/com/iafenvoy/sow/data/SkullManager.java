package com.iafenvoy.sow.data;

import com.iafenvoy.neptune.render.SkullRenderRegistry;
import com.iafenvoy.neptune.util.Color4i;
import net.minecraft.block.Block;
import net.minecraft.block.SkullBlock;
import net.minecraft.item.SkullItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class SkullManager {
    private static final Map<SkullBlock.SkullType, Pair<Identifier, Color4i>> MARKER_TEXTURES = new HashMap<>();

    public static void registerSkull(SkullBlock.SkullType type, Identifier texture, Block... blocks) {
        SkullRenderRegistry.register(type, texture, blocks);
    }

    public static void registerSkull(SkullBlock.SkullType type, Identifier texture, Identifier marker, Color4i color, Block... blocks) {
        SkullRenderRegistry.register(type, texture, blocks);
        MARKER_TEXTURES.put(type, new Pair<>(marker, color));
    }

    public static Pair<Identifier, Color4i> getMarkerTexture(SkullItem skull) {
        return skull.getBlock() instanceof SkullBlock skullBlock ? MARKER_TEXTURES.get(skullBlock.getSkullType()) : null;
    }
}
