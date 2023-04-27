package com.almightyfork.unwanted.recipe;

import com.almightyfork.unwanted.Unwanted;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Unwanted.MODID);

    public static final RegistryObject<RecipeSerializer<GemCuttingStationRecipe>> GEM_CUTTING_SERIALIZER =
            SERIALIZERS.register("gem_cutting", () -> GemCuttingStationRecipe.Serializer.INSTANCE);

//    public static final RegistryObject<RecipeSerializer<GemInfuserRecipe>> GEM_INFUSER_SERIALIZER =
//            SERIALIZERS.register("gem_infuser", () -> GemInfuserRecipe.Serializer.INSTANCE);
//
//    public static final RegistryObject<RecipeSerializer<TorridFurnaceRecipe>> TORRID_FURNACE_SERIALIZER =
//            SERIALIZERS.register("torrid_furnace", () -> TorridFurnaceRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
