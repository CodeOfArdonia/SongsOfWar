package com.iafenvoy.sow.network.payload;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.data.BeaconData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record BeaconTeleportS2CPayload(BlockPos pos, BeaconData data) implements CustomPacketPayload {
    public static final Type<BeaconTeleportS2CPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "beacon_teleport_s2c"));
    public static final StreamCodec<RegistryFriendlyByteBuf, BeaconTeleportS2CPayload> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, BeaconTeleportS2CPayload::pos,
            BeaconData.STREAM_CODEC, BeaconTeleportS2CPayload::data,
            BeaconTeleportS2CPayload::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
