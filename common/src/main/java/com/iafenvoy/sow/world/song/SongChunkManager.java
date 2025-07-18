package com.iafenvoy.sow.world.song;

import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.chunk.WorldChunk;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class SongChunkManager {
    public static boolean hasSongChunk(StructureWorldAccess serverWorld, SowAbilityCategory category, ChunkPos pos, int radius) {
        return ChunkPos.stream(pos, radius).reduce(false, (p, c) -> p || SongChunkManager.isSongChunk(serverWorld, category, c), (a, b) -> a || b);
    }

    public static boolean isSongChunk(StructureWorldAccess serverWorld, SowAbilityCategory category, ChunkPos pos) {
        WorldChunk chunk = serverWorld.getChunkManager().getWorldChunk(pos.x, pos.z);
        return !SongChunkData.byChunk(chunk).isEmpty() && new Random(serverWorld.getSeed() + category.getSeed() + pos.x * 24523L + pos.z * 89L).nextInt(SowCommonConfig.INSTANCE.common.songChunkRarity.getValue()) == 0;
    }

    @Nullable
    public static SowAbilityCategory find(StructureWorldAccess serverWorld, ChunkPos pos) {
        for (SowAbilityCategory category : SowAbilityCategory.values())
            if (isSongChunk(serverWorld, category, pos))
                return category;
        return null;
    }

    public static boolean reduce(StructureWorldAccess serverWorld, ChunkPos pos) {
        WorldChunk chunk = serverWorld.getChunkManager().getWorldChunk(pos.x, pos.z);
        if (chunk == null) return false;
        SongChunkData data = SongChunkData.byChunk(chunk);
        if (!data.isFulfilled()) data.initialize(serverWorld.getRandom().nextBetween(3, 6));
        return data.decreaseRemainNotes();
    }
}
