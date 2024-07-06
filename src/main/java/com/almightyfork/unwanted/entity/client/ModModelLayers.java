package com.almightyfork.unwanted.entity.client;

import com.almightyfork.unwanted.Unwanted;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation EBONY_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(Unwanted.MODID, "boat/ebony"), "main");
    public static final ModelLayerLocation EBONY_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(Unwanted.MODID, "chest_boat/ebony"), "main");
    public static final ModelLayerLocation WOODEN_SPEAR = new ModelLayerLocation(
            new ResourceLocation(Unwanted.MODID, "wooden_spear"), "main");
    public static final ModelLayerLocation IRON_SPEAR = new ModelLayerLocation(
            new ResourceLocation(Unwanted.MODID, "iron_spear"), "main");
}
