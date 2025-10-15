package com.iafenvoy.sow.mixin;

import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.data.BeaconData;
import com.iafenvoy.sow.network.payload.BeaconTeleportS2CPayload;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.BeaconBlock;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(BeaconBlock.class)
public abstract class BeaconBlockMixin extends BaseEntityBlock {
    protected BeaconBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "useWithoutItem", at = @At("HEAD"), cancellable = true)
    private void handleUse(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult, CallbackInfoReturnable<InteractionResult> cir) {
        if (!SowCommonConfig.INSTANCE.common.enableBeaconTp.getValue()) return;
        if (!(level instanceof ServerLevel serverWorld) || !(player instanceof ServerPlayer serverPlayer))
            return;
        if (level.getBlockEntity(pos) instanceof BeaconBlockEntity) {
            BeaconData beaconData = BeaconData.getInstance(serverWorld);
            Optional<BeaconData.SingleBeaconData> optional = beaconData.get(pos);
            if (optional.isPresent()) {
                PacketDistributor.sendToPlayer(serverPlayer, new BeaconTeleportS2CPayload(pos, beaconData));
                cir.setReturnValue(InteractionResult.CONSUME);
            }
        }
    }

    @Override
    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity placer, @NotNull ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (stack.has(DataComponents.CUSTOM_NAME))
            if (level instanceof ServerLevel serverWorld)
                BeaconData.getInstance(serverWorld).add(pos, stack.getHoverName());
    }
}
