package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.ability.type.DelayAbility;
import com.iafenvoy.neptune.ability.type.InstantAbility;
import com.iafenvoy.neptune.util.RandomHelper;
import com.iafenvoy.neptune.world.RaycastHelper;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.entity.power.SupporekesisControllable;
import com.iafenvoy.sow.entity.power.SupporoSpikeEntity;
import com.iafenvoy.sow.registry.SowEntities;
import com.iafenvoy.sow.registry.SowItems;
import com.iafenvoy.sow.registry.SowSounds;
import com.iafenvoy.sow.util.RecipeUtils;
import it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Ownable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Vector3f;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public final class SupportiumPowers {
    public static final DelayAbility SUPPOREKESIS = new DelayAbility(Identifier.of(SongsOfWar.MOD_ID, "supporekesis"), SowAbilityCategory.SUPPORTIUM.getCategory())
            .setApplySound(SowSounds.SUPPOREKESIS)
            .setDelay(20)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporekesisPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporekesisSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.supportium.supporekesisExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                double r = SowCommonConfig.INSTANCE.supportium.supporekesisRange.getValue();
                List<Entity> controllables = world.getEntitiesByClass(Entity.class, new Box(player.getX() - r, player.getY() - r, player.getZ() - r, player.getX() + r, player.getY() + r, player.getZ() + r), c -> c instanceof SupporekesisControllable);
                for (Entity c : controllables) {
                    if (c instanceof Ownable ownable && ownable.getOwner() != null && Objects.equals(ownable.getOwner().getUuid(), player.getUuid()) && !SowCommonConfig.INSTANCE.supportium.supporekesisControlSelf.getValue())
                        continue;
                    if (c instanceof SupporekesisControllable controllable)
                        controllable.setDisappearCd(70, true);
                }
            });
    public static final DelayAbility SUPPOROFORM = new DelayAbility(Identifier.of(SongsOfWar.MOD_ID, "supporoform"), SowAbilityCategory.SUPPORTIUM.getCategory())
            .setApplySound(SowSounds.SUPPOROFORM)
            .setDelay(20)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporoformPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporoformSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.supportium.supporoformExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                if (!(world instanceof ServerWorld serverWorld)) return;
                final int MAX_CNT = 41;
                for (int i = 0; i < MAX_CNT; i++) {
                    ItemStack stack = player.getInventory().getStack(i);
                    if (stack.isEmpty()) continue;
                    ItemStack stack1 = ItemStack.EMPTY;
                    if (stack.isOf(Items.OBSIDIAN))
                        stack1 = switch (stack.getCount()) {
                            case 5 -> new ItemStack(SowItems.ENDER_KNIGHT_HELMET.get());
                            case 8 -> new ItemStack(SowItems.ENDER_KNIGHT_CHESTPLATE.get());
                            case 7 -> new ItemStack(SowItems.ENDER_KNIGHT_LEGGINGS.get());
                            case 4 -> new ItemStack(SowItems.ENDER_KNIGHT_BOOTS.get());
                            default -> ItemStack.EMPTY;
                        };
                    if (stack1.isEmpty()) stack1 = RecipeUtils.findSmeltResult(serverWorld, stack).copy();
                    if (!stack1.isEmpty()) player.getInventory().setStack(i, stack1);
                }
            });
    public static final InstantAbility SUPPOROLIFT = new InstantAbility(Identifier.of(SongsOfWar.MOD_ID, "supporolift"), SowAbilityCategory.SUPPORTIUM.getCategory())
            .setApplySound(SowSounds.SUPPOROLIFT)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporoliftPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporoliftSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.supportium.supporoliftExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                double maxDistance = SowCommonConfig.INSTANCE.supportium.supporoliftRange.getValue();
                EntityHitResult result = RaycastHelper.raycastNearest(player, maxDistance);
                if (result != null && result.getEntity() instanceof LivingEntity living) {
                    Vec3d dir = player.getPos().subtract(living.getPos()).multiply(0.2);
                    living.setVelocity(dir.add(0, 0.3, 0));
                    living.velocityModified = true;
                } else holder.cancel();
            });
    public static final InstantAbility SUPPOROSPIKE = new InstantAbility(Identifier.of(SongsOfWar.MOD_ID, "supporospike"), SowAbilityCategory.SUPPORTIUM.getCategory())
            .setApplySound(SowSounds.SUPPOROSPIKE)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporospikePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporospikeSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.supportium.supporospikeExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                double maxDistance = SowCommonConfig.INSTANCE.supportium.supporospikeRange.getValue();
                EntityHitResult result = RaycastHelper.raycastNearest(player, maxDistance);
                if (result != null && result.getEntity() instanceof LivingEntity living) {
                    Vec3d[] vecs = new Vec3d[]{
                            new Vec3d(-0.5, -0.5, -0.5),
                            new Vec3d(0.5, -0.5, -0.5),
                            new Vec3d(-0.5, -0.5, 0.5),
                            new Vec3d(0.5, -0.5, 0.5),
                            new Vec3d(0, 0.5, 0)
                    };
                    Double2FloatFunction RANDOM = r -> (float) RandomHelper.nextDouble(-r, r);
                    BlockState state = world.getBlockState(living.getBlockPos().down());
                    for (Vec3d vec : vecs) {
                        SupporoSpikeEntity spike = SowEntities.SUPPORO_SPIKE.get().create(world);
                        if (spike != null) {
                            spike.setBlockState(state);
                            spike.setPosition(living.getPos().add(vec));
                            spike.setScale(1.2F);
                            spike.setDuration(50);
                            spike.setRotation(new Vector3f(RANDOM.get(Math.PI / 4), RANDOM.get(Math.PI / 16), RANDOM.get(Math.PI / 16)));
                            world.spawnEntity(spike);
                        }
                    }
                    living.setVelocity(new Vec3d(0, 1.5, 0));
                    living.velocityModified = true;
                } else holder.cancel();
            });

    public static void init() {
    }
}
