package com.iafenvoy.sow.event;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.data.BeaconData;
import com.iafenvoy.sow.item.SongCubeItem;
import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import com.iafenvoy.sow.power.PowerMergeHelper;
import com.iafenvoy.sow.registry.power.MobiliumPowers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public final class ServerEvents {
    @SubscribeEvent
    public static void onBreakBlock(BlockEvent.BreakEvent event) {
        if (event.getState().is(Blocks.BEACON) && event.getLevel() instanceof ServerLevel serverWorld)
            BeaconData.getInstance(serverWorld).remove(event.getPos());
        else if (event.getLevel().getBlockEntity(event.getPos()) instanceof WallsOfTimeBlockEntity blockEntity && !blockEntity.getContents().getContent().isEmpty()) {
            event.getPlayer().sendSystemMessage(Component.translatable("block.sow.walls_of_time.cannot_break"));
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingEntityDie(LivingDeathEvent event) {
        if (!event.getEntity().level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY))
            SongCubeItem.dropAll(event.getEntity());
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        AbilityData data = AbilityData.get(event.getEntity());
        if (event.getEntity().level() instanceof ServerLevel serverWorld)
            PowerMergeHelper.run(data, event.getEntity(), serverWorld);
        if (data.abilityEnabled(MobiliumPowers.MOBILILEAP.get()))
            event.getEntity().fallDistance = 0;
    }
}
