package com.iafenvoy.sow.impl.fabric;

import com.iafenvoy.sow.fabric.component.SongChunkComponent;
import com.iafenvoy.sow.world.song.SongChunkData;
import net.minecraft.world.chunk.WorldChunk;
import org.jetbrains.annotations.NotNull;

public class ComponentManagerImpl {
    public static SongChunkData getSongChunkData(@NotNull WorldChunk chunk) {
        return SongChunkComponent.SONG_CHUNK_COMPONENT.get(chunk).getData();
    }
}
