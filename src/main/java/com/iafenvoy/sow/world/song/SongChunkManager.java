package com.iafenvoy.sow.world.song;

import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.LevelChunk;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class SongChunkManager {
    public static boolean hasSongChunk(WorldGenLevel serverWorld, SowAbilityCategory category, ChunkPos pos, int radius) {
        return ChunkPos.rangeClosed(pos, radius).reduce(false, (p, c) -> p || SongChunkManager.isSongChunk(serverWorld, category, c), (a, b) -> a || b);
    }

    public static boolean isSongChunk(WorldGenLevel serverWorld, SowAbilityCategory category, ChunkPos pos) {
        LevelChunk chunk = serverWorld.getChunkSource().getChunkNow(pos.x, pos.z);
        return !SongChunkData.get(chunk).isEmpty() && new Random(serverWorld.getSeed() + category.getSeed() + pos.x * 24523L + pos.z * 89L).nextInt(SowCommonConfig.INSTANCE.common.songChunkRarity.getValue()) == 0;
    }

    @Nullable
    public static SowAbilityCategory find(WorldGenLevel serverWorld, ChunkPos pos) {
        for (SowAbilityCategory category : SowAbilityCategory.values())
            if (isSongChunk(serverWorld, category, pos))
                return category;
        return null;
    }

    public static boolean reduce(WorldGenLevel serverWorld, ChunkPos pos) {
        LevelChunk chunk = serverWorld.getChunkSource().getChunkNow(pos.x, pos.z);
        if (chunk == null) return false;
        SongChunkData data = SongChunkData.get(chunk);
        if (!data.isFulfilled()) data.initialize(serverWorld.getRandom().nextIntBetweenInclusive(3, 6));
        return data.decreaseRemainNotes();
    }
}
