package net.ervo.missingworkstations.datagen;

import net.ervo.missingworkstations.block.ModBlocks;
import net.ervo.missingworkstations.recipe.ModRecipes;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public ModRecipeProvider(PackOutput pOutput) {
		super(pOutput);
	}

	@Override
	protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
		//region Kiln crafting
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KILN.get())
				.pattern("BBB")
				.pattern("BFB")
				.pattern("B B")
				.define('B', Items.BRICK)
				.define('F', Items.FURNACE)
				.unlockedBy(getHasName(Items.FURNACE), has(Items.FURNACE))
				.save(pWriter);
		//endregion

		kilning(Ingredient.of(Blocks.COBBLESTONE), Blocks.STONE, 0.1F, CookingBookCategory.BLOCKS, RecipeCategory.BUILDING_BLOCKS, pWriter);
		kilning(Ingredient.of(Blocks.STONE), Blocks.SMOOTH_STONE, 0.1F, CookingBookCategory.BLOCKS, RecipeCategory.BUILDING_BLOCKS, pWriter);
	}

	public static void kilning(Ingredient ingredient, Block result, float xp, CookingBookCategory bookCategory, RecipeCategory recipeCategory, Consumer<FinishedRecipe> pWriter) {
		Item ingredientItem = ingredient.getItems()[0].getItem();
		generiquerCookingRecipe(ingredient, bookCategory, recipeCategory, result.asItem(), xp, 100, ModRecipes.KILNING_SERIALIZER.get())
				.unlockedBy("has_" + getItemName(ingredientItem), has(ingredientItem))
				.save(pWriter, getItemName(result.asItem()) + "_from_kilning");
	}

	public static SimpleCookingRecipeBuilder generiquerCookingRecipe(Ingredient pIngredient, CookingBookCategory pCookBook, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer) {
		return new SimpleCookingRecipeBuilder(pCategory, pCookBook, pResult, pIngredient, pExperience, pCookingTime, pSerializer);
	}
}
