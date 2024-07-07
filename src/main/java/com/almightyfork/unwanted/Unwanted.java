package com.almightyfork.unwanted;

import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.block.entity.ModBlockEntities;
import com.almightyfork.unwanted.block.entity.client.GemInfuserBlockRenderer;
import com.almightyfork.unwanted.entity.ModEntities;
import com.almightyfork.unwanted.entity.client.ModBoatRenderer;
import com.almightyfork.unwanted.entity.client.ModModelLayers;
import com.almightyfork.unwanted.item.ModItems;
import com.almightyfork.unwanted.item.armor.layers.*;
import com.almightyfork.unwanted.item.trident.iron.ThrownIronSpearRenderer;
import com.almightyfork.unwanted.item.trident.wood.ThrownWoodenSpearRenderer;
import com.almightyfork.unwanted.misc.EPBrewingRecipe;
import com.almightyfork.unwanted.misc.KeyBindings;
import com.almightyfork.unwanted.misc.ModCreativeModeTabs;
import com.almightyfork.unwanted.misc.ModWoodTypes;
import com.almightyfork.unwanted.potion.ModPotions;
import com.almightyfork.unwanted.potion.effect.ModEffects;
import com.almightyfork.unwanted.recipe.ModRecipes;
import com.almightyfork.unwanted.screen.ModMenuTypes;
import com.almightyfork.unwanted.sound.ModSounds;
import com.almightyfork.unwanted.villager.ModVillagers;
import com.almightyfork.unwanted.worldgen.tree.custom.ModFoliagePlacers;
import com.almightyfork.unwanted.worldgen.tree.custom.ModTrunkPlacerTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
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

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModTrunkPlacerTypes.register(modEventBus);
        ModFoliagePlacers.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
//        modEventBus.addListener(Layers::registerLayers);
        modEventBus.addListener(this::registerElytraLayer);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.TORRID_BUSH.getId(), ModBlocks.POTTED_TORRID_BUSH);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.EBONY_SAPLING.getId(), ModBlocks.POTTED_EBONY_SAPLING);

            BrewingRecipeRegistry.addRecipe(new EPBrewingRecipe(Potions.AWKWARD,
                    ModItems.TORRID_STEEL_POWDER.get(), ModPotions.FRAGILE_POTION.get()));
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if(event.getTab() == ModCreativeModeTabs.ITEMS_TAB.get()) {
            event.accept(ModItems.ROUGH_RUBY);
            event.accept(ModItems.RUBY);
            event.accept(ModItems.PURE_RUBY);
            event.accept(ModItems.TORRID_STEEL_INGOT);
            event.accept(ModItems.TORRID_STEEL_NUGGET);
            event.accept(ModItems.TORRID_STEEL_POWDER);
            event.accept(ModItems.EMBARIUM);
            event.accept(ModItems.PROFUNDIUM_FLAKE);
            event.accept(ModItems.PROFUNDIUM_SCRAP);
            event.accept(ModItems.PROFUNDIUM_INGOT);
            event.accept(ModItems.MARBLE_SHARD);
            event.accept(ModItems.BLAZING_WATER);
            event.accept(ModItems.PURE_BLAZE_POWDER);
            event.accept(ModItems.WOODEN_SPEAR_HEAD);
            event.accept(ModItems.DARKNESS_MUSIC_DISK);
            event.accept(ModItems.CAVE_WHISPERS_MUSIC_DISK);
            event.accept(ModItems.EBONY_BOAT);
            event.accept(ModItems.EBONY_CHEST_BOAT);

            event.accept(ModItems.TEA_CUP);
            event.accept(ModItems.CUP_OF_WATER);
            event.accept(ModItems.GRASSY_TEA);
            event.accept(ModItems.WARPED_TEA);
            event.accept(ModItems.CRIMSON_TEA);
            event.accept(ModItems.LEAVY_TEA);
            event.accept(ModItems.KELPED_TEA);
            event.accept(ModItems.VINEY_TEA);
            event.accept(ModItems.GLOWY_TEA);
            event.accept(ModItems.SCULKED_TEA);
            event.accept(ModItems.ROOTED_TEA);
        }

        if(event.getTab() == ModCreativeModeTabs.BLOCKS_TAB.get()) {
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.EMBARIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_EMBARIUM_ORE);
            event.accept(ModBlocks.PROFUNDIUM_ORE);
            event.accept(ModBlocks.TORRID_STEEL_ORE);
            event.accept(ModBlocks.RUBY_BLOCK);
            event.accept(ModBlocks.EMBARIUM_BLOCK);
            event.accept(ModBlocks.PROFUNDIUM_BLOCK);
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
            event.accept(ModBlocks.EBONY_FENCE);
            event.accept(ModBlocks.EBONY_FENCE_GATE);
            event.accept(ModBlocks.EBONY_LEAVES);
            event.accept(ModBlocks.EBONY_SAPLING);
            event.accept(ModBlocks.TORRID_BUSH);
            event.accept(ModItems.EBONY_SIGN);
            event.accept(ModItems.EBONY_HANGING_SIGN);

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
            event.accept(ModBlocks.KETTLE);
        }

        if(event.getTab() == ModCreativeModeTabs.SLABS_TAB.get()) {
            event.accept(ModBlocks.MARBLE_SLAB);
            event.accept(ModBlocks.SMOOTH_MARBLE_SLAB);
            event.accept(ModBlocks.POLISHED_MARBLE_SLAB);
            event.accept(ModBlocks.MARBLE_BRICKS_SLAB);
            event.accept(ModBlocks.CRACKED_MARBLE_BRICKS_SLAB);
            event.accept(ModBlocks.MOSSY_MARBLE_BRICKS_SLAB);
            event.accept(ModBlocks.EBONY_SLAB);
        }

        if(event.getTab() == ModCreativeModeTabs.STAIRS_TAB.get()) {
            event.accept(ModBlocks.MARBLE_STAIRS);
            event.accept(ModBlocks.SMOOTH_MARBLE_STAIRS);
            event.accept(ModBlocks.POLISHED_MARBLE_STAIRS);
            event.accept(ModBlocks.MARBLE_BRICKS_STAIRS);
            event.accept(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS);
            event.accept(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS);
            event.accept(ModBlocks.EBONY_STAIRS);
        }

        if(event.getTab() == ModCreativeModeTabs.WALLS_TAB.get()) {
            event.accept(ModBlocks.MARBLE_WALL);
            event.accept(ModBlocks.SMOOTH_MARBLE_WALL);
            event.accept(ModBlocks.POLISHED_MARBLE_WALL);
            event.accept(ModBlocks.MARBLE_BRICKS_WALL);
            event.accept(ModBlocks.CRACKED_MARBLE_BRICKS_WALL);
            event.accept(ModBlocks.MOSSY_MARBLE_BRICKS_WALL);
        }

        if(event.getTab() == ModCreativeModeTabs.TOOLS_TAB.get()) {
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
            event.accept(ModItems.PROFUNDIUM_SWORD);
            event.accept(ModItems.PROFUNDIUM_PICKAXE);
            event.accept(ModItems.PROFUNDIUM_AXE);
            event.accept(ModItems.PROFUNDIUM_SHOVEL);
            event.accept(ModItems.PROFUNDIUM_HOE);
            event.accept(ModItems.WOODEN_SPEAR);
            event.accept(ModItems.IRON_SPEAR);
            event.accept(ModItems.CHISEL);
            event.accept(ModItems.NETHERITE_CHISEL);
            event.accept(ModItems.RUBY_DETECTOR);
        }

        if(event.getTab() == ModCreativeModeTabs.COMBAT_TAB.get()) {
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
            event.accept(ModItems.PROFUNDIUM_HELMET);
            event.accept(ModItems.PROFUNDIUM_CHESTPLATE);
            event.accept(ModItems.PROFUNDIUM_LEGGINGS);
            event.accept(ModItems.PROFUNDIUM_BOOTS);
            event.accept(ModItems.ELYTRA_GLIDER);
            event.accept(ModItems.MECHANICAL_ELYTRA);
        }

        if(event.getTab() == ModCreativeModeTabs.REDSTONE_TAB.get()) {
            event.accept(ModBlocks.TORRID_STEEL_DOOR);
            event.accept(ModBlocks.TORRID_STEEL_TRAPDOOR);
            event.accept(ModBlocks.TORRID_STEEL_BARS_DOOR);
            event.accept(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR);
            event.accept(ModBlocks.TORRID_STEEL_BUTTON);
            event.accept(ModBlocks.TORRID_STEEL_PRESSURE_PLATE);
            event.accept(ModBlocks.MARBLE_BUTTON);
            event.accept(ModBlocks.MARBLE_PRESSURE_PLATE);
            event.accept(ModBlocks.EBONY_DOOR);
            event.accept(ModBlocks.EBONY_TRAPDOOR);
            event.accept(ModBlocks.EBONY_BUTTON);
            event.accept(ModBlocks.EBONY_PRESSURE_PLATE);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.EBONY);

            BlockEntityRenderers.register(ModBlockEntities.GEM_INFUSER_BLOCK_ENTITY.get(), GemInfuserBlockRenderer::new);
            EntityRenderers.register(ModEntities.MOD_BOAT.get(), p_174010_ -> new ModBoatRenderer(p_174010_, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), p_174010_ -> new ModBoatRenderer(p_174010_, true));
            EntityRenderers.register(ModEntities.WOODEN_SPEAR.get(), p_174420_ -> new ThrownWoodenSpearRenderer(p_174420_, ModModelLayers.WOODEN_SPEAR));
            EntityRenderers.register(ModEntities.IRON_SPEAR.get(), ThrownIronSpearRenderer::new);
        }

        @SubscribeEvent
        public static void registerKeys(RegisterKeyMappingsEvent event) {
            event.register(KeyBindings.KEY_BINDINGS.boost);
            event.register(KeyBindings.KEY_BINDINGS.craw);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void registerElytraLayer(EntityRenderersEvent event) {
        if(event instanceof EntityRenderersEvent.AddLayers addLayersEvent){
            EntityModelSet entityModels = addLayersEvent.getEntityModels();
            addLayersEvent.getSkins().forEach(s -> {
                LivingEntityRenderer<? extends Player, ? extends EntityModel<? extends Player>> livingEntityRenderer = addLayersEvent.getSkin(s);
                if(livingEntityRenderer instanceof PlayerRenderer playerRenderer){
                    playerRenderer.addLayer(new ElytraGliderLayer(playerRenderer, entityModels));
                    playerRenderer.addLayer(new MechanicalElytraLayer(playerRenderer, entityModels));
                    playerRenderer.addLayer(new ProfundiumElytraLayer(playerRenderer, entityModels));
                }
            });
            LivingEntityRenderer<ArmorStand, ? extends EntityModel<ArmorStand>> livingEntityRenderer = addLayersEvent.getRenderer(EntityType.ARMOR_STAND);
            if(livingEntityRenderer instanceof ArmorStandRenderer armorStandRenderer){
                armorStandRenderer.addLayer(new ElytraGliderArmorStandLayer(armorStandRenderer, entityModels));
                armorStandRenderer.addLayer(new ProfundiumElytraArmorStandLayer(armorStandRenderer, entityModels));
                armorStandRenderer.addLayer(new MechanicalElytraArmorStandLayer(armorStandRenderer, entityModels));
            }
        }
    }
}
