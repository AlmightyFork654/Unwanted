package com.almightyfork.unwanted.misc;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.recipe.GemCuttingStationRecipe;
import com.almightyfork.unwanted.recipe.GemInfuserRecipe;
import com.almightyfork.unwanted.recipe.KettleRecipe;
import com.almightyfork.unwanted.recipe.TorridFurnaceRecipe;
import com.almightyfork.unwanted.recipe.category.GemCuttingStationRecipeCategory;
import com.almightyfork.unwanted.recipe.category.GemInfuserRecipeCategory;
import com.almightyfork.unwanted.recipe.category.KettleRecipeCategory;
import com.almightyfork.unwanted.recipe.category.TorridFurnaceRecipeCategory;
import com.almightyfork.unwanted.screen.GemCuttingStationScreen;
import com.almightyfork.unwanted.screen.GemInfuserScreen;
import com.almightyfork.unwanted.screen.KettleScreen;
import com.almightyfork.unwanted.screen.TorridFurnaceScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    public static RecipeType<GemCuttingStationRecipe> CUTTING_TYPE =
            new RecipeType<>(GemCuttingStationRecipeCategory.UID, GemCuttingStationRecipe.class);
    public static RecipeType<GemInfuserRecipe> INFUSION_TYPE =
            new RecipeType<>(GemInfuserRecipeCategory.UID, GemInfuserRecipe.class);
    public static RecipeType<TorridFurnaceRecipe> MELTING_TYPE =
            new RecipeType<>(TorridFurnaceRecipeCategory.UID, TorridFurnaceRecipe.class);
    public static RecipeType<KettleRecipe> KETTLE_TYPE =
            new RecipeType<>(KettleRecipeCategory.UID, KettleRecipe.class);
    @Override

    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Unwanted.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                GemCuttingStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                GemInfuserRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                TorridFurnaceRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                KettleRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

//        List<GemCuttingStationRecipe> recipes = rm.getAllRecipesFor(GemCuttingStationRecipe.Type.INSTANCE);
//        registration.addRecipes(new RecipeType<>(GemCuttingStationRecipeCategory.UID, GemCuttingStationRecipe.class), recipes);

        List<GemCuttingStationRecipe> recipes = rm.getAllRecipesFor(GemCuttingStationRecipe.Type.INSTANCE);
        registration.addRecipes(CUTTING_TYPE, recipes);

        List<GemInfuserRecipe> recipes1 = rm.getAllRecipesFor(GemInfuserRecipe.Type.INSTANCE);
        registration.addRecipes(INFUSION_TYPE, recipes1);

        List<TorridFurnaceRecipe> recipes2 = rm.getAllRecipesFor(TorridFurnaceRecipe.Type.INSTANCE);
        registration.addRecipes(MELTING_TYPE, recipes2);

        List<KettleRecipe> recipes3 = rm.getAllRecipesFor(KettleRecipe.Type.INSTANCE);
        registration.addRecipes(KETTLE_TYPE, recipes3);

//        List<GemInfuserRecipe> recipes1 = rm.getAllRecipesFor(GemInfuserRecipe.Type.INSTANCE);
//        registration.addRecipes(new RecipeType<>(GemInfuserRecipeCategory.UID, GemInfuserRecipe.class), recipes1);
//
//        List<TorridFurnaceRecipe> recipes2 = rm.getAllRecipesFor(TorridFurnaceRecipe.Type.INSTANCE);
//        registration.addRecipes(new RecipeType<>(TorridFurnaceRecipeCategory.UID, TorridFurnaceRecipe.class), recipes2);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(GemCuttingStationScreen.class, 60, 30, 20 ,30, CUTTING_TYPE);
        registration.addRecipeClickArea(GemInfuserScreen.class, 60, 30, 20 ,30, INFUSION_TYPE);
        registration.addRecipeClickArea(TorridFurnaceScreen.class, 60, 30, 20 ,30, MELTING_TYPE);
        registration.addRecipeClickArea(KettleScreen.class, 60, 30, 20 ,30, KETTLE_TYPE);
    }
}
