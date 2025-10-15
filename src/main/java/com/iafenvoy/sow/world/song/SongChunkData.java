package com.iafenvoy.sow.world.song;

import com.iafenvoy.sow.registry.SowAttachments;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.chunk.LevelChunk;

public class SongChunkData {
    public static final Codec<SongChunkData> CODEC = RecordCodecBuilder.create(i -> i.group(
            Codec.BOOL.fieldOf("fulfilled").forGetter(SongChunkData::isFulfilled),
            Codec.INT.fieldOf("maxNotes").forGetter(SongChunkData::getMaxNotes),
            Codec.INT.fieldOf("remain_notes").forGetter(SongChunkData::getRemainNotes)
    ).apply(i, SongChunkData::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, SongChunkData> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, SongChunkData::isFulfilled,
            ByteBufCodecs.INT, SongChunkData::getMaxNotes,
            ByteBufCodecs.INT, SongChunkData::getRemainNotes,
            SongChunkData::new
    );
    private boolean fulfilled = false;
    private int maxNotes;
    private int remainNotes;

    public SongChunkData() {
    }

    private SongChunkData(boolean fulfilled, int maxNotes, int remainNotes) {
        this.fulfilled = fulfilled;
        this.maxNotes = maxNotes;
        this.remainNotes = remainNotes;
    }

    private int getMaxNotes() {
        return this.maxNotes;
    }

    private void setMaxNotes(int maxNotes) {
        this.maxNotes = maxNotes;
    }

    public int getRemainNotes() {
        return this.remainNotes;
    }

    private void setRemainNotes(int remainNotes) {
        this.remainNotes = remainNotes;
    }

    public boolean isFulfilled() {
        return this.fulfilled;
    }

    private void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public void initialize(int remainNotes) {
        if (this.isFulfilled()) return;
        this.setFulfilled(true);
        this.setMaxNotes(remainNotes);
        this.setRemainNotes(remainNotes);
    }

    public boolean decreaseRemainNotes() {
        if (!this.isFulfilled()) return false;
        if (this.remainNotes <= 0) return false;
        this.remainNotes--;
        return true;
    }

    public void increaseRemainNotes() {
        if (!this.isFulfilled()) return;
        if (this.remainNotes >= this.maxNotes) return;
        this.remainNotes++;
    }

    public boolean isEmpty() {
        return this.fulfilled && this.remainNotes <= 0;
    }

    public static SongChunkData get(LevelChunk chunk) {
        if (chunk == null) return new SongChunkData();
        return chunk.getData(SowAttachments.SONG_CHUNK);
    }
}
