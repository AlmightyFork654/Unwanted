package com.almightyfork.unwanted.villager;

import com.almightyfork.unwanted.Unwanted;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Unwanted.MODID)
public class VillageAddition {
    private static final ResourceKey<StructureProcessorList> EMPTY_PROCESSOR_LIST_KEY = ResourceKey.create(
            Registries.PROCESSOR_LIST, new ResourceLocation("minecraft", "empty"));

    /**
     * Adds the building to the targeted pool.
     * We will call this in addNewVillageBuilding method further down to add to every village.
     *
     * Note: This is an additive operation which means multiple mods can do this and they stack with each other safely.
     */
    private static void addBuildingToPool(Registry<StructureTemplatePool> templatePoolRegistry,
                                          Registry<StructureProcessorList> processorListRegistry,
                                          ResourceLocation poolRL,
                                          String nbtPieceRL,
                                          int weight) {

        // Grabs the processor list we want to use along with our piece.
        // This is a requirement as using the ProcessorLists.EMPTY field will cause the game to throw errors.
        // The reason why is the empty processor list in the world's registry is not the same instance as in that field once the world is started up.
        Holder<StructureProcessorList> emptyProcessorList = processorListRegistry.getHolderOrThrow(EMPTY_PROCESSOR_LIST_KEY);

        // Grab the pool we want to add to
        StructureTemplatePool pool = templatePoolRegistry.get(poolRL);
        if (pool == null) return;

        // Grabs the nbt piece and creates a SinglePoolElement of it that we can add to a structure's pool.
        // Use .legacy( for villages/outposts and .single( for everything else
        SinglePoolElement piece = SinglePoolElement.legacy(nbtPieceRL,
                emptyProcessorList).apply(StructureTemplatePool.Projection.RIGID);

        // Use AccessTransformer or Accessor Mixin to make StructureTemplatePool's templates field public for us to see.
        // Weight is handled by how many times the entry appears in this list.
        // We do not need to worry about immutability as this field is created using Lists.newArrayList(); which makes a mutable list.
        for (int i = 0; i < weight; i++) {
            pool.templates.add(piece);
        }

        // Use AccessTransformer or Accessor Mixin to make StructureTemplatePool's rawTemplates field public for us to see.
        // This list of pairs of pieces and weights is not used by vanilla by default but another mod may need it for efficiency.
        // So lets add to this list for completeness. We need to make a copy of the array as it can be an immutable list.
        List<Pair<StructurePoolElement, Integer>> listOfPieceEntries = new ArrayList<>(pool.rawTemplates);
        listOfPieceEntries.add(new Pair<>(piece, weight));
        pool.rawTemplates = listOfPieceEntries;
    }

//    public static void addBuildingToPool(Registry<StructureTemplatePool> templatePoolRegistry, Registry<StructureProcessorList> processorListRegistry, ResourceLocation poolRL, String nbtPieceRL, int weight) {
//        Holder<StructureProcessorList> emptyProcessorList = processorListRegistry.getHolderOrThrow(EMPTY_PROCESSOR_LIST_KEY);
//
//        StructureTemplatePool pool = templatePoolRegistry.get(poolRL);
//        if (pool == null) return;
//
//        SinglePoolElement piece = SinglePoolElement.single(nbtPieceRL, emptyProcessorList).apply(StructureTemplatePool.Projection.RIGID);
//
//        for (int i = 0; i < weight; i++) {
//            ((StructureTemplatePoolAccessor) pool).getTemplates().add(piece);
//        }
//
//        List<Pair<StructurePoolElement, Integer>> listOfPieceEntries = new ArrayList<>(((StructureTemplatePoolAccessor) pool).getRawTemplates());
//        listOfPieceEntries.add(new Pair<>(piece, weight));
//        ((StructureTemplatePoolAccessor) pool).setRawTemplates(listOfPieceEntries);
//    }

    /**
     * We use FMLServerAboutToStartEvent as the dynamic registry exists now and all JSON worldgen files were parsed.
     * Mod compat is best done here.
     */
    @SubscribeEvent
    public static void addNewVillageBuilding(final ServerAboutToStartEvent event) {
        Registry<StructureTemplatePool> templatePoolRegistry = event.getServer().registryAccess().registry(Registries.TEMPLATE_POOL).orElseThrow();
        Registry<StructureProcessorList> processorListRegistry = event.getServer().registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();

        // Adds our piece to all village houses pool
        // Note, the resourcelocation is getting the pool files from the data folder. Not assets folder.
        ResourceLocation plainsPoolLocation = new ResourceLocation("minecraft:village/plains/houses");
        ResourceLocation desertPoolLocation = new ResourceLocation("minecraft:village/desert/houses");
        ResourceLocation savannaPoolLocation = new ResourceLocation("minecraft:village/savanna/houses");
        ResourceLocation snowyPoolLocation = new ResourceLocation("minecraft:village/snowy/houses");
        ResourceLocation taigaPoolLocation = new ResourceLocation("minecraft:village/taiga/houses");
        int weight = 4;
        int rare_weight = 2;

        // PLAINS VILLAGE HOUSES
        addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "unwanted:village/plains/plains_enchanter", rare_weight);
        addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "unwanted:village/plains/plains_musician", weight);
        addBuildingToPool(templatePoolRegistry, processorListRegistry, plainsPoolLocation, "unwanted:village/plains/plains_gem_cutter", weight);
        

        // TAIGA VILLAGE HOUSES
        addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "unwanted:village/taiga/taiga_enchanter", rare_weight);
        addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "unwanted:village/taiga/taiga_musician", weight);
        addBuildingToPool(templatePoolRegistry, processorListRegistry, taigaPoolLocation, "unwanted:village/taiga/taiga_gem_cutter", weight);
    

        // SAVANNA VILLAGE HOUSES
        addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "unwanted:village/savanna/savanna_enchanter", rare_weight);
        addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "unwanted:village/savanna/savanna_musician", weight);
        addBuildingToPool(templatePoolRegistry, processorListRegistry, savannaPoolLocation, "unwanted:village/savanna/savanna_gem_cutter", weight);
    

        // SNOWY VILLAGE HOUSEs
        addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "unwanted:village/snowy/snowy_enchanter", rare_weight);
        addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "unwanted:village/snowy/snowy_musician", weight);
        addBuildingToPool(templatePoolRegistry, processorListRegistry, snowyPoolLocation, "unwanted:village/snowy/snowy_gem_cutter", weight);
    

        // DESERT VILLAGE HOUSES
        addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "unwanted:village/desert/desert_enchanter", rare_weight);
        addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "unwanted:village/desert/desert_musician", weight);
        addBuildingToPool(templatePoolRegistry, processorListRegistry, desertPoolLocation, "unwanted:village/desert/desert_gem_cutter", weight);
    }
}
