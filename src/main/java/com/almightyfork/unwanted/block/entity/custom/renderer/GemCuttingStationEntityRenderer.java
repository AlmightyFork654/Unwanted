package com.almightyfork.unwanted.block.entity.custom.renderer;

import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.block.custom.GemCuttingStationBlock;
import com.almightyfork.unwanted.block.entity.custom.GemCuttingStationBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class GemCuttingStationEntityRenderer implements BlockEntityRenderer<GemCuttingStationBlockEntity> {

    public GemCuttingStationEntityRenderer(BlockEntityRendererProvider.Context context){

    }


    @Override
    public void render(GemCuttingStationBlockEntity entity, float p_112308_, PoseStack stack, MultiBufferSource source, int p_112311_, int p_112312_) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = entity.getRenderStack();


        String rotation = String.valueOf(entity.getBlockState().getValue(GemCuttingStationBlock.FACING));
        switch (rotation) {
            case "north" -> {
                stack.pushPose();
                stack.translate(4.75/16f, 5.25/16f,11.75/16f);
                stack.scale(4/16f, 4/16f, 4/16f);

                stack.mulPose(Axis.XP.rotationDegrees(270));
                stack.mulPose(Axis.ZP.rotationDegrees(90));
            }
            case "east" -> {
                stack.pushPose();
                stack.translate(4.25/16f, 5.25/16f,4.75/16f);
                stack.scale(4/16f, 4/16f, 4/16f);

                stack.mulPose(Axis.XP.rotationDegrees(270));
                stack.mulPose(Axis.ZP.rotationDegrees(0));
            }
            case "south" -> {
                stack.pushPose();
                stack.translate(11.25/16f, 5.25/16f,4.25/16f);
                stack.scale(4/16f, 4/16f, 4/16f);

                stack.mulPose(Axis.XP.rotationDegrees(270));
                stack.mulPose(Axis.ZP.rotationDegrees(270));
            }
            case "west" -> {
                stack.pushPose();
                stack.translate(11.75/16f, 5.25/16f,11.25/16f);
                stack.scale(4/16f, 4/16f, 4/16f);

                stack.mulPose(Axis.XP.rotationDegrees(270));
                stack.mulPose(Axis.ZP.rotationDegrees(180));
            }
        }

        itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, getLightLevel(entity.getLevel(), entity.getBlockPos()),
                OverlayTexture.NO_OVERLAY, stack, source, entity.getLevel(), 1);
        stack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
