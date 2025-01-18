package com.iafenvoy.sow.network;

import com.iafenvoy.sow.Constants;
import com.iafenvoy.sow.data.BeaconData;
import com.iafenvoy.sow.power.ClientPowerEvents;
import com.iafenvoy.sow.power.type.AbstractSongPower;
import com.iafenvoy.sow.screen.BeaconTeleportScreen;
import dev.architectury.networking.NetworkManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class ClientNetworkHelper {
    public static void init() {
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, Constants.BEACON_TELEPORT, (buf, context) -> {
            BlockPos pos = buf.readBlockPos();
            BeaconData data = BeaconData.readNbt(buf.readNbt());
            context.queue(() -> MinecraftClient.getInstance().setScreen(new BeaconTeleportScreen(data, pos, 0)));
        });
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, Constants.POWER_STATE_CHANGE, (buf, context) -> {
            World world = MinecraftClient.getInstance().world;
            assert world != null;
            PlayerEntity player = world.getPlayerByUuid(buf.readUuid());
            AbstractSongPower<?> power = AbstractSongPower.byId(buf.readString());
            boolean enable = buf.readBoolean();
            if (!power.isEmpty())
                (enable ? ClientPowerEvents.POWER_ENABLE : ClientPowerEvents.POWER_DISABLE).invoker().onChange(player, power);
        });
    }
}
