package com.iafenvoy.sow.config;

import com.iafenvoy.jupiter.config.container.FileConfigContainer;
import com.iafenvoy.jupiter.config.entry.BooleanEntry;
import com.iafenvoy.jupiter.config.entry.DoubleEntry;
import com.iafenvoy.jupiter.interfaces.IConfigEntry;
import com.iafenvoy.sow.SongsOfWar;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.resources.ResourceLocation;

public class SowClientConfig extends FileConfigContainer {
    public static final SowClientConfig INSTANCE = new SowClientConfig();
    public final IConfigEntry<Boolean> enableDeathSound = new BooleanEntry("config.sow.client.enableDeathSound", true).json("enableDeathSound");
    public final IConfigEntry<Double> emissiveLayerScale = new DoubleEntry("config.sow.client.emissiveLayerScale", 1.0025, 1, 1.5).json("emissiveLayerScale");
    public final IConfigEntry<Double> emissiveLayerOffsetX = new DoubleEntry("config.sow.client.emissiveLayerOffsetX", -0.00125).json("emissiveLayerOffsetX");
    public final IConfigEntry<Double> emissiveLayerOffsetY = new DoubleEntry("config.sow.client.emissiveLayerOffsetY", -0.00125).json("emissiveLayerOffsetY");
    public final IConfigEntry<Double> emissiveLayerOffsetZ = new DoubleEntry("config.sow.client.emissiveLayerOffsetZ", -0.00125).json("emissiveLayerOffsetZ");

    public SowClientConfig() {
        super(ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "sow_config_client"), "config.sow.client.title", "./config/sow/songs-of-war-client.json");
    }

    @Override
    public void init() {
        this.createTab("common", "config.sow.category.common")
                .add(this.enableDeathSound)
                .add(this.emissiveLayerScale)
                .add(this.emissiveLayerOffsetX)
                .add(this.emissiveLayerOffsetY)
                .add(this.emissiveLayerOffsetZ);
    }

    public static void processEmissiveStack(PoseStack matrices) {
        float scale = SowClientConfig.INSTANCE.emissiveLayerScale.getValue().floatValue();
        matrices.scale(scale, scale, scale);
        float x = SowClientConfig.INSTANCE.emissiveLayerOffsetX.getValue().floatValue();
        float y = SowClientConfig.INSTANCE.emissiveLayerOffsetY.getValue().floatValue();
        float z = SowClientConfig.INSTANCE.emissiveLayerOffsetZ.getValue().floatValue();
        matrices.translate(x, y, z);
    }
}
