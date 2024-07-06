package com.almightyfork.unwanted.block.entity.custom.renderer;

import com.almightyfork.unwanted.block.custom.GemCuttingStationBlock;
import com.almightyfork.unwanted.block.custom.TorridFurnaceBlock;
import com.almightyfork.unwanted.block.entity.custom.TorridFurnaceBlockEntity;
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

public class TorridFurnaceBlockEntityRenderer implements BlockEntityRenderer<TorridFurnaceBlockEntity> {

    public TorridFurnaceBlockEntityRenderer(BlockEntityRendererProvider.Context context){

    }


    @Override
    public void render(TorridFurnaceBlockEntity entity, float p_112308_, PoseStack stack, MultiBufferSource source, int p_112311_, int p_112312_) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = entity.getRenderStack();


        String rotation = String.valueOf(entity.getBlockState().getValue(TorridFurnaceBlock.FACING));
        switch (rotation) {
            case "north" -> {
                stack.pushPose();
                stack.translate(8/16f, 2.25/16f,3/16f);
                stack.scale(4/16f, 4/16f, 4/16f);

                stack.mulPose(Axis.XP.rotationDegrees(270));
                stack.mulPose(Axis.ZP.rotationDegrees(180));
            }
            case "east" -> {
                stack.pushPose();
                stack.translate(13/16f, 2.25/16f,8/16f);
                stack.scale(4/16f, 4/16f, 4/16f);

                stack.mulPose(Axis.XP.rotationDegrees(270));
                stack.mulPose(Axis.ZP.rotationDegrees(90));
            }
            case "south" -> {
                stack.pushPose();
                stack.translate(8/16f, 2.25/16f,13/16f);
                stack.scale(4/16f, 4/16f, 4/16f);

                stack.mulPose(Axis.XP.rotationDegrees(270));
                stack.mulPose(Axis.ZP.rotationDegrees(0));
            }
            case "west" -> {
                stack.pushPose();
                stack.translate(3/16f, 2.25/16f,8/16f);
                stack.scale(4/16f, 4/16f, 4/16f);

                stack.mulPose(Axis.XP.rotationDegrees(270));
                stack.mulPose(Axis.ZP.rotationDegrees(270));
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
