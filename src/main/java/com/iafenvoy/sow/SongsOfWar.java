package com.iafenvoy.sow;

import com.iafenvoy.jupiter.ConfigManager;
import com.iafenvoy.jupiter.ServerConfigManager;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.registry.*;
import com.iafenvoy.sow.registry.power.*;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(SongsOfWar.MOD_ID)
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
}
