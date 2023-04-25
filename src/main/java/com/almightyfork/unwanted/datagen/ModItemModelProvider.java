package com.almightyfork.unwanted.datagen;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Unwanted.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ROUGH_RUBY);
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.PURE_RUBY);
        simpleItem(ModItems.TORRID_STEEL_INGOT);
        simpleItem(ModItems.TORRID_STEEL_NUGGET);
        simpleItem(ModItems.TORRID_STEEL_POWDER);
        simpleItem(ModItems.EMBARIUM);
        simpleItem(ModItems.MARBLE_SHARD);
        simpleItem(ModItems.BLAZING_WATER);
        simpleItem(ModItems.PURE_BLAZE_POWDER);

        handheldItem(ModItems.CHISEL);
        handheldItem(ModItems.NETHERITE_CHISEL);

        handheldItem(ModItems.TORRID_STEEL_SWORD);
        handheldItem(ModItems.TORRID_STEEL_PICKAXE);
        handheldItem(ModItems.TORRID_STEEL_AXE);
        handheldItem(ModItems.TORRID_STEEL_SHOVEL);
        handheldItem(ModItems.TORRID_STEEL_HOE);
        handheldItem(ModItems.EMBARIUM_SWORD);
        handheldItem(ModItems.EMBARIUM_PICKAXE);
        handheldItem(ModItems.EMBARIUM_AXE);
        handheldItem(ModItems.EMBARIUM_SHOVEL);
        handheldItem(ModItems.EMBARIUM_HOE);
        handheldItem(ModItems.TORRID_EMBARIUM_SWORD);
        handheldItem(ModItems.TORRID_EMBARIUM_PICKAXE);
        handheldItem(ModItems.TORRID_EMBARIUM_AXE);
        handheldItem(ModItems.TORRID_EMBARIUM_SHOVEL);
        handheldItem(ModItems.TORRID_EMBARIUM_HOE);

        simpleItem(ModItems.TORRID_HELMET);
        simpleItem(ModItems.TORRID_CHESTPLATE);
        simpleItem(ModItems.TORRID_LEGGINGS);
        simpleItem(ModItems.TORRID_BOOTS);
        simpleItem(ModItems.EMBARIUM_HELMET);
        simpleItem(ModItems.EMBARIUM_CHESTPLATE);
        simpleItem(ModItems.EMBARIUM_LEGGINGS);
        simpleItem(ModItems.EMBARIUM_BOOTS);
        simpleItem(ModItems.TORRID_EMBARIUM_HELMET);
        simpleItem(ModItems.TORRID_EMBARIUM_CHESTPLATE);
        simpleItem(ModItems.TORRID_EMBARIUM_LEGGINGS);
        simpleItem(ModItems.TORRID_EMBARIUM_BOOTS);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Unwanted.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Unwanted.MODID, "item/" + item.getId().getPath()));
    }
}
