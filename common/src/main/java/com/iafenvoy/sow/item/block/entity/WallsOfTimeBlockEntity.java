package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.neptune.ServerHelper;
import com.iafenvoy.neptune.network.ServerNetworkHelper;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowBlockEntities;
import com.iafenvoy.sow.util.BookUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class WallsOfTimeBlockEntity extends BlockEntity {
    private WotContents contents = WotContents.EMPTY.get();
    private boolean fulfilled = false;

    public WallsOfTimeBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.WALLS_OF_TIME.get(), pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.contents = WotContents.CODEC.parse(NbtOps.INSTANCE, nbt.get("content")).resultOrPartial(SongsOfWar.LOGGER::error).orElse(WotContents.EMPTY.get());
        this.fulfilled = true;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.put("content", WotContents.CODEC.encodeStart(NbtOps.INSTANCE, this.contents).resultOrPartial(SongsOfWar.LOGGER::error).orElse(new NbtCompound()));
    }

    public WotContents getContents() {
        return this.contents;
    }

    public void sync() {
        if (this.world != null && this.world.isClient || ServerHelper.server == null) return;
        for (ServerPlayerEntity player : ServerHelper.server.getPlayerManager().getPlayerList())
            ServerNetworkHelper.sendBlockEntityData(player, this.pos, this);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    public static final class WotContents {
        public static final Supplier<WotContents> EMPTY = () -> new WotContents(Direction.EAST, ItemStack.EMPTY, 0, 0, 1, 1);
        public static final Codec<WotContents> CODEC = RecordCodecBuilder.create(i -> i.group(
                Direction.CODEC.optionalFieldOf("direction", EMPTY.get().direction).forGetter(WotContents::getDirection),
                ItemStack.CODEC.optionalFieldOf("content", EMPTY.get().content).forGetter(WotContents::getContent),
                Codec.INT.optionalFieldOf("offsetX", EMPTY.get().offsetX).forGetter(WotContents::getOffsetX),
                Codec.INT.optionalFieldOf("offsetY", EMPTY.get().offsetY).forGetter(WotContents::getOffsetY),
                Codec.INT.optionalFieldOf("sizeX", EMPTY.get().sizeX).forGetter(WotContents::getSizeX),
                Codec.INT.optionalFieldOf("sizeY", EMPTY.get().sizeY).forGetter(WotContents::getSizeY)
        ).apply(i, WotContents::new));
        private Direction direction;
        private ItemStack content;
        private int offsetX;
        private int offsetY;
        private int sizeX;
        private int sizeY;

        public WotContents(Direction direction, ItemStack content, int offsetX, int offsetY, int sizeX, int sizeY) {
            this.direction = direction;
            this.content = content;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.sizeX = sizeX;
            this.sizeY = sizeY;
        }

        public Direction getDirection() {
            return this.direction;
        }

        public ItemStack getContent() {
            return this.content;
        }

        public int getOffsetX() {
            return this.offsetX;
        }

        public int getOffsetY() {
            return this.offsetY;
        }

        public int getSizeX() {
            return this.sizeX;
        }

        public int getSizeY() {
            return this.sizeY;
        }

        public WotContents withDirection(Direction direction) {
            this.direction = direction;
            return this;
        }

        public WotContents withContent(ItemStack content) {
            this.content = content;
            return this;
        }

        public String getContentString() {
            NbtList nbtList = this.content.getOrCreateNbt().getList("pages", 8);
            if (nbtList != null)
                return BookUtils.nbtToString(nbtList);
            return "";
        }
    }

    public enum EditType {
        OFFSET_X_PLUS(c -> c.offsetX++),
        OFFSET_X_SUB(c -> c.offsetX--),
        OFFSET_Y_PLUS(c -> c.offsetY++),
        OFFSET_Y_SUB(c -> c.offsetY--),
        SIZE_X_PLUS(c -> c.sizeX++),
        SIZE_X_SUB(c -> c.sizeX--),
        SIZE_Y_PLUS(c -> c.sizeY++),
        SIZE_Y_SUB(c -> c.sizeY--),
        CLEAR(c -> c.content = ItemStack.EMPTY);

        private final Consumer<WotContents> process;

        EditType(Consumer<WotContents> process) {
            this.process = process;
        }

        public Consumer<WotContents> getProcess() {
            return this.process;
        }

        public EditType next() {
            return values()[(this.ordinal() + 1) % values().length];
        }
    }
}
