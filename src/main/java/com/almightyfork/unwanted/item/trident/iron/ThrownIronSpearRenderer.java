package com.almightyfork.unwanted.item.trident.iron;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.entity.client.ModModelLayers;
import com.almightyfork.unwanted.item.trident.SpearModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ThrownIronSpearRenderer extends EntityRenderer<IronThrownSpear> {
    public static final ResourceLocation SPEAR_LOCATION = new ResourceLocation(Unwanted.MODID,"textures/entity/iron_spear_in_hand.png");
    private final SpearModel model;

    public ThrownIronSpearRenderer(EntityRendererProvider.Context p_174420_) {
        super(p_174420_);
        this.model = new SpearModel(p_174420_.bakeLayer(ModModelLayers.IRON_SPEAR));
    }

    public void render(IronThrownSpear p_116111_, float p_116112_, float p_116113_, PoseStack p_116114_, MultiBufferSource p_116115_, int p_116116_) {
        p_116114_.pushPose();
        p_116114_.mulPose(Axis.YP.rotationDegrees(Mth.lerp(p_116113_, p_116111_.yRotO, p_116111_.getYRot()) - 90.0F));
        p_116114_.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(p_116113_, p_116111_.xRotO, p_116111_.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(p_116115_, RenderType.entityCutout(this.getTextureLocation(p_116111_)), false, p_116111_.isFoil());
//        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(p_116115_, this.model.renderType(this.getTextureLocation(p_116111_)), false, p_116111_.isFoil());
//        this.model.renderType(this.getTextureLocation(p_116111_))
//        VertexConsumer vertexconsumer = p_113843_.getBuffer(RenderType.entityCutout(this.getTextureLocation(p_113839_)));
        this.model.renderToBuffer(p_116114_, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        p_116114_.popPose();
        super.render(p_116111_, p_116112_, p_116113_, p_116114_, p_116115_, p_116116_);
    }

    public ResourceLocation getTextureLocation(IronThrownSpear p_116109_) {
        return SPEAR_LOCATION;
    }
}