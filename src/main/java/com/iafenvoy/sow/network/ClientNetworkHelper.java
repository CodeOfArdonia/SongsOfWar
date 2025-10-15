package com.iafenvoy.sow.network;

import com.iafenvoy.sow.network.payload.BeaconTeleportS2CPayload;
import com.iafenvoy.sow.screen.BeaconTeleportScreen;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.handling.IPayloadContext;

@OnlyIn(Dist.CLIENT)
public class ClientNetworkHelper {
    public static void onBeaconTeleport(BeaconTeleportS2CPayload payload, IPayloadContext context) {
        Minecraft.getInstance().setScreen(new BeaconTeleportScreen(payload.data(), payload.pos(), 0));
    }
}
