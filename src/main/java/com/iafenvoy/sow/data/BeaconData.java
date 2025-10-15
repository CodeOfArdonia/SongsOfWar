package com.iafenvoy.sow.data;

import com.iafenvoy.sow.SongsOfWar;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BeaconData extends SavedData {
    private static final String ID = "beaconData";
    public static final Codec<List<SingleBeaconData>> CODEC = RecordCodecBuilder.<SingleBeaconData>create(i1 -> i1.group(
            BlockPos.CODEC.fieldOf("pos").forGetter(SingleBeaconData::pos),
            ComponentSerialization.FLAT_CODEC.fieldOf("name").forGetter(SingleBeaconData::name)
    ).apply(i1, SingleBeaconData::new)).listOf();
    //FIXME::Direct stream codec
    public static final StreamCodec<RegistryFriendlyByteBuf, BeaconData> STREAM_CODEC = ByteBufCodecs.fromCodecWithRegistries(CODEC).map(BeaconData::new, BeaconData::getBeaconPos);
    private final List<SingleBeaconData> beaconPos;

    private BeaconData() {
        this(new LinkedList<>());
    }

    private BeaconData(CompoundTag compound, HolderLookup.Provider registries) {
        this(new ArrayList<>(CODEC.parse(NbtOps.INSTANCE, compound.get(ID)).getOrThrow()));
    }

    private BeaconData(List<SingleBeaconData> beaconPos) {
        this.beaconPos = beaconPos;
    }

    @Override
    public @NotNull CompoundTag save(CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        nbt.put(ID, CODEC.encodeStart(NbtOps.INSTANCE, this.beaconPos).getOrThrow());
        return nbt;
    }

    public List<SingleBeaconData> getBeaconPos() {
        return this.beaconPos;
    }

    public Optional<SingleBeaconData> get(BlockPos pos) {
        return this.beaconPos.stream().filter(x -> x.pos.equals(pos)).findFirst();
    }

    public void add(BlockPos pos, Component name) {
        this.remove(pos);
        this.beaconPos.add(new SingleBeaconData(pos, name));
        this.setDirty();
    }

    public void remove(BlockPos pos) {
        this.beaconPos.removeIf(x -> x.pos.equals(pos));
        this.setDirty();
    }

    public static BeaconData readNbt(CompoundTag nbt, HolderLookup.Provider registries) {
        return new BeaconData(nbt, registries);
    }

    public static BeaconData getInstance(ServerLevel world) {
        BeaconData data = world.getDataStorage().computeIfAbsent(new Factory<>(BeaconData::new, BeaconData::readNbt), ID);
        int cnt = data.beaconPos.size();
        data.beaconPos.removeIf(x -> !world.getBlockState(x.pos).is(Blocks.BEACON));
        int delta = cnt - data.beaconPos.size();
        if (delta > 0) SongsOfWar.LOGGER.warn("Remove {} wrong teleport beacon data.", delta);
        return data;
    }

    public record SingleBeaconData(BlockPos pos, Component name) {
    }
}
