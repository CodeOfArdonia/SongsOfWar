package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.neptune.power.PowerCategory;
import com.iafenvoy.neptune.power.type.AbstractPower;
import com.iafenvoy.neptune.power.type.DummyPower;
import com.iafenvoy.sow.Proxies;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public abstract class AbstractSongCubeBlockEntity extends BlockEntity {
    private AbstractPower<?> power = DummyPower.EMPTY;

    public AbstractSongCubeBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.power = AbstractPower.byId(Identifier.tryParse(nbt.getString("songPower")));
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (this.power != null) nbt.putString("songPower", this.power.getId().toString());
    }

    public void setPower(AbstractPower<?> power) {
        this.power = power;
    }

    public AbstractPower<?> getPower() {
        return this.power;
    }

    @Override
    public void markRemoved() {
        super.markRemoved();
        Proxies.songCubeSoundManager.destroy(this.pos);
    }

    public abstract PowerCategory getCategory();
}
