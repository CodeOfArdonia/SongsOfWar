package com.iafenvoy.sow.impl;

import com.iafenvoy.sow.world.song.SongChunkData;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.chunk.WorldChunk;
import org.jetbrains.annotations.NotNull;

public class ComponentManager {
    @ExpectPlatform
    public static SongChunkData getSongChunkData(@NotNull WorldChunk chunk) {
        throw new AssertionError("This method should be replaced by Architectury");
    }
}
