package com.iafenvoy.sow.power;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.ability.type.AbstractAbility;
import com.iafenvoy.neptune.object.DamageUtil;
import com.iafenvoy.neptune.util.Color4i;
import com.iafenvoy.neptune.world.FakeExplosionBehavior;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.item.block.entity.SongCubeBlockEntity;
import com.iafenvoy.sow.registry.SowParticles;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
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

    public static void run(AbilityData data, PlayerEntity player, ServerWorld serverWorld) {
        if (!data.isEnabled(SowAbilityCategory.ALL.get().toArray(AbilityCategory[]::new)))
            return;
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
                        SowAbilityCategory category = holder.getCategory();
                        Color4i color = category.getCategory().getColor();
                        if (mergeData.sneakTick >= 20 && mergeData.sneakTick <= 60)
                            serverWorld.spawnParticles(SowParticles.SONG_EFFECT.get(), center.getX(), center.getY() - 0.25, center.getZ(), 0, color.getR(), color.getG(), color.getB(), 1);
                        if (mergeData.sneakTick == 60) {
                            AbilityData.SingleAbilityData d = data.get(category.getCategory());
                            AbstractAbility<?> newPower = holder.getPower();
                            if (d.hasAbility()) holder.setPower(d.getActiveAbility());
                            else holder.destroy();
                            d.setActiveAbility(newPower);
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
        private final SongCubeBlockEntity blockEntity;
        @Nullable
        private final ItemEntity itemEntity;

        private static InteractHolder of(ServerWorld world, BlockPos pos) {
            return world.getBlockState(pos).getBlock() instanceof SongCubeBlock && world.getBlockEntity(pos) instanceof SongCubeBlockEntity blockEntity ?
                    new InteractHolder(pos, blockEntity) :
                    new InteractHolder(pos, world.getEntitiesByClass(ItemEntity.class, new Box(pos), x -> x.getStack().getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof SongCubeBlock).stream().findFirst().orElse(null));
        }

        private InteractHolder(BlockPos pos, @Nullable SongCubeBlockEntity blockEntity) {
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

        public AbstractAbility<?> getPower() {
            if (this.blockEntity != null) return this.blockEntity.getPower();
            if (this.itemEntity != null && this.itemEntity.getStack().getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof SongCubeBlock songCubeBlock)
                return songCubeBlock.getPower(this.itemEntity.getStack());
            return null;
        }

        public SowAbilityCategory getCategory() {
            if (this.blockEntity != null) return this.blockEntity.getCategory();
            if (this.itemEntity != null && this.itemEntity.getStack().getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof SongCubeBlock songCubeBlock)
                return songCubeBlock.getCategory();
            return SowAbilityCategory.AGGRESSIUM;
        }

        public void setPower(AbstractAbility<?> power) {
            if (this.blockEntity != null) this.blockEntity.setPower(power);
            if (this.itemEntity != null) this.itemEntity.setStack(SongCubeBlock.getStack(power));
        }

        public void destroy() {
            if (this.blockEntity != null && this.blockEntity.getWorld() != null)
                this.blockEntity.getWorld().breakBlock(this.pos, false);
            if (this.itemEntity != null) this.itemEntity.remove(Entity.RemovalReason.DISCARDED);
        }
    }
}
