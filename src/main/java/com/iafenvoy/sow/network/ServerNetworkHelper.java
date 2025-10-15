package com.iafenvoy.sow.network;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.network.payload.BeaconTeleportC2SPayload;
import com.iafenvoy.sow.network.payload.JumpPressPayload;
import com.iafenvoy.sow.power.component.MobiliWingsComponent;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ServerNetworkHelper {
    public static void onJumpPress(JumpPressPayload payload, IPayloadContext context) {
        Player player = context.player();
        AbilityData data = AbilityData.get(player);
        if (data.abilityEnabled(MobiliumPowers.MOBILIWINGS.get()))
            context.enqueueWork(() -> {
                if (AbilityData.get(player).getComponent(MobiliWingsComponent.ID) instanceof MobiliWingsComponent component)
                    component.speedUp(player);
            });
    }

    public static void onBeaconTeleport(BeaconTeleportC2SPayload payload, IPayloadContext context) {
        BlockPos prev = payload.prev(), now = payload.now();
        Player player = context.player();
        if (player.blockPosition().distSqr(prev) > 10 * 10) {
            SongsOfWar.LOGGER.warn("Player {} request to teleport but too far!", player.getScoreboardName());
            return;
        }
        context.enqueueWork(() -> {
            BlockPos newPos = player.blockPosition().subtract(prev).offset(now);
            player.teleportTo(newPos.getX(), newPos.getY(), newPos.getZ());
        });
    }
}
