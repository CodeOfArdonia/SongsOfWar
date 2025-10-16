package com.iafenvoy.sow.world.sound;

import com.iafenvoy.neptune.ability.AbilityCategory;
import net.minecraft.core.BlockPos;

public interface SongCubeSoundManager {
    void startPlaying(BlockPos pos, AbilityCategory category);

    void destroy(BlockPos pos);

    void tick();

    enum Empty implements SongCubeSoundManager {
        INSTANCE;

        @Override
        public void startPlaying(BlockPos pos, AbilityCategory category) {
        }

        @Override
        public void destroy(BlockPos pos) {
        }

        @Override
        public void tick() {
        }
    }
}
