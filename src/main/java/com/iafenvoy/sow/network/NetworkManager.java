package com.iafenvoy.sow.network;

import com.iafenvoy.sow.network.payload.BeaconTeleportC2SPayload;
import com.iafenvoy.sow.network.payload.BeaconTeleportS2CPayload;
import com.iafenvoy.sow.network.payload.JumpPressPayload;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.MainThreadPayloadHandler;

@EventBusSubscriber
public final class NetworkManager {
    @SubscribeEvent
    public static void registerPayloads(RegisterPayloadHandlersEvent event) {
        event.registrar("1")
                .playToServer(JumpPressPayload.TYPE, JumpPressPayload.STREAM_CODEC, ServerNetworkHelper::onJumpPress)
                .playToServer(BeaconTeleportC2SPayload.TYPE, BeaconTeleportC2SPayload.STREAM_CODEC, ServerNetworkHelper::onBeaconTeleport)
                .playToClient(BeaconTeleportS2CPayload.TYPE, BeaconTeleportS2CPayload.STREAM_CODEC, new MainThreadPayloadHandler<>(ClientNetworkHelper::onBeaconTeleport));
    }
}
