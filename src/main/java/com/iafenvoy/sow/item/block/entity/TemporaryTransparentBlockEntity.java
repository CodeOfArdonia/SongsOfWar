package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.registry.SowBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TemporaryTransparentBlockEntity extends BlockEntity {
    private BlockState state = Blocks.AIR.defaultBlockState();
    private int tick = -1;

    public TemporaryTransparentBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.TEMPORARY.get(), pos, state);
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(nbt, registries);
        this.setState(BlockState.CODEC.parse(NbtOps.INSTANCE, nbt.get("state")).resultOrPartial(SongsOfWar.LOGGER::debug).orElse(Blocks.AIR.defaultBlockState()));
        this.setTick(nbt.getInt("tick"));
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        super.saveAdditional(nbt, registries);
        nbt.put("state", BlockState.CODEC.encodeStart(NbtOps.INSTANCE, this.getState()).resultOrPartial(SongsOfWar.LOGGER::debug).orElse(new CompoundTag()));
        nbt.putInt("tick", this.tick);
    }

    public BlockState getState() {
        return this.state;
    }

    public void setState(BlockState state) {
        this.state = state;
    }

    public int getTick() {
        return this.tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public static void tick(Level world, BlockPos pos, BlockState state, TemporaryTransparentBlockEntity blockEntity) {
        int tick = blockEntity.getTick();
        if (tick == 0) {
            BlockState s = blockEntity.getState();
            if (s != null) world.setBlock(pos, s, 2, 0);
        } else if (tick > 0) blockEntity.setTick(tick - 1);
    }
}
