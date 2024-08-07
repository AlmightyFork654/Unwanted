package com.almightyfork.unwanted.worldgen.tree.custom;

import com.almightyfork.unwanted.Unwanted;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, Unwanted.MODID);

    public static final RegistryObject<FoliagePlacerType<EbonyFoliagePlacer>> EBONY_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("ebony_foliage_placer", () -> new FoliagePlacerType<>(EbonyFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
