package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.ability.type.*;
import com.iafenvoy.neptune.registry.NeptuneRegistries;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.entity.power.ProteCloneEntity;
import com.iafenvoy.sow.item.block.TemporaryTransparentBlock;
import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.registry.SowEntities;
import com.iafenvoy.sow.registry.SowItems;
import com.iafenvoy.sow.registry.SowSounds;
import com.iafenvoy.sow.util.SowMath;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unused")
public final class ProtisiumPowers {
    public static final DeferredRegister<Ability<?>> REGISTRY = DeferredRegister.create(NeptuneRegistries.ABILITY, SongsOfWar.MOD_ID);

    public static final DeferredHolder<Ability<?>, PersistAbility> PROTEARMOR = REGISTRY.register("protearmor", () -> new PersistAbility(SowAbilityCategory.PROTISIUM.getCategory())
            .setApplySound(SowSounds.PROTEARMOR)
            .setUnapplySound(SowSounds.PROTEARMOR_UNAPPLY)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protearmorPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protearmorSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.protisium.protearmorExhaustion.getValue())
            .onInit(self -> NeoForge.EVENT_BUS.<LivingDamageEvent.Pre>addListener(event -> {
                AbilityData data = AbilityData.get(event.getEntity());
                if (data.abilityEnabled(self)) {
                    data.get(SowAbilityCategory.PROTISIUM.getCategory()).disable(event.getEntity());
                    event.setNewDamage(Math.max(event.getOriginalDamage() - SowCommonConfig.INSTANCE.protisium.protearmorMaxReduceDamage.getValue().floatValue(), 0));
                }
            })));
    public static final DeferredHolder<Ability<?>, InstantAbility> PROTEBARRIER = REGISTRY.register("protebarrier", () -> new InstantAbility(SowAbilityCategory.PROTISIUM.getCategory())
            .setApplySound(SowSounds.PROTEBARRIER)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protebarrierPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protebarrierSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.protisium.protebarrierExhaustion.getValue())
            .onApply(holder -> {
                LivingEntity living = holder.getEntity();
                Level world = holder.getWorld();
                int range = 8;
                float pitch = living.getXRot(), yaw = living.getYHeadRot();
                Vec3 origin = living.position();
                for (float i = pitch - 30; i <= pitch + 30; i += 5)
                    for (float j = yaw - 40; j <= yaw + 40; j += 5) {
                        BlockPos pos = BlockPos.containing(origin.add(SowMath.getRotationVectorUnit(i, j).scale(range)));
                        if (!world.getBlockState(pos).isRedstoneConductor(world, pos))
                            TemporaryTransparentBlock.place(world, pos, SowBlocks.PROTE_BARRIER.get().defaultBlockState(), 20 * SowCommonConfig.INSTANCE.protisium.protebarrierExistTime.getValue());
                    }
            }));
    public static final DeferredHolder<Ability<?>, DelayAbility> PROTECLONE = REGISTRY.register("proteclone", () -> new DelayAbility(SowAbilityCategory.PROTISIUM.getCategory())
            .setApplySound(SowSounds.PROTECLONE)
            .setDelay(12)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.proteclonePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protecloneSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.protisium.protecloneExhaustion.getValue())
            .onApply(holder -> {
                LivingEntity living = holder.getEntity();
                Level world = holder.getWorld();
                ProteCloneEntity proteClone = SowEntities.PROTE_CLONE.get().create(world);
                if (proteClone != null) {
                    proteClone.moveTo(living.getX(), living.getY(), living.getZ(), living.getYRot(), living.getXRot());
                    proteClone.setDisappearCd(SowCommonConfig.INSTANCE.protisium.proteclonePrimaryCooldown.getValue());
                    world.addFreshEntity(proteClone);
                }
            }));
    public static final DeferredHolder<Ability<?>, IntervalAbility> PROTEHEAL = REGISTRY.register("proteheal", () -> new IntervalAbility(SowAbilityCategory.PROTISIUM.getCategory())
            .setApplySound(SowSounds.PROTEHEAL)
            .setInterval(10)
            .setTimes(10)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protehealPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.protisium.protehealSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.protisium.protehealExhaustion.getValue())
            .onApply(holder -> {
                LivingEntity living = holder.getEntity();
                if (living.getHealth() >= living.getMaxHealth()) {
                    holder.cancel();
                    return;
                }
                living.heal(1);
            }));
    public static final DeferredHolder<Ability<?>, PersistAbility> PROTEPOINT = REGISTRY.register("protepoint", () -> new PersistAbility(SowAbilityCategory.PROTISIUM.getCategory())
            .setApplySound(SowSounds.PROTEPOINT)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.protisium.protepointExhaustion.getValue())
            .onApply(holder -> {
                ItemStack stack = new ItemStack(SowItems.PROTEPOINT_SHIELD.get());
                holder.getEntity().setItemInHand(InteractionHand.OFF_HAND, stack);
            }).onTick(holder -> {
                if (!holder.getEntity().getOffhandItem().is(SowItems.PROTEPOINT_SHIELD.get())) holder.cancel();
            }).onUnapply(holder -> {
                LivingEntity living = holder.getEntity();
                if (living.getOffhandItem().is(SowItems.PROTEPOINT_SHIELD.get()))
                    living.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY.copy());
            }));
    public static final DeferredHolder<Ability<?>, PersistAbility> PROTESPHERE = REGISTRY.register("protesphere", () -> new PersistAbility(SowAbilityCategory.PROTISIUM.getCategory())
            .setApplySound(SowSounds.PROTESPHERE)
            .setUnapplySound(SowSounds.PROTESPHERE_UNAPPLY)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.protisium.protesphereExhaustion.getValue())
            .onApply(holder -> {
                AttributeInstance instance = holder.getEntity().getAttributes().getInstance(Attributes.ARMOR);
                if (instance != null)
                    instance.addTransientModifier(new AttributeModifier(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "protesphere"), 50, AttributeModifier.Operation.ADD_VALUE));
            })
            .onUnapply(holder -> {
                AttributeInstance instance = holder.getEntity().getAttributes().getInstance(Attributes.ARMOR);
                if (instance != null)
                    instance.removeModifier(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "protesphere"));
            }));
}
