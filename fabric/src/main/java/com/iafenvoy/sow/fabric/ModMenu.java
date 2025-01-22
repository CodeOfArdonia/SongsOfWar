package com.iafenvoy.sow.fabric;

import com.iafenvoy.jupiter.render.screen.ConfigSelectScreen;
import com.iafenvoy.sow.config.SowClientConfig;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.minecraft.text.Text;

public class ModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> new ConfigSelectScreen<>(Text.translatable("config.sow.title"), parent, SowCommonConfig.INSTANCE, SowClientConfig.INSTANCE);
    }
}
