package com.iafenvoy.sow.world.sound;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.sow.registry.SowSounds;
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public enum ClientSongCubeSoundManager implements SongCubeSoundManager {
    INSTANCE;
    private static final Map<BlockPos, SongCubeSoundInstance> INSTANCES = new HashMap<>();
    private static final int MAX_DISTANCE = 10;
    public static final Map<AbilityCategory, SoundEvent> SOUNDS = new LinkedHashMap<>();

    static {
        SOUNDS.put(SowAbilityCategories.AGGRESSIUM.get(), SowSounds.AGGRESSIUM.get());
        SOUNDS.put(SowAbilityCategories.MOBILIUM.get(), SowSounds.MOBILIUM.get());
        SOUNDS.put(SowAbilityCategories.PROTISIUM.get(), SowSounds.PROTISIUM.get());
        SOUNDS.put(SowAbilityCategories.SUPPORTIUM.get(), SowSounds.SUPPORTIUM.get());
    }

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
        Player player = Minecraft.getInstance().player;
        return player == null || player.blockPosition().distSqr(pos) > MAX_DISTANCE * MAX_DISTANCE;
    }

    private static class SongCubeSoundInstance extends AbstractSoundInstance implements TickableSoundInstance {
        private static final Supplier<Minecraft> client = Minecraft::getInstance;
        private boolean playing;

        public SongCubeSoundInstance(BlockPos pos, AbilityCategory category) {
            super(SOUNDS.get(category), SoundSource.BLOCKS, new SingleThreadedRandomSource(0));
            this.looping = true;
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
        public boolean isStopped() {
            return false;
        }

        @Override
        public void tick() {
            LocalPlayer player = client.get().player;
            if (player == null) return;
            double distance = Math.sqrt(player.distanceToSqr(this.x, this.y, this.z));
            if (distance > MAX_DISTANCE) this.stop();
            else this.volume = (float) (1 - 0.9 * distance / MAX_DISTANCE);
        }
    }
}
