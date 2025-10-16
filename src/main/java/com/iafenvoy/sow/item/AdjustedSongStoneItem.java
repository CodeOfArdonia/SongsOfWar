package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.registry.SowDataComponents;
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import com.iafenvoy.sow.world.song.SongChunkManager;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdjustedSongStoneItem extends Item {
    public static final String NEAR_KEY = "near_song";
    private final DeferredHolder<AbilityCategory, AbilityCategory> category;

    public AdjustedSongStoneItem(DeferredHolder<AbilityCategory, AbilityCategory> category) {
        super(new Properties().rarity(Rarity.RARE).stacksTo(1));
        this.category = category;
    }

    @Override
    public @NotNull String getDescriptionId() {
        return "item.sow.adjusted_song_stone";
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(this.category.get().appendColor(Component.translatable(String.format("block.%s_song", this.category.getId().toLanguageKey()))));
    }

    @SuppressWarnings("all")
    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (world instanceof ServerLevel serverWorld) {
            if (!(entity instanceof Player player) || !AbilityData.get(player).isEnabled(SowAbilityCategories.ALL.get().toArray(AbilityCategory[]::new)))
                stack.remove(SowDataComponents.SONG_STONE_NEAR);
            else {
                ChunkPos pos = entity.chunkPosition();
                if (SongChunkManager.isSongChunk(serverWorld, this.category.get(), pos))
                    stack.set(SowDataComponents.SONG_STONE_NEAR, 1F);
                else if (SongChunkManager.hasSongChunk(serverWorld, this.category.get(), pos, SowCommonConfig.INSTANCE.common.songChunkDetectRange.getValue()))
                    stack.set(SowDataComponents.SONG_STONE_NEAR, 0.5F);
                else stack.remove(SowDataComponents.SONG_STONE_NEAR);
            }
        }
    }
}
