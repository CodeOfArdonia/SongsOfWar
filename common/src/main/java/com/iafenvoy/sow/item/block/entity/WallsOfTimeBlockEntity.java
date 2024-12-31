package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowBlockEntities;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtOps;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class WallsOfTimeBlockEntity extends BlockEntity {
    private WotContents contents = WotContents.EMPTY;

    public WallsOfTimeBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.WALLS_OF_TIME.get(), pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.contents = WotContents.CODEC.parse(NbtOps.INSTANCE, nbt.get("content")).resultOrPartial(SongsOfWar.LOGGER::error).orElse(WotContents.EMPTY);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.put("content", WotContents.CODEC.encodeStart(NbtOps.INSTANCE, this.contents).resultOrPartial(SongsOfWar.LOGGER::error).orElse(new NbtCompound()));
    }

    public WotContents getContents() {
        return this.contents;
    }

    public static final class WotContents {
        public static final WotContents EMPTY = new WotContents(Direction.UP, "", 0, 0, 0, 0);
        public static final Codec<WotContents> CODEC = RecordCodecBuilder.create(i -> i.group(
                Direction.CODEC.optionalFieldOf("direction", EMPTY.direction).forGetter(WotContents::getDirection),
                Codec.STRING.optionalFieldOf("content", EMPTY.content).forGetter(WotContents::getContent),
                Codec.INT.optionalFieldOf("offsetX", EMPTY.offsetX).forGetter(WotContents::getOffsetX),
                Codec.INT.optionalFieldOf("offsetY", EMPTY.offsetY).forGetter(WotContents::getOffsetY),
                Codec.INT.optionalFieldOf("sizeX", EMPTY.sizeX).forGetter(WotContents::getSizeX),
                Codec.INT.optionalFieldOf("sizeY", EMPTY.sizeY).forGetter(WotContents::getSizeY)
        ).apply(i, WotContents::new));
        private Direction direction;
        private String content;
        private int offsetX;
        private int offsetY;
        private int sizeX;
        private int sizeY;

        public WotContents(Direction direction, String content, int offsetX, int offsetY, int sizeX, int sizeY) {
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

        public String getContent() {
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

        public WotContents withContent(String content) {
            this.content = content;
            return this;
        }

        public WotContents withOffset(int x, int y) {
            this.offsetX = x;
            this.offsetY = y;
            return this;
        }

        public WotContents withSize(int x, int y) {
            this.sizeX = x;
            this.sizeY = y;
            return this;
        }
    }
}
