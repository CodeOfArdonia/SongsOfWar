package com.iafenvoy.sow.render.generator;

import com.iafenvoy.sow.render.block.ArdoniGraveBlockEntityRenderer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public enum GeneratorReloader implements ResourceManagerReloadListener {
    INSTANCE;

    @Override
    public void onResourceManagerReload(@NotNull ResourceManager manager) {
        ArdoniMarkerGenerator.resetAll();
        ArdoniGraveBlockEntityRenderer.reset();
        MagnoriteSkinGenerator.resetAll();
    }
}
