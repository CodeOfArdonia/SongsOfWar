package com.iafenvoy.sow;

import com.iafenvoy.jupiter.ConfigManager;
import com.iafenvoy.jupiter.ServerConfigManager;
import com.iafenvoy.neptune.event.OriginsEvents;
import com.iafenvoy.neptune.power.PowerData;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.data.BeaconData;
import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import com.iafenvoy.sow.network.ServerNetworkHelper;
import com.iafenvoy.sow.registry.*;
import com.iafenvoy.sow.registry.power.SowPowerCategories;
import com.iafenvoy.sow.registry.power.SowPowers;
import com.mojang.logging.LogUtils;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.BlockEvent;
import io.github.apace100.origins.Origins;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

public final class SongsOfWar {
    public static final String MOD_ID = "sow";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        ConfigManager.getInstance().registerConfigHandler(SowCommonConfig.INSTANCE);
        ConfigManager.getInstance().registerServerConfig(SowCommonConfig.INSTANCE, ServerConfigManager.PermissionChecker.IS_OPERATOR);

        SowBlocks.REGISTRY.register();
        SowBlocks.ITEM_REGISTRY.register();
        SowBlockEntities.REGISTRY.register();
        SowDelight.BLOCK_REGISTRY.register();
        SowDelight.ITEM_REGISTRY.register();
        SowEntities.REGISTRY.register();
        SowItemGroups.REGISTRY.register();
        SowItems.REGISTRY.register();
        SowParticles.REGISTRY.register();
        SowSpawnEggs.REGISTRY.register();
        SowSkulls.REGISTRY.register();
        SowSkulls.ITEM_REGISTRY.register();
        SowSounds.REGISTRY.register();
        SowWeapons.REGISTRY.register();
        SowCommands.init();
        SowEntities.init();
    }

    public static void process() {
        SowBanners.init();
        SowPowers.init();
        BlockEvent.BREAK.register((world, pos, state, player, xp) -> {
            if (state.isOf(Blocks.BEACON) && world instanceof ServerWorld serverWorld)
                BeaconData.getInstance(serverWorld).remove(pos);
            else if (world.getBlockEntity(pos) instanceof WallsOfTimeBlockEntity blockEntity && !blockEntity.getContents().getContent().isEmpty()) {
                player.sendMessage(Text.translatable("block.sow.walls_of_time.cannot_break"));
                return EventResult.interruptFalse();
            }
            return EventResult.pass();
        });
        ServerNetworkHelper.init();
        OriginsEvents.ON_CONFIRM.register(((player, layer, origin) -> {
            if (player.getServer() != null && layer.equals(Identifier.of(Origins.MODID, "origin")))
                player.getServer().execute(() -> {
                    PowerData data = PowerData.byPlayer(player);
                    if (origin.equals(Identifier.of(SongsOfWar.MOD_ID, "ardoni")))
                        data.enable(SowPowerCategories.ALL);
                    else data.disable(SowPowerCategories.ALL);
                });
        }));
    }
}
