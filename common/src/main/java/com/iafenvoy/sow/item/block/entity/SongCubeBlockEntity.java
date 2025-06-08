package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.neptune.ability.type.AbstractAbility;
import com.iafenvoy.neptune.ability.type.DummyAbility;
import com.iafenvoy.sow.Proxies;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.registry.SowBlockEntities;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class SongCubeBlockEntity extends BlockEntity {
    private AbstractAbility<?> power = DummyAbility.EMPTY;

    public SongCubeBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.SONG_CUBE.get(), pos, state);
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

    public SowAbilityCategory getCategory() {
        if (this.getCachedState().getBlock() instanceof SongCubeBlock block) return block.getCategory();
        else throw new IllegalStateException("This is not a song cube block!");
    }
}
