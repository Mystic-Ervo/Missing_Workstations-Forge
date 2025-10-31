package net.ervo.missingworkstations.screen;

import net.ervo.missingworkstations.MissingWorkstations;
import net.ervo.missingworkstations.recipe.ModRecipes;
import net.ervo.missingworkstations.screen.recipebook.ModRecipeBookTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;

public class KilnMenu extends AbstractFurnaceMenu {

	public KilnMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf extraData) {
		super(ModMenuTypes.KILN_MENU.get(), ModRecipes.KILNING.get(), RecipeBookType.FURNACE, pContainerId, pPlayerInventory); // TODO: MissingWorkstations.KILN
	}

	public KilnMenu(int pContainerId, Inventory pPlayerInventory, Container pKilnContainer, ContainerData pKilnData) {
		super(ModMenuTypes.KILN_MENU.get(), ModRecipes.KILNING.get(), RecipeBookType.FURNACE, pContainerId, pPlayerInventory, pKilnContainer, pKilnData); // TODO: MissingWorkstations.KILN
	}
}
