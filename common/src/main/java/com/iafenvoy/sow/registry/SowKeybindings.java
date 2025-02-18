package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.network.PacketBufferUtils;
import com.iafenvoy.neptune.power.PowerKeybindings;
import com.iafenvoy.sow.SowConstants;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.power.SowPowerCategories;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.networking.NetworkManager;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public final class SowKeybindings {
    public static final String CATEGORY = "key.category." + SongsOfWar.MOD_ID;
    public static final KeyBinding AGGRESSIUM_POWER = new KeyBinding("key." + SongsOfWar.MOD_ID + ".aggressium_power", GLFW.GLFW_KEY_C, CATEGORY);
    public static final KeyBinding MOBILIUM_POWER = new KeyBinding("key." + SongsOfWar.MOD_ID + ".mobilium_power", GLFW.GLFW_KEY_V, CATEGORY);
    public static final KeyBinding PROTISIUM_POWER = new KeyBinding("key." + SongsOfWar.MOD_ID + ".protisium_power", GLFW.GLFW_KEY_B, CATEGORY);
    public static final KeyBinding SUPPORTIUM_POWER = new KeyBinding("key." + SongsOfWar.MOD_ID + ".supportium_power", GLFW.GLFW_KEY_N, CATEGORY);
    public static final PowerKeybindings.KeyBindingHolder JUMP = new PowerKeybindings.KeyBindingHolder(() -> MinecraftClient.getInstance().options.jumpKey);

    public static void init() {
        KeyMappingRegistry.register(AGGRESSIUM_POWER);
        KeyMappingRegistry.register(MOBILIUM_POWER);
        KeyMappingRegistry.register(PROTISIUM_POWER);
        KeyMappingRegistry.register(SUPPORTIUM_POWER);

        PowerKeybindings.registerKeyBinding(SowPowerCategories.AGGRESSIUM, AGGRESSIUM_POWER);
        PowerKeybindings.registerKeyBinding(SowPowerCategories.MOBILIUM, MOBILIUM_POWER);
        PowerKeybindings.registerKeyBinding(SowPowerCategories.PROTISIUM, PROTISIUM_POWER);
        PowerKeybindings.registerKeyBinding(SowPowerCategories.SUPPORTIUM, SUPPORTIUM_POWER);

        ClientTickEvent.CLIENT_POST.register(client -> JUMP.tick());
        JUMP.registerPressCallback(x -> {
            if (x) NetworkManager.sendToServer(SowConstants.JUMP_PRESS, PacketBufferUtils.create());
        });
    }
}
