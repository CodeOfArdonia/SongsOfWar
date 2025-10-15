package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.registry.NeptuneDataComponents;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import com.iafenvoy.sow.world.song.SongChunkManager;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SongStoneItem extends Item {
    public static final String POWER_KEY = "song_power";

    public SongStoneItem() {
        super(new Properties().rarity(Rarity.UNCOMMON).stacksTo(1));
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level world, @NotNull Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (world instanceof ServerLevel serverWorld) {
            if (entity instanceof Player player && AbilityData.get(player).isEnabled(SowAbilityCategory.ALL.get().toArray(AbilityCategory[]::new))) {
                SowAbilityCategory category = SongChunkManager.find(serverWorld, entity.chunkPosition());
                if (category != null) stack.set(NeptuneDataComponents.ABILITY_CATEGORY, category.getCategory());
                else stack.remove(NeptuneDataComponents.ABILITY_CATEGORY);
            } else stack.remove(NeptuneDataComponents.ABILITY_CATEGORY);
        }
    }
}
