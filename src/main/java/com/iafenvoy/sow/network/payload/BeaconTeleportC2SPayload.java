package com.iafenvoy.sow.network.payload;

import com.iafenvoy.sow.SongsOfWar;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record BeaconTeleportC2SPayload(BlockPos prev, BlockPos now) implements CustomPacketPayload {
    public static final Type<BeaconTeleportC2SPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "beacon_teleport_c2s"));
    public static final StreamCodec<RegistryFriendlyByteBuf, BeaconTeleportC2SPayload> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, BeaconTeleportC2SPayload::prev,
            BlockPos.STREAM_CODEC, BeaconTeleportC2SPayload::now,
            BeaconTeleportC2SPayload::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
