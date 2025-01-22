package com.iafenvoy.sow.mixin;

import com.iafenvoy.sow.config.SowClientConfig;
import com.iafenvoy.sow.registry.SowSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Shadow
    @Nullable
    public Screen currentScreen;
    @Unique
    private SoundInstance songsOfWar$soundInstance = null;

    @Inject(method = "setScreen", at = @At("HEAD"))
    private void playDeathSound(Screen screen, CallbackInfo ci) {
        if (!SowClientConfig.INSTANCE.enableDeathSound.getValue()) return;
        if (this.currentScreen instanceof DeathScreen && this.songsOfWar$soundInstance != null) {
            MinecraftClient.getInstance().getSoundManager().stop(this.songsOfWar$soundInstance);
            this.songsOfWar$soundInstance = null;
        }
        if (screen instanceof DeathScreen) {
            PlayerEntity player = MinecraftClient.getInstance().player;
            if (player != null) {
                this.songsOfWar$soundInstance = new PositionedSoundInstance(SowSounds.SOW_DEATH.get(), SoundCategory.PLAYERS, 1, 0, Random.create(0), player.getX(), player.getY(), player.getZ());
                MinecraftClient.getInstance().getSoundManager().play(this.songsOfWar$soundInstance);
            }
        }
    }
}
