package com.almightyfork.unwanted.datagen;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.misc.ModCreativeModeTabs;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Unwanted.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.TORRID_STEEL_ORE);
        blockWithItem(ModBlocks.EMBARIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_EMBARIUM_ORE);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.EMBARIUM_BLOCK);
        blockWithItem(ModBlocks.TORRID_STEEL_BLOCK);
        blockWithItem(ModBlocks.TORRID_STEEL_BARS);

        blockWithItem(ModBlocks.MARBLE);
        blockWithItem(ModBlocks.SMOOTH_MARBLE);
        blockWithItem(ModBlocks.POLISHED_MARBLE);
        blockWithItem(ModBlocks.MARBLE_BRICKS);
        blockWithItem(ModBlocks.CRACKED_MARBLE_BRICKS);
        blockWithItem(ModBlocks.MOSSY_MARBLE_BRICKS);
        blockWithItem(ModBlocks.CHISELED_C_MARBLE);
        blockWithItem(ModBlocks.CHISELED_S_MARBLE);
        blockWithItem(ModBlocks.CHISELED_W_MARBLE);
        blockWithItem(ModBlocks.CHISELED_E_MARBLE);
        blockWithItem(ModBlocks.MARBLE_PILLAR);

//        blockWithItem(ModBlocks.MARBLE_SLAB);
//        blockWithItem(ModBlocks.SMOOTH_MARBLE_SLAB);
//        blockWithItem(ModBlocks.POLISHED_MARBLE_SLAB);
//        blockWithItem(ModBlocks.MARBLE_BRICKS_SLAB);
//        blockWithItem(ModBlocks.CRACKED_MARBLE_BRICKS_SLAB);
//        blockWithItem(ModBlocks.MOSSY_MARBLE_BRICKS_SLAB);
//
//        blockWithItem(ModBlocks.MARBLE_STAIRS);
//        blockWithItem(ModBlocks.SMOOTH_MARBLE_STAIRS);
//        blockWithItem(ModBlocks.POLISHED_MARBLE_STAIRS);
//        blockWithItem(ModBlocks.MARBLE_BRICKS_STAIRS);
//        blockWithItem(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS);
//        blockWithItem(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS);
//
//        blockWithItem(ModBlocks.MARBLE_WALL);
//        blockWithItem(ModBlocks.SMOOTH_MARBLE_WALL);
//        blockWithItem(ModBlocks.POLISHED_MARBLE_WALL);
//        blockWithItem(ModBlocks.MARBLE_BRICKS_WALL);
//        blockWithItem(ModBlocks.CRACKED_MARBLE_BRICKS_WALL);
//        blockWithItem(ModBlocks.MOSSY_MARBLE_BRICKS_WALL);

        blockWithItem(ModBlocks.RED_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.ORANGE_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.YELLOW_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.LIME_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.GREEN_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.LIGHT_BLUE_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.CYAN_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.BLUE_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.PINK_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.MAGENTA_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.PURPLE_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.LIGHT_GRAY_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.GRAY_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.BROWN_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.BLACK_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.WHITE_BOUNCER_BLOCK);
        blockWithItem(ModBlocks.SPEEDER_BLOCK);
        blockWithItem(ModBlocks.EMBARIUM_LAMP_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
