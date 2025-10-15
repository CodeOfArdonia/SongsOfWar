package com.iafenvoy.sow.render.power;

import com.iafenvoy.neptune.event.AbilityStateChangeEvent;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(Dist.CLIENT)
public class PowerAnimationManager {
    private static final Set<UUID> MOBILIBURST_RENDER = new HashSet<>();

    public static boolean enableMobiliburst(Player player) {
        return MOBILIBURST_RENDER.contains(player.getUUID());
    }

    @SubscribeEvent
    public static void onAbilityStateChange(AbilityStateChangeEvent event) {
        if (event.getAbility() == MobiliumPowers.MOBILIBURST.get())
            if (event.isEnabled()) MOBILIBURST_RENDER.add(event.getPlayer().getUUID());
            else MOBILIBURST_RENDER.remove(event.getPlayer().getUUID());
    }
}
