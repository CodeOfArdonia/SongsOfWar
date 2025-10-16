package com.iafenvoy.sow.mixin;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.item.NoteItem;
import com.iafenvoy.sow.world.song.SongChunkManager;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NoteBlock.class)
public class NoteBlockMixin {
    @Inject(method = "playNote", at = @At("RETURN"))
    private void dropNote(@Nullable Entity entity, BlockState state, Level world, BlockPos pos, CallbackInfo ci) {
        if (entity == null) return;
        if (!(world instanceof ServerLevel serverWorld) || !(entity instanceof Player player)) return;
        if (!AbilityData.get(player).isEnabled()) return;
        ChunkPos chunkPos = new ChunkPos(pos);
        AbilityCategory category = SongChunkManager.find(serverWorld, chunkPos);
        if (category == null) return;
        BlockPos above = pos.above();
        if (serverWorld.getBlockState(above).isRedstoneConductor(serverWorld, above)) return;
        if (serverWorld.getRandom().nextInt(50) == 0 && SongChunkManager.reduce(serverWorld, chunkPos)) {
            Vec3 vec3d = above.getCenter();
            ItemEntity item = new ItemEntity(serverWorld, vec3d.x, vec3d.y, vec3d.z, new ItemStack(NoteItem.getItem(category)));
            world.addFreshEntity(item);
        }
    }
}
