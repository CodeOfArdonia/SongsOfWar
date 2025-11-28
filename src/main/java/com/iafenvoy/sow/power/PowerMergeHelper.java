package com.iafenvoy.sow.power;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.ability.type.Ability;
import com.iafenvoy.neptune.object.DamageUtil;
import com.iafenvoy.neptune.world.FakeExplosionBehavior;
import com.iafenvoy.sow.item.SongCubeItem;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.item.block.entity.SongCubeBlockEntity;
import com.iafenvoy.sow.registry.SowParticles;
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import com.iafenvoy.sow.world.ShrineStructureHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.FastColor;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class PowerMergeHelper {
    private static final Map<Player, MergeData> DATA = new HashMap<>();

    public static void run(AbilityData data, Player player, ServerLevel serverWorld) {
        if (!data.isEnabled(SowAbilityCategories.ALL.get().toArray(AbilityCategory[]::new)))
            return;
        if (!DATA.containsKey(player)) DATA.put(player, new MergeData());
        MergeData mergeData = DATA.get(player);
        if (player.isShiftKeyDown()) {
            Direction[] dirs = Direction.orderedByNearest(player);
            if (dirs[0].getAxis() != Direction.Axis.Y) {
                if (mergeData.sneakPos == null) {
                    mergeData.sneakPos = player.blockPosition();
                    mergeData.lastDir = dirs[0];
                }
                if (dirs[0] == mergeData.lastDir && player.blockPosition().equals(mergeData.sneakPos)) {
                    mergeData.sneakTick++;
                    BlockPos songPos = mergeData.sneakPos.offset(dirs[0].getNormal().multiply(6)).offset(0, 1, 0);
                    InteractHolder holder = InteractHolder.of(serverWorld, songPos);
                    if (holder.isPresent() && ShrineStructureHelper.match(mergeData.sneakPos, serverWorld)) {
                        Vec3 center = songPos.getCenter();
                        AbilityCategory category = holder.getCategory();
                        int color = category.getColor();
                        if (mergeData.sneakTick >= 20 && mergeData.sneakTick <= 60)
                            serverWorld.sendParticles(SowParticles.SONG_EFFECT.get(), center.x(), center.y() - 0.25, center.z(), 0, FastColor.ARGB32.red(color), FastColor.ARGB32.green(color), FastColor.ARGB32.blue(color), 1);
                        if (mergeData.sneakTick == 60) {
                            AbilityData.SingleAbilityData d = data.get(category);
                            Ability<?> newPower = holder.getPower();
                            if (d.hasAbility()) holder.setPower(d.getActiveAbility());
                            else holder.destroy();
                            d.setActiveAbility(player, newPower);
                            serverWorld.explode(player, DamageUtil.build(player, DamageTypes.EXPLOSION), new FakeExplosionBehavior(), center, 1, false, Level.ExplosionInteraction.NONE);
                            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20 * 20));
                            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 18 * 20));
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

        private static InteractHolder of(ServerLevel world, BlockPos pos) {
            return world.getBlockState(pos).getBlock() instanceof SongCubeBlock && world.getBlockEntity(pos) instanceof SongCubeBlockEntity blockEntity ?
                    new InteractHolder(pos, blockEntity) :
                    new InteractHolder(pos, world.getEntitiesOfClass(ItemEntity.class, new AABB(pos), x -> x.getItem().getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof SongCubeBlock).stream().findFirst().orElse(null));
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

        public Ability<?> getPower() {
            if (this.blockEntity != null) return this.blockEntity.getPower();
            if (this.itemEntity != null && this.itemEntity.getItem().getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof SongCubeBlock songCubeBlock)
                return SongCubeItem.getPower(this.itemEntity.getItem());
            return null;
        }

        public AbilityCategory getCategory() {
            if (this.blockEntity != null) return this.blockEntity.getCategory();
            if (this.itemEntity != null && this.itemEntity.getItem().getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof SongCubeBlock songCubeBlock)
                return songCubeBlock.getCategory();
            return SowAbilityCategories.AGGRESSIUM.get();
        }

        public void setPower(Ability<?> power) {
            if (this.blockEntity != null) this.blockEntity.setPower(power);
            if (this.itemEntity != null) this.itemEntity.setItem(SongCubeItem.getStack(power));
        }

        public void destroy() {
            if (this.blockEntity != null && this.blockEntity.getLevel() != null)
                this.blockEntity.getLevel().destroyBlock(this.pos, false);
            if (this.itemEntity != null) this.itemEntity.remove(Entity.RemovalReason.DISCARDED);
        }
    }
}
