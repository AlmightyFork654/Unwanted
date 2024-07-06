package com.almightyfork.unwanted.recipe.category;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.item.ModItems;
import com.almightyfork.unwanted.misc.CustomTags;
import com.almightyfork.unwanted.misc.JEIPlugin;
import com.almightyfork.unwanted.recipe.GemCuttingStationRecipe;
import com.almightyfork.unwanted.recipe.KettleRecipe;
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
import org.checkerframework.checker.nullness.qual.NonNull;

public class KettleRecipeCategory implements IRecipeCategory<KettleRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Unwanted.MODID, "kettle");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Unwanted.MODID, "textures/gui/kettle_gui.png");

    private final IDrawable bg;
    private final IDrawable icon;

    public KettleRecipeCategory(IGuiHelper helper) {
        this.bg = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.KETTLE.get()));
    }

    @Override
    public RecipeType<KettleRecipe> getRecipeType() {
        return JEIPlugin.KETTLE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Kettle");
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
    public void setRecipe(@NonNull IRecipeLayoutBuilder builder, @NonNull KettleRecipe recipe, @NonNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 57, 18).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 103, 18).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 60).addItemStack(recipe.output);
    }
}

