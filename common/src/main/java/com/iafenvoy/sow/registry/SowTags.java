package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class SowTags {
    public static final TagKey<Block> STONE_BRICKS = block("stone_bricks");
    public static final TagKey<Block> STONE_BRICK_STAIRS = block("stone_brick_stairs");
    public static final TagKey<Item> MASTER_STAFF = item("master_staff");
    public static final TagKey<Item> KIKI_FOOD = item("kiki_food");

    private static TagKey<Block> block(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(SongsOfWar.MOD_ID, id));
    }

    private static TagKey<Item> item(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(SongsOfWar.MOD_ID, id));
    }
}
