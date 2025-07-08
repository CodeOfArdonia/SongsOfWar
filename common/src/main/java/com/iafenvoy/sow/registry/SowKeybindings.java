package com.iafenvoy.sow.registry;

import com.iafenvoy.neptune.ability.AbilityKeybindings;
import com.iafenvoy.neptune.network.PacketBufferUtils;
import com.iafenvoy.sow.Constants;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
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
    public static final AbilityKeybindings.KeyBindingHolder JUMP = new AbilityKeybindings.KeyBindingHolder(() -> MinecraftClient.getInstance().options.jumpKey);

    public static void init() {
        KeyMappingRegistry.register(AGGRESSIUM_POWER);
        KeyMappingRegistry.register(MOBILIUM_POWER);
        KeyMappingRegistry.register(PROTISIUM_POWER);
        KeyMappingRegistry.register(SUPPORTIUM_POWER);

        AbilityKeybindings.registerKeyBinding(SowAbilityCategory.AGGRESSIUM.getCategory(), AGGRESSIUM_POWER);
        AbilityKeybindings.registerKeyBinding(SowAbilityCategory.MOBILIUM.getCategory(), MOBILIUM_POWER);
        AbilityKeybindings.registerKeyBinding(SowAbilityCategory.PROTISIUM.getCategory(), PROTISIUM_POWER);
        AbilityKeybindings.registerKeyBinding(SowAbilityCategory.SUPPORTIUM.getCategory(), SUPPORTIUM_POWER);

        ClientTickEvent.CLIENT_POST.register(client -> JUMP.tick());
        JUMP.registerPressCallback(x -> {
            if (x) NetworkManager.sendToServer(Constants.JUMP_PRESS, PacketBufferUtils.create());
        });
    }
}
