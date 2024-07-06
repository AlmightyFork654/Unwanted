package com.almightyfork.unwanted.datagen;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.item.ModItems;
import com.almightyfork.unwanted.misc.CustomTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Unwanted.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.TORRID_HELMET.get(),
                        ModItems.TORRID_CHESTPLATE.get(),
                        ModItems.TORRID_LEGGINGS.get(),
                        ModItems.TORRID_BOOTS.get(),
                        ModItems.EMBARIUM_HELMET.get(),
                        ModItems.EMBARIUM_CHESTPLATE.get(),
                        ModItems.EMBARIUM_LEGGINGS.get(),
                        ModItems.EMBARIUM_BOOTS.get(),
                        ModItems.TORRID_EMBARIUM_HELMET.get(),
                        ModItems.TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.PROFUNDIUM_HELMET.get(),
                        ModItems.PROFUNDIUM_CHESTPLATE.get(),
                        ModItems.PROFUNDIUM_LEGGINGS.get(),
                        ModItems.PROFUNDIUM_BOOTS.get());

        this.tag(ItemTags.SWORDS)
                .add(ModItems.EMBARIUM_SWORD.get(),
                        ModItems.TORRID_STEEL_SWORD.get(),
                        ModItems.TORRID_EMBARIUM_SWORD.get(),
                        ModItems.PROFUNDIUM_SWORD.get()
                );

        this.tag(ItemTags.PICKAXES)
                .add(ModItems.EMBARIUM_PICKAXE.get(),
                        ModItems.TORRID_STEEL_PICKAXE.get(),
                        ModItems.TORRID_EMBARIUM_PICKAXE.get(),
                        ModItems.PROFUNDIUM_PICKAXE.get()
                );

        this.tag(ItemTags.AXES)
                .add(ModItems.EMBARIUM_AXE.get(),
                        ModItems.TORRID_STEEL_AXE.get(),
                        ModItems.TORRID_EMBARIUM_AXE.get(),
                        ModItems.PROFUNDIUM_AXE.get()
                );

        this.tag(ItemTags.SHOVELS)
                .add(ModItems.EMBARIUM_SHOVEL.get(),
                        ModItems.TORRID_STEEL_SHOVEL.get(),
                        ModItems.TORRID_EMBARIUM_SHOVEL.get(),
                        ModItems.PROFUNDIUM_SHOVEL.get()
                );

        this.tag(ItemTags.HOES)
                .add(ModItems.EMBARIUM_HOE.get(),
                        ModItems.TORRID_STEEL_HOE.get(),
                        ModItems.TORRID_EMBARIUM_HOE.get(),
                        ModItems.PROFUNDIUM_HOE.get()
                );

        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.DARKNESS_MUSIC_DISK.get(), ModItems.CAVE_WHISPERS_MUSIC_DISK.get());

        this.tag(CustomTags.Items.CHISELS)
                .add(ModItems.CHISEL.get(), ModItems.NETHERITE_CHISEL.get());

        this.tag(CustomTags.Items.FUELS)
                .add(ModItems.PURE_BLAZE_POWDER.get(), Items.BLAZE_POWDER, Items.BLAZE_ROD);

        this.tag(CustomTags.Items.ALL_FUELS)
                .add(Items.LAVA_BUCKET,
                        Items.COAL,
                        Items.COAL_BLOCK,
                        Items.CHARCOAL,
                        Items.DRIED_KELP_BLOCK,
                        Items.SCAFFOLDING,
                        Items.BAMBOO,
                        Items.STICK)
                .addTag(CustomTags.Items.FUELS)
                .addTag(ItemTags.PLANKS)
                .addTag(ItemTags.LOGS);

        this.tag(Tags.Items.ORES)
                .add(ModBlocks.RUBY_ORE.get().asItem(),
                        ModBlocks.EMBARIUM_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_EMBARIUM_ORE.get().asItem(),
                        ModBlocks.TORRID_STEEL_ORE.get().asItem(),
                        ModBlocks.PROFUNDIUM_ORE.get().asItem());

        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.EBONY_PRESSURE_PLATE.get().asItem());
        this.tag(ItemTags.WOODEN_BUTTONS).add(ModBlocks.EBONY_BUTTON.get().asItem());
        this.tag(ItemTags.STONE_BUTTONS).add(ModBlocks.MARBLE_BUTTON.get().asItem(), ModBlocks.TORRID_STEEL_BUTTON.get().asItem());
        this.tag(ItemTags.DOORS).add(ModBlocks.TORRID_STEEL_BARS_DOOR.get().asItem(), ModBlocks.TORRID_STEEL_DOOR.get().asItem());
        this.tag(ItemTags.WOODEN_DOORS).add(ModBlocks.EBONY_DOOR.get().asItem());
        this.tag(ItemTags.TRAPDOORS).add(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get().asItem(), ModBlocks.TORRID_STEEL_TRAPDOOR.get().asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.EBONY_TRAPDOOR.get().asItem());

        this.tag(ItemTags.LOGS).addTag(CustomTags.Items.EBONY_LOGS);
        this.tag(ItemTags.LOGS_THAT_BURN).addTag(CustomTags.Items.EBONY_LOGS);

        this.tag(ItemTags.PLANKS).add(ModBlocks.EBONY_PLANKS.get().asItem());
        this.tag(ItemTags.SAPLINGS).add(ModBlocks.EBONY_SAPLING.get().asItem());
        this.tag(ItemTags.SMALL_FLOWERS).add(ModBlocks.TORRID_BUSH.get().asItem());

        this.tag(ItemTags.SLABS)
                .add(ModBlocks.MARBLE_SLAB.get().asItem(),
                        ModBlocks.POLISHED_MARBLE_SLAB.get().asItem(),
                        ModBlocks.SMOOTH_MARBLE_SLAB.get().asItem(),
                        ModBlocks.MARBLE_BRICKS_SLAB.get().asItem(),
                        ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get().asItem(),
                        ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get().asItem());
        this.tag(ItemTags.STAIRS)
                .add(ModBlocks.MARBLE_STAIRS.get().asItem(),
                        ModBlocks.POLISHED_MARBLE_STAIRS.get().asItem(),
                        ModBlocks.SMOOTH_MARBLE_STAIRS.get().asItem(),
                        ModBlocks.MARBLE_BRICKS_STAIRS.get().asItem(),
                        ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get().asItem(),
                        ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get().asItem());

        this.tag(ItemTags.WOODEN_SLABS).add(ModBlocks.EBONY_SLAB.get().asItem());
        this.tag(ItemTags.WOODEN_STAIRS).add(ModBlocks.EBONY_STAIRS.get().asItem());

        this.tag(ItemTags.WALLS)
                .add(ModBlocks.MARBLE_WALL.get().asItem(),
                        ModBlocks.POLISHED_MARBLE_WALL.get().asItem(),
                        ModBlocks.SMOOTH_MARBLE_WALL.get().asItem(),
                        ModBlocks.MARBLE_BRICKS_WALL.get().asItem(),
                        ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get().asItem(),
                        ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get().asItem());

        this.tag(ItemTags.WOODEN_FENCES).add(ModBlocks.EBONY_FENCE.get().asItem());
        this.tag(ItemTags.FENCE_GATES).add(ModBlocks.EBONY_FENCE_GATE.get().asItem());

        this.tag(ItemTags.STONE_CRAFTING_MATERIALS).add(ModBlocks.MARBLE.get().asItem());
        this.tag(ItemTags.STONE_TOOL_MATERIALS).add(ModBlocks.MARBLE.get().asItem());

        this.tag(CustomTags.Items.EBONY_LOGS)
                .add(ModBlocks.EBONY_LOG.get().asItem(),
                        ModBlocks.EBONY_WOOD.get().asItem(),
                        ModBlocks.STRIPPED_EBONY_WOOD.get().asItem(),
                        ModBlocks.STRIPPED_EBONY_LOG.get().asItem());

        this.tag(CustomTags.Items.NUGGETS).add(Items.IRON_NUGGET, ModItems.TORRID_STEEL_NUGGET.get());
        this.tag(CustomTags.Items.INGOTS).add(Items.IRON_INGOT, ModItems.TORRID_STEEL_INGOT.get());

        this.tag(CustomTags.Items.BASE_TEA).addTags(CustomTags.Items.GRASSY, CustomTags.Items.WARPED, CustomTags.Items.CRIMSON,
                CustomTags.Items.LEAVY, CustomTags.Items.KELPED, CustomTags.Items.VINEY,
                CustomTags.Items.GLOWY, CustomTags.Items.SCULKED, CustomTags.Items.ROOTED);
        this.tag(CustomTags.Items.GRASSY).add(Items.GRASS, Items.TALL_GRASS, Items.SEAGRASS, Items.FERN, Items.LARGE_FERN);
        this.tag(CustomTags.Items.WARPED).add(Items.WARPED_FUNGUS, Items.WARPED_ROOTS, Items.NETHER_SPROUTS, Items.TWISTING_VINES);
        this.tag(CustomTags.Items.CRIMSON).add(Items.CRIMSON_FUNGUS, Items.CRIMSON_ROOTS, Items.WEEPING_VINES);
        this.tag(CustomTags.Items.LEAVY).add(Items.LILY_PAD, Items.BIG_DRIPLEAF, Items.SMALL_DRIPLEAF);
        this.tag(CustomTags.Items.KELPED).add(Items.KELP, Items.DRIED_KELP);
        this.tag(CustomTags.Items.VINEY).add(Items.VINE);
        this.tag(CustomTags.Items.GLOWY).add(Items.GLOW_LICHEN);
        this.tag(CustomTags.Items.SCULKED).add(Items.SCULK_VEIN);
        this.tag(CustomTags.Items.ROOTED).add(Items.MANGROVE_ROOTS, Items.HANGING_ROOTS);

        this.tag(CustomTags.Items.TELEPORTS).addTags(CustomTags.Items.SPAWN, CustomTags.Items.OVERWORLD, CustomTags.Items.NETHER,
                CustomTags.Items.END);
        this.tag(CustomTags.Items.SPAWN).add(Items.CHORUS_FRUIT, Items.POPPED_CHORUS_FRUIT);
        this.tag(CustomTags.Items.OVERWORLD).add(Items.ENDER_PEARL);
        this.tag(CustomTags.Items.NETHER).add(Items.GHAST_TEAR);
        this.tag(CustomTags.Items.END).add(Items.DRAGON_BREATH);

        this.tag(CustomTags.Items.MODS).add(Items.REDSTONE, Items.GLOWSTONE_DUST, Items.GUNPOWDER);

        this.tag(CustomTags.Items.ADDITIVES).addTags(CustomTags.Items.RED_STUFF, CustomTags.Items.GOLDEN_FRUIT, CustomTags.Items. GOD_APPLE,
                CustomTags.Items. SWEET, CustomTags.Items.GLOWING_FRUIT, CustomTags.Items.PINK_FLOWER, CustomTags.Items.YELLOW_FLOWER,
                CustomTags.Items.WHITE_FLOWER, CustomTags.Items.GREY_FLOWER, CustomTags.Items.PURPLE_FLOWER1, CustomTags.Items.PURPLE_FLOWER2, CustomTags.Items.BLUE_FLOWER,
                CustomTags.Items.RED_FLOWER, CustomTags.Items.END_FLOWER, CustomTags.Items.FIRE_FLOWER, CustomTags.Items.POT_FLOWER,
                CustomTags.Items.WING, CustomTags.Items.FIRE, CustomTags.Items.TORRID, CustomTags.Items.WITHER);

        this.tag(CustomTags.Items.RED_STUFF).add(Items.APPLE, Items.MELON_SLICE, Items.POPPY, Items.ROSE_BUSH);
        this.tag(CustomTags.Items.GOLDEN_FRUIT).add(Items.GOLDEN_APPLE, Items.GLISTERING_MELON_SLICE);
        this.tag(CustomTags.Items.GOD_APPLE).add(Items.ENCHANTED_GOLDEN_APPLE);
        this.tag(CustomTags.Items.SWEET).add(Items.SUGAR, Items.HONEY_BOTTLE, Items.SWEET_BERRIES);
        this.tag(CustomTags.Items.GLOWING_FRUIT).add(Items.GLOW_BERRIES);
        this.tag(CustomTags.Items.PINK_FLOWER).add(Items.PINK_PETALS, Items.SPORE_BLOSSOM);
        this.tag(CustomTags.Items.YELLOW_FLOWER).add(Items.DANDELION, Items.SUNFLOWER, Items.ORANGE_TULIP);
        this.tag(CustomTags.Items.WHITE_FLOWER).add(Items.WHITE_TULIP, Items.LILY_OF_THE_VALLEY);
        this.tag(CustomTags.Items.GREY_FLOWER).add(Items.OXEYE_DAISY, Items.AZURE_BLUET);
        this.tag(CustomTags.Items.PURPLE_FLOWER1).add(Items.ALLIUM, Items.PEONY);
        this.tag(CustomTags.Items.PURPLE_FLOWER2).add(Items.PINK_TULIP, Items.LILAC);
        this.tag(CustomTags.Items.BLUE_FLOWER).add(Items.CORNFLOWER, Items.BLUE_ORCHID);
        this.tag(CustomTags.Items.RED_FLOWER).add(Items.RED_TULIP);
        this.tag(CustomTags.Items.END_FLOWER).add(Items.CHORUS_FLOWER);
        this.tag(CustomTags.Items.FIRE_FLOWER).add(Items.TORCHFLOWER);
        this.tag(CustomTags.Items.POT_FLOWER).add(Items.PITCHER_PLANT);
        this.tag(CustomTags.Items.WING).add(Items.PHANTOM_MEMBRANE);
        this.tag(CustomTags.Items.FIRE).add(Items.MAGMA_CREAM, Items.BLAZE_POWDER);
        this.tag(CustomTags.Items.TORRID).add(ModItems.TORRID_STEEL_POWDER.get());
        this.tag(CustomTags.Items.WITHER).add(Items.WITHER_ROSE);




    }
}
