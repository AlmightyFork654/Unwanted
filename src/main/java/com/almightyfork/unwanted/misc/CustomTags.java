package com.almightyfork.unwanted.misc;

import com.almightyfork.unwanted.Unwanted;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CustomTags {

    public static class Blocks {

        public static final TagKey<Block> RUBY_DETECTOR_VALUABLES
                = tag("ruby_detector_valuables");

        public static final TagKey<Block> EBONY_LOGS
                = tag("ebony_logs");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Unwanted.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

        //tags

    }

    public static class Items {

        public static final TagKey<Item> CHISELS
                = tag("chisels");
        public static final TagKey<Item> FUELS
                = tag("fuels");
        public static final TagKey<Item> ALL_FUELS
                = tag("all_fuels");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Unwanted.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

        //tags

    }
}
