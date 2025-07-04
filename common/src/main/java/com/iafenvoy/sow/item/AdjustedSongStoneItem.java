package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.config.SowCommonConfig;
import com.iafenvoy.sow.registry.SowItemGroups;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import com.iafenvoy.sow.world.song.SongChunkManager;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AdjustedSongStoneItem extends Item {
    public static final String NEAR_KEY = "near_song";
    private final SowAbilityCategory category;

    public AdjustedSongStoneItem(SowAbilityCategory category) {
        super(new Settings().rarity(Rarity.RARE).maxCount(1).arch$tab(SowItemGroups.ITEMS));
        this.category = category;
    }

    @Override
    public String getTranslationKey() {
        return "item.sow.adjusted_song_stone";
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(this.category.getCategory().appendColor(Text.translatable(String.format("block.%s_song", this.category.getCategory().getId().toTranslationKey()))));
    }

    @SuppressWarnings("all")
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (world instanceof ServerWorld serverWorld) {
            if (!(entity instanceof PlayerEntity player) || !AbilityData.byPlayer(player).isEnabled(SowAbilityCategory.ALL.get().toArray(AbilityCategory[]::new)))
                stack.getOrCreateNbt().remove(NEAR_KEY);
            else {
                ChunkPos pos = entity.getChunkPos();
                NbtCompound compound = stack.getOrCreateNbt();
                if (SongChunkManager.isSongChunk(serverWorld, this.category, pos)) compound.putFloat(NEAR_KEY, 1);
                else if (SongChunkManager.hasSongChunk(serverWorld, this.category, pos, SowCommonConfig.INSTANCE.common.songChunkDetectRange.getValue()))
                    compound.putFloat(NEAR_KEY, 0.5F);
                else compound.remove(NEAR_KEY);
            }
        }
    }
}
