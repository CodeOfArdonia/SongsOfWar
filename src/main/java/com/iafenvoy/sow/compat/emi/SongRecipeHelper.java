package com.iafenvoy.sow.compat.emi;

import com.iafenvoy.sow.SongsOfWar;
import com.iafenvoy.sow.item.block.SongCubeBlock;
import com.iafenvoy.sow.registry.SowItems;
import com.iafenvoy.sow.registry.power.SupportiumPowers;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class SongRecipeHelper {
    private static final ResourceLocation SONG_RECIPE = ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "song_recipe");
    private static final EmiTexture TEXTURE = new EmiTexture(ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "textures/gui/gui_song_recipe.png"), 0, 0, 140, 44);
    private static final EmiStack WORKSTATION = EmiStack.of(SongCubeBlock.getStack(SupportiumPowers.SUPPOROFORM.get()));
    private static final EmiRecipeCategory CATEGORY = new EmiRecipeCategory(SONG_RECIPE, WORKSTATION, TEXTURE);
    private static final List<SongRecipe> RECIPES = List.of(
            new SongRecipe("obsidian_helmet", new ItemStack(Items.OBSIDIAN, 5), new ItemStack(SowItems.ENDER_KNIGHT_HELMET.get())),
            new SongRecipe("obsidian_chestplate", new ItemStack(Items.OBSIDIAN, 8), new ItemStack(SowItems.ENDER_KNIGHT_CHESTPLATE.get())),
            new SongRecipe("obsidian_leggings", new ItemStack(Items.OBSIDIAN, 7), new ItemStack(SowItems.ENDER_KNIGHT_LEGGINGS.get())),
            new SongRecipe("obsidian_boots", new ItemStack(Items.OBSIDIAN, 4), new ItemStack(SowItems.ENDER_KNIGHT_BOOTS.get()))
    );

    public static void register(EmiRegistry registry) {
        registry.addCategory(CATEGORY);
        registry.addWorkstation(CATEGORY, WORKSTATION);
        for (SongRecipe recipe : RECIPES)
            registry.addRecipe(recipe);
    }

    private record SongRecipe(String id, ItemStack input, ItemStack output) implements EmiRecipe {
        @Override
        public EmiRecipeCategory getCategory() {
            return CATEGORY;
        }

        @Override
        public ResourceLocation getId() {
            return ResourceLocation.tryBuild(SongsOfWar.MOD_ID, "/song/%s".formatted(this.id));
        }

        @Override
        public List<EmiIngredient> getInputs() {
            return List.of(EmiIngredient.of(Ingredient.of(this.input)));
        }

        @Override
        public List<EmiStack> getOutputs() {
            return List.of(EmiStack.of(this.output));
        }

        @Override
        public int getDisplayWidth() {
            return 140;
        }

        @Override
        public int getDisplayHeight() {
            return 44;
        }

        @Override
        public void addWidgets(WidgetHolder widgets) {
            widgets.addTexture(TEXTURE, 0, 0);
            widgets.addSlot(this.getInputs().getFirst(), 13, 12);
            widgets.addSlot(EmiIngredient.of(List.of(WORKSTATION)), 61, 12);
            widgets.addSlot(this.getOutputs().getFirst(), 109, 12).recipeContext(this);
        }
    }
}
