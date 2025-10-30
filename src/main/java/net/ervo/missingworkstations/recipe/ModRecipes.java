package net.ervo.missingworkstations.recipe;

import net.ervo.missingworkstations.MissingWorkstations;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {

	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
			DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MissingWorkstations.MOD_ID);

	public static final RegistryObject<RecipeSerializer<KilningRecipe>> KILNING_SERIALIZER =
			SERIALIZERS.register("kilning", () -> new SimpleCookingSerializer<>(KilningRecipe::new, 100));



	public static final DeferredRegister<RecipeType<?>> RECIPES =
			DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, MissingWorkstations.MOD_ID);

	public static final RegistryObject<RecipeType<KilningRecipe>> KILNING =
			RECIPES.register("kilning", () -> new RecipeType<>() { });

	public static void register(IEventBus eventBus) {
		SERIALIZERS.register(eventBus);
		RECIPES.register(eventBus);
	}
}
