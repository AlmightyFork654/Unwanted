package com.almightyfork.unwanted.recipe.category;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.misc.CustomTags;
import com.almightyfork.unwanted.misc.JEIPlugin;
import com.almightyfork.unwanted.recipe.GemCuttingStationRecipe;
import com.almightyfork.unwanted.recipe.GemInfuserRecipe;
import com.almightyfork.unwanted.recipe.TorridFurnaceRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public class TorridFurnaceRecipeCategory implements IRecipeCategory<TorridFurnaceRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Unwanted.MODID, "torrid_furnace");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Unwanted.MODID, "textures/gui/torrid_furnace_gui.png");

    private final IDrawable bg;
    private final IDrawable icon;

    public TorridFurnaceRecipeCategory(IGuiHelper helper) {
        this.bg = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TORRID_FURNACE.get()));
    }

    @Override
    public RecipeType<TorridFurnaceRecipe> getRecipeType() {
        return JEIPlugin.MELTING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Torrid Steel Furnace");
    }

    @Override
    public IDrawable getBackground() {
        return this.bg;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull TorridFurnaceRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 53).addIngredients(Ingredient.of(CustomTags.Items.ALL_FUELS));
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 17).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 53).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 53).addItemStack(recipe.output);
    }
}
