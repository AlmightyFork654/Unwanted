package com.almightyfork.unwanted.datagen;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.item.ModItems;
import com.almightyfork.unwanted.misc.CustomTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;

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

        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.RUBY.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.EMBARIUM.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMBARIUM_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.TORRID_STEEL_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TORRID_STEEL_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.PROFUNDIUM_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.PROFUNDIUM_BLOCK.get());
        nineBlockStorageRecipesWithCustomPacking(consumer, RecipeCategory.MISC, ModItems.TORRID_STEEL_NUGGET.get(), RecipeCategory.MISC, ModItems.TORRID_STEEL_INGOT.get(), "torrid_steel_ingot_from_nuggets", "torrid_steel_ingot");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TORRID_STEEL_POWDER.get()).requires(ModItems.TORRID_STEEL_NUGGET.get()).unlockedBy(getHasName(ModItems.TORRID_STEEL_NUGGET.get()), has(ModItems.TORRID_STEEL_NUGGET.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PROFUNDIUM_SCRAP.get())
                .requires(Ingredient.of(CustomTags.Items.NUGGETS), 4)
                .requires(ModItems.PROFUNDIUM_FLAKE.get(), 4)
                .unlockedBy(getHasName(ModItems.PROFUNDIUM_FLAKE.get()), has(ModItems.PROFUNDIUM_FLAKE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PROFUNDIUM_INGOT.get())
                .requires(Ingredient.of(CustomTags.Items.INGOTS), 4)
                .requires(ModItems.PROFUNDIUM_SCRAP.get(), 4)
                .unlockedBy(getHasName(ModItems.PROFUNDIUM_SCRAP.get()), has(ModItems.PROFUNDIUM_SCRAP.get()))
                .save(consumer);
        // shaped blocks

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GEM_CUTTING_STATION.get())
                .pattern("cgc")
                .pattern("ddd")
                .pattern("www")
                .define('w', ItemTags.PLANKS)
                .define('d', Items.POLISHED_DEEPSLATE_SLAB)
                .define('c', Items.COPPER_INGOT)
                .define('g', Items.GLASS)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GEM_INFUSER.get())
                .pattern(" i ")
                .pattern("rir")
                .pattern("ppp")
                .define('i', Items.IRON_INGOT)
                .define('r', Items.REDSTONE)
                .define('p', Items.POLISHED_BLACKSTONE_SLAB)
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TORRID_FURNACE.get())
                .pattern("ttt")
                .pattern("tft")
                .pattern("bbb")
                .define('b', Items.BASALT)
                .define('t', ModItems.TORRID_STEEL_INGOT.get())
                .define('f', Items.BLAST_FURNACE)
                .unlockedBy(getHasName(ModItems.TORRID_STEEL_INGOT.get()), has(ModItems.TORRID_STEEL_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.RED_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.RED_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.ORANGE_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.ORANGE_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.YELLOW_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.YELLOW_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.LIME_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.LIME_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.GREEN_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.GREEN_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.CYAN_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.CYAN_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.LIGHT_BLUE_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.LIGHT_BLUE_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.BLUE_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.BLUE_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.PURPLE_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.PURPLE_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.MAGENTA_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.MAGENTA_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.PINK_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.PINK_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.LIGHT_GRAY_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.LIGHT_GRAY_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.GRAY_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.GRAY_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.BROWN_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.BROWN_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.BLACK_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.BLACK_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.WHITE_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.WHITE_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPEEDER_BLOCK.get(), 3)
                .pattern("sss")
                .pattern("mem")
                .pattern("mmm")
                .define('e', ModItems.EMBARIUM.get())
                .define('s', Items.SLIME_BLOCK)
                .define('m', ModBlocks.MARBLE.get())
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMBARIUM_LAMP_BLOCK.get())
                .pattern("pgp")
                .pattern("geg")
                .pattern("pgp")
                .define('e', ModItems.EMBARIUM.get())
                .define('g', Items.GLOWSTONE_DUST)
                .define('p', ItemTags.PLANKS)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);

        //marble

        //crafting table

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE.get())
                .pattern("mm")
                .pattern("mm")
                .define('m', ModItems.MARBLE_SHARD.get())
                .unlockedBy(getHasName(ModItems.MARBLE_SHARD.get()), has(ModItems.MARBLE_SHARD.get()))
                .save(consumer);
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_SLAB.get(), ModBlocks.MARBLE.get());
        stairBuilder(ModBlocks.MARBLE_STAIRS.get(), Ingredient.of(ModBlocks.MARBLE.get())).unlockedBy(getHasName(ModBlocks.MARBLE.get()), has(ModBlocks.MARBLE.get())).save(consumer);
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_WALL.get(), ModBlocks.MARBLE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS.get(), 4)
                .pattern("mm")
                .pattern("mm")
                .define('m', ModBlocks.MARBLE.get())
                .unlockedBy(getHasName(ModBlocks.MARBLE.get()), has(ModBlocks.MARBLE.get()))
                .save(consumer);
        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS_SLAB.get(), ModBlocks.MARBLE_BRICKS.get());
        stairBuilder(ModBlocks.MARBLE_BRICKS_STAIRS.get(), Ingredient.of(ModBlocks.MARBLE_BRICKS.get())).unlockedBy(getHasName(ModBlocks.MARBLE_BRICKS.get()), has(ModBlocks.MARBLE_BRICKS.get())).save(consumer);
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS_WALL.get(), ModBlocks.MARBLE_BRICKS.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PILLAR.get(), 2)
                .pattern("m")
                .pattern("m")
                .define('m', ModBlocks.MARBLE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.MARBLE_BRICKS.get()), has(ModBlocks.MARBLE_BRICKS.get()))
                .save(consumer);

        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get(), ModBlocks.CRACKED_MARBLE_BRICKS.get());
        stairBuilder(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get(), Ingredient.of(ModBlocks.CRACKED_MARBLE_BRICKS.get())).unlockedBy(getHasName(ModBlocks.CRACKED_MARBLE_BRICKS.get()), has(ModBlocks.MARBLE_BRICKS.get())).save(consumer);
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get(), ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get());

        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get(), ModBlocks.MOSSY_MARBLE_BRICKS.get());
        stairBuilder(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get(), Ingredient.of(ModBlocks.MOSSY_MARBLE_BRICKS.get())).unlockedBy(getHasName(ModBlocks.MOSSY_MARBLE_BRICKS.get()), has(ModBlocks.MOSSY_MARBLE_BRICKS.get())).save(consumer);
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get(), ModBlocks.MOSSY_MARBLE_BRICKS.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MARBLE_BRICKS.get())
                .pattern("v")
                .pattern("m")
                .define('m', ModBlocks.MARBLE_BRICKS.get())
                .define('v', Blocks.VINE)
                .unlockedBy(getHasName(ModBlocks.MARBLE_BRICKS.get()), has(ModBlocks.MARBLE_BRICKS.get()))
                .save(consumer);

        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_MARBLE_SLAB.get(), ModBlocks.SMOOTH_MARBLE.get());
        stairBuilder(ModBlocks.SMOOTH_MARBLE_STAIRS.get(), Ingredient.of(ModBlocks.SMOOTH_MARBLE.get())).unlockedBy(getHasName(ModBlocks.SMOOTH_MARBLE.get()), has(ModBlocks.SMOOTH_MARBLE.get())).save(consumer);
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_MARBLE_WALL.get(), ModBlocks.SMOOTH_MARBLE.get());

        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB.get(), ModBlocks.POLISHED_MARBLE.get());
        stairBuilder(ModBlocks.POLISHED_MARBLE_STAIRS.get(), Ingredient.of(ModBlocks.POLISHED_MARBLE.get())).unlockedBy(getHasName(ModBlocks.POLISHED_MARBLE.get()), has(ModBlocks.POLISHED_MARBLE.get())).save(consumer);
        wall(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_WALL.get(), ModBlocks.POLISHED_MARBLE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE.get(), 9)
                .pattern("mmm")
                .pattern("mmm")
                .pattern("mmm")
                .define('m', ModBlocks.MARBLE.get())
                .unlockedBy(getHasName(ModBlocks.MARBLE.get()), has(ModBlocks.MARBLE.get()))
                .save(consumer);

        pressurePlate(consumer, ModBlocks.MARBLE_PRESSURE_PLATE.get(), ModBlocks.POLISHED_MARBLE.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.MARBLE_BUTTON.get()).requires(ModBlocks.POLISHED_MARBLE.get()).unlockedBy(getHasName(ModBlocks.POLISHED_MARBLE.get()), has(ModBlocks.POLISHED_MARBLE.get()))
                .save(consumer);

        //stone cutting

        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_SLAB.get(), ModBlocks.MARBLE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_STAIRS.get(), ModBlocks.MARBLE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_WALL.get(), ModBlocks.MARBLE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS.get(), ModBlocks.MARBLE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS_SLAB.get(), ModBlocks.MARBLE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS_STAIRS.get(), ModBlocks.MARBLE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS_WALL.get(), ModBlocks.MARBLE_BRICKS.get());

        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get(), ModBlocks.MOSSY_MARBLE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get(), ModBlocks.MOSSY_MARBLE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get(), ModBlocks.MOSSY_MARBLE_BRICKS.get());

        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get(), ModBlocks.CRACKED_MARBLE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get(), ModBlocks.CRACKED_MARBLE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get(), ModBlocks.CRACKED_MARBLE_BRICKS.get());

        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_MARBLE_SLAB.get(), ModBlocks.SMOOTH_MARBLE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_MARBLE_STAIRS.get(), ModBlocks.SMOOTH_MARBLE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_MARBLE_WALL.get(), ModBlocks.SMOOTH_MARBLE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB.get(), ModBlocks.POLISHED_MARBLE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_STAIRS.get(), ModBlocks.POLISHED_MARBLE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_WALL.get(), ModBlocks.POLISHED_MARBLE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_W_MARBLE.get(), ModBlocks.MARBLE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_S_MARBLE.get(), ModBlocks.MARBLE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_E_MARBLE.get(), ModBlocks.MARBLE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_C_MARBLE.get(), ModBlocks.MARBLE_BRICKS.get());

        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PILLAR.get(), ModBlocks.MARBLE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PILLAR.get(), ModBlocks.MARBLE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PRESSURE_PLATE.get(), ModBlocks.POLISHED_MARBLE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BUTTON.get(), ModBlocks.POLISHED_MARBLE.get(), 4);

        // smelting

        oreSmelting(consumer, List.of(ModBlocks.MARBLE.get()), RecipeCategory.MISC, ModBlocks.SMOOTH_MARBLE.get().asItem(),
                0.1f, 200, "smooth_marble");

        oreSmelting(consumer, List.of(ModBlocks.MARBLE_BRICKS.get()), RecipeCategory.MISC, ModBlocks.CRACKED_MARBLE_BRICKS.get().asItem(),
                0.1f, 200, "cracked_marble_bricks");
        oreSmelting(consumer, List.of(ModBlocks.MARBLE_BRICKS_SLAB.get()), RecipeCategory.MISC, ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get().asItem(),
                0.1f, 200, "cracked_marble_bricks_slab");
        oreSmelting(consumer, List.of(ModBlocks.MARBLE_BRICKS_STAIRS.get()), RecipeCategory.MISC, ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get().asItem(),
                0.1f, 200, "cracked_marble_bricks_stairs");
        oreSmelting(consumer, List.of(ModBlocks.MARBLE_BRICKS_WALL.get()), RecipeCategory.MISC, ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get().asItem(),
                0.1f, 200, "cracked_marble_bricks_wall");

        //ebony

        planksFromLog(consumer, ModBlocks.EBONY_PLANKS.get(), CustomTags.Items.EBONY_LOGS, 4);
        woodFromLogs(consumer, ModBlocks.EBONY_WOOD.get(), ModBlocks.EBONY_LOG.get());
        woodFromLogs(consumer, ModBlocks.STRIPPED_EBONY_WOOD.get(), ModBlocks.STRIPPED_EBONY_LOG.get());

        slab(consumer, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EBONY_SLAB.get(), ModBlocks.EBONY_PLANKS.get());
        stairBuilder(ModBlocks.EBONY_STAIRS.get(), Ingredient.of(ModBlocks.EBONY_PLANKS.get())).unlockedBy(getHasName(ModBlocks.EBONY_PLANKS.get()), has(ModBlocks.EBONY_PLANKS.get())).save(consumer);

        wall(consumer, RecipeCategory.REDSTONE, ModBlocks.EBONY_TRAPDOOR.get(), ModBlocks.EBONY_PLANKS.get());
        doorBuilder(ModBlocks.EBONY_DOOR.get(), Ingredient.of(ModBlocks.EBONY_PLANKS.get())).unlockedBy(getHasName(ModBlocks.EBONY_PLANKS.get()), has(ModBlocks.EBONY_PLANKS.get())).save(consumer);
        pressurePlate(consumer, ModBlocks.EBONY_PRESSURE_PLATE.get(), ModBlocks.EBONY_PLANKS.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.EBONY_BUTTON.get()).requires(ModBlocks.EBONY_PLANKS.get()).unlockedBy(getHasName(ModBlocks.EBONY_PLANKS.get()), has(ModBlocks.EBONY_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EBONY_FENCE.get())
                .pattern("ese")
                .pattern("ese")
                .define('e', ModBlocks.EBONY_PLANKS.get())
                .define('s', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.EBONY_PLANKS.get()), has(ModBlocks.EBONY_PLANKS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EBONY_FENCE_GATE.get())
                .pattern("ses")
                .pattern("ses")
                .define('e', ModBlocks.EBONY_PLANKS.get())
                .define('s', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.EBONY_PLANKS.get()), has(ModBlocks.EBONY_PLANKS.get()))
                .save(consumer);

        woodenBoat(consumer, ModItems.EBONY_BOAT.get(), ModBlocks.EBONY_PLANKS.get());
        chestBoat(consumer, ModItems.EBONY_CHEST_BOAT.get(), ModBlocks.EBONY_PLANKS.get());

        ModsignBuilder(ModItems.EBONY_SIGN.get(), ModBlocks.EBONY_PLANKS.get());
        hangingSign(consumer, ModItems.EBONY_HANGING_SIGN.get(), ModBlocks.STRIPPED_EBONY_LOG.get());

        //items

            //other

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLAZING_WATER.get(), 4)
                .pattern("pwp")
                .pattern("wpw")
                .pattern("pwp")
                .define('p', ModItems.PURE_BLAZE_POWDER.get())
                .define('w', Items.POTION)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PURE_BLAZE_POWDER.get(), 2)
                .requires(Items.BLAZE_POWDER, 4)
                .requires(ModItems.TORRID_STEEL_POWDER.get(), 4)
                .unlockedBy(getHasName(Items.BLAZE_POWDER), has(Items.BLAZE_POWDER))
                .save(consumer);

        twoByTwoPacker(consumer, RecipeCategory.REDSTONE, ModBlocks.TORRID_STEEL_TRAPDOOR.get(), ModItems.TORRID_STEEL_INGOT.get());
        doorBuilder(ModBlocks.TORRID_STEEL_DOOR.get(), Ingredient.of(ModItems.TORRID_STEEL_INGOT.get())).unlockedBy(getHasName(ModItems.TORRID_STEEL_INGOT.get()), has(ModItems.TORRID_STEEL_INGOT.get())).save(consumer);
        twoByTwoPacker(consumer, RecipeCategory.REDSTONE, ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get(), ModBlocks.TORRID_STEEL_BARS.get());
        doorBuilder(ModBlocks.TORRID_STEEL_BARS_DOOR.get(), Ingredient.of(ModBlocks.TORRID_STEEL_BARS.get())).unlockedBy(getHasName(ModBlocks.TORRID_STEEL_BARS.get()), has(ModBlocks.TORRID_STEEL_BARS.get())).save(consumer);
        pressurePlate(consumer, ModBlocks.TORRID_STEEL_PRESSURE_PLATE.get(), ModItems.TORRID_STEEL_INGOT.get());
        twoByTwoPacker(consumer, RecipeCategory.REDSTONE, ModBlocks.TORRID_STEEL_BUTTON.get(), ModItems.TORRID_STEEL_INGOT.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TORRID_STEEL_BARS.get(), 16).define('#', ModItems.TORRID_STEEL_INGOT.get()).pattern("###").pattern("###").unlockedBy(getHasName(ModItems.TORRID_STEEL_INGOT.get()), has(ModItems.TORRID_STEEL_INGOT.get())).save(consumer);

        //tool and armor

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHISEL.get())
                .pattern("d")
                .pattern("s")
                .define('d', Items.DIAMOND)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(consumer);

        upgradeSmithing(consumer, ModItems.CHISEL.get(), Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, RecipeCategory.TOOLS, ModItems.NETHERITE_CHISEL.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_DETECTOR.get())
                .pattern("#r#")
                .pattern("#r#")
                .pattern("#t#")
                .define('#', Items.REDSTONE)
                .define('r', ModItems.PURE_RUBY.get())
                .define('t', ModItems.TORRID_STEEL_INGOT.get())
                .unlockedBy(getHasName(ModItems.PURE_RUBY.get()), has(ModItems.PURE_RUBY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.ELYTRA_GLIDER.get())
                .pattern("sss")
                .pattern("f f")
                .pattern("f f")
                .define('s', Items.STICK)
                .define('f', Items.PHANTOM_MEMBRANE)
                .unlockedBy(getHasName(Items.PHANTOM_MEMBRANE), has(Items.PHANTOM_MEMBRANE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOODEN_SPEAR.get())
                .pattern("  k")
                .pattern(" s ")
                .pattern("s  ")
                .define('k', ModItems.WOODEN_SPEAR_HEAD.get()).define('s', Items.STICK)
                .unlockedBy(getHasName(ModItems.WOODEN_SPEAR_HEAD.get()), has(ModItems.WOODEN_SPEAR_HEAD.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.IRON_SPEAR.get())
                .pattern("  k")
                .pattern(" s ")
                .pattern("s  ")
                .define('k', Items.IRON_INGOT).define('s', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOODEN_SPEAR_HEAD.get(), 2)
                .pattern("  w")
                .pattern("ww ")
                .pattern("ww ")
                .define('w', ItemTags.PLANKS)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer);

        //tea

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TEA_CUP.get(), 4)
                .pattern("m m")
                .pattern(" m ")
                .define('m', ModItems.MARBLE_SHARD.get())
                .unlockedBy(getHasName(ModItems.MARBLE_SHARD.get()), has(ModItems.MARBLE_SHARD.get()))
                .save(consumer);
    }

    protected static RecipeBuilder ModsignBuilder(ItemLike p_176727_, ItemLike p_176728_) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, p_176727_, 3).group("sign").define('#', p_176728_).define('X', Items.STICK).pattern("###").pattern("###").pattern(" X ");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_) {
        oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        for(ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_)
                    .group(p_251450_).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(p_250791_, Unwanted.MODID + ":" + (p_250066_) + p_249236_ + "_" + getItemName(itemlike));
        }

    }

    protected static void upgradeSmithing(Consumer<FinishedRecipe> p_251614_, Item p_250046_,Item upgrader, RecipeCategory p_248986_, Item p_250389_) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(upgrader),
                Ingredient.of(p_250046_), Ingredient.of(Items.NETHERITE_INGOT), p_248986_, p_250389_)
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(p_251614_, getItemName(p_250389_) + "_smithing");
    }
}
