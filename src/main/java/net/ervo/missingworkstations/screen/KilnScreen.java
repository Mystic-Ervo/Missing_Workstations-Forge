package net.ervo.missingworkstations.screen;

import net.ervo.missingworkstations.MissingWorkstations;
import net.ervo.missingworkstations.screen.recipebook.KilningRecipeBookComponent;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KilnScreen extends AbstractFurnaceScreen<KilnMenu> {

	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MissingWorkstations.MOD_ID, "textures/gui/container/kiln.png");

	public KilnScreen(KilnMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, new KilningRecipeBookComponent(), pPlayerInventory, pTitle, TEXTURE);
	}
}
