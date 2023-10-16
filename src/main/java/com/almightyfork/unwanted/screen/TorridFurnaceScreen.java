package com.almightyfork.unwanted.screen;

import com.almightyfork.unwanted.Unwanted;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class TorridFurnaceScreen extends AbstractContainerScreen<TorridFurnaceMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Unwanted.MODID, "textures/gui/torrid_furnace_gui.png");

    public TorridFurnaceScreen(TorridFurnaceMenu p_97741_, Inventory p_97742_, Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
    }

    public void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float p_97788_, int p_97789_, int p_97790_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
        renderFuel(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y){
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 69, y + 23, 176, 14, menu.getScaledProgress(), 26);
        }
    }

    private void renderFuel(GuiGraphics guiGraphics, int x, int y){
        if(menu.hasFuel()) {
            guiGraphics.blit(TEXTURE, x + 44, y + 36 + 14 - menu.getScaledFuelProgress(), 176,
                    14 - menu.getScaledFuelProgress(), 14, menu.getScaledFuelProgress());
        }
    }

    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
