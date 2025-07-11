package com.iafenvoy.sow.network;

import com.iafenvoy.sow.Constants;
import com.iafenvoy.sow.data.BeaconData;
import com.iafenvoy.sow.screen.BeaconTeleportScreen;
import dev.architectury.networking.NetworkManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class ClientNetworkHelper {
    public static void init() {
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, Constants.BEACON_TELEPORT, (buf, context) -> {
            BlockPos pos = buf.readBlockPos();
            BeaconData data = BeaconData.readNbt(buf.readNbt());
            context.queue(() -> MinecraftClient.getInstance().setScreen(new BeaconTeleportScreen(data, pos, 0)));
        });
    }
}
