package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.item.block.ArdoniGraveBlock;
import com.iafenvoy.sow.registry.SowBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class ArdoniGraveBlockEntity extends BlockEntity {
    private long seed;
    private boolean fixed;
    private ResourceLocation texturePath = ResourceLocation.tryParse("");
    private ArdoniType ardoniType = ArdoniType.NONE;

    public ArdoniGraveBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.ARDONI_GRAVE.get(), pos, state);
    }

    @Override
    public void loadAdditional(@NotNull CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        super.loadAdditional(nbt, registries);
        this.setSeed(nbt.getLong("seed"));
        this.setFixed(nbt.getBoolean("fixed"));
        this.setArdoniType(ArdoniType.byId(nbt.getString("type")));
        this.setTexturePath(ResourceLocation.tryParse(nbt.getString("texturePath").toLowerCase(Locale.ROOT)));
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        super.saveAdditional(nbt, registries);
        nbt.putLong("seed", this.getSeed());
        nbt.putBoolean("fixed", this.isFixed());
        nbt.putString("type", this.getArdoniType().id());
        nbt.putString("texturePath", this.getTexturePath().toString());
    }

    public boolean isFixed() {
        return this.fixed;
    }

    public long getSeed() {
        return this.seed;
    }

    public void setArdoniType(ArdoniType ardoniType) {
        this.ardoniType = ardoniType;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public void setTexturePath(ResourceLocation texturePath) {
        this.texturePath = texturePath;
    }

    public ArdoniType getArdoniType() {
        return this.ardoniType;
    }

    public ResourceLocation getTexturePath() {
        return this.texturePath;
    }

    public boolean activated() {
        return this.getBlockState().getValue(ArdoniGraveBlock.ACTIVATED);
    }

    public float getRotationDegree() {
        return -this.getBlockState().getValue(ArdoniGraveBlock.FACING).toYRot() + 180;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        return this.saveWithoutMetadata(registries);
    }
}
