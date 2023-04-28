package com.almightyfork.unwanted.block.entity.client;

import com.almightyfork.unwanted.block.entity.custom.GemInfuserBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoBlockRenderer;


public class GemInfuserBlockRenderer extends GeoBlockRenderer<GemInfuserBlockEntity> {
    public GemInfuserBlockRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        super(new GemInfuserBlockModel());
    }

//    @Override
//    public RenderType getRenderType(GemInfuserBlockEntity animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
//        return RenderType.entityTranslucent(getTextureLocation(animatable));
//    }
}
