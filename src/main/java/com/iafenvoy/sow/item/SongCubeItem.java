package com.iafenvoy.sow.item;

import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.neptune.ability.type.Ability;
import com.iafenvoy.neptune.ability.type.DummyAbility;
import com.iafenvoy.neptune.registry.NeptuneDataComponents;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
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
        Ability<?> power = this.block.getCategory().getCategory().randomOne();
        appendComponent(power, stack);
    }

    public static ItemStack appendComponent(Ability<?> power, ItemStack stack) {
        stack.set(NeptuneDataComponents.ABILITY, power);
        return stack;
    }

    public static ItemStack getStack(Ability<?> power) {
        return appendComponent(power, new ItemStack(SongCubeBlock.BLOCKS_MAP.getOrDefault(SowAbilityCategory.byCategory(power.getCategory()), Items.AIR)));
    }

    public static void dropAll(LivingEntity living) {
        AbilityData data = AbilityData.get(living);
        for (SowAbilityCategory category : SowAbilityCategory.values()) {
            Block.popResource(living.level(), living.blockPosition(), getStack(data.get(category.getCategory()).getActiveAbility()));
            data.get(category.getCategory()).setActiveAbility(living, DummyAbility.EMPTY);
        }
    }

    public static Ability<?> getPower(ItemStack stack) {
        return stack.getOrDefault(NeptuneDataComponents.ABILITY, DummyAbility.EMPTY);
    }
}
