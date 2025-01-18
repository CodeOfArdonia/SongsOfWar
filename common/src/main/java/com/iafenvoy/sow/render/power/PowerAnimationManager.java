package com.iafenvoy.sow.render.power;

import com.iafenvoy.sow.power.ClientPowerEvents;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Environment(EnvType.CLIENT)
public class PowerAnimationManager {
    private static final Set<UUID> MOBILIBURST_RENDER = new HashSet<>();

    public static boolean enableMobiliburst(PlayerEntity player) {
        return MOBILIBURST_RENDER.contains(player.getUuid());
    }

    static {
        ClientPowerEvents.POWER_ENABLE.register((player, songPower) -> {
            if (songPower == MobiliumPowers.MOBILIBURST)
                MOBILIBURST_RENDER.add(player.getUuid());
        });
        ClientPowerEvents.POWER_DISABLE.register((player, songPower) -> {
            if (songPower == MobiliumPowers.MOBILIBURST)
                MOBILIBURST_RENDER.remove(player.getUuid());
        });
    }
}
