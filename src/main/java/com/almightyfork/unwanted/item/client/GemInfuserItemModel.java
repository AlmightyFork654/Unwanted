package com.almightyfork.unwanted.item.client;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.entity.custom.GemInfuserBlockEntity;
import com.almightyfork.unwanted.item.custom.GemInfuserItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GemInfuserItemModel extends GeoModel<GemInfuserItem> {
    @Override
    public ResourceLocation getModelResource(GemInfuserItem object) {
        return new ResourceLocation(Unwanted.MODID, "geo/gem_infuser.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GemInfuserItem object) {
        return new ResourceLocation(Unwanted.MODID, "textures/block/gem_infuser.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GemInfuserItem animatable) {
        return new ResourceLocation(Unwanted.MODID, "animations/gem_infuser.animation.json");
    }
}
