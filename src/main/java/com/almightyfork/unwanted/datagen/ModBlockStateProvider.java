package com.almightyfork.unwanted.datagen;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.misc.ModCreativeModeTabs;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.shadowed.eliotlash.mclib.math.functions.classic.Mod;

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
        blockWithItem(ModBlocks.PROFUNDIUM_ORE);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        simpleBlockWithItem(ModBlocks.EMBARIUM_BLOCK.get(), models().cubeAll(blockTexture(ModBlocks.EMBARIUM_BLOCK.get()).getPath(),
                blockTexture(ModBlocks.EMBARIUM_BLOCK.get())).renderType("translucent"));
        blockWithItem(ModBlocks.TORRID_STEEL_BLOCK);
        blockWithItem(ModBlocks.PROFUNDIUM_BLOCK);

        blockWithItem(ModBlocks.MARBLE);
        blockWithItem(ModBlocks.SMOOTH_MARBLE);
        blockWithItem(ModBlocks.POLISHED_MARBLE);
        blockWithItem(ModBlocks.MARBLE_BRICKS);
        blockWithItem(ModBlocks.CRACKED_MARBLE_BRICKS);
        blockWithItem(ModBlocks.MOSSY_MARBLE_BRICKS);
        horizontalBlock(ModBlocks.CHISELED_C_MARBLE.get(), modLoc("block/chiseled_c_marble"), modLoc("block/chiseled_c_marble"), modLoc("block/chiseled_c_marble_top"));
        horizontalBlock(ModBlocks.CHISELED_S_MARBLE.get(), modLoc("block/chiseled_s_marble"), modLoc("block/chiseled_s_marble"), modLoc("block/chiseled_s_marble_top"));
        horizontalBlock(ModBlocks.CHISELED_W_MARBLE.get(), modLoc("block/chiseled_w_marble"), modLoc("block/chiseled_w_marble"), modLoc("block/chiseled_w_marble_top"));
        horizontalBlock(ModBlocks.CHISELED_E_MARBLE.get(), modLoc("block/chiseled_e_marble"), modLoc("block/chiseled_e_marble"), modLoc("block/chiseled_e_marble_top"));
//        blockWithItem(ModBlocks.CHISELED_C_MARBLE);
//        blockWithItem(ModBlocks.CHISELED_S_MARBLE);
//        blockWithItem(ModBlocks.CHISELED_W_MARBLE);
//        blockWithItem(ModBlocks.CHISELED_E_MARBLE);
        logBlock(((RotatedPillarBlock) ModBlocks.MARBLE_PILLAR.get()));

        stairsBlock(((StairBlock) ModBlocks.MARBLE_STAIRS.get()), blockTexture(ModBlocks.MARBLE.get()));
        stairsBlock(((StairBlock) ModBlocks.POLISHED_MARBLE_STAIRS.get()), blockTexture(ModBlocks.POLISHED_MARBLE.get()));
        stairsBlock(((StairBlock) ModBlocks.SMOOTH_MARBLE_STAIRS.get()), blockTexture(ModBlocks.SMOOTH_MARBLE.get()));
        stairsBlock(((StairBlock) ModBlocks.MARBLE_BRICKS_STAIRS.get()), blockTexture(ModBlocks.MARBLE_BRICKS.get()));
        stairsBlock(((StairBlock) ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get()), blockTexture(ModBlocks.CRACKED_MARBLE_BRICKS.get()));
        stairsBlock(((StairBlock) ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get()), blockTexture(ModBlocks.MOSSY_MARBLE_BRICKS.get()));

        slabBlock(((SlabBlock) ModBlocks.MARBLE_SLAB.get()), blockTexture(ModBlocks.MARBLE.get()), blockTexture(ModBlocks.MARBLE.get()));
        slabBlock(((SlabBlock) ModBlocks.POLISHED_MARBLE_SLAB.get()), blockTexture(ModBlocks.DOUBLE_POLISHED_MARBLE_SLAB.get()), blockTexture(ModBlocks.POLISHED_MARBLE.get()));
        slabBlock(((SlabBlock) ModBlocks.SMOOTH_MARBLE_SLAB.get()), blockTexture(ModBlocks.DOUBLE_SMOOTH_MARBLE_SLAB.get()), blockTexture(ModBlocks.SMOOTH_MARBLE.get()));
        slabBlock(((SlabBlock) ModBlocks.MARBLE_BRICKS_SLAB.get()), blockTexture(ModBlocks.MARBLE_BRICKS.get()), blockTexture(ModBlocks.MARBLE_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get()), blockTexture(ModBlocks.CRACKED_MARBLE_BRICKS.get()), blockTexture(ModBlocks.CRACKED_MARBLE_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get()), blockTexture(ModBlocks.MOSSY_MARBLE_BRICKS.get()), blockTexture(ModBlocks.MOSSY_MARBLE_BRICKS.get()));

        wallBlock(((WallBlock) ModBlocks.MARBLE_WALL.get()), blockTexture(ModBlocks.MARBLE.get()));
        wallBlock(((WallBlock) ModBlocks.POLISHED_MARBLE_WALL.get()), blockTexture(ModBlocks.POLISHED_MARBLE.get()));
        wallBlock(((WallBlock) ModBlocks.SMOOTH_MARBLE_WALL.get()), blockTexture(ModBlocks.SMOOTH_MARBLE.get()));
        wallBlock(((WallBlock) ModBlocks.MARBLE_BRICKS_WALL.get()), blockTexture(ModBlocks.MARBLE_BRICKS.get()));
        wallBlock(((WallBlock) ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get()), blockTexture(ModBlocks.CRACKED_MARBLE_BRICKS.get()));
        wallBlock(((WallBlock) ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get()), blockTexture(ModBlocks.MOSSY_MARBLE_BRICKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.MARBLE_BUTTON.get()), blockTexture(ModBlocks.MARBLE.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.MARBLE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.MARBLE.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.TORRID_STEEL_DOOR.get()), modLoc("block/torrid_steel_door_bottom"), modLoc("block/torrid_steel_door_top"), "translucent");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.TORRID_STEEL_TRAPDOOR.get()), modLoc("block/torrid_steel_trapdoor"), true , "translucent");
        doorBlockWithRenderType(((DoorBlock) ModBlocks.TORRID_STEEL_BARS_DOOR.get()), modLoc("block/torrid_steel_bars_door_bottom"), modLoc("block/torrid_steel_bars_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get()), modLoc("block/torrid_steel_bars_trapdoor"), true , "cutout");
        buttonBlock(((ButtonBlock) ModBlocks.TORRID_STEEL_BUTTON.get()), blockTexture(ModBlocks.TORRID_STEEL_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.TORRID_STEEL_PRESSURE_PLATE.get()), blockTexture(ModBlocks.TORRID_STEEL_BLOCK.get()));

        blockWithItem(ModBlocks.EBONY_PLANKS);
        stairsBlock(((StairBlock) ModBlocks.EBONY_STAIRS.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.EBONY_SLAB.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.EBONY_FENCE.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.EBONY_FENCE_GATE.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.EBONY_DOOR.get()), modLoc("block/ebony_door_bottom"), modLoc("block/ebony_door_top"), "translucent");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.EBONY_TRAPDOOR.get()), modLoc("block/ebony_trapdoor"), true , "translucent");
        buttonBlock(((ButtonBlock) ModBlocks.EBONY_BUTTON.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.EBONY_PRESSURE_PLATE.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));

        signBlock(((StandingSignBlock) ModBlocks.EBONY_SIGN.get()), ((WallSignBlock) ModBlocks.EBONY_WALL_SIGN.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        hangingSignBlock(ModBlocks.EBONY_HANGING_SIGN.get(), ModBlocks.EBONY_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.EBONY_PLANKS.get()));

        horizontalBlock(ModBlocks.GEM_CUTTING_STATION.get(), new ModelFile.UncheckedModelFile(modLoc("block/gem_cutting_station")));
        horizontalBlock(ModBlocks.GEM_INFUSER.get(), new ModelFile.UncheckedModelFile(modLoc("block/gem_infuser")));
        horizontalBlock(ModBlocks.TORRID_FURNACE.get(), new ModelFile.UncheckedModelFile(modLoc("block/torrid_furnace")));
        horizontalBlock(ModBlocks.KETTLE.get(), new ModelFile.UncheckedModelFile(modLoc("block/kettle")));

        horizontalBlock(ModBlocks.RED_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_bouncer_block")));
        horizontalBlock(ModBlocks.ORANGE_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/orange_bouncer_block")));
        horizontalBlock(ModBlocks.YELLOW_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/yellow_bouncer_block")));
        horizontalBlock(ModBlocks.LIME_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/lime_bouncer_block")));
        horizontalBlock(ModBlocks.GREEN_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/green_bouncer_block")));
        horizontalBlock(ModBlocks.CYAN_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_bouncer_block")));
        horizontalBlock(ModBlocks.LIGHT_BLUE_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/light_blue_bouncer_block")));
        horizontalBlock(ModBlocks.BLUE_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_bouncer_block")));
        horizontalBlock(ModBlocks.PURPLE_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_bouncer_block")));
        horizontalBlock(ModBlocks.MAGENTA_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/magenta_bouncer_block")));
        horizontalBlock(ModBlocks.PINK_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/pink_bouncer_block")));
        horizontalBlock(ModBlocks.BROWN_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/brown_bouncer_block")));
        horizontalBlock(ModBlocks.GRAY_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/gray_bouncer_block")));
        horizontalBlock(ModBlocks.LIGHT_GRAY_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/light_gray_bouncer_block")));
        horizontalBlock(ModBlocks.WHITE_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/white_bouncer_block")));
        horizontalBlock(ModBlocks.BLACK_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_bouncer_block")));
        horizontalBlock(ModBlocks.SPEEDER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/speeder_block")));


        logBlock(((RotatedPillarBlock) ModBlocks.EBONY_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.EBONY_WOOD.get(), blockTexture(ModBlocks.EBONY_LOG.get()), blockTexture(ModBlocks.EBONY_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_LOG.get(), new ResourceLocation(Unwanted.MODID, "block/stripped_ebony_log"),
                new ResourceLocation(Unwanted.MODID, "block/stripped_ebony_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_WOOD.get(), new ResourceLocation(Unwanted.MODID, "block/stripped_ebony_log"),
                new ResourceLocation(Unwanted.MODID, "block/stripped_ebony_log"));
        blockWithItem(ModBlocks.EBONY_LEAVES);

        simpleBlock(ModBlocks.TORRID_BUSH.get(), models().cross(blockTexture(ModBlocks.TORRID_BUSH.get()).getPath(),
                blockTexture(ModBlocks.TORRID_BUSH.get())).renderType("cutout"));
        simpleBlock(ModBlocks.POTTED_TORRID_BUSH.get(), models().singleTexture("potted_torrid_bush", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.TORRID_BUSH.get())).renderType("cutout"));
        simpleBlock(ModBlocks.EBONY_SAPLING.get(), models().cross(blockTexture(ModBlocks.EBONY_SAPLING.get()).getPath(),
                blockTexture(ModBlocks.EBONY_SAPLING.get())).renderType("cutout"));
        simpleBlock(ModBlocks.POTTED_EBONY_SAPLING.get(), models().singleTexture("potted_ebony_sapling", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.EBONY_SAPLING.get())).renderType("cutout"));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
