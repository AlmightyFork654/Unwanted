package com.almightyfork.unwanted.item.client;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.item.armor.ProArmorItem;
import com.almightyfork.unwanted.item.custom.GemInfuserItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ProArmorModel extends GeoModel<ProArmorItem> {
    @Override
    public ResourceLocation getModelResource(ProArmorItem object) {
        return new ResourceLocation(Unwanted.MODID, "geo/profundium_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ProArmorItem object) {
        return new ResourceLocation(Unwanted.MODID, "textures/models/armor/profundium_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ProArmorItem animatable) {
        return new ResourceLocation(Unwanted.MODID, "animations/profundium_armor.animation.json");
    }
}
