package com.iafenvoy.sow.util;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;

public class RecipeUtils {
    public static ItemStack findSmeltResult(ServerLevel serverWorld, ItemStack source) {
        ItemStack stack = findResult(serverWorld, RecipeType.SMELTING, source);
        if (!stack.isEmpty()) return stack;
        stack = findResult(serverWorld, RecipeType.BLASTING, source);
        if (!stack.isEmpty()) return stack;
        stack = findResult(serverWorld, RecipeType.SMOKING, source);
        if (!stack.isEmpty()) return stack;
        return ItemStack.EMPTY;
    }

    public static <T extends AbstractCookingRecipe> ItemStack findResult(ServerLevel serverWorld, RecipeType<T> type, ItemStack source) {
        for (RecipeHolder<T> holder : serverWorld.getRecipeManager().getAllRecipesFor(type)) {
            T recipe = holder.value();
            if (recipe.getIngredients().size() == 1 && recipe.getIngredients().getFirst().test(source)) {
                ItemStack result = recipe.getResultItem(serverWorld.registryAccess());
                result.setCount(result.getCount() * source.getCount());
                return result;
            }
        }
        return ItemStack.EMPTY;
    }
}
