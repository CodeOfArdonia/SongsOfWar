package com.iafenvoy.sow.power;

import com.iafenvoy.sow.power.type.AbstractSongPower;
import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;

@Environment(EnvType.CLIENT)
public class ClientPowerEvents {
    public static final Event<PowerStateChange> POWER_ENABLE = EventFactory.of(callbacks -> (player, songPower) -> callbacks.forEach(x -> x.onChange(player, songPower)));
    //Note: Disable only invoke for persist song power
    public static final Event<PowerStateChange> POWER_DISABLE = EventFactory.of(callbacks -> (player, songPower) -> callbacks.forEach(x -> x.onChange(player, songPower)));

    @FunctionalInterface
    public interface PowerStateChange {
        void onChange(PlayerEntity player, AbstractSongPower<?> songPower);
    }
}
