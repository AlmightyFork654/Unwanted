package com.almightyfork.unwanted.datagen;

import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // ores vanilla smelting

        oreSmelting(consumer, List.of(ModBlocks.RUBY_ORE.get()), RecipeCategory.MISC, ModItems.ROUGH_RUBY.get(),
                0.2f, 200, "rough_ruby");
        oreBlasting(consumer, List.of(ModBlocks.RUBY_ORE.get()), RecipeCategory.MISC, ModItems.ROUGH_RUBY.get(),
                0.3f, 160, "rough_ruby");
        oreSmelting(consumer, List.of(ModBlocks.EMBARIUM_ORE.get()), RecipeCategory.MISC, ModItems.EMBARIUM.get(),
                0.2f, 200, "embarium");
        oreBlasting(consumer, List.of(ModBlocks.EMBARIUM_ORE.get()), RecipeCategory.MISC, ModItems.EMBARIUM.get(),
                0.3f, 160, "embarium");
        oreSmelting(consumer, List.of(ModBlocks.DEEPSLATE_EMBARIUM_ORE.get()), RecipeCategory.MISC, ModItems.EMBARIUM.get(),
                0.2f, 200, "embarium");
        oreBlasting(consumer, List.of(ModBlocks.DEEPSLATE_EMBARIUM_ORE.get()), RecipeCategory.MISC, ModItems.EMBARIUM.get(),
                0.3f, 160, "embarium");
        oreSmelting(consumer, List.of(ModBlocks.TORRID_STEEL_ORE.get()), RecipeCategory.MISC, ModItems.TORRID_STEEL_INGOT.get(),
                0.2f, 200, "torrid_steel_ingot");
        oreBlasting(consumer, List.of(ModBlocks.TORRID_STEEL_ORE.get()), RecipeCategory.MISC, ModItems.TORRID_STEEL_INGOT.get(),
                0.3f, 160, "torrid_steel_ingot");


        //ore blocks

        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY.get(),RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.EMBARIUM.get(),RecipeCategory.MISC, ModBlocks.EMBARIUM_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.TORRID_STEEL_INGOT.get(),RecipeCategory.MISC, ModBlocks.TORRID_STEEL_BLOCK.get());



    }
}
