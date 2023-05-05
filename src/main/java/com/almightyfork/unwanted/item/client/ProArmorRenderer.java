package com.almightyfork.unwanted.item.client;

import com.almightyfork.unwanted.item.armor.ProArmorItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ProArmorRenderer extends GeoArmorRenderer<ProArmorItem> {
    public ProArmorRenderer() {
        super(new ProArmorModel());
    }
}
