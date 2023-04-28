package com.almightyfork.unwanted.item.client;

import com.almightyfork.unwanted.item.custom.GemInfuserItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GemInfuserItemRenderer extends GeoItemRenderer<GemInfuserItem> {
    public GemInfuserItemRenderer() {
        super(new GemInfuserItemModel());
    }
}
