package net.ervo.missingworkstations.block.entity;

import net.ervo.missingworkstations.recipe.KilningRecipe;
import net.ervo.missingworkstations.recipe.ModRecipes;
import net.ervo.missingworkstations.screen.KilnMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.BlastFurnaceMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class KilnBlockEntity extends AbstractFurnaceBlockEntity {

	public KilnBlockEntity(BlockPos pPos, BlockState pBlockState) {
		super(ModBlockEntities.KILN_BE.get(), pPos, pBlockState, ModRecipes.KILNING.get());
	}

	@Override
	@NotNull
	protected Component getDefaultName() {
		return Component.translatable("container.kiln");
	}

	@Override
	protected int getBurnDuration(@NotNull ItemStack pFuel) {
		return super.getBurnDuration(pFuel) / 2;
	}

	@Override
	@NotNull
	protected AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pInventory) {
		return new KilnMenu(pContainerId, pInventory, this, this.dataAccess);
	}

	@Override
	@NotNull
	public Component getDisplayName() {
		return Component.translatable("block.missingworkstations.kiln");
	}
}
