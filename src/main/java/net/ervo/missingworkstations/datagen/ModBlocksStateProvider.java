package net.ervo.missingworkstations.datagen;

import net.ervo.missingworkstations.MissingWorkstations;
import net.ervo.missingworkstations.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocksStateProvider extends BlockStateProvider {

	public ModBlocksStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, MissingWorkstations.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		blockWithItem(ModBlocks.KILN);
	}

	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}
}
