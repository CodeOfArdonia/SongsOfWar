package com.iafenvoy.sow.forge;

import com.iafenvoy.jupiter.render.screen.ConfigSelectScreen;
import com.iafenvoy.sow.SongsOfWarClient;
import com.iafenvoy.sow.config.SowClientConfig;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.registry.SowItems;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SongsOfWarForgeClient {
    @SubscribeEvent
    public static void process(FMLClientSetupEvent event) {
        event.enqueueWork(SongsOfWarClient::process);
        ItemPropertiesRegistry.register(SowItems.PROTEPOINT_SHIELD.get(), Identifier.of(Identifier.DEFAULT_NAMESPACE, "blocking"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() ? 1 : 0);
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory((client, screen) -> new ConfigSelectScreen<>(Text.translatable("config.sow.title"), screen, SowCommonConfig.INSTANCE, SowClientConfig.INSTANCE)));
    }
}
