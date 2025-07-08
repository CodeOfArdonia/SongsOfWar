package com.iafenvoy.sow.registry.power;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.ability.type.DelayAbility;
import com.iafenvoy.neptune.ability.type.InstantAbility;
import com.iafenvoy.neptune.ability.type.PersistAbility;
import com.iafenvoy.sow.Constants;
import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.item.block.TemporaryTransparentBlock;
import com.iafenvoy.sow.power.component.MobiliBurstComponent;
import com.iafenvoy.sow.power.component.MobiliWingsComponent;
import com.iafenvoy.sow.registry.SowBlocks;
import com.iafenvoy.sow.registry.SowSounds;
import com.iafenvoy.sow.util.SowMath;
import net.minecraft.block.BlockState;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public final class MobiliumPowers {
    public static final InstantAbility MOBILIBOUNCE = new InstantAbility(Identifier.of(SongsOfWar.MOD_ID, "mobilibounce"), SowAbilityCategory.MOBILIUM.getCategory())
            .setApplySound(SowSounds.MOBILIBOUNCE)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.mobilium.mobilibouncePrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.mobilium.mobilibounceSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.mobilium.mobilibounceExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                World world = holder.getWorld();
                BlockPos below = player.getBlockPos().down();
                BlockState state = world.getBlockState(below);
                if (state.isSolidBlock(world, below) || player.isOnGround()) holder.cancel();
                TemporaryTransparentBlock.place(world, below, SowBlocks.MOBILIBOUNCE_PLATFORM.get().getDefaultState(), 20 * SowCommonConfig.INSTANCE.mobilium.mobilibounceExistTime.getValue());
                player.setVelocity(0, 0, 0);
                player.velocityModified = true;
            });
    public static final DelayAbility MOBILIBURST = new DelayAbility(Identifier.of(SongsOfWar.MOD_ID, "mobiliburst"), SowAbilityCategory.MOBILIUM.getCategory())
            .setApplySound(SowSounds.MOBILIBURST)
            .setDelay(28)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliburstPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliburstSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliburstExhaustion.getValue())
            .onApply(holder -> {
                World world = holder.getWorld();
                PlayerEntity player = holder.getPlayer();
                final Vec3d dir = SowMath.getRotationVectorUnit(MathHelper.clamp(player.getPitch(), -15, 15), player.getHeadYaw());
                player.setVelocity(dir.multiply(SowCommonConfig.INSTANCE.mobilium.mobiliburstSpeed.getValue()));
                player.velocityModified = true;
                MobiliBurstComponent component = new MobiliBurstComponent(player);
                component.setActivate(true);
                component.setMaxTick(SowCommonConfig.INSTANCE.mobilium.mobiliburstPrimaryCooldown.getValue() + 20);
                AbilityData.byPlayer(player).addComponent(MobiliBurstComponent.ID, component);
            });
    public static final DelayAbility MOBILIFLASH = new DelayAbility(Identifier.of(SongsOfWar.MOD_ID, "mobiliflash"), SowAbilityCategory.MOBILIUM.getCategory())
            .setApplySound(SowSounds.MOBILIFLASH)
            .setDelay(20)
            .setPrimaryCooldown(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliflashPrimaryCooldown.getValue())
            .setSecondaryCooldown(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliflashSecondaryCooldown.getValue())
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliflashExhaustion.getValue())
            .onApply(holder -> {
                World world = holder.getWorld();
                PlayerEntity player = holder.getPlayer();
                final Vec3d dir = SowMath.getRotationVectorUnit(MathHelper.clamp(player.getPitch(), -15, 15), player.getHeadYaw());
                player.setVelocity(dir.multiply(SowCommonConfig.INSTANCE.mobilium.mobiliflashSpeed.getValue()));
                player.velocityModified = true;
            });
    public static final PersistAbility MOBILIGLIDE = new PersistAbility(Identifier.of(SongsOfWar.MOD_ID, "mobiliglide"), SowAbilityCategory.MOBILIUM.getCategory())
            .setApplySound(SowSounds.MOBILIGLIDE)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliglideExhaustion.getValue())
            .onApply(holder -> {//GRAVITY attribute not available before 1.20.5
                EntityAttributeInstance instance = holder.getPlayer().getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (instance != null)
                    instance.addTemporaryModifier(new EntityAttributeModifier(Constants.MOBILIGLIDE_UUID, "mobiliglide", 1, EntityAttributeModifier.Operation.ADDITION));
            })
            .onTick(holder -> {
                if (holder.getPlayer().isOnGround() || holder.getPlayer().getAbilities().flying) holder.cancel();
            })
            .onUnapply(holder -> {
                EntityAttributeInstance instance = holder.getPlayer().getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (instance != null) instance.removeModifier(Constants.MOBILIGLIDE_UUID);
            });
    public static final PersistAbility MOBILILEAP = new PersistAbility(Identifier.of(SongsOfWar.MOD_ID, "mobilileap"), SowAbilityCategory.MOBILIUM.getCategory())
            .setApplySound(SowSounds.MOBILILEAP)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.mobilium.mobilileapExhaustion.getValue());
    public static final PersistAbility MOBILIWINGS = new PersistAbility(Identifier.of(SongsOfWar.MOD_ID, "mobiliwings"), SowAbilityCategory.MOBILIUM.getCategory())
            .setApplySound(SowSounds.MOBILIWINGS)
            .setExhaustion(holder -> SowCommonConfig.INSTANCE.mobilium.mobiliwingsExhaustion.getValue())
            .onApply(holder -> {
                PlayerEntity player = holder.getPlayer();
                player.startFallFlying();
                AbilityData.byPlayer(player).addComponent(MobiliWingsComponent.ID, new MobiliWingsComponent(player));
            })
            .onTick(holder -> {
                PlayerEntity player = holder.getPlayer();
                if (player.isOnGround() || player.getAbilities().flying) holder.cancel();
            })
            .onUnapply(holder -> AbilityData.byPlayer(holder.getPlayer()).removeComponent(MobiliWingsComponent.ID));

    public static void init() {
    }
}
