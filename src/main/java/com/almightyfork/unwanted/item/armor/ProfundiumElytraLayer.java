package com.almightyfork.unwanted.item.armor;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.item.ModItems;
import com.google.common.eventbus.Subscribe;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;

public class ProfundiumElytraLayer<T extends LivingEntity, M extends EntityModel<T>> extends ElytraLayer<T, M> {
    private static final ResourceLocation WINGS_LOCATION = new ResourceLocation(Unwanted.MODID,"textures/models/armor/elytra.png");

    public ProfundiumElytraLayer(RenderLayerParent parent, EntityModelSet set) {
        super(parent, set);
    }

    @Override
    public boolean shouldRender(ItemStack stack, LivingEntity entity) {
        return stack.getItem() == ModItems.PROFUNDIUM_CHESTPLATE.get();
    }

    @Override
    public ResourceLocation getElytraTexture(ItemStack stack, LivingEntity entity) {
        return WINGS_LOCATION;
    }
}

