package com.iafenvoy.sow;

import com.iafenvoy.jupiter.ConfigManager;
import com.iafenvoy.jupiter.render.screen.ConfigSelectScreen;
import com.iafenvoy.sow.compat.LitematicaHelper;
import com.iafenvoy.sow.config.SowClientConfig;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.data.ArdoniName;
import com.iafenvoy.sow.registry.SowItems;
import com.iafenvoy.sow.registry.SowRenderers;
import com.iafenvoy.sow.render.generator.GeneratorReloader;
import com.iafenvoy.sow.world.sound.ClientSongCubeSoundManager;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@OnlyIn(Dist.CLIENT)
@Mod(value = SongsOfWar.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(Dist.CLIENT)
public final class SongsOfWarClient {
    public SongsOfWarClient() {
        ConfigManager.getInstance().registerConfigHandler(SowClientConfig.INSTANCE);
    }

    @SubscribeEvent
    public static void process(FMLClientSetupEvent event) {
        Proxies.songCubeSoundManager = ClientSongCubeSoundManager.INSTANCE;
        Proxies.ardoniNameProxy = ArdoniName.INSTANCE;

        SowRenderers.registerSkull();
        SowRenderers.registerRenderType();
        SowRenderers.registerModelPredicate();
        LitematicaHelper.extractFile();
        ItemProperties.register(SowItems.PROTEPOINT_SHIELD.get(), ResourceLocation.withDefaultNamespace("blocking"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() ? 1 : 0);
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (container, parent) -> ConfigSelectScreen.builder(Component.translatable("config.sow.title"), parent).common(SowCommonConfig.INSTANCE).client(SowClientConfig.INSTANCE).build());
    }

    @SubscribeEvent
    public static void registerClientReloadListeners(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(GeneratorReloader.INSTANCE);
        event.registerReloadListener(ArdoniName.INSTANCE);
    }
}
