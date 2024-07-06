package com.almightyfork.unwanted.item.armor.layers;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.item.ModItems;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class ElytraGliderLayer<T extends LivingEntity, M extends EntityModel<T>> extends ElytraLayer<T, M> {
    private static final ResourceLocation WINGS_LOCATION = new ResourceLocation(Unwanted.MODID,"textures/models/armor/elytra_glider.png");

    public ElytraGliderLayer(RenderLayerParent parent, EntityModelSet set) {
        super(parent, set);
    }

    @Override
    public boolean shouldRender(ItemStack stack, LivingEntity entity) {
        return stack.getItem() == ModItems.ELYTRA_GLIDER.get();
    }

    @Override
    public ResourceLocation getElytraTexture(ItemStack stack, LivingEntity entity) {
        return WINGS_LOCATION;
    }
}
