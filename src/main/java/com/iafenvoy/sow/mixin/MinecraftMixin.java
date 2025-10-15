package com.iafenvoy.sow.mixin;

import com.iafenvoy.sow.config.SowClientConfig;
import com.iafenvoy.sow.registry.SowSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@OnlyIn(Dist.CLIENT)
@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow
    @Nullable
    public Screen screen;
    @Unique
    private SoundInstance songsOfWar$soundInstance = null;

    @Inject(method = "setScreen", at = @At("HEAD"))
    private void playDeathSound(Screen screen, CallbackInfo ci) {
        if (!SowClientConfig.INSTANCE.enableDeathSound.getValue()) return;
        if (this.screen instanceof DeathScreen && this.songsOfWar$soundInstance != null) {
            Minecraft.getInstance().getSoundManager().stop(this.songsOfWar$soundInstance);
            this.songsOfWar$soundInstance = null;
        }
        if (screen instanceof DeathScreen) {
            Player player = Minecraft.getInstance().player;
            if (player != null) {
                this.songsOfWar$soundInstance = new SimpleSoundInstance(SowSounds.SOW_DEATH.get(), SoundSource.PLAYERS, 1, 0, RandomSource.create(0), player.getX(), player.getY(), player.getZ());
                Minecraft.getInstance().getSoundManager().play(this.songsOfWar$soundInstance);
            }
        }
    }
}
