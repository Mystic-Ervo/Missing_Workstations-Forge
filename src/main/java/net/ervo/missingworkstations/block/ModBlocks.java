package net.ervo.missingworkstations.block;

import net.ervo.missingworkstations.MissingWorkstations;
import net.ervo.missingworkstations.block.custom.KilnBlock;
import net.ervo.missingworkstations.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, MissingWorkstations.MOD_ID);

	public static final RegistryObject<Block> KILN = registerBlock("kiln",
			() -> new KilnBlock(BlockBehaviour.Properties.copy(Blocks.STONE).lightLevel(litBlockEmission(13))));



	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
		return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}

	private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
		return (blockState) -> blockState.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
	}
}
