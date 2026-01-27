package com.iafenvoy.sow.config;

import com.iafenvoy.jupiter.config.container.FileConfigContainer;
import com.iafenvoy.jupiter.config.entry.BooleanEntry;
import com.iafenvoy.jupiter.config.entry.DoubleEntry;
import com.iafenvoy.sow.SongsOfWar;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.resources.ResourceLocation;

public class SowClientConfig extends FileConfigContainer {
    public static final SowClientConfig INSTANCE = new SowClientConfig();
    public final BooleanEntry enableDeathSound = BooleanEntry.builder("config.sow.client.enableDeathSound", true).json("enableDeathSound").build();
    public final DoubleEntry emissiveLayerScale = DoubleEntry.builder("config.sow.client.emissiveLayerScale", 1.0025).json("emissiveLayerScale").min(1).max(1.5).build();
    public final DoubleEntry emissiveLayerOffsetX = DoubleEntry.builder("config.sow.client.emissiveLayerOffsetX", -0.00125).json("emissiveLayerOffsetX").build();
    public final DoubleEntry emissiveLayerOffsetY = DoubleEntry.builder("config.sow.client.emissiveLayerOffsetY", -0.00125).json("emissiveLayerOffsetY").build();
    public final DoubleEntry emissiveLayerOffsetZ = DoubleEntry.builder("config.sow.client.emissiveLayerOffsetZ", -0.00125).json("emissiveLayerOffsetZ").build();
    public final IConfigEntry<Boolean> enableDeathSound = new BooleanEntry("config.sow.client.enableDeathSound", true).json("enableDeathSound");

    public SowClientConfig() {
        super(ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "sow_config_client"), "config.sow.client.title", "./config/sow/songs-of-war-client.json");
    }

    @Override
    public void init() {
        this.createTab("common", "config.sow.category.common")
                .add(this.enableDeathSound);
    }
}
