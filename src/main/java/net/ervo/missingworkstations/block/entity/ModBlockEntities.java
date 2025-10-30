package net.ervo.missingworkstations.block.entity;

import net.ervo.missingworkstations.MissingWorkstations;
import net.ervo.missingworkstations.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
			DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MissingWorkstations.MOD_ID);

	public static final RegistryObject<BlockEntityType<KilnBlockEntity>> KILN_BE =
			BLOCK_ENTITIES.register("kiln_be", () ->
					BlockEntityType.Builder.of(KilnBlockEntity::new, ModBlocks.KILN.get()).build(null));

	public static void register(IEventBus eventBus) {
		BLOCK_ENTITIES.register(eventBus);
	}
}
