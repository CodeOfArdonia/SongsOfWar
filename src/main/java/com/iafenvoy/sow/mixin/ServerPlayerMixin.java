package com.iafenvoy.sow.mixin;

import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player {
    public ServerPlayerMixin(Level world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Inject(method = "die", at = @At("TAIL"))
    private void onPlayerDeath(DamageSource damageSource, CallbackInfo ci) {
        if (!this.getCommandSenderWorld().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY))
            SongCubeBlock.dropAll(this);
    }
}
