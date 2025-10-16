package com.iafenvoy.sow.data;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@OnlyIn(Dist.CLIENT)
public enum ArdoniName implements ResourceManagerReloadListener, ArdoniNameProxy {
    INSTANCE;
    private static final List<String> NAMES = new ArrayList<>();

    @Override
    public void onResourceManagerReload(@NotNull ResourceManager manager) {
        NAMES.clear();
        load(manager, Minecraft.getInstance().options.languageCode.toLowerCase(Locale.ROOT));
        if (NAMES.isEmpty()) load(manager, "en_us");
        SongsOfWar.LOGGER.info("Successfully loaded {} ardoni name(s),", NAMES.size());
    }

    private static void load(ResourceManager manager, String language) {
        ResourceLocation file = ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "ardoni_name/%s.txt".formatted(language));
        for (Resource resource : manager.getResourceStack(file))
            try (BufferedReader reader = resource.openAsReader()) {
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
