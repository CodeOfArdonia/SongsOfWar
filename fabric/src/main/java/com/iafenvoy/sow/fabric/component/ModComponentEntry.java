package com.iafenvoy.sow.fabric.component;

import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentInitializer;

public class ModComponentEntry implements ChunkComponentInitializer {
    @Override
    public void registerChunkComponentFactories(ChunkComponentFactoryRegistry registry) {
        registry.register(SongChunkComponent.SONG_CHUNK_COMPONENT, SongChunkComponent::new);
    }
}
