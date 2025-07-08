package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.ability.type.DelayAbility;
import com.iafenvoy.neptune.ability.type.InstantAbility;
import com.iafenvoy.neptune.ability.type.IntervalAbility;
import com.iafenvoy.neptune.ability.type.PersistAbility;
import com.iafenvoy.neptune.event.LivingEntityEvents;
import com.iafenvoy.sow.Constants;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.entity.power.ProteCloneEntity;
import com.iafenvoy.sow.item.block.TemporaryTransparentBlock;
import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.registry.SowEntities;
import com.iafenvoy.sow.registry.SowItems;
import com.iafenvoy.sow.registry.SowSounds;
import com.iafenvoy.sow.util.SowMath;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public final class ProtisiumPowers {
    public static final PersistAbility PROTEARMOR = new PersistAbility(Identifier.of(SongsOfWar.MOD_ID, "protearmor"), SowAbilityCategory.PROTISIUM.getCategory())
            .setApplySound(SowSounds.PROTEARMOR)
            .setUnapplySound(SowSounds.PROTEARMOR_UNAPPLY)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protearmorPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protearmorSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.protisium.protearmorExhaustion.getValue())
            .onInit(self -> LivingEntityEvents.DAMAGE.register((entity, source, amount) -> {
                if (entity instanceof PlayerEntity player) {
                    AbilityData data = AbilityData.byPlayer(player);
                    if (data.abilityEnabled(self)) {
                        data.get(SowAbilityCategory.PROTISIUM.getCategory()).disable();
                        return Math.max(amount - SowCommonConfig.INSTANCE.protisium.protearmorMaxReduceDamage.getValue().floatValue(), 0);
                    }
                }
                return amount;
            }));
    public static final InstantAbility PROTEBARRIER = new InstantAbility(Identifier.of(SongsOfWar.MOD_ID, "protebarrier"), SowAbilityCategory.PROTISIUM.getCategory())
            .setApplySound(SowSounds.PROTEBARRIER)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protebarrierPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protebarrierSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.protisium.protebarrierExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                int range = 8;
                float pitch = player.getPitch(), yaw = player.getHeadYaw();
                Vec3d origin = player.getPos();
                for (float i = pitch - 30; i <= pitch + 30; i += 5)
                    for (float j = yaw - 40; j <= yaw + 40; j += 5) {
                        BlockPos pos = BlockPos.ofFloored(origin.add(SowMath.getRotationVectorUnit(i, j).multiply(range)));
                        if (!world.getBlockState(pos).isSolidBlock(world, pos))
                            TemporaryTransparentBlock.place(world, pos, SowBlocks.PROTE_BARRIER.get().getDefaultState(), 20 * SowCommonConfig.INSTANCE.protisium.protebarrierExistTime.getValue());
                    }
            });
    public static final DelayAbility PROTECLONE = new DelayAbility(Identifier.of(SongsOfWar.MOD_ID, "proteclone"), SowAbilityCategory.PROTISIUM.getCategory())
            .setApplySound(SowSounds.PROTECLONE)
            .setDelay(12)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.proteclonePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protecloneSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.protisium.protecloneExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                ProteCloneEntity proteClone = SowEntities.PROTE_CLONE.get().create(world);
                if (proteClone != null) {
                    proteClone.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), player.getYaw(), player.getPitch());
                    proteClone.setDisappearCd(SowCommonConfig.INSTANCE.protisium.proteclonePrimaryCooldown.getValue());
                    world.spawnEntity(proteClone);
                }
            });
    public static final IntervalAbility PROTEHEAL = new IntervalAbility(Identifier.of(SongsOfWar.MOD_ID, "proteheal"), SowAbilityCategory.PROTISIUM.getCategory())
            .setApplySound(SowSounds.PROTEHEAL)
            .setInterval(10)
            .setTimes(10)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protehealPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protehealSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.protisium.protehealExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                if (player.getHealth() >= player.getMaxHealth()) {
                    holder.cancel();
                    return;
                }
                player.heal(1);
            });
    public static final PersistAbility PROTEPOINT = new PersistAbility(Identifier.of(SongsOfWar.MOD_ID, "protepoint"), SowAbilityCategory.PROTISIUM.getCategory())
            .setApplySound(SowSounds.PROTEPOINT)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.protisium.protepointExhaustion.getValue())
            .onApply(holder -> {
                ItemStack stack = new ItemStack(SowItems.PROTEPOINT_SHIELD.get());
                holder.getPlayer().setStackInHand(Hand.OFF_HAND, stack);
            }).onTick(holder -> {
                if (!holder.getPlayer().getOffHandStack().isOf(SowItems.PROTEPOINT_SHIELD.get())) holder.cancel();
            }).onUnapply(holder -> {
                if (holder.getPlayer().getOffHandStack().isOf(SowItems.PROTEPOINT_SHIELD.get()))
                    holder.getPlayer().setStackInHand(Hand.OFF_HAND, ItemStack.EMPTY.copy());
            });
    public static final PersistAbility PROTESPHERE = new PersistAbility(Identifier.of(SongsOfWar.MOD_ID, "protesphere"), SowAbilityCategory.PROTISIUM.getCategory())
            .setApplySound(SowSounds.PROTESPHERE)
            .setUnapplySound(SowSounds.PROTESPHERE_UNAPPLY)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.protisium.protesphereExhaustion.getValue())
            .onApply(holder -> {
                EntityAttributeInstance instance = holder.getPlayer().getAttributes().getCustomInstance(EntityAttributes.GENERIC_ARMOR);
                if (instance != null)
                    instance.addTemporaryModifier(new EntityAttributeModifier(Constants.PROTESPHERE_UUID, "protesphere", 50, EntityAttributeModifier.Operation.ADDITION));
            })
            .onUnapply(holder -> {
                EntityAttributeInstance instance = holder.getPlayer().getAttributes().getCustomInstance(EntityAttributes.GENERIC_ARMOR);
                if (instance != null) instance.removeModifier(Constants.PROTESPHERE_UUID);
            });

    public static void init() {
    }
}
