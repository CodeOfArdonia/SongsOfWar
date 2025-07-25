package com.iafenvoy.sow.world.sound;

import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import net.minecraft.util.math.BlockPos;

public interface SongCubeSoundManager {
    void startPlaying(BlockPos pos, SowAbilityCategory category);

    void destroy(BlockPos pos);

    void tick();

    enum Empty implements SongCubeSoundManager {
        INSTANCE;

        @Override
        public void startPlaying(BlockPos pos, SowAbilityCategory category) {
        }

        @Override
        public void destroy(BlockPos pos) {
        }

        @Override
        public void tick() {
        }
    }
}
