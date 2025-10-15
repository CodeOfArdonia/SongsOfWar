package com.iafenvoy.sow.network.payload;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record JumpPressPayload() implements CustomPacketPayload {
    public static final Type<JumpPressPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "jump_press"));
    public static final StreamCodec<RegistryFriendlyByteBuf, JumpPressPayload> STREAM_CODEC = StreamCodec.unit(new JumpPressPayload());

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
