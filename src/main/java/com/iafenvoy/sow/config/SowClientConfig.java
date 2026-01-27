package com.iafenvoy.sow.config;

import com.iafenvoy.jupiter.config.container.FileConfigContainer;
import com.iafenvoy.jupiter.config.entry.BooleanEntry;
import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.resources.ResourceLocation;

public class SowClientConfig extends FileConfigContainer {
    public static final SowClientConfig INSTANCE = new SowClientConfig();
    public final BooleanEntry enableDeathSound = BooleanEntry.builder("config.sow.client.enableDeathSound", true).key("enableDeathSound").build();

    public SowClientConfig() {
        super(ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "sow_config_client"), "config.sow.client.title", "./config/sow/songs-of-war-client.json");
    }

    @Override
    public void init() {
        this.createTab("common", "config.sow.category.common")
                .addEntry(this.enableDeathSound);
    }
}
