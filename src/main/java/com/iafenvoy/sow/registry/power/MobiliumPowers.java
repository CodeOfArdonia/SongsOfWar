package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.ability.type.Ability;
import com.iafenvoy.neptune.ability.type.DelayAbility;
import com.iafenvoy.neptune.ability.type.InstantAbility;
import com.iafenvoy.neptune.ability.type.PersistAbility;
import com.iafenvoy.neptune.registry.NeptuneRegistries;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.item.block.TemporaryTransparentBlock;
import com.iafenvoy.sow.power.component.MobiliBurstComponent;
import com.iafenvoy.sow.power.component.MobiliWingsComponent;
import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.registry.SowSounds;
import com.iafenvoy.sow.util.SowMath;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unused")
public final class MobiliumPowers {
    public static final DeferredRegister<Ability<?>> REGISTRY = DeferredRegister.create(NeptuneRegistries.ABILITY, SongsOfWar.MOD_ID);

    public static final DeferredHolder<Ability<?>, InstantAbility> MOBILIBOUNCE = REGISTRY.register("mobilibounce", () -> new InstantAbility(SowAbilityCategories.MOBILIUM)
            .setApplySound(SowSounds.MOBILIBOUNCE)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.mobilium.mobilibouncePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.mobilium.mobilibounceSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.mobilium.mobilibounceExhaustion.getValue())
            .onApply(holder -> {
                LivingEntity player = holder.getEntity();
                Level world = holder.getWorld();
                BlockPos below = player.blockPosition().below();
                BlockState state = world.getBlockState(below);
                if (state.isRedstoneConductor(world, below) || player.onGround()) holder.cancel();
                TemporaryTransparentBlock.place(world, below, SowBlocks.MOBILIBOUNCE_PLATFORM.get().defaultBlockState(), 20 * SowCommonConfig.INSTANCE.mobilium.mobilibounceExistTime.getValue());
                player.setDeltaMovement(0, 0, 0);
                player.hurtMarked = true;
            }));
    public static final DeferredHolder<Ability<?>, DelayAbility> MOBILIBURST = REGISTRY.register("mobiliburst", () -> new DelayAbility(SowAbilityCategories.MOBILIUM)
            .setApplySound(SowSounds.MOBILIBURST)
            .setDelay(28)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliburstPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliburstSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliburstExhaustion.getValue())
            .onApply(holder -> {
                Level world = holder.getWorld();
                LivingEntity living = holder.getEntity();
                final Vec3 dir = SowMath.getRotationVectorUnit(Mth.clamp(living.getXRot(), -15, 15), living.getYHeadRot());
                living.setDeltaMovement(dir.scale(SowCommonConfig.INSTANCE.mobilium.mobiliburstSpeed.getValue()));
                living.hurtMarked = true;
                MobiliBurstComponent component = new MobiliBurstComponent();
                component.setActivate(true);
                component.setMaxTick(SowCommonConfig.INSTANCE.mobilium.mobiliburstPrimaryCooldown.getValue() + 20);
                AbilityData.get(living).addComponent(MobiliBurstComponent.ID, component);
            }));
    public static final DeferredHolder<Ability<?>, DelayAbility> MOBILIFLASH = REGISTRY.register("mobiliflash", () -> new DelayAbility(SowAbilityCategories.MOBILIUM)
            .setApplySound(SowSounds.MOBILIFLASH)
            .setDelay(20)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliflashPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliflashSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliflashExhaustion.getValue())
            .onApply(holder -> {
                Level world = holder.getWorld();
                LivingEntity living = holder.getEntity();
                final Vec3 dir = SowMath.getRotationVectorUnit(Mth.clamp(living.getXRot(), -15, 15), living.getYHeadRot());
                living.setDeltaMovement(dir.scale(SowCommonConfig.INSTANCE.mobilium.mobiliflashSpeed.getValue()));
                living.hurtMarked = true;
            }));
    public static final DeferredHolder<Ability<?>, PersistAbility> MOBILIGLIDE = REGISTRY.register("mobiliglide", () -> new PersistAbility(SowAbilityCategories.MOBILIUM)
            .setApplySound(SowSounds.MOBILIGLIDE)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliglideExhaustion.getValue())
            .onApply(holder -> {//GRAVITY attribute not available before 1.20.5
                AttributeInstance instance = holder.getEntity().getAttributes().getInstance(Attributes.MOVEMENT_SPEED);
                if (instance != null)
                    instance.addTransientModifier(new AttributeModifier(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "mobiliglide"), 1, AttributeModifier.Operation.ADD_VALUE));
            })
            .onTick(holder -> {
                LivingEntity living = holder.getEntity();
                if (living.onGround() || living instanceof Player player && player.getAbilities().flying)
                    holder.cancel();
            })
            .onUnapply(holder -> {
                AttributeInstance instance = holder.getEntity().getAttributes().getInstance(Attributes.MOVEMENT_SPEED);
                if (instance != null)
                    instance.removeModifier(ResourceLocation.fromNamespaceAndPath(SongsOfWar.MOD_ID, "mobiliglide"));
            }));
    public static final DeferredHolder<Ability<?>, PersistAbility> MOBILILEAP = REGISTRY.register("mobilileap", () -> new PersistAbility(SowAbilityCategories.MOBILIUM)
            .setApplySound(SowSounds.MOBILILEAP)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.mobilium.mobilileapExhaustion.getValue()));
    public static final DeferredHolder<Ability<?>, PersistAbility> MOBILIWINGS = REGISTRY.register("mobiliwings", () -> new PersistAbility(SowAbilityCategories.MOBILIUM)
            .setApplySound(SowSounds.MOBILIWINGS)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliwingsExhaustion.getValue())
            .onApply(holder -> {
                LivingEntity living = holder.getEntity();
                if (living instanceof Player player) player.startFallFlying();
                AbilityData.get(living).addComponent(MobiliWingsComponent.ID, new MobiliWingsComponent());
            })
            .onTick(holder -> {
                LivingEntity living = holder.getEntity();
                if (living.onGround() || living instanceof Player player && player.getAbilities().flying)
                    holder.cancel();
            })
            .onUnapply(holder -> AbilityData.get(holder.getEntity()).removeComponent(MobiliWingsComponent.ID)));

}
