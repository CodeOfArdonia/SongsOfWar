package com.iafenvoy.sow.event;

import com.iafenvoy.sow.Proxies;
import com.iafenvoy.sow.config.SowClientConfig;
import com.iafenvoy.sow.registry.SowSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(Dist.CLIENT)
public class ClientEvents {
    private static SoundInstance DEATH_SOUND_INSTANCE = null;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Proxies.songCubeSoundManager.tick();
    }

    @SubscribeEvent
    public static void onDeathScreenOpen(ScreenEvent.Opening event) {
        if (!SowClientConfig.INSTANCE.enableDeathSound.getValue()) return;
        if (event.getCurrentScreen() instanceof DeathScreen && DEATH_SOUND_INSTANCE != null) {
            Minecraft.getInstance().getSoundManager().stop(DEATH_SOUND_INSTANCE);
            DEATH_SOUND_INSTANCE = null;
        }
        if (event.getNewScreen() instanceof DeathScreen) {
            Player player = Minecraft.getInstance().player;
            if (player != null) {
                DEATH_SOUND_INSTANCE = new SimpleSoundInstance(SowSounds.SOW_DEATH.get(), SoundSource.PLAYERS, 1, 0, RandomSource.create(0), player.getX(), player.getY(), player.getZ());
                Minecraft.getInstance().getSoundManager().play(DEATH_SOUND_INSTANCE);
            }
        }
    }
}
