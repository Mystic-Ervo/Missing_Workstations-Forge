package net.ervo.missingworkstations.datagen;

import net.ervo.missingworkstations.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public ModRecipeProvider(PackOutput pOutput) {
		super(pOutput);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KILN.get())
				.pattern("BBB")
				.pattern("BFB")
				.pattern("B B")
				.define('B', Items.BRICK)
				.define('F', Items.FURNACE)
				.unlockedBy(getHasName(Items.FURNACE), has(Items.FURNACE))
				.save(pWriter);
	}
}
