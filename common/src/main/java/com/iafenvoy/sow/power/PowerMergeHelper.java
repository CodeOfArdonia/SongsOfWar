package com.iafenvoy.sow.power;

import com.iafenvoy.neptune.object.DamageUtil;
import com.iafenvoy.neptune.power.PowerCategory;
import com.iafenvoy.neptune.power.PowerData;
import com.iafenvoy.neptune.power.type.AbstractPower;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.sow.item.block.AbstractSongCubeBlock;
import com.iafenvoy.sow.item.block.entity.AbstractSongCubeBlockEntity;
import com.iafenvoy.sow.registry.SowParticles;
import com.iafenvoy.sow.registry.power.SowPowerCategories;
import com.iafenvoy.sow.world.FakeExplosionBehavior;
import com.iafenvoy.sow.world.ShrineStructureHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class PowerMergeHelper {
    private static final Map<PlayerEntity, MergeData> DATA = new HashMap<>();

    public static void run(PowerData songPowerData, PlayerEntity player, ServerWorld serverWorld) {
        if (!DATA.containsKey(player)) DATA.put(player, new MergeData());
        MergeData mergeData = DATA.get(player);
        if (player.isSneaking()) {
            Direction[] dirs = Direction.getEntityFacingOrder(player);
            if (dirs[0].getAxis() != Direction.Axis.Y) {
                if (mergeData.sneakPos == null) {
                    mergeData.sneakPos = player.getBlockPos();
                    mergeData.lastDir = dirs[0];
                }
                if (dirs[0] == mergeData.lastDir && player.getBlockPos().equals(mergeData.sneakPos)) {
                    mergeData.sneakTick++;
                    BlockPos songPos = mergeData.sneakPos.add(dirs[0].getVector().multiply(6)).add(0, 1, 0);
                    InteractHolder holder = InteractHolder.of(serverWorld, songPos);
                    if (holder.isPresent() && ShrineStructureHelper.match(mergeData.sneakPos, serverWorld)) {
                        Vec3d center = songPos.toCenterPos();
                        PowerCategory category = holder.getCategory();
                        Color4i color = category.getColor();
                        if (mergeData.sneakTick >= 20 && mergeData.sneakTick <= 60)
                            serverWorld.spawnParticles(SowParticles.SONG_EFFECT.get(), center.getX(), center.getY() - 0.25, center.getZ(), 0, color.getR(), color.getG(), color.getB(), 1);
                        if (mergeData.sneakTick == 60) {
                            PowerData.SinglePowerData d = songPowerData.get(category);
                            AbstractPower<?> newPower = holder.getPower();
                            if (d.hasPower()) holder.setPower(d.getActivePower());
                            else holder.destroy();
                            d.setActivePower(newPower);
                            serverWorld.createExplosion(player, DamageUtil.build(player, DamageTypes.EXPLOSION), new FakeExplosionBehavior(), center, 1, false, World.ExplosionSourceType.NONE);
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 20));
                            player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 18 * 20));
                        }
                        return;
                    }
                }
            }
        }
        mergeData.reset();
    }

    private static class MergeData {
        public Direction lastDir = Direction.UP;
        public BlockPos sneakPos = null;
        public int sneakTick = 0;

        public void reset() {
            this.lastDir = Direction.UP;
            this.sneakPos = null;
            this.sneakTick = 0;
        }
    }

    private static class InteractHolder {
        private final BlockPos pos;
        @Nullable
        private final AbstractSongCubeBlockEntity blockEntity;
        @Nullable
        private final ItemEntity itemEntity;

        private static InteractHolder of(ServerWorld world, BlockPos pos) {
            return world.getBlockState(pos).getBlock() instanceof AbstractSongCubeBlock && world.getBlockEntity(pos) instanceof AbstractSongCubeBlockEntity blockEntity ?
                    new InteractHolder(pos, blockEntity) :
                    new InteractHolder(pos, world.getEntitiesByClass(ItemEntity.class, new Box(pos), x -> x.getStack().getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof AbstractSongCubeBlock).stream().findFirst().orElse(null));
        }

        private InteractHolder(BlockPos pos, @Nullable AbstractSongCubeBlockEntity blockEntity) {
            this.pos = pos;
            this.blockEntity = blockEntity;
            this.itemEntity = null;
        }

        private InteractHolder(BlockPos pos, @Nullable ItemEntity itemEntity) {
            this.pos = pos;
            this.blockEntity = null;
            this.itemEntity = itemEntity;
        }

        public boolean isPresent() {
            return this.blockEntity != null || this.itemEntity != null;
        }

        public AbstractPower<?> getPower() {
            if (this.blockEntity != null) return this.blockEntity.getPower();
            if (this.itemEntity != null && this.itemEntity.getStack().getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof AbstractSongCubeBlock songCubeBlock)
                return songCubeBlock.getPower(this.itemEntity.getStack());
            return null;
        }

        public PowerCategory getCategory() {
            if (this.blockEntity != null) return this.blockEntity.getCategory();
            if (this.itemEntity != null && this.itemEntity.getStack().getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof AbstractSongCubeBlock songCubeBlock)
                return songCubeBlock.getCategory();
            return SowPowerCategories.AGGRESSIUM;
        }

        public void setPower(AbstractPower<?> power) {
            if (this.blockEntity != null) this.blockEntity.setPower(power);
            if (this.itemEntity != null) this.itemEntity.setStack(AbstractSongCubeBlock.getStack(power));
        }

        public void destroy() {
            if (this.blockEntity != null && this.blockEntity.getWorld() != null)
                this.blockEntity.getWorld().breakBlock(this.pos, false);
            if (this.itemEntity != null) this.itemEntity.remove(Entity.RemovalReason.DISCARDED);
        }
    }
}
