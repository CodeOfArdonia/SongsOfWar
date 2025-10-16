package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.ability.type.Ability;
import com.iafenvoy.neptune.ability.type.DummyAbility;
import com.iafenvoy.neptune.registry.NeptuneDataComponents;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.registry.power.SowAbilityCategories;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
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
        Ability<?> power = this.block.getCategory().randomOne();
        appendComponent(power, stack);
    }

    public static ItemStack appendComponent(Ability<?> power, ItemStack stack) {
        stack.set(NeptuneDataComponents.ABILITY, power);
        return stack;
    }

    public static ItemStack getStack(Ability<?> power) {
        return appendComponent(power, new ItemStack(SongCubeBlock.getBlock(power.getCategory())));
    }

    public static void dropAll(LivingEntity living) {
        AbilityData data = AbilityData.get(living);
        for (AbilityCategory category : SowAbilityCategories.ALL.get()) {
            Block.popResource(living.level(), living.blockPosition(), getStack(data.get(category).getActiveAbility()));
            data.get(category).setActiveAbility(living, DummyAbility.EMPTY);
        }
    }

    public static Ability<?> getPower(ItemStack stack) {
        return stack.getOrDefault(NeptuneDataComponents.ABILITY, DummyAbility.EMPTY);
    }
}
