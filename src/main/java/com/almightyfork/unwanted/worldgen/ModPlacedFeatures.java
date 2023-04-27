package com.almightyfork.unwanted.worldgen;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> EBONY_PLACED_KEY = createKey("ebony_placed");

//    public static final ResourceKey<PlacedFeature> TORRID_BUSH_PLACED_KEY = createKey("torrid_bush_placed");


    public static final ResourceKey<PlacedFeature> RUBY_PLACED_KEY = createKey("ruby_placed");
    public static final ResourceKey<PlacedFeature> EMBARIUM_PLACED_KEY = createKey("embarium_placed");
    public static final ResourceKey<PlacedFeature> TORRID_PLACED_KEY = createKey("torrid_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, EBONY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EBONY_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.2f, 4),
                        ModBlocks.EBONY_SAPLING.get()));

//        register(context, TORRID_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TORRID_KEY),
//                List.of(RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, EMBARIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EMBARIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement( 12, //veins per chunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(160)))); // spawn levels
        register(context, RUBY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement( 8, //veins per chunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)))); // spawn levels
        register(context, TORRID_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TORRID_ORE_KEY),
                ModOrePlacement.commonOrePlacement( 24, //veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(240)))); // spawn levels

    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Unwanted.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
        List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

}
