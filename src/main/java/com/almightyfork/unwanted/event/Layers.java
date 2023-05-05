package com.almightyfork.unwanted.event;

import com.almightyfork.unwanted.Unwanted;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class Layers {

    public static final ModelLayerLocation PROFUNDIUM_ELYTRA_LAYER = new ModelLayerLocation(new ResourceLocation(Unwanted.MODID, "profundium_elytra"), "main");

    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(PROFUNDIUM_ELYTRA_LAYER, () -> ElytraModel.createLayer());
    }
}
