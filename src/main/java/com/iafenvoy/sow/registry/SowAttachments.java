package com.iafenvoy.sow.registry;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.world.song.SongChunkData;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class SowAttachments {
    public static final DeferredRegister<AttachmentType<?>> REGISTRY = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, SongsOfWar.MOD_ID);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<SongChunkData>> SONG_CHUNK = REGISTRY.register("song_chunk", () -> AttachmentType.builder(SongChunkData::new).serialize(SongChunkData.CODEC).sync(SongChunkData.STREAM_CODEC).build());
}
