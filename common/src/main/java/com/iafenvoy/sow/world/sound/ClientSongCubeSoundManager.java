package com.iafenvoy.sow.world.sound;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.sound.AbstractSoundInstance;
import net.minecraft.client.sound.TickableSoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.LocalRandom;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public enum ClientSongCubeSoundManager implements SongCubeSoundManager {
    INSTANCE;
    private static final Map<BlockPos, SongCubeSoundInstance> INSTANCES = new HashMap<>();
    private static final int MAX_DISTANCE = 10;

    @Override
    public void startPlaying(BlockPos pos, AbilityCategory category) {
        if (category == null) return;
        if (farEnough(pos)) {
            this.destroy(pos);
            return;
        }
        if (!INSTANCES.containsKey(pos)) INSTANCES.put(pos, new SongCubeSoundInstance(pos, category));
        INSTANCES.get(pos).start();
    }

    @Override
    public void destroy(BlockPos pos) {
        SongCubeSoundInstance instance = INSTANCES.remove(pos);
        if (instance != null) instance.stop();
    }

    @Override
    public void tick() {
        for (BlockPos pos : INSTANCES.keySet())
            if (farEnough(pos))
                this.destroy(pos);
    }

    public static boolean farEnough(BlockPos pos) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        return player == null || player.getBlockPos().getSquaredDistance(pos) > MAX_DISTANCE * MAX_DISTANCE;
    }

    private static class SongCubeSoundInstance extends AbstractSoundInstance implements TickableSoundInstance {
        private static final Supplier<MinecraftClient> client = MinecraftClient::getInstance;
        private boolean playing;

        public SongCubeSoundInstance(BlockPos pos, AbilityCategory category) {
            super(SowAbilityCategories.EXTRA_DATA.get(category).second().get(), SoundCategory.BLOCKS, new LocalRandom(0));
            this.repeat = true;
            this.x = pos.getX();
            this.y = pos.getY();
            this.z = pos.getZ();
            this.playing = false;
        }

        public void start() {
            if (!this.playing) {
                client.get().getSoundManager().play(this);
                this.playing = true;
            }
        }

        public void stop() {
            if (this.playing) {
                client.get().getSoundManager().stop(this);
                this.playing = false;
            }
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public void tick() {
            ClientPlayerEntity player = client.get().player;
            if (player == null) return;
            double distance = Math.sqrt(player.squaredDistanceTo(this.x, this.y, this.z));
            if (distance > MAX_DISTANCE) this.stop();
            else this.volume = (float) (1 - 0.9 * distance / MAX_DISTANCE);
        }
    }
}
