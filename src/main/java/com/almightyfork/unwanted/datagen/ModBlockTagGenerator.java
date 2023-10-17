package com.almightyfork.unwanted.datagen;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.misc.CustomTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Unwanted.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(CustomTags.Blocks.RUBY_DETECTOR_VALUABLES)
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.EMBARIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_EMBARIUM_ORE.get())
                .add(ModBlocks.TORRID_STEEL_ORE.get())
                .add(ModBlocks.PROFUNDIUM_ORE.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(CustomTags.Blocks.EBONY_LOGS)
                .add(ModBlocks.EBONY_LOG.get())
                .add(ModBlocks.EBONY_WOOD.get())
                .add(ModBlocks.STRIPPED_EBONY_WOOD.get())
                .add(ModBlocks.STRIPPED_EBONY_LOG.get());

//        this.tag(BlockTags.MINEABLE_WITH_AXE)
//                .add(ModBlocks.EBONY_PLANKS.get())
//                .addTag(CustomTags.Blocks.EBONY_LOGS)
//                .add(ModBlocks.EBONY_SLAB.get())
//                .add(ModBlocks.EBONY_STAIRS.get())
//                .add(ModBlocks.EBONY_FENCE.get())
//                .add(ModBlocks.EBONY_FENCE_GATE.get())
//                .add(ModBlocks.EBONY_DOOR.get())
//                .add(ModBlocks.EBONY_TRAPDOOR.get())
//                .add(ModBlocks.EBONY_PRESSURE_PLATE.get())
//                .add(ModBlocks.EBONY_BUTTON.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.EMBARIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_EMBARIUM_ORE.get())
                .add(ModBlocks.TORRID_STEEL_ORE.get())
                .add(ModBlocks.PROFUNDIUM_ORE.get())
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.EMBARIUM_BLOCK.get())
                .add(ModBlocks.PROFUNDIUM_BLOCK.get())
                .add(ModBlocks.TORRID_STEEL_BLOCK.get())
                .add(ModBlocks.TORRID_STEEL_BARS.get())
                .add(ModBlocks.MARBLE.get())
//                .add(ModBlocks.MARBLE_WALL.get())
                .add(ModBlocks.MARBLE_STAIRS.get())
                .add(ModBlocks.MARBLE_SLAB.get())
                .add(ModBlocks.MARBLE_PILLAR.get())
                .add(ModBlocks.POLISHED_MARBLE.get())
//                .add(ModBlocks.POLISHED_MARBLE_WALL.get())
                .add(ModBlocks.POLISHED_MARBLE_STAIRS.get())
                .add(ModBlocks.POLISHED_MARBLE_SLAB.get())
                .add(ModBlocks.SMOOTH_MARBLE.get())
//                .add(ModBlocks.SMOOTH_MARBLE_WALL.get())
                .add(ModBlocks.SMOOTH_MARBLE_SLAB.get())
                .add(ModBlocks.SMOOTH_MARBLE_STAIRS.get())
                .add(ModBlocks.MARBLE_BRICKS.get())
//                .add(ModBlocks.MARBLE_BRICKS_WALL.get())
                .add(ModBlocks.MARBLE_BRICKS_SLAB.get())
                .add(ModBlocks.MARBLE_BRICKS_STAIRS.get())
                .add(ModBlocks.CRACKED_MARBLE_BRICKS.get())
//                .add(ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get())
                .add(ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get())
                .add(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get())
                .add(ModBlocks.MOSSY_MARBLE_BRICKS.get())
//                .add(ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get())
                .add(ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get())
                .add(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get())
                .add(ModBlocks.CHISELED_C_MARBLE.get())
                .add(ModBlocks.CHISELED_E_MARBLE.get())
                .add(ModBlocks.CHISELED_S_MARBLE.get())
                .add(ModBlocks.CHISELED_W_MARBLE.get())
                .add(ModBlocks.SPEEDER_BLOCK.get())
                .add(ModBlocks.TORRID_FURNACE.get())
                .add(ModBlocks.GEM_INFUSER.get())
                .add(ModBlocks.GEM_CUTTING_STATION.get())
//                .add(ModBlocks.MARBLE_BUTTON.get())
                .add(ModBlocks.MARBLE_PRESSURE_PLATE.get())
                .add(ModBlocks.TORRID_STEEL_DOOR.get())
                .add(ModBlocks.TORRID_STEEL_BARS_DOOR.get())
                .add(ModBlocks.TORRID_STEEL_TRAPDOOR.get())
                .add(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get())
//                .add(ModBlocks.TORRID_STEEL_BUTTON.get())
                .add(ModBlocks.TORRID_STEEL_PRESSURE_PLATE.get());

                this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                        .add(ModBlocks.EBONY_PRESSURE_PLATE.get());
                this.tag(BlockTags.STONE_PRESSURE_PLATES)
                        .add(ModBlocks.MARBLE_PRESSURE_PLATE.get())
                        .add(ModBlocks.TORRID_STEEL_PRESSURE_PLATE.get());
                this.tag(BlockTags.WOODEN_BUTTONS)
                        .add(ModBlocks.EBONY_BUTTON.get());
                this.tag(BlockTags.STONE_BUTTONS)
                        .add(ModBlocks.MARBLE_BUTTON.get())
                        .add(ModBlocks.TORRID_STEEL_BUTTON.get());
                this.tag(BlockTags.DOORS)
                        .add(ModBlocks.TORRID_STEEL_BARS_DOOR.get())
                        .add(ModBlocks.TORRID_STEEL_DOOR.get());
                this.tag(BlockTags.WOODEN_DOORS)
                        .add(ModBlocks.EBONY_DOOR.get());
                this.tag(BlockTags.TRAPDOORS)
                        .add(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get())
                        .add(ModBlocks.TORRID_STEEL_TRAPDOOR.get());
                this.tag(BlockTags.WOODEN_TRAPDOORS)
                        .add(ModBlocks.EBONY_TRAPDOOR.get());

                this.tag(BlockTags.LOGS).addTag(CustomTags.Blocks.EBONY_LOGS);
                this.tag(BlockTags.LOGS_THAT_BURN).addTag(CustomTags.Blocks.EBONY_LOGS);

                this.tag(BlockTags.PLANKS).add(ModBlocks.EBONY_PLANKS.get());
                this.tag(BlockTags.SAPLINGS).add(ModBlocks.EBONY_SAPLING.get());
                this.tag(BlockTags.SMALL_FLOWERS).add(ModBlocks.TORRID_BUSH.get());

                this.tag(BlockTags.SLABS)
                        .add(ModBlocks.MARBLE_SLAB.get())
                        .add(ModBlocks.POLISHED_MARBLE_SLAB.get())
                        .add(ModBlocks.SMOOTH_MARBLE_SLAB.get())
                        .add(ModBlocks.MARBLE_BRICKS_SLAB.get())
                        .add(ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get())
                        .add(ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get());
                this.tag(BlockTags.STAIRS)
                        .add(ModBlocks.MARBLE_STAIRS.get())
                        .add(ModBlocks.POLISHED_MARBLE_STAIRS.get())
                        .add(ModBlocks.SMOOTH_MARBLE_STAIRS.get())
                        .add(ModBlocks.MARBLE_BRICKS_STAIRS.get())
                        .add(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get())
                        .add(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get());

                this.tag(BlockTags.WOODEN_SLABS).add(ModBlocks.EBONY_SLAB.get());
                this.tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.EBONY_STAIRS.get());

                this.tag(BlockTags.WALLS)
                        .add(ModBlocks.MARBLE_WALL.get())
                        .add(ModBlocks.POLISHED_MARBLE_WALL.get())
                        .add(ModBlocks.SMOOTH_MARBLE_WALL.get())
                        .add(ModBlocks.MARBLE_BRICKS_WALL.get())
                        .add(ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get())
                        .add(ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get());

                this.tag(BlockTags.WOODEN_FENCES).add(ModBlocks.EBONY_FENCE.get());
                this.tag(BlockTags.FENCE_GATES).add(ModBlocks.EBONY_FENCE_GATE.get());

                this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.RUBY_ORE.get()).add(ModBlocks.PROFUNDIUM_ORE.get());
                this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.EMBARIUM_ORE.get()).add(ModBlocks.DEEPSLATE_EMBARIUM_ORE.get());
                this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.TORRID_STEEL_ORE.get());

    }
}
