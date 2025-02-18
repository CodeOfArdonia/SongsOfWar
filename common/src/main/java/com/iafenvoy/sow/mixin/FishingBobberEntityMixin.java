package com.iafenvoy.sow.mixin;

import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.entity.ardoni.DeathSingerEntity;
import com.iafenvoy.sow.registry.SowEntities;
import com.iafenvoy.sow.registry.SowSkulls;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberEntityMixin extends ProjectileEntity {
    @Shadow
    @Final
    private Random velocityRandom;

    @Shadow
    @Nullable
    public abstract PlayerEntity getPlayerOwner();

    public FishingBobberEntityMixin(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "use", at = @At(value = "INVOKE", target = "Ljava/util/Iterator;hasNext()Z"), cancellable = true)
    private void onGenerateLoot(ItemStack usedItem, CallbackInfoReturnable<Integer> cir) {
        PlayerEntity player = this.getPlayerOwner();
        if (player == null) return;
        if (this.velocityRandom.nextDouble() < SowCommonConfig.INSTANCE.common.specialFishChance.getValue() || player.getEquippedStack(EquipmentSlot.HEAD).isOf(SowSkulls.TIDE_SINGER_HEAD_ITEM.get())) {
            DeathSingerEntity entity = SowEntities.DEATH_SINGER.get().create(this.getWorld());
            if (entity == null) return;
            double d0 = player.getX() - this.getX();
            double d1 = player.getY() - this.getY();
            double d2 = player.getZ() - this.getZ();
            entity.setPosition(this.getPos());
            entity.setVelocity(d0 * 0.2, d1 * 0.2 + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.16, d2 * 0.2);
            this.getWorld().spawnEntity(entity);
            this.discard();
            cir.setReturnValue(this.isOnGround() ? 2 : 1);
        }
    }
}
