package com.almightyfork.unwanted.event;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber
public class ModConfig {
    public static ForgeConfigSpec COMMON_CONFIG;

    public static final String CATEGORY_HOUSES = "houses";
    public static final String CATEGORY_WEIGHTS = "weights";
    public static final ForgeConfigSpec.BooleanValue GENERATE_PLAINS_HOUSES;
    public static final ForgeConfigSpec.BooleanValue GENERATE_TAIGA_HOUSES;
    public static final ForgeConfigSpec.BooleanValue GENERATE_SAVANNA_HOUSES;
    public static final ForgeConfigSpec.BooleanValue GENERATE_SNOWY_HOUSES;
    public static final ForgeConfigSpec.BooleanValue GENERATE_DESERT_HOUSES;
    public static final ForgeConfigSpec.IntValue ENCHANTER_HOUSE_WEIGHT;
    public static final ForgeConfigSpec.IntValue MUSICIAN_HOUSE_WEIGHT;
    public static final ForgeConfigSpec.IntValue GEM_CUTTER_HOUSE_WEIGHT;


    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.comment("House generation settings").push(CATEGORY_HOUSES);
        GENERATE_PLAINS_HOUSES = COMMON_BUILDER.comment("Should Unwanted Villagers houses generate in plains biome villages?")
                .define("generatePlainsHouses", true);
        GENERATE_TAIGA_HOUSES = COMMON_BUILDER.comment("Should MUnwanted Villagers houses generate in taiga biome villages?")
                .define("generateTaigaHouses", true);
        GENERATE_SAVANNA_HOUSES = COMMON_BUILDER.comment("Should Unwanted Villagers houses generate in savanna biome villages?")
                .define("generateSavannaHouses", true);
        GENERATE_SNOWY_HOUSES = COMMON_BUILDER.comment("Should Unwanted Villagers houses generate in snowy biome villages?")
                .define("generateSnowyHouses", true);
        GENERATE_DESERT_HOUSES = COMMON_BUILDER.comment("Should Unwanted Villagers houses generate in desert biome villages?")
                .define("generateDesertHouses", true);

        COMMON_BUILDER.comment("House weights (spawn frequency)").push(CATEGORY_WEIGHTS);
        ENCHANTER_HOUSE_WEIGHT = COMMON_BUILDER.comment("Enchanter house spawn chance").defineInRange("enchanterHouseWeight", 100, 0, Integer.MAX_VALUE);
        MUSICIAN_HOUSE_WEIGHT = COMMON_BUILDER.comment("Musician house spawn chance").defineInRange("musicianHouseWeight", 100, 0, Integer.MAX_VALUE);
        GEM_CUTTER_HOUSE_WEIGHT = COMMON_BUILDER.comment("Gem cutter house spawn chance").defineInRange("gemCutterHouseWeight", 100, 0, Integer.MAX_VALUE);

        COMMON_BUILDER.pop();


        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading configEvent) { }

    @SubscribeEvent
    public static void onReload(final ModConfigEvent.Reloading configEvent) { }
}

