package com.almightyfork.unwanted;

import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.block.entity.ModBlockEntities;
import com.almightyfork.unwanted.block.entity.client.GemInfuserBlockRenderer;
import com.almightyfork.unwanted.item.ModItems;
import com.almightyfork.unwanted.misc.EPBrewingRecipe;
import com.almightyfork.unwanted.misc.ModCreativeModeTabs;
import com.almightyfork.unwanted.potion.ModPotions;
import com.almightyfork.unwanted.potion.effect.ModEffects;
import com.almightyfork.unwanted.recipe.ModRecipes;
import com.almightyfork.unwanted.screen.GemCuttingStationScreen;
import com.almightyfork.unwanted.screen.GemInfuserScreen;
import com.almightyfork.unwanted.screen.ModMenuTypes;
import com.almightyfork.unwanted.screen.TorridFurnaceScreen;
import com.almightyfork.unwanted.sound.ModSounds;
import com.almightyfork.unwanted.villager.ModVillagers;
import com.almightyfork.unwanted.worldgen.ModConfiguredFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

@Mod(Unwanted.MODID)
public class Unwanted
{
    public static final String MODID = "unwanted";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Unwanted()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::clientSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.TORRID_BUSH.getId(), ModBlocks.POTTED_TORRID_BUSH);

            BrewingRecipeRegistry.addRecipe(new EPBrewingRecipe(Potions.AWKWARD,
                    ModItems.TORRID_STEEL_POWDER.get(), ModPotions.ENERGY_POTION.get()));

            ModVillagers.registerPOI();

//            SpawnPlacements.register(ModEntityTypes.GOBLIN_WARRIOR.get(),
//                    SpawnPlacements.Type.ON_GROUND,
//                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
//                    Mob::checkMobSpawnRules);
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {

        if(event.getTab() == ModCreativeModeTabs.ITEMS_TAB) {
            event.accept(ModItems.ROUGH_RUBY);
            event.accept(ModItems.RUBY);
            event.accept(ModItems.PURE_RUBY);
            event.accept(ModItems.TORRID_STEEL_INGOT);
            event.accept(ModItems.TORRID_STEEL_NUGGET);
            event.accept(ModItems.TORRID_STEEL_POWDER);
            event.accept(ModItems.EMBARIUM);
            event.accept(ModItems.CHISEL);
            event.accept(ModItems.NETHERITE_CHISEL);
            event.accept(ModItems.MARBLE_SHARD);
            event.accept(ModItems.BLAZING_WATER);
            event.accept(ModItems.PURE_BLAZE_POWDER);
            event.accept(ModItems.DARKNESS_MUSIC_DISK);
            event.accept(ModItems.CAVE_WHISPERS_MUSIC_DISK);
        }

        if(event.getTab() == ModCreativeModeTabs.BLOCKS_TAB) {
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.TORRID_STEEL_ORE);
            event.accept(ModBlocks.EMBARIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_EMBARIUM_ORE);
            event.accept(ModBlocks.RUBY_BLOCK);
            event.accept(ModBlocks.EMBARIUM_BLOCK);
            event.accept(ModBlocks.TORRID_STEEL_BLOCK);
            event.accept(ModBlocks.TORRID_STEEL_BARS);

            event.accept(ModBlocks.MARBLE);
            event.accept(ModBlocks.SMOOTH_MARBLE);
            event.accept(ModBlocks.POLISHED_MARBLE);
            event.accept(ModBlocks.MARBLE_BRICKS);
            event.accept(ModBlocks.CRACKED_MARBLE_BRICKS);
            event.accept(ModBlocks.MOSSY_MARBLE_BRICKS);
            event.accept(ModBlocks.CHISELED_C_MARBLE);
            event.accept(ModBlocks.CHISELED_S_MARBLE);
            event.accept(ModBlocks.CHISELED_W_MARBLE);
            event.accept(ModBlocks.CHISELED_E_MARBLE);
            event.accept(ModBlocks.MARBLE_PILLAR);

            event.accept(ModBlocks.EBONY_LOG);
            event.accept(ModBlocks.EBONY_WOOD);
            event.accept(ModBlocks.STRIPPED_EBONY_LOG);
            event.accept(ModBlocks.STRIPPED_EBONY_WOOD);
            event.accept(ModBlocks.EBONY_PLANKS);
            event.accept(ModBlocks.EBONY_LEAVES);
            event.accept(ModBlocks.EBONY_SAPLING);
            event.accept(ModBlocks.TORRID_BUSH);

            event.accept(ModBlocks.RED_BOUNCER_BLOCK);
            event.accept(ModBlocks.ORANGE_BOUNCER_BLOCK);
            event.accept(ModBlocks.YELLOW_BOUNCER_BLOCK);
            event.accept(ModBlocks.LIME_BOUNCER_BLOCK);
            event.accept(ModBlocks.GREEN_BOUNCER_BLOCK);
            event.accept(ModBlocks.LIGHT_BLUE_BOUNCER_BLOCK);
            event.accept(ModBlocks.CYAN_BOUNCER_BLOCK);
            event.accept(ModBlocks.BLUE_BOUNCER_BLOCK);
            event.accept(ModBlocks.PINK_BOUNCER_BLOCK);
            event.accept(ModBlocks.MAGENTA_BOUNCER_BLOCK);
            event.accept(ModBlocks.PURPLE_BOUNCER_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_BOUNCER_BLOCK);
            event.accept(ModBlocks.GRAY_BOUNCER_BLOCK);
            event.accept(ModBlocks.BROWN_BOUNCER_BLOCK);
            event.accept(ModBlocks.BLACK_BOUNCER_BLOCK);
            event.accept(ModBlocks.WHITE_BOUNCER_BLOCK);
            event.accept(ModBlocks.SPEEDER_BLOCK);
            event.accept(ModBlocks.EMBARIUM_LAMP_BLOCK);
            event.accept(ModBlocks.GEM_CUTTING_STATION);
            event.accept(ModBlocks.GEM_INFUSER);
            event.accept(ModBlocks.TORRID_FURNACE);
        }

        if(event.getTab() == ModCreativeModeTabs.SLABS_TAB) {
            event.accept(ModBlocks.MARBLE_SLAB);
            event.accept(ModBlocks.SMOOTH_MARBLE_SLAB);
            event.accept(ModBlocks.POLISHED_MARBLE_SLAB);
            event.accept(ModBlocks.MARBLE_BRICKS_SLAB);
            event.accept(ModBlocks.CRACKED_MARBLE_BRICKS_SLAB);
            event.accept(ModBlocks.MOSSY_MARBLE_BRICKS_SLAB);
            event.accept(ModBlocks.EBONY_SLAB);
        }

        if(event.getTab() == ModCreativeModeTabs.STAIRS_TAB) {
            event.accept(ModBlocks.MARBLE_STAIRS);
            event.accept(ModBlocks.SMOOTH_MARBLE_STAIRS);
            event.accept(ModBlocks.POLISHED_MARBLE_STAIRS);
            event.accept(ModBlocks.MARBLE_BRICKS_STAIRS);
            event.accept(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS);
            event.accept(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS);
            event.accept(ModBlocks.EBONY_STAIRS);
        }

        if(event.getTab() == ModCreativeModeTabs.WALLS_TAB) {
            event.accept(ModBlocks.MARBLE_WALL);
            event.accept(ModBlocks.SMOOTH_MARBLE_WALL);
            event.accept(ModBlocks.POLISHED_MARBLE_WALL);
            event.accept(ModBlocks.MARBLE_BRICKS_WALL);
            event.accept(ModBlocks.CRACKED_MARBLE_BRICKS_WALL);
            event.accept(ModBlocks.MOSSY_MARBLE_BRICKS_WALL);
        }

        if(event.getTab() == ModCreativeModeTabs.TOOLS_TAB) {
            event.accept(ModItems.TORRID_STEEL_SWORD);
            event.accept(ModItems.TORRID_STEEL_PICKAXE);
            event.accept(ModItems.TORRID_STEEL_AXE);
            event.accept(ModItems.TORRID_STEEL_SHOVEL);
            event.accept(ModItems.TORRID_STEEL_HOE);
            event.accept(ModItems.EMBARIUM_SWORD);
            event.accept(ModItems.EMBARIUM_PICKAXE);
            event.accept(ModItems.EMBARIUM_AXE);
            event.accept(ModItems.EMBARIUM_SHOVEL);
            event.accept(ModItems.EMBARIUM_HOE);
            event.accept(ModItems.TORRID_EMBARIUM_SWORD);
            event.accept(ModItems.TORRID_EMBARIUM_PICKAXE);
            event.accept(ModItems.TORRID_EMBARIUM_AXE);
            event.accept(ModItems.TORRID_EMBARIUM_SHOVEL);
            event.accept(ModItems.TORRID_EMBARIUM_HOE);
            event.accept(ModItems.RUBY_DETECTOR);
        }

        if(event.getTab() == ModCreativeModeTabs.COMBAT_TAB) {
            event.accept(ModItems.TORRID_HELMET);
            event.accept(ModItems.TORRID_CHESTPLATE);
            event.accept(ModItems.TORRID_LEGGINGS);
            event.accept(ModItems.TORRID_BOOTS);
            event.accept(ModItems.EMBARIUM_HELMET);
            event.accept(ModItems.EMBARIUM_CHESTPLATE);
            event.accept(ModItems.EMBARIUM_LEGGINGS);
            event.accept(ModItems.EMBARIUM_BOOTS);
            event.accept(ModItems.TORRID_EMBARIUM_HELMET);
            event.accept(ModItems.TORRID_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.TORRID_EMBARIUM_LEGGINGS);
            event.accept(ModItems.TORRID_EMBARIUM_BOOTS);
        }
    }

    @Deprecated
    private void clientSetup(final FMLClientSetupEvent event) {

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORRID_STEEL_BARS.get(), RenderType.cutout());
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORRID_STEEL_BARS_DOOR.get(), RenderType.cutout());
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get(), RenderType.cutout());
//
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_DOOR.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_TRAPDOOR.get(), RenderType.translucent());
//
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORRID_STEEL_DOOR.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORRID_STEEL_TRAPDOOR.get(), RenderType.translucent());
//
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EMBARIUM_BLOCK.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORRID_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_TORRID_BUSH.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GEM_CUTTING_STATION.get(), RenderType.translucent());

        MenuScreens.register(ModMenuTypes.GEM_CUTTING_STATION_MENU.get(), GemCuttingStationScreen::new);
        MenuScreens.register(ModMenuTypes.GEM_INFUSER_MENU.get(), GemInfuserScreen::new);
        MenuScreens.register(ModMenuTypes.TORRID_FURNACE_MENU.get(), TorridFurnaceScreen::new);

//        EntityRenderers.register(ModEntityTypes.GOBLIN_WARRIOR.get(), GoblinWarriorRenderer::new);
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            BlockEntityRenderers.register(ModBlockEntities.GEM_INFUSER_BLOCK_ENTITY.get(), GemInfuserBlockRenderer::new);
        }
    }
}
