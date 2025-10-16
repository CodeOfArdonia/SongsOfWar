package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.ability.type.Ability;
import com.iafenvoy.neptune.ability.type.DelayAbility;
import com.iafenvoy.neptune.ability.type.InstantAbility;
import com.iafenvoy.neptune.registry.NeptuneRegistries;
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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.joml.Vector3f;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public final class SupportiumPowers {
    public static final DeferredRegister<Ability<?>> REGISTRY = DeferredRegister.create(NeptuneRegistries.ABILITY, SongsOfWar.MOD_ID);

    public static final DeferredHolder<Ability<?>, DelayAbility> SUPPOREKESIS = REGISTRY.register("supporekesis", () -> new DelayAbility(SowAbilityCategories.SUPPORTIUM)
            .setApplySound(SowSounds.SUPPOREKESIS)
            .setDelay(20)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporekesisPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporekesisSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.supportium.supporekesisExhaustion.getValue())
            .onApply(holder -> {
                LivingEntity living = holder.getEntity();
                Level world = holder.getWorld();
                double r = SowCommonConfig.INSTANCE.supportium.supporekesisRange.getValue();
                List<Entity> controllables = world.getEntitiesOfClass(Entity.class, new AABB(living.getX() - r, living.getY() - r, living.getZ() - r, living.getX() + r, living.getY() + r, living.getZ() + r), c -> c instanceof SupporekesisControllable);
                for (Entity c : controllables) {
                    if (c instanceof TraceableEntity ownable && ownable.getOwner() != null && Objects.equals(ownable.getOwner().getUUID(), living.getUUID()) && !SowCommonConfig.INSTANCE.supportium.supporekesisControlSelf.getValue())
                        continue;
                    if (c instanceof SupporekesisControllable controllable)
                        controllable.setDisappearCd(70, true);
                }
            }));
    public static final DeferredHolder<Ability<?>, DelayAbility> SUPPOROFORM = REGISTRY.register("supporoform", () -> new DelayAbility(SowAbilityCategories.SUPPORTIUM)
            .setApplySound(SowSounds.SUPPOROFORM)
            .setDelay(20)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporoformPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporoformSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.supportium.supporoformExhaustion.getValue())
            .onApply(holder -> {
                LivingEntity living = holder.getEntity();
                Level world = holder.getWorld();
                if (!(world instanceof ServerLevel serverWorld) || !(living instanceof Player player)) return;
                final int MAX_CNT = 41;
                for (int i = 0; i < MAX_CNT; i++) {
                    ItemStack stack = player.getInventory().getItem(i);
                    if (stack.isEmpty()) continue;
                    ItemStack stack1 = ItemStack.EMPTY;
                    if (stack.is(Items.OBSIDIAN))
                        stack1 = switch (stack.getCount()) {
                            case 5 -> new ItemStack(SowItems.ENDER_KNIGHT_HELMET.get());
                            case 8 -> new ItemStack(SowItems.ENDER_KNIGHT_CHESTPLATE.get());
                            case 7 -> new ItemStack(SowItems.ENDER_KNIGHT_LEGGINGS.get());
                            case 4 -> new ItemStack(SowItems.ENDER_KNIGHT_BOOTS.get());
                            default -> ItemStack.EMPTY;
                        };
                    if (stack1.isEmpty()) stack1 = RecipeUtils.findSmeltResult(serverWorld, stack).copy();
                    if (!stack1.isEmpty()) player.getInventory().setItem(i, stack1);
                }
            }));
    public static final DeferredHolder<Ability<?>, InstantAbility> SUPPOROLIFT = REGISTRY.register("supporolift", () -> new InstantAbility(SowAbilityCategories.SUPPORTIUM)
            .setApplySound(SowSounds.SUPPOROLIFT)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporoliftPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporoliftSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.supportium.supporoliftExhaustion.getValue())
            .onApply(holder -> {
                LivingEntity living = holder.getEntity();
                double maxDistance = SowCommonConfig.INSTANCE.supportium.supporoliftRange.getValue();
                EntityHitResult result = RaycastHelper.raycastNearest(living, maxDistance);
                if (result != null && result.getEntity() instanceof LivingEntity l) {
                    Vec3 dir = living.position().subtract(l.position()).scale(0.2);
                    l.setDeltaMovement(dir.add(0, 0.3, 0));
                    l.hurtMarked = true;
                } else holder.cancel();
            }));
    public static final DeferredHolder<Ability<?>, InstantAbility> SUPPOROSPIKE = REGISTRY.register("supporospike", () -> new InstantAbility(SowAbilityCategories.SUPPORTIUM)
            .setApplySound(SowSounds.SUPPOROSPIKE)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporospikePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.supportium.supporospikeSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.supportium.supporospikeExhaustion.getValue())
            .onApply(holder -> {
                LivingEntity living = holder.getEntity();
                Level world = holder.getWorld();
                double maxDistance = SowCommonConfig.INSTANCE.supportium.supporospikeRange.getValue();
                EntityHitResult result = RaycastHelper.raycastNearest(living, maxDistance);
                if (result != null && result.getEntity() instanceof LivingEntity l) {
                    Vec3[] vecs = new Vec3[]{
                            new Vec3(-0.5, -0.5, -0.5),
                            new Vec3(0.5, -0.5, -0.5),
                            new Vec3(-0.5, -0.5, 0.5),
                            new Vec3(0.5, -0.5, 0.5),
                            new Vec3(0, 0.5, 0)
                    };
                    Double2FloatFunction RANDOM = r -> (float) RandomHelper.nextDouble(-r, r);
                    BlockState state = world.getBlockState(l.blockPosition().below());
                    for (Vec3 vec : vecs) {
                        SupporoSpikeEntity spike = SowEntities.SUPPORO_SPIKE.get().create(world);
                        if (spike != null) {
                            spike.setBlockState(state);
                            spike.setPos(l.position().add(vec));
                            spike.setScale(1.2F);
                            spike.setDuration(50);
                            spike.setRotation(new Vector3f(RANDOM.get(Math.PI / 4), RANDOM.get(Math.PI / 16), RANDOM.get(Math.PI / 16)));
                            world.addFreshEntity(spike);
                        }
                    }
                    l.setDeltaMovement(new Vec3(0, 1.5, 0));
                    l.hurtMarked = true;
                } else holder.cancel();
            }));

}
