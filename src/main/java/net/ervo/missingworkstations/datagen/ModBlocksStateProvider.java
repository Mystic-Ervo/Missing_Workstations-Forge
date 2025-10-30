package net.ervo.missingworkstations.datagen;

import net.ervo.missingworkstations.MissingWorkstations;
import net.ervo.missingworkstations.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ModBlocksStateProvider extends BlockStateProvider {

	public ModBlocksStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, MissingWorkstations.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		orientableFurnaceWithItem(ModBlocks.KILN, OrientableType.BOTTOM);

	}

	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}

	private void orientableBlockWithItem(RegistryObject<Block> blockRegistryObject, OrientableType type, String... states) {
		String blockName = name(blockRegistryObject.get());
		for(String state : states) {
			ModelFile orientable = switch (type) {
				case FRONT -> models().orientableVertical(blockName + state, modLoc(blockName + "_side"), modLoc(blockName + "_front" + state));
				case TOP -> models().orientable(blockName + state, modLoc(blockName + "_side"), modLoc(blockName + "_front" + state), modLoc(blockName + "_top"));
				case BOTTOM -> models().orientableWithBottom(blockName + state, modLoc(blockName + "_side"), modLoc(blockName + "_front" + state), modLoc(blockName + "_bottom"), modLoc(blockName + "_top"));
			};
			horizontalBlock(blockRegistryObject.get(), orientable);
			simpleBlockItem(blockRegistryObject.get(), orientable);
		}
	}

	private void orientableFurnaceWithItem(RegistryObject<Block> blockRegistryObject, OrientableType type) {
		String blockName = name(blockRegistryObject.get());
		String[] states = new String[]{"", "_on"};
		ArrayList<ModelFile> orientables = new ArrayList<>();
		for(String state : states) {
			ModelFile orientable = switch (type) {
				case FRONT -> models().orientableVertical(blockName + state, modLoc(blockName + "_side"), modLoc(blockName + "_front" + state));
				case TOP -> models().orientable(blockName + state, modLoc(blockName + "_side"), modLoc(blockName + "_front" + state), modLoc(blockName + "_top"));
				case BOTTOM -> models().orientableWithBottom(blockName + state, modLoc(blockName + "_side"), modLoc(blockName + "_front" + state), modLoc(blockName + "_bottom"), modLoc(blockName + "_top"));
			};
			orientables.add(orientable);
		}
		horizontalBlock(blockRegistryObject.get(), state -> state.getValue(AbstractFurnaceBlock.LIT) ? orientables.get(1): orientables.get(0));
		simpleBlockItem(blockRegistryObject.get(), orientables.get(0));
	}

	private enum OrientableType {
		/**
		 * An orientable block with only sides and front texture.
		 */
		FRONT,
		/**
		 * An orientable block with sides, front and top texture.
		 */
		TOP,
		/**
		 * An orientable block with sides, front, top and bottom texture.
		 */
		BOTTOM
	}

	private ResourceLocation key(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block);
	}

	private String name(Block block) {
		// return key(block).getPath();
		String test = key(block).getPath();
		return ModelProvider.BLOCK_FOLDER + "/" + test;
	}
}
