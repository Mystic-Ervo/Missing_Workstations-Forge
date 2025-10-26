package net.ervo.missingworkstations.item;

import net.ervo.missingworkstations.MissingWorkstations;
import net.ervo.missingworkstations.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MissingWorkstations.MOD_ID);

	public static final RegistryObject<CreativeModeTab> MISSING_WORKSTATIONS_TAB = CREATIVE_MODE_TABS.register("missing_workstations_tab",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.KILN.get()))
					.title(Component.translatable("creativetab.missing_workstations_tab"))
					.displayItems((itemDisplayParameters, output) -> {
						output.accept(ModBlocks.KILN.get());
					})
					.build());


	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
}
