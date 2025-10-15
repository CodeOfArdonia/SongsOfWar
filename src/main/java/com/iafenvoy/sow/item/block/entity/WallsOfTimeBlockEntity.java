package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowBlockEntities;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.WrittenBookContent;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class WallsOfTimeBlockEntity extends BlockEntity {
    private WotContents contents = WotContents.EMPTY.get();

    public WallsOfTimeBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.WALLS_OF_TIME.get(), pos, state);
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(nbt, registries);
        this.contents = WotContents.CODEC.parse(NbtOps.INSTANCE, nbt.get("content")).resultOrPartial(SongsOfWar.LOGGER::error).orElse(WotContents.EMPTY.get());
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        super.saveAdditional(nbt, registries);
        nbt.put("content", WotContents.CODEC.encodeStart(NbtOps.INSTANCE, this.contents).resultOrPartial(SongsOfWar.LOGGER::error).orElse(new CompoundTag()));
    }

    public WotContents getContents() {
        return this.contents;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        return this.saveWithoutMetadata(registries);
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

        public MutableComponent getContentString() {
            return this.content.getOrDefault(DataComponents.WRITTEN_BOOK_CONTENT, WrittenBookContent.EMPTY)
                    .getPages(false)
                    .stream()
                    .map(Component::copy)
                    .reduce(Component.empty(), MutableComponent::append);
        }
    }

    public enum EditType implements StringRepresentable {
        OFFSET_X_PLUS(c -> c.offsetX++),
        OFFSET_X_SUB(c -> c.offsetX--),
        OFFSET_Y_PLUS(c -> c.offsetY++),
        OFFSET_Y_SUB(c -> c.offsetY--),
        SIZE_X_PLUS(c -> c.sizeX++),
        SIZE_X_SUB(c -> c.sizeX--),
        SIZE_Y_PLUS(c -> c.sizeY++),
        SIZE_Y_SUB(c -> c.sizeY--),
        CLEAR(c -> c.content = ItemStack.EMPTY);

        public static final Codec<EditType> CODEC = StringRepresentable.fromValues(EditType::values);
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

        @Override
        public @NotNull String getSerializedName() {
            return this.name().toLowerCase(Locale.ROOT);
        }
    }
}
