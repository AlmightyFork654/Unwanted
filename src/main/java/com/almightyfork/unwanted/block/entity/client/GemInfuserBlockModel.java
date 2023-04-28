package com.almightyfork.unwanted.block.entity.client;


import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.entity.custom.GemInfuserBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GemInfuserBlockModel extends GeoModel<GemInfuserBlockEntity> {
    @Override
    public ResourceLocation getModelResource(GemInfuserBlockEntity object) {
        return new ResourceLocation(Unwanted.MODID, "geo/gem_infuser.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GemInfuserBlockEntity object) {
        return new ResourceLocation(Unwanted.MODID, "textures/block/gem_infuser.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GemInfuserBlockEntity animatable) {
        return new ResourceLocation(Unwanted.MODID, "animations/gem_infuser.animation.json");
    }
}