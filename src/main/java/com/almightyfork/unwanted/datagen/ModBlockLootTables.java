package com.almightyfork.unwanted.datagen;

import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.RUBY_BLOCK.get());
        dropSelf(ModBlocks.EMBARIUM_BLOCK.get());
        dropSelf(ModBlocks.TORRID_STEEL_BLOCK.get());
        dropSelf(ModBlocks.TORRID_STEEL_BARS.get());

        dropSelf(ModBlocks.SMOOTH_MARBLE.get());
        dropSelf(ModBlocks.POLISHED_MARBLE.get());
        dropSelf(ModBlocks.MARBLE_BRICKS.get());
        dropSelf(ModBlocks.CRACKED_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.MOSSY_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.CHISELED_C_MARBLE.get());
        dropSelf(ModBlocks.CHISELED_S_MARBLE.get());
        dropSelf(ModBlocks.CHISELED_W_MARBLE.get());
        dropSelf(ModBlocks.CHISELED_E_MARBLE.get());
        dropSelf(ModBlocks.MARBLE_PILLAR.get());

        dropSelf(ModBlocks.MARBLE_SLAB.get());
        dropSelf(ModBlocks.SMOOTH_MARBLE_SLAB.get());
        dropSelf(ModBlocks.POLISHED_MARBLE_SLAB.get());
        dropSelf(ModBlocks.MARBLE_BRICKS_SLAB.get());
        dropSelf(ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get());
        dropSelf(ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get());

        dropSelf(ModBlocks.DOUBLE_POLISHED_MARBLE_SLAB.get());
        dropSelf(ModBlocks.DOUBLE_SMOOTH_MARBLE_SLAB.get());

        dropSelf(ModBlocks.MARBLE_STAIRS.get());
        dropSelf(ModBlocks.SMOOTH_MARBLE_STAIRS.get());
        dropSelf(ModBlocks.POLISHED_MARBLE_STAIRS.get());
        dropSelf(ModBlocks.MARBLE_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get());

        dropSelf(ModBlocks.MARBLE_WALL.get());
        dropSelf(ModBlocks.SMOOTH_MARBLE_WALL.get());
        dropSelf(ModBlocks.POLISHED_MARBLE_WALL.get());
        dropSelf(ModBlocks.MARBLE_BRICKS_WALL.get());
        dropSelf(ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get());
        dropSelf(ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get());

        dropSelf(ModBlocks.RED_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.ORANGE_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.YELLOW_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.LIME_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.GREEN_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.LIGHT_BLUE_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.CYAN_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.BLUE_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.PINK_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.MAGENTA_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.PURPLE_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.LIGHT_GRAY_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.GRAY_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.BROWN_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.BLACK_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.WHITE_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.SPEEDER_BLOCK.get());

        add(ModBlocks.RUBY_ORE.get(),
                (block -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.ROUGH_RUBY.get())));
        add(ModBlocks.TORRID_STEEL_ORE.get(),
                (block -> createOreDrop(ModBlocks.TORRID_STEEL_ORE.get(), ModItems.TORRID_STEEL_NUGGET.get())));
        add(ModBlocks.EMBARIUM_ORE.get(),
                (block -> createOreDrop(ModBlocks.EMBARIUM_ORE.get(), ModItems.EMBARIUM.get())));
        add(ModBlocks.DEEPSLATE_EMBARIUM_ORE.get(),
                (block -> createOreDrop(ModBlocks.DEEPSLATE_EMBARIUM_ORE.get(), ModItems.EMBARIUM.get())));

        add(ModBlocks.MARBLE.get(),
                (block -> createSingleItemTableWithSilkTouch(ModBlocks.MARBLE.get(), ModItems.MARBLE_SHARD.get())));

        add(ModBlocks.EMBARIUM_LAMP_BLOCK.get(),
                (block -> createSingleItemTableWithSilkTouch(ModBlocks.EMBARIUM_LAMP_BLOCK.get(), Blocks.GLASS)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
