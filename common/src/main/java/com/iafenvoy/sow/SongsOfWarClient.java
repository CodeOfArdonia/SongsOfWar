package com.iafenvoy.sow;

import com.iafenvoy.sow.compat.LitematicaHelper;
import com.iafenvoy.sow.data.ArdoniName;
import com.iafenvoy.sow.network.ClientNetworkHelper;
import com.iafenvoy.sow.registry.SowKeybindings;
import com.iafenvoy.sow.registry.SowRenderers;
import com.iafenvoy.sow.render.generator.GeneratorReloader;
import com.iafenvoy.sow.world.sound.ClientSongCubeSoundManager;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.registry.ReloadListenerRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public final class SongsOfWarClient {
    public static void init() {
        SowKeybindings.init();
        SowRenderers.registerEntityRenderers();
        SowRenderers.registerParticleRenderer();
    }

    public static void process() {
        Proxies.songCubeSoundManager = ClientSongCubeSoundManager.INSTANCE;
        Proxies.ardoniNameProxy = ArdoniName.INSTANCE;

        SowRenderers.registerSkull();
        SowRenderers.registerBlockEntityRenderer();
        SowRenderers.registerRenderType();
        SowRenderers.registerModelPredicate();
        ClientTickEvent.CLIENT_POST.register(client -> Proxies.songCubeSoundManager.tick());
        ReloadListenerRegistry.register(ResourceType.CLIENT_RESOURCES, GeneratorReloader.INSTANCE, Identifier.of(SongsOfWar.MOD_ID, "generator"));
        ReloadListenerRegistry.register(ResourceType.CLIENT_RESOURCES, ArdoniName.INSTANCE, Identifier.of(SongsOfWar.MOD_ID, "ardoni_name"));
        LitematicaHelper.extractFile();
        ClientNetworkHelper.init();
    }
}
