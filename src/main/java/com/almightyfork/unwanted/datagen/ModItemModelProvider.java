package com.almightyfork.unwanted.datagen;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.shadowed.eliotlash.mclib.math.functions.classic.Mod;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Unwanted.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //items
        simpleItem(ModItems.ROUGH_RUBY);
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.PURE_RUBY);
        simpleItem(ModItems.TORRID_STEEL_INGOT);
        simpleItem(ModItems.TORRID_STEEL_NUGGET);
        simpleItem(ModItems.TORRID_STEEL_POWDER);
        simpleItem(ModItems.EMBARIUM);
        simpleItem(ModItems.MARBLE_SHARD);
        simpleItem(ModItems.BLAZING_WATER);
        simpleItem(ModItems.PURE_BLAZE_POWDER);
        simpleItem(ModItems.PROFUNDIUM_INGOT);
        simpleItem(ModItems.PROFUNDIUM_SCRAP);
        simpleItem(ModItems.PROFUNDIUM_FLAKE);

        simpleItem(ModItems.TEA_CUP);
        simpleItem(ModItems.CUP_OF_WATER);
        simpleItem(ModItems.GRASSY_TEA);
        simpleItem(ModItems.WARPED_TEA);
        simpleItem(ModItems.CRIMSON_TEA);
        simpleItem(ModItems.LEAVY_TEA);
        simpleItem(ModItems.KELPED_TEA);
        simpleItem(ModItems.VINEY_TEA);
        simpleItem(ModItems.GLOWY_TEA);
        simpleItem(ModItems.SCULKED_TEA);
        simpleItem(ModItems.ROOTED_TEA);

        simpleItem(ModItems.DARKNESS_MUSIC_DISK);
        simpleItem(ModItems.CAVE_WHISPERS_MUSIC_DISK);

        handheldItem(ModItems.CHISEL);
        handheldItem(ModItems.NETHERITE_CHISEL);
        handheldItem(ModItems.RUBY_DETECTOR);
        handheldItem(ModItems.TORRID_STEEL_SWORD);
        handheldItem(ModItems.TORRID_STEEL_PICKAXE);
        handheldItem(ModItems.TORRID_STEEL_AXE);
        handheldItem(ModItems.TORRID_STEEL_SHOVEL);
        handheldItem(ModItems.TORRID_STEEL_HOE);
        handheldItem(ModItems.EMBARIUM_SWORD);
        handheldItem(ModItems.EMBARIUM_PICKAXE);
        handheldItem(ModItems.EMBARIUM_AXE);
        handheldItem(ModItems.EMBARIUM_SHOVEL);
        handheldItem(ModItems.EMBARIUM_HOE);
        handheldItem(ModItems.TORRID_EMBARIUM_SWORD);
        handheldItem(ModItems.TORRID_EMBARIUM_PICKAXE);
        handheldItem(ModItems.TORRID_EMBARIUM_AXE);
        handheldItem(ModItems.TORRID_EMBARIUM_SHOVEL);
        handheldItem(ModItems.TORRID_EMBARIUM_HOE);
        handheldItem(ModItems.PROFUNDIUM_SWORD);
        handheldItem(ModItems.PROFUNDIUM_PICKAXE);
        handheldItem(ModItems.PROFUNDIUM_AXE);
        handheldItem(ModItems.PROFUNDIUM_SHOVEL);
        handheldItem(ModItems.PROFUNDIUM_HOE);

        simpleItem(ModItems.WOODEN_SPEAR_HEAD);

        trimmedArmorItem(ModItems.TORRID_HELMET);
        trimmedArmorItem(ModItems.TORRID_CHESTPLATE);
        trimmedArmorItem(ModItems.TORRID_LEGGINGS);
        trimmedArmorItem(ModItems.TORRID_BOOTS);
        trimmedArmorItem(ModItems.EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.TORRID_EMBARIUM_HELMET);
        trimmedArmorItem(ModItems.TORRID_EMBARIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.TORRID_EMBARIUM_LEGGINGS);
        trimmedArmorItem(ModItems.TORRID_EMBARIUM_BOOTS);
        trimmedArmorItem(ModItems.PROFUNDIUM_HELMET);
        trimmedArmorItem(ModItems.PROFUNDIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.PROFUNDIUM_LEGGINGS);
        trimmedArmorItem(ModItems.PROFUNDIUM_BOOTS);

        simpleItem(ModItems.ELYTRA_GLIDER);
        simpleItem(ModItems.MECHANICAL_ELYTRA);

//        //block-items

        evenSimplerBlockItem(ModBlocks.MARBLE_PILLAR);

        evenSimplerBlockItem(ModBlocks.MARBLE_STAIRS);
        evenSimplerBlockItem(ModBlocks.POLISHED_MARBLE_STAIRS);
        evenSimplerBlockItem(ModBlocks.SMOOTH_MARBLE_STAIRS);
        evenSimplerBlockItem(ModBlocks.MARBLE_BRICKS_STAIRS);
        evenSimplerBlockItem(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS);
        evenSimplerBlockItem(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS);

        evenSimplerBlockItem(ModBlocks.MARBLE_SLAB);
        evenSimplerBlockItem(ModBlocks.POLISHED_MARBLE_SLAB);
        evenSimplerBlockItem(ModBlocks.SMOOTH_MARBLE_SLAB);
        evenSimplerBlockItem(ModBlocks.MARBLE_BRICKS_SLAB);
        evenSimplerBlockItem(ModBlocks.CRACKED_MARBLE_BRICKS_SLAB);
        evenSimplerBlockItem(ModBlocks.MOSSY_MARBLE_BRICKS_SLAB);

        wallItem(ModBlocks.MARBLE_WALL, ModBlocks.MARBLE);
        wallItem(ModBlocks.POLISHED_MARBLE_WALL, ModBlocks.POLISHED_MARBLE);
        wallItem(ModBlocks.SMOOTH_MARBLE_WALL, ModBlocks.SMOOTH_MARBLE);
        wallItem(ModBlocks.MARBLE_BRICKS_WALL, ModBlocks.MARBLE_BRICKS);
        wallItem(ModBlocks.CRACKED_MARBLE_BRICKS_WALL, ModBlocks.CRACKED_MARBLE_BRICKS);
        wallItem(ModBlocks.MOSSY_MARBLE_BRICKS_WALL, ModBlocks.MOSSY_MARBLE_BRICKS);

        simpleBlockItemBlockTexture(ModBlocks.TORRID_STEEL_BARS);
        simpleBlockItem(ModBlocks.TORRID_STEEL_DOOR);
        trapdoorItem(ModBlocks.TORRID_STEEL_TRAPDOOR);
        simpleBlockItem(ModBlocks.TORRID_STEEL_BARS_DOOR);
        trapdoorItem(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR);
        buttonItem(ModBlocks.TORRID_STEEL_BUTTON, ModBlocks.TORRID_STEEL_BLOCK);
        evenSimplerBlockItem(ModBlocks.TORRID_STEEL_PRESSURE_PLATE);

        buttonItem(ModBlocks.MARBLE_BUTTON, ModBlocks.MARBLE);
        evenSimplerBlockItem(ModBlocks.MARBLE_PRESSURE_PLATE);

        evenSimplerBlockItem(ModBlocks.DOUBLE_POLISHED_MARBLE_SLAB);
        evenSimplerBlockItem(ModBlocks.DOUBLE_SMOOTH_MARBLE_SLAB);

        evenSimplerBlockItem(ModBlocks.EBONY_STAIRS);
        evenSimplerBlockItem(ModBlocks.EBONY_SLAB);
        fenceItem(ModBlocks.EBONY_FENCE, ModBlocks.EBONY_PLANKS);
        evenSimplerBlockItem(ModBlocks.EBONY_FENCE_GATE);
        simpleBlockItem(ModBlocks.EBONY_DOOR);
        trapdoorItem(ModBlocks.EBONY_TRAPDOOR);
        buttonItem(ModBlocks.EBONY_BUTTON, ModBlocks.EBONY_PLANKS);
        evenSimplerBlockItem(ModBlocks.EBONY_PRESSURE_PLATE);

        evenSimplerBlockItem(ModBlocks.EBONY_LOG);
        evenSimplerBlockItem(ModBlocks.STRIPPED_EBONY_LOG);
        evenSimplerBlockItem(ModBlocks.EBONY_WOOD);
        evenSimplerBlockItem(ModBlocks.STRIPPED_EBONY_WOOD);

        simpleBlockItemBlockTexture(ModBlocks.TORRID_BUSH);
        simpleBlockItemBlockTexture(ModBlocks.EBONY_SAPLING);

        simpleItem(ModItems.EBONY_SIGN);
        simpleItem(ModItems.EBONY_HANGING_SIGN);

        simpleItem(ModItems.EBONY_BOAT);
        simpleItem(ModItems.EBONY_CHEST_BOAT);

        evenSimplerBlockItem(ModBlocks.GEM_CUTTING_STATION);
        evenSimplerBlockItem(ModBlocks.GEM_INFUSER);
        evenSimplerBlockItem(ModBlocks.TORRID_FURNACE);
        evenSimplerBlockItem(ModBlocks.KETTLE);

        evenSimplerBlockItem(ModBlocks.SPEEDER_BLOCK);
        evenSimplerBlockItem(ModBlocks.RED_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.ORANGE_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.YELLOW_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.LIME_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.GREEN_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.CYAN_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.LIGHT_BLUE_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.BLUE_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.PURPLE_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.MAGENTA_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.PINK_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.LIGHT_GRAY_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.GRAY_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.BROWN_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.WHITE_BOUNCER_BLOCK);
        evenSimplerBlockItem(ModBlocks.BLACK_BOUNCER_BLOCK);

        evenSimplerBlockItem(ModBlocks.EMBARIUM_LAMP_BLOCK);

        evenSimplerBlockItem(ModBlocks.CHISELED_C_MARBLE);
        evenSimplerBlockItem(ModBlocks.CHISELED_S_MARBLE);
        evenSimplerBlockItem(ModBlocks.CHISELED_W_MARBLE);
        evenSimplerBlockItem(ModBlocks.CHISELED_E_MARBLE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Unwanted.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Unwanted.MODID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Unwanted.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Unwanted.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Unwanted.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Unwanted.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Unwanted.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Unwanted.MODID,"block/" + item.getId().getPath()));
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = Unwanted.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                        mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

}
