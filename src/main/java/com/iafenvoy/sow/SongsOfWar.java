package com.iafenvoy.sow;

import com.iafenvoy.jupiter.ConfigManager;
import com.iafenvoy.jupiter.ServerConfigManager;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.data.BeaconData;
import com.iafenvoy.sow.item.block.entity.WallsOfTimeBlockEntity;
import com.iafenvoy.sow.registry.*;
import com.iafenvoy.sow.registry.power.*;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.slf4j.Logger;

@Mod(SongsOfWar.MOD_ID)
@EventBusSubscriber
public final class SongsOfWar {
    public static final String MOD_ID = "sow";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SongsOfWar(ModContainer container, IEventBus bus) {
        ConfigManager.getInstance().registerConfigHandler(SowCommonConfig.INSTANCE);
        ConfigManager.getInstance().registerServerConfig(SowCommonConfig.INSTANCE, ServerConfigManager.PermissionChecker.IS_OPERATOR);

        SowArmorMaterials.REGISTRY.register(bus);
        SowAttachments.REGISTRY.register(bus);
        SowBlocks.REGISTRY.register(bus);
        SowBlockEntities.REGISTRY.register(bus);
        SowDataComponents.REGISTRY.register(bus);
        SowDelight.BLOCK_REGISTRY.register(bus);
        SowDelight.ITEM_REGISTRY.register(bus);
        SowEntities.REGISTRY.register(bus);
        SowCreativeTabs.REGISTRY.register(bus);
        SowItems.REGISTRY.register(bus);
        SowParticles.REGISTRY.register(bus);
        SowSpawnEggs.REGISTRY.register(bus);
        SowSkulls.BLOCK_REGISTRY.register(bus);
        SowSkulls.ITEM_REGISTRY.register(bus);
        SowSounds.REGISTRY.register(bus);
        SowWeapons.REGISTRY.register(bus);
        //Powers
        SowAbilityCategories.REGISTRY.register(bus);
        AggressiumPowers.REGISTRY.register(bus);
        MobiliumPowers.REGISTRY.register(bus);
        ProtisiumPowers.REGISTRY.register(bus);
        SupportiumPowers.REGISTRY.register(bus);
    }

    @SubscribeEvent
    public static void onBreakBlock(BlockEvent.BreakEvent event) {
        if (event.getState().is(Blocks.BEACON) && event.getLevel() instanceof ServerLevel serverWorld)
            BeaconData.getInstance(serverWorld).remove(event.getPos());
        else if (event.getLevel().getBlockEntity(event.getPos()) instanceof WallsOfTimeBlockEntity blockEntity && !blockEntity.getContents().getContent().isEmpty()) {
            event.getPlayer().sendSystemMessage(Component.translatable("block.sow.walls_of_time.cannot_break"));
            event.setCanceled(true);
        }
    }
}
