package com.iafenvoy.sow.item.block.entity;

import com.iafenvoy.sow.data.ArdoniType;
import com.iafenvoy.sow.item.block.ArdoniGraveBlock;
import com.iafenvoy.sow.registry.SowBlockEntities;
import com.iafenvoy.sow.registry.SowBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class ArdoniGraveBlockEntity extends BlockEntity {
    private long seed;
    private boolean fixed;
    private Identifier texturePath = Identifier.tryParse("");
    private ArdoniType ardoniType = ArdoniType.NONE;

    public ArdoniGraveBlockEntity(BlockPos pos, BlockState state) {
        super(SowBlockEntities.ARDONI_GRAVE.get(), pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.setSeed(nbt.getLong("seed"));
        this.setFixed(nbt.getBoolean("fixed"));
        this.setArdoniType(ArdoniType.byId(nbt.getString("type")));
        this.setTexturePath(Identifier.tryParse(nbt.getString("texturePath").toLowerCase(Locale.ROOT)));
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
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

    public void setTexturePath(Identifier texturePath) {
        this.texturePath = texturePath;
    }

    public ArdoniType getArdoniType() {
        return this.ardoniType;
    }

    public Identifier getTexturePath() {
        return this.texturePath;
    }

    public boolean activated() {
        return this.getCachedState().get(ArdoniGraveBlock.ACTIVATED);
    }

    public float getRotationDegree() {
        return -this.getCachedState().get(ArdoniGraveBlock.FACING).asRotation() + 180;
    }

    public static ItemStack buildGrave(long seed, ArdoniType type) {
        NbtCompound nbt = new NbtCompound();
        nbt.putLong("seed", seed);
        nbt.putBoolean("fixed", false);
        nbt.putString("type", type.id());
        ItemStack stack = new ItemStack(SowBlocks.ARDONI_GRAVE.get());
        stack.setSubNbt("BlockEntityTag", nbt);
        return stack;
    }

    public static ItemStack buildGrave(Identifier texture) {
        NbtCompound nbt = new NbtCompound();
        nbt.putBoolean("fixed", true);
        nbt.putString("texturePath", texture.toString());
        ItemStack stack = new ItemStack(SowBlocks.ARDONI_GRAVE.get());
        stack.setSubNbt("BlockEntityTag", nbt);
        return stack;
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
}
