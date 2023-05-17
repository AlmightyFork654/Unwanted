package com.almightyfork.unwanted.event;

public class ModConfigHelper {
    public static boolean generatePlainsHouses() {
        return ModConfig.GENERATE_PLAINS_HOUSES.get();
    }

    public static boolean generateTaigaHouses() {
        return ModConfig.GENERATE_TAIGA_HOUSES.get();
    }

    public static boolean generateSavannaHouses() {
        return ModConfig.GENERATE_SAVANNA_HOUSES.get();
    }

    public static boolean generateSnowyHouses() {
        return ModConfig.GENERATE_SNOWY_HOUSES.get();
    }

    public static boolean generateDesertHouses() {
        return ModConfig.GENERATE_DESERT_HOUSES.get();
    }

    public static int enchanterHouseWeight() {
        return ModConfig.ENCHANTER_HOUSE_WEIGHT.get();
    }

    public static int musicianHouseWeight() {
        return ModConfig.MUSICIAN_HOUSE_WEIGHT.get();
    }

    public static int gemCutterHouseWeight() {
        return ModConfig.GEM_CUTTER_HOUSE_WEIGHT.get();
    }
}
