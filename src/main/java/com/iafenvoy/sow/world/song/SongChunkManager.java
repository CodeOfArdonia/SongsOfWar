package com.iafenvoy.sow.world.song;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.LevelChunk;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class SongChunkManager {
    public static final Object2IntMap<AbilityCategory> SEEDS = new Object2IntOpenHashMap<>();

    static {
        SEEDS.put(SowAbilityCategories.AGGRESSIUM.get(), 231);
        SEEDS.put(SowAbilityCategories.MOBILIUM.get(), 9035);
        SEEDS.put(SowAbilityCategories.PROTISIUM.get(), 4290);
        SEEDS.put(SowAbilityCategories.SUPPORTIUM.get(), 10);
    }

    public static boolean hasSongChunk(WorldGenLevel serverWorld, AbilityCategory category, ChunkPos pos, int radius) {
        return ChunkPos.rangeClosed(pos, radius).reduce(false, (p, c) -> p || SongChunkManager.isSongChunk(serverWorld, category, c), (a, b) -> a || b);
    }

    public static boolean isSongChunk(WorldGenLevel serverWorld, AbilityCategory category, ChunkPos pos) {
        LevelChunk chunk = serverWorld.getChunkSource().getChunkNow(pos.x, pos.z);
        return !SongChunkData.get(chunk).isEmpty() && new Random(serverWorld.getSeed() + SEEDS.getOrDefault(category, 0) + pos.x * 24523L + pos.z * 89L).nextInt(SowCommonConfig.INSTANCE.common.songChunkRarity.getValue()) == 0;
    }

    @Nullable
    public static AbilityCategory find(WorldGenLevel serverWorld, ChunkPos pos) {
        for (AbilityCategory category : SowAbilityCategories.ALL.get())
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
