package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.ability.AbilityKeybindings;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.network.payload.JumpPressPayload;
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(Dist.CLIENT)
public final class SowKeybindings {
    public static final String CATEGORY = "key.category." + SongsOfWar.MOD_ID;
    public static final KeyMapping AGGRESSIUM_POWER = new KeyMapping("key." + SongsOfWar.MOD_ID + ".aggressium_power", GLFW.GLFW_KEY_C, CATEGORY);
    public static final KeyMapping MOBILIUM_POWER = new KeyMapping("key." + SongsOfWar.MOD_ID + ".mobilium_power", GLFW.GLFW_KEY_V, CATEGORY);
    public static final KeyMapping PROTISIUM_POWER = new KeyMapping("key." + SongsOfWar.MOD_ID + ".protisium_power", GLFW.GLFW_KEY_B, CATEGORY);
    public static final KeyMapping SUPPORTIUM_POWER = new KeyMapping("key." + SongsOfWar.MOD_ID + ".supportium_power", GLFW.GLFW_KEY_N, CATEGORY);
    public static final AbilityKeybindings.KeyBindingHolder JUMP = new AbilityKeybindings.KeyBindingHolder(() -> Minecraft.getInstance().options.keyJump);

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(AGGRESSIUM_POWER);
        event.register(MOBILIUM_POWER);
        event.register(PROTISIUM_POWER);
        event.register(SUPPORTIUM_POWER);

        AbilityKeybindings.registerKeyBinding(SowAbilityCategories.AGGRESSIUM.get(), AGGRESSIUM_POWER);
        AbilityKeybindings.registerKeyBinding(SowAbilityCategories.MOBILIUM.get(), MOBILIUM_POWER);
        AbilityKeybindings.registerKeyBinding(SowAbilityCategories.PROTISIUM.get(), PROTISIUM_POWER);
        AbilityKeybindings.registerKeyBinding(SowAbilityCategories.SUPPORTIUM.get(), SUPPORTIUM_POWER);

        JUMP.registerPressCallback(x -> {
            if (x) PacketDistributor.sendToServer(new JumpPressPayload());
        });
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        JUMP.tick();
    }
}
