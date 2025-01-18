package com.iafenvoy.sow.render.generator;

import com.iafenvoy.sow.render.block.ArdoniGraveBlockEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;

@Environment(EnvType.CLIENT)
public enum GeneratorReloader implements SynchronousResourceReloader {
    INSTANCE;

    @Override
    public void reload(ResourceManager manager) {
        ArdoniMarkerGenerator.resetAll();
        ArdoniGraveBlockEntityRenderer.reset();
        MagnoriteSkinGenerator.resetAll();
    }
}
