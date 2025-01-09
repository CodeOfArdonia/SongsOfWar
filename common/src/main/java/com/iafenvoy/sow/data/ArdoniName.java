package com.iafenvoy.sow.data;

import com.iafenvoy.sow.SongsOfWar;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Environment(EnvType.CLIENT)
public enum ArdoniName implements SynchronousResourceReloader, ArdoniNameProxy {
    INSTANCE;
    private static final List<String> NAMES = new ArrayList<>();

    @Override
    public void reload(ResourceManager manager) {
        NAMES.clear();
        load(manager, MinecraftClient.getInstance().options.language.toLowerCase(Locale.ROOT));
        if (NAMES.isEmpty()) load(manager, "en_us");
        SongsOfWar.LOGGER.info("Successfully loaded {} ardoni name(s),", NAMES.size());
    }

    private static void load(ResourceManager manager, String language) {
        Identifier file = Identifier.of(SongsOfWar.MOD_ID, "ardoni_name/%s.txt".formatted(language));
        for (Resource resource : manager.getAllResources(file))
            try {
                BufferedReader reader = resource.getReader();
                String s;
                while ((s = reader.readLine()) != null) NAMES.add(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public @NotNull String getNameBySeed(long seed) throws UnsupportedOperationException {
        return NAMES.get((int) (seed % NAMES.size()));
    }
}
