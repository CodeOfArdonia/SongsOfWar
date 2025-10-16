package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.type.Ability;
import com.iafenvoy.neptune.ability.type.DummyAbility;
import com.iafenvoy.neptune.registry.NeptuneRegistries;
import com.iafenvoy.sow.Proxies;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.registry.SowBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SongCubeBlockEntity extends BlockEntity {
    private Ability<?> power = DummyAbility.EMPTY;

    public SongCubeBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.SONG_CUBE.get(), pos, state);
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(nbt, registries);
        this.power = NeptuneRegistries.ABILITY.get(ResourceLocation.tryParse(nbt.getString("songPower")));
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        super.saveAdditional(nbt, registries);
        if (this.power != null) nbt.putString("songPower", this.power.getId().toString());
    }

    public void setPower(Ability<?> power) {
        this.power = power;
    }

    public Ability<?> getPower() {
        return this.power;
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        Proxies.songCubeSoundManager.destroy(this.worldPosition);
    }

    public AbilityCategory getCategory() {
        if (this.getBlockState().getBlock() instanceof SongCubeBlock block) return block.getCategory();
        else throw new IllegalStateException("This is not a song cube block!");
    }
}
