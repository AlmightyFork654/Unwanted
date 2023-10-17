package com.almightyfork.unwanted.villager;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, Unwanted.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Unwanted.MODID);


    //enchanter
    public static final RegistryObject<PoiType> ENCHANTING_TABLE = POI_TYPES.register("enchanting_table",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.ENCHANTING_TABLE.getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<VillagerProfession> ENCHANTER = VILLAGER_PROFESSIONS.register("enchanter",
            () -> new VillagerProfession("enchanter", holder -> holder.get() ==  ENCHANTING_TABLE.get(), holder -> holder.get() == ENCHANTING_TABLE.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_LIBRARIAN));

    //musician
    public static final RegistryObject<PoiType> JUKEBOX = POI_TYPES.register("jukebox",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.JUKEBOX.getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<VillagerProfession> MUSICIAN = VILLAGER_PROFESSIONS.register("musician",
            () -> new VillagerProfession("musician", holder -> holder.get() ==   JUKEBOX.get(), holder -> holder.get() == JUKEBOX.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_MASON));

    //gem cutter
    public static final RegistryObject<PoiType> GEM_CUTTING_STATION = POI_TYPES.register("gem_cutting_station",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.GEM_CUTTING_STATION.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<VillagerProfession> GEM_CUTTER = VILLAGER_PROFESSIONS.register("gem_cutter",
            () -> new VillagerProfession("gem_cutter", holder -> holder.get() ==   GEM_CUTTING_STATION.get(), holder -> holder.get() == GEM_CUTTING_STATION.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    //collecter
    public static final RegistryObject<PoiType> COLLECTING_STATION = POI_TYPES.register("collecting_station",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.SHULKER_BOX.getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<VillagerProfession> COLLECTOR = VILLAGER_PROFESSIONS.register("collector",
            () -> new VillagerProfession("collector", holder -> holder.get() ==   COLLECTING_STATION.get(), holder -> holder.get() == COLLECTING_STATION.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_LIBRARIAN));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
