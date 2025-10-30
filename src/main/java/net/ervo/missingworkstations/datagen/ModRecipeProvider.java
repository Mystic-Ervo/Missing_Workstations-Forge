package net.ervo.missingworkstations.datagen;

import net.ervo.missingworkstations.block.ModBlocks;
import net.ervo.missingworkstations.recipe.ModRecipes;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public ModRecipeProvider(PackOutput pOutput) {
		super(pOutput);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
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

		SimpleCookingRecipeBuilder.generic(Ingredient.of(Blocks.COBBLESTONE), RecipeCategory.BUILDING_BLOCKS, Blocks.STONE.asItem(), 0.1F, 100, ModRecipes.KILNING_SERIALIZER.get())
				.unlockedBy("has_cobblestone", has(Blocks.COBBLESTONE))
				.save(pWriter);
	}
}
