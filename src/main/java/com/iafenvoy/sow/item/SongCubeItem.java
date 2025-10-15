package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.ability.type.Ability;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SongCubeItem extends BlockItem {
    private final SongCubeBlock block;

    public SongCubeItem(SongCubeBlock block) {
        super(block, new Item.Properties().rarity(Rarity.EPIC).stacksTo(1));
        this.block = block;
    }

    @Override
    public void onCraftedBy(@NotNull ItemStack stack, @NotNull Level world, @NotNull Player player) {
        super.onCraftedBy(stack, world, player);
        Ability<?> power = this.block.getCategory().getCategory().randomOne();
        SongCubeBlock.appendComponent(power, stack);
    }
}
