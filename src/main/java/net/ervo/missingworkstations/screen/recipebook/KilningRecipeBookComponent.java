package net.ervo.missingworkstations.screen.recipebook;

import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import java.util.Set;

public class KilningRecipeBookComponent extends AbstractFurnaceRecipeBookComponent {

	private static final Component FILTER_NAME = Component.translatable("gui.recipebook.toggleRecipes.kilnable");

	protected Component getRecipeFilterName() {
		return FILTER_NAME;
	}

	@Override
	protected Set<Item> getFuelItems() {
		return Set.of();
	}
}
