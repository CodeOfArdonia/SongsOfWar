package com.iafenvoy.sow.item;

import com.iafenvoy.sow.entity.ThrownWeaponEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ThrowableWeaponItem extends SwordItem {
    private final int rotateOffset;

    public ThrowableWeaponItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        this(toolMaterial, attackDamage, attackSpeed, settings, 0);
    }

    public ThrowableWeaponItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, int rotateOffset) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.rotateOffset = rotateOffset;
    }

    public int getRotateOffset() {
        return this.rotateOffset;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int i = this.getMaxUseTime(stack) - remainingUseTicks;
            if (i >= 10) {
                if (!world.isClient) {
                    stack.damage(1, playerEntity, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
                    ThrownWeaponEntity weapon = new ThrownWeaponEntity(world, playerEntity, stack);
                    weapon.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, 2.5F, 1.0F);
                    if (playerEntity.getAbilities().creativeMode)
                        weapon.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                    else playerEntity.getInventory().removeOne(stack);
                    if (remainingUseTicks <= 0) weapon.setCritical(true);
                    world.spawnEntity(weapon);
                    world.playSoundFromEntity(null, weapon, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
                }
                playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (itemStack.getDamage() >= itemStack.getMaxDamage() - 1)
            return TypedActionResult.fail(itemStack);
        else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
    }
}
