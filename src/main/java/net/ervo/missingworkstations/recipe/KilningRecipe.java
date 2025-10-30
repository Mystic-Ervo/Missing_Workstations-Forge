package net.ervo.missingworkstations.recipe;

import com.google.gson.JsonObject;
import net.ervo.missingworkstations.MissingWorkstations;
import net.ervo.missingworkstations.block.ModBlocks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KilningRecipe extends AbstractCookingRecipe {

	public KilningRecipe(ResourceLocation pId, String pGroup, CookingBookCategory pCategory, Ingredient pIngredient, ItemStack pResult, float pExperience, int pCookingTime) {
		super(ModRecipes.KILNING.get(), pId, pGroup, pCategory, pIngredient, pResult, pExperience, pCookingTime);
	}

	@Override
	@NotNull
	public ItemStack getToastSymbol() {
		return new ItemStack(ModBlocks.KILN.get());
	}

	@Override
	@NotNull
	public RecipeSerializer<?> getSerializer() {
		return ModRecipes.KILNING_SERIALIZER.get();
	}
}
