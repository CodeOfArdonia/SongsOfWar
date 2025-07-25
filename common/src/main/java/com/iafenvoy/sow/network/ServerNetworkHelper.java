package com.iafenvoy.sow.network;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.Constants;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.power.component.MobiliWingsComponent;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import dev.architectury.networking.NetworkManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

public class ServerNetworkHelper {
    public static void init() {
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, Constants.BEACON_TELEPORT, (buf, context) -> {
            BlockPos prev = buf.readBlockPos(), now = buf.readBlockPos();
            PlayerEntity player = context.getPlayer();
            if (player.getBlockPos().getSquaredDistance(prev) > 10 * 10) {
                SongsOfWar.LOGGER.warn("Player {} request to teleport but too far!", player.getEntityName());
                return;
            }
            context.queue(() -> {
                BlockPos newPos = player.getBlockPos().subtract(prev).add(now);
                player.requestTeleport(newPos.getX(), newPos.getY(), newPos.getZ());
            });
        });
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, Constants.JUMP_PRESS, (buf, context) -> {
            PlayerEntity player = context.getPlayer();
            AbilityData data = AbilityData.byPlayer(player);
            if (data.abilityEnabled(MobiliumPowers.MOBILIWINGS))
                context.queue(() -> {
                    if (AbilityData.byPlayer(player).getComponent(MobiliWingsComponent.ID) instanceof MobiliWingsComponent component)
                        component.speedUp();
                });
        });
    }
}
