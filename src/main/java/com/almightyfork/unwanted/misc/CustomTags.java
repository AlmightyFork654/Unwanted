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
        public static final TagKey<Item> EBONY_LOGS
                = tag("ebony_logs");
        public static final TagKey<Item> NUGGETS
                = tag("nuggets");
        public static final TagKey<Item> INGOTS
                = tag("ingots");
        //tea tags

        public static final TagKey<Item> BASE_TEA
                = tag("base_teas");

        public static final TagKey<Item> GRASSY
                = tag("grassy");
        public static final TagKey<Item> WARPED
                = tag("warped");
        public static final TagKey<Item> CRIMSON
                = tag("crimson");
        public static final TagKey<Item> LEAVY
                = tag("leavy");
        public static final TagKey<Item> KELPED
                = tag("kelped");
        public static final TagKey<Item> VINEY
                = tag("viney");
        public static final TagKey<Item> GLOWY
                = tag("glowy");
        public static final TagKey<Item> SCULKED
                = tag("sculked");
        public static final TagKey<Item> ROOTED
                = tag("rooted");

        public static final TagKey<Item> TELEPORTS
                = tag("teleports");

        public static final TagKey<Item> SPAWN
                = tag("spawn");
        public static final TagKey<Item> OVERWORLD
                = tag("overworld");
        public static final TagKey<Item> NETHER
                = tag("nether");
        public static final TagKey<Item> END
                = tag("end");

        public static final TagKey<Item> MODS
                = tag("mods");

        public static final TagKey<Item> ADDITIVES
                = tag("additives");

        public static final TagKey<Item> RED_STUFF
                = tag("red_stuff");
        public static final TagKey<Item> GOLDEN_FRUIT
                = tag("golden_fruit");
        public static final TagKey<Item> GOD_APPLE
                = tag("god_apple");
        public static final TagKey<Item> SWEET
                = tag("sweet");
        public static final TagKey<Item> GLOWING_FRUIT
                = tag("glowing_fruit");
        public static final TagKey<Item> PINK_FLOWER
                = tag("pink_flower");
        public static final TagKey<Item> YELLOW_FLOWER
                = tag("yellow_flower");
        public static final TagKey<Item> WHITE_FLOWER
                = tag("white_flower");
        public static final TagKey<Item> GREY_FLOWER
                = tag("grey_flower");
        public static final TagKey<Item> BLUE_FLOWER
                = tag("blue_flower");
        public static final TagKey<Item> PURPLE_FLOWER1
                = tag("purple_flower1");
        public static final TagKey<Item> PURPLE_FLOWER2
                = tag("purple_flower2");
        public static final TagKey<Item> RED_FLOWER
                = tag("red_flower");
        public static final TagKey<Item> END_FLOWER
                = tag("end_flower");
        public static final TagKey<Item> FIRE_FLOWER
                = tag("fire_flower");
        public static final TagKey<Item> POT_FLOWER
                = tag("pot_flower");
        public static final TagKey<Item> WING
                = tag("wing");
        public static final TagKey<Item> FIRE
                = tag("fire");
        public static final TagKey<Item> TORRID
                = tag("torrid");
        public static final TagKey<Item> WITHER
                = tag("wither");



        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Unwanted.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

        //tags

    }
}
