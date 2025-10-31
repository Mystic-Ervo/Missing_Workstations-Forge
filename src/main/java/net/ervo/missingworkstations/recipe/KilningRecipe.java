package net.ervo.missingworkstations.recipe;

import net.ervo.missingworkstations.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class KilningRecipe extends AbstractCookingRecipe {

	public KilningRecipe(ResourceLocation pId, String pGroup, CookingBookCategory pCategory, Ingredient pIngredient, ItemStack pResult, float pExperience, int pCookingTime) {
		super(ModRecipes.KILNING.get(), pId, pGroup, pCategory, pIngredient, pResult, pExperience, pCookingTime);
	}

	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(ModBlocks.KILN.get());
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ModRecipes.KILNING_SERIALIZER.get();
	}
}
