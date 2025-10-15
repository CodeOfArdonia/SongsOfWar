package com.iafenvoy.sow.mixin;

import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.world.song.SongChunkData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.storage.ServerLevelData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerLevel.class)
public class ServerLevelMixin {
    @Shadow
    @Final
    private ServerLevelData serverLevelData;

    @Inject(method = "tickChunk", at = @At("RETURN"))
    private void onMidnight(LevelChunk chunk, int randomTickSpeed, CallbackInfo ci) {
        if (SowCommonConfig.INSTANCE.common.songChunkRegen.getValue() && this.serverLevelData.getDayTime() % 24000 == 18000)
            SongChunkData.get(chunk).increaseRemainNotes();
    }
}
