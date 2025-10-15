package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class SowTags {
    public static final TagKey<Block> STONE_BRICKS = block("stone_bricks");
    public static final TagKey<Block> STONE_BRICK_STAIRS = block("stone_brick_stairs");
    public static final TagKey<Item> MASTER_STAFF = item("master_staff");

    private static TagKey<Block> block(String id) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, id));
    }

    private static TagKey<Item> item(String id) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, id));
    }
}
