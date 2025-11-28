package com.iafenvoy.sow.data;

import com.iafenvoy.neptune.render.SkullRenderRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.PlayerHeadItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;

import java.util.HashMap;
import java.util.Map;

public class SkullManager {
    private static final Map<SkullBlock.Type, Tuple<ResourceLocation, Integer>> MARKER_TEXTURES = new HashMap<>();

    public static void registerSkull(SkullBlock.Type type, ResourceLocation texture, Block... blocks) {
        SkullRenderRegistry.register(type, texture, blocks);
    }

    public static void registerSkull(SkullBlock.Type type, ResourceLocation texture, ResourceLocation marker, int color, Block... blocks) {
        SkullRenderRegistry.register(type, texture, blocks);
        MARKER_TEXTURES.put(type, new Tuple<>(marker, color));
    }

    public static Tuple<ResourceLocation, Integer> getMarkerTexture(PlayerHeadItem skull) {
        return skull.getBlock() instanceof SkullBlock skullBlock ? MARKER_TEXTURES.get(skullBlock.getType()) : null;
    }
}
