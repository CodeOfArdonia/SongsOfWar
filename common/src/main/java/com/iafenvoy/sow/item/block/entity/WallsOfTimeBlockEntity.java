package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.sow.registry.SowBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WallsOfTimeBlockEntity extends BlockEntity {
    private static final List<Direction> HORIZONTAL = Arrays.stream(Direction.values()).filter(x -> x.getHorizontal() >= 0).toList();
    private final Map<Direction, String> texts = Util.make(new HashMap<>(), map -> {
        for (Direction dir : HORIZONTAL)
            map.put(dir, "");
    });

    public WallsOfTimeBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.WALLS_OF_TIME.get(), pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        for (Direction dir : HORIZONTAL)
            this.texts.put(dir, nbt.getString(dir.getName()));
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        for (Direction dir : HORIZONTAL)
            nbt.putString(dir.getName(), this.texts.get(dir));
    }

    public String getDisplayText(Direction dir) {
        return this.texts.getOrDefault(dir, "");
    }
}
