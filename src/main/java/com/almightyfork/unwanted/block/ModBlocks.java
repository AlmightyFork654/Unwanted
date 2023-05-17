package com.almightyfork.unwanted.block;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.custom.*;
import com.almightyfork.unwanted.item.ModItems;
import com.almightyfork.unwanted.sound.ModSounds;
import com.almightyfork.unwanted.worldgen.tree.EbonyTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Unwanted.MODID);

    //ores

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> TORRID_STEEL_ORE = registerBlock("torrid_steel_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> EMBARIUM_ORE = registerBlock("embarium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_EMBARIUM_ORE = registerBlock("deepslate_embarium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> PROFUNDIUM_ORE = registerBlock("profundium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));

    //block

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5F, 6F).destroyTime(8).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TORRID_STEEL_BLOCK = registerBlock("torrid_steel_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5F, 6F).destroyTime(8).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TORRID_STEEL_BARS = registerBlock("torrid_steel_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5F, 6F).destroyTime(5).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> EMBARIUM_BLOCK = registerBlock("embarium_block",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(ModSounds.EMBARIUM_SOUNDS)
                    .strength(5F, 6F).destroyTime(8).requiresCorrectToolForDrops().lightLevel((blockState) -> 8)));

    public static final RegistryObject<Block> EMBARIUM_LAMP_BLOCK = registerBlock("embarium_lamp_block",
            () -> new EmbariumLampBlock(BlockBehaviour.Properties.of(Material.BUILDABLE_GLASS).sound(SoundType.AMETHYST_CLUSTER)
                    .strength(5F, 6F).destroyTime(8).requiresCorrectToolForDrops().lightLevel((blockState) -> blockState.getValue(EmbariumLampBlock.CLICKED) ? 15 : 0)));


    //crafting

    public static final RegistryObject<Block> GEM_CUTTING_STATION = registerBlock("gem_cutting_station",
            () -> new GemCuttingStationBlock(BlockBehaviour.Properties.copy(Blocks.SMITHING_TABLE).noOcclusion()));

    public static final RegistryObject<Block> GEM_INFUSER = BLOCKS.register("gem_infuser",
            ()-> new GemInfuserBlock(BlockBehaviour.Properties.copy(Blocks.SMITHING_TABLE).noOcclusion()));

    public static final RegistryObject<Block> TORRID_FURNACE = registerBlock("torrid_furnace",
            () -> new TorridFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.SMITHING_TABLE).noOcclusion()));

    //bouncy

    public static final RegistryObject<Block> WHITE_BOUNCER_BLOCK = registerBlock("white_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> BLACK_BOUNCER_BLOCK = registerBlock("black_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> GRAY_BOUNCER_BLOCK = registerBlock("gray_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> LIGHT_GRAY_BOUNCER_BLOCK = registerBlock("light_gray_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> BROWN_BOUNCER_BLOCK = registerBlock("brown_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> BLUE_BOUNCER_BLOCK = registerBlock("blue_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> CYAN_BOUNCER_BLOCK = registerBlock("cyan_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> LIGHT_BLUE_BOUNCER_BLOCK = registerBlock("light_blue_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> GREEN_BOUNCER_BLOCK = registerBlock("green_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> LIME_BOUNCER_BLOCK = registerBlock("lime_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> MAGENTA_BOUNCER_BLOCK = registerBlock("magenta_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> ORANGE_BOUNCER_BLOCK = registerBlock("orange_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> PINK_BOUNCER_BLOCK = registerBlock("pink_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> PURPLE_BOUNCER_BLOCK = registerBlock("purple_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> RED_BOUNCER_BLOCK = registerBlock("red_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final RegistryObject<Block> YELLOW_BOUNCER_BLOCK = registerBlock("yellow_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));

    public static final RegistryObject<Block> SPEEDER_BLOCK = registerBlock("speeder_block",
            () -> new SpeederBlock(BlockBehaviour.Properties.of(Material.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(1.0F).destroyTime(1).instabreak()));

    //marble
    public static final RegistryObject<Block> MARBLE = registerBlock("marble",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SMOOTH_MARBLE = registerBlock("smooth_marble",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DOUBLE_SMOOTH_MARBLE_SLAB = registerBlock("double_smooth_marble_slab",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_MARBLE = registerBlock("polished_marble",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DOUBLE_POLISHED_MARBLE_SLAB = registerBlock("double_polished_marble_slab",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MARBLE_BRICKS = registerBlock("marble_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRACKED_MARBLE_BRICKS = registerBlock("cracked_marble_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOSSY_MARBLE_BRICKS = registerBlock("mossy_marble_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CHISELED_W_MARBLE = registerBlock("chiseled_w_marble",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHISELED_S_MARBLE = registerBlock("chiseled_s_marble",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHISELED_C_MARBLE = registerBlock("chiseled_c_marble",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHISELED_E_MARBLE = registerBlock("chiseled_e_marble",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MARBLE_PILLAR = registerBlock("marble_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));

    //marble stairs
    public static final RegistryObject<Block> MARBLE_STAIRS = registerBlock("marble_stairs",
            () -> new StairBlock(() -> ModBlocks.MARBLE.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_MARBLE_STAIRS = registerBlock("smooth_marble_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_MARBLE.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_MARBLE_STAIRS = registerBlock("polished_marble_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_MARBLE.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MARBLE_BRICKS_STAIRS = registerBlock("marble_bricks_stairs",
            () -> new StairBlock(() -> ModBlocks.MARBLE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRACKED_MARBLE_BRICKS_STAIRS = registerBlock("cracked_marble_bricks_stairs",
            () -> new StairBlock(() -> ModBlocks.CRACKED_MARBLE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(1).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOSSY_MARBLE_BRICKS_STAIRS = registerBlock("mossy_marble_bricks_stairs",
            () -> new StairBlock(() -> ModBlocks.MOSSY_MARBLE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));

    //marble slabs
    public static final RegistryObject<Block> MARBLE_SLAB = registerBlock("marble_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_MARBLE_SLAB = registerBlock("smooth_marble_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_MARBLE_SLAB = registerBlock("polished_marble_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MARBLE_BRICKS_SLAB = registerBlock("marble_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRACKED_MARBLE_BRICKS_SLAB = registerBlock("cracked_marble_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(1).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOSSY_MARBLE_BRICKS_SLAB = registerBlock("mossy_marble_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));

    //marble walls
    public static final RegistryObject<Block> MARBLE_WALL = registerBlock("marble_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_MARBLE_WALL = registerBlock("smooth_marble_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_MARBLE_WALL = registerBlock("polished_marble_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MARBLE_BRICKS_WALL = registerBlock("marble_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRACKED_MARBLE_BRICKS_WALL = registerBlock("cracked_marble_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(1).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOSSY_MARBLE_BRICKS_WALL = registerBlock("mossy_marble_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));

        // non-blocks

    //doors

    public static final RegistryObject<Block> TORRID_STEEL_DOOR = registerBlock("torrid_steel_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.METAL, TORRID_STEEL_BLOCK.get().defaultMaterialColor()).sound(SoundType.METAL)
                    .strength(5F, 6F).destroyTime(32).noOcclusion(), BlockSetType.IRON));

    public static final RegistryObject<Block> TORRID_STEEL_BARS_DOOR = registerBlock("torrid_steel_bars_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, TORRID_STEEL_BARS.get().defaultMaterialColor()).sound(SoundType.METAL)
                    .strength(5F, 6F).destroyTime(16).noOcclusion(), BlockSetType.IRON));

    //trapdoors

    public static final RegistryObject<Block> TORRID_STEEL_TRAPDOOR = registerBlock("torrid_steel_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.METAL, TORRID_STEEL_BLOCK.get().defaultMaterialColor()).sound(SoundType.METAL)
                    .strength(5F, 6F).destroyTime(32).noOcclusion(), BlockSetType.IRON));

    public static final RegistryObject<Block> TORRID_STEEL_BARS_TRAPDOOR = registerBlock("torrid_steel_bars_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, TORRID_STEEL_BARS.get().defaultMaterialColor()).sound(SoundType.METAL)
                    .strength(5F, 6F).destroyTime(16).noOcclusion(), BlockSetType.IRON));

    //buttons

    public static final RegistryObject<Block> TORRID_STEEL_BUTTON = registerBlock("torrid_steel_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.METAL)
                    .strength(5F, 6F).destroyTime(4).noCollission(), BlockSetType.IRON, 40, false));

    public static final RegistryObject<Block> MARBLE_BUTTON = registerBlock("marble_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)
                    .strength(1.5F, 3F).destroyTime(2).noCollission(), BlockSetType.STONE, 30, false));

    //pressure plates

    public static final RegistryObject<Block> TORRID_STEEL_PRESSURE_PLATE = registerBlock("torrid_steel_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.METAL, TORRID_STEEL_BLOCK.get().defaultMaterialColor())
                    .sound(SoundType.METAL).strength(5F, 6F).destroyTime(4), BlockSetType.IRON));

    public static final RegistryObject<Block> MARBLE_PRESSURE_PLATE = registerBlock("marble_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE, MARBLE.get().defaultMaterialColor())
                    .sound(SoundType.STONE).strength(1.5F, 3F).destroyTime(2), BlockSetType.STONE));

    //nature

    public static final RegistryObject<Block> TORRID_BUSH = registerBlock("torrid_bush",
            () -> new NetherFlowerBlock(MobEffects.FIRE_RESISTANCE,15 ,BlockBehaviour.Properties.copy(Blocks.WARPED_FUNGUS).noOcclusion()));

    public static final RegistryObject<Block> POTTED_TORRID_BUSH = registerBlockWithoutBlockItem("potted_torrid_bush",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ModBlocks.TORRID_BUSH, BlockBehaviour.Properties.copy(Blocks.POTTED_WARPED_FUNGUS).noOcclusion()));

    //tree

    public static final RegistryObject<Block> EBONY_LOG = registerBlock("ebony_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> EBONY_WOOD = registerBlock("ebony_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_EBONY_LOG = registerBlock("stripped_ebony_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_EBONY_WOOD = registerBlock("stripped_ebony_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> EBONY_PLANKS = registerBlock("ebony_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }
            });


    public static final RegistryObject<Block> EBONY_LEAVES = registerBlock("ebony_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> EBONY_SAPLING = registerBlock("ebony_sapling",
            () -> new SaplingBlock(new EbonyTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> POTTED_EBONY_SAPLING = registerBlockWithoutBlockItem("potted_ebony_sapling",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ModBlocks.EBONY_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));


//    ebony non-blocks

    public static final RegistryObject<Block> EBONY_STAIRS = registerBlock("ebony_stairs",
            () -> new StairBlock(() -> ModBlocks.EBONY_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD).strength(1F, 2F)));
    public static final RegistryObject<Block> EBONY_SLAB = registerBlock("ebony_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1F, 2F)));

//    FIR_SIGN = registerBlockNoBlockItem(() -> new StandingSignBlockBOP(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), BOPWoodTypes.FIR), "fir_sign");
//    FIR_WALL_SIGN = registerBlockNoBlockItem(() -> new WallSignBlockBOP(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).lootFrom(FIR_SIGN), BOPWoodTypes.FIR), "fir_wall_sign");

    public static final RegistryObject<Block> EBONY_FENCE = registerBlock("ebony_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, EBONY_PLANKS.get().defaultMaterialColor())
                    .strength(1F, 2F)));
    public static final RegistryObject<Block> EBONY_FENCE_GATE = registerBlock("ebony_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, EBONY_PLANKS.get().defaultMaterialColor())
                    .strength(1F, 2F), WoodType.OAK));

    public static final RegistryObject<Block> EBONY_BUTTON = registerBlock("ebony_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1F, 2F).noCollission().destroyTime(2), BlockSetType.OAK, 20, true));
    public static final RegistryObject<Block> EBONY_PRESSURE_PLATE = registerBlock("ebony_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, EBONY_PLANKS.get().defaultMaterialColor())
                    .strength(1F, 2F).destroyTime(2), BlockSetType.OAK));

    public static final RegistryObject<Block> EBONY_DOOR = registerBlock("ebony_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, EBONY_PLANKS.get().defaultMaterialColor())
                    .strength(1F, 2F).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> EBONY_TRAPDOOR = registerBlock("ebony_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, EBONY_PLANKS.get().defaultMaterialColor())
                    .strength(1F, 2F).noOcclusion(), BlockSetType.OAK));


    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties())) ;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
