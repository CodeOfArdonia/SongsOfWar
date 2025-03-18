package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.type.AbstractAbility;
import com.iafenvoy.neptune.ability.type.DummyAbility;
import com.iafenvoy.sow.Proxies;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public abstract class AbstractSongCubeBlockEntity extends BlockEntity {
    private AbstractAbility<?> power = DummyAbility.EMPTY;

    public AbstractSongCubeBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.power = AbstractAbility.byId(Identifier.tryParse(nbt.getString("songPower")));
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (this.power != null) nbt.putString("songPower", this.power.getId().toString());
    }

    public void setPower(AbstractAbility<?> power) {
        this.power = power;
    }

    public AbstractAbility<?> getPower() {
        return this.power;
    }

    @Override
    public void markRemoved() {
        super.markRemoved();
        Proxies.songCubeSoundManager.destroy(this.pos);
    }

    public abstract AbilityCategory getCategory();
}
