package net.ervo.missingworkstations.datagen;

import net.ervo.missingworkstations.MissingWorkstations;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, MissingWorkstations.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {

	}

	private ItemModelBuilder simpleItem(RegistryObject<Item> itemRegistryObject) {
		assert itemRegistryObject.getId() != null;
		return withExistingParent(itemRegistryObject.getId().getPath(), ResourceLocation.tryParse("item/generated")).
				texture("layer0", ResourceLocation.tryBuild(MissingWorkstations.MOD_ID, "item/" + itemRegistryObject.getId().getPath()));
	}
}
