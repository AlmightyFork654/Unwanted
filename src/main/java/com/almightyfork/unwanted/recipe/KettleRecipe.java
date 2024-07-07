package com.almightyfork.unwanted.recipe;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.misc.CustomTags;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KettleRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    public final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public KettleRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems){
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        boolean matchesFirst = recipeItems.get(0).test(pContainer.getItem(0));
        boolean matchesSecond = recipeItems.get(1).test(pContainer.getItem(1));
        if ( matchesFirst && matchesSecond) {
            return true;
        }
        return false;
    }

    @Override
    public ItemStack assemble(SimpleContainer inv, RegistryAccess p_267165_) {
        ItemStack outputCopy = output.copy();
        CompoundTag outputTag = outputCopy.getOrCreateTag();

        ItemStack input = inv.getItem(0);

        ListTag modList = new ListTag();
        ListTag addList = new ListTag();

        if (input.hasTag()) {
            CompoundTag inputTag = input.getTag();
            if (inputTag != null) {

                // Copy specific tags from the input to the output
                if (inputTag.contains("TeaType")) {
                    outputTag.putString("TeaType", inputTag.getString("TeaType"));
                }
                if (inputTag.contains("TP")) {
                    outputTag.putString("TP", inputTag.getString("TP"));
                }
                if (inputTag.contains("Additives")) {
//                    outputTag.put("Additives", inputTag.getList("Additives", 8)); // 8 is the tag type for strings
                    ListTag Adds = inputTag.getList("Additives", Tag.TAG_STRING);
                    for (Tag AddTag : Adds) {
                        String add = AddTag.getAsString();
                        addList.add(StringTag.valueOf(add));
                    }
                }
                if (inputTag.contains("Mods")) {
//                    outputTag.put("Mods", inputTag.getList("Mods", 8)); // 8 is the tag type for strings
                    ListTag Mods = inputTag.getList("Mods", Tag.TAG_STRING);
                    for (Tag ModTag : Mods) {
                        String mod = ModTag.getAsString();
                        modList.add(StringTag.valueOf(mod));
                    }
                }

            }
        }

        ItemStack itemInSlot1 = inv.getItem(1);


        if (itemInSlot1.is(CustomTags.Items.BASE_TEA)) {
            if(!outputTag.contains("TeaType")) {
                if (itemInSlot1.is(CustomTags.Items.GRASSY)) {
                    outputTag.putString("TeaType", "grassy");
                }
                if (itemInSlot1.is(CustomTags.Items.WARPED)) {
                    outputTag.putString("TeaType", "warped");
                }
                if (itemInSlot1.is(CustomTags.Items.CRIMSON)) {
                    outputTag.putString("TeaType", "crimson");
                }
                if (itemInSlot1.is(CustomTags.Items.LEAVY)) {
                    outputTag.putString("TeaType", "leavy");
                }
                if (itemInSlot1.is(CustomTags.Items.KELPED)) {
                    outputTag.putString("TeaType", "kelped");
                }
                if (itemInSlot1.is(CustomTags.Items.VINEY)) {
                    outputTag.putString("TeaType", "viney");
                }
                if (itemInSlot1.is(CustomTags.Items.GLOWY)) {
                    outputTag.putString("TeaType", "glowy");
                }
                if (itemInSlot1.is(CustomTags.Items.SCULKED)) {
                    outputTag.putString("TeaType", "sculked");
                }
                if (itemInSlot1.is(CustomTags.Items.ROOTED)) {
                    outputTag.putString("TeaType", "rooted");
                }
            }
        }

        if (itemInSlot1.is(CustomTags.Items.TELEPORTS)) {
            if(!outputTag.contains("TP")) {
                if (itemInSlot1.is(CustomTags.Items.SPAWN)) {
                    outputTag.putString("TP", "spawn");
                }
                if (itemInSlot1.is(CustomTags.Items.OVERWORLD)) {
                    outputTag.putString("TP", "overworld");
                }
                if (itemInSlot1.is(CustomTags.Items.NETHER)) {
                    outputTag.putString("TP", "nether");
                }
                if (itemInSlot1.is(CustomTags.Items.END)) {
                    outputTag.putString("TP", "end");
                }
            }
        }

        if (itemInSlot1.is(CustomTags.Items.MODS)) {
            if (itemInSlot1.is(Items.REDSTONE)) {
                modList.add(StringTag.valueOf("redstone"));
            }
            if (itemInSlot1.is(Items.GLOWSTONE_DUST)) {
                modList.add(StringTag.valueOf("glowstone"));
            }
            if (itemInSlot1.is(Items.GUNPOWDER)) {
                modList.add(StringTag.valueOf("gunpowder"));
            }
        }


        if (itemInSlot1.is(CustomTags.Items.ADDITIVES)) {
            if (itemInSlot1.is(CustomTags.Items.RED_STUFF)) {
                addList.add(StringTag.valueOf("red_stuff"));
            }
            if (itemInSlot1.is(CustomTags.Items.GOLDEN_FRUIT)) {
                addList.add(StringTag.valueOf("golden_fruit"));
            }
            if (itemInSlot1.is(CustomTags.Items.GOD_APPLE)) {
                addList.add(StringTag.valueOf("god_apple"));
            }
            if (itemInSlot1.is(CustomTags.Items.SWEET)) {
                addList.add(StringTag.valueOf("sweet"));
            }
            if (itemInSlot1.is(CustomTags.Items.GLOWING_FRUIT)) {
                addList.add(StringTag.valueOf("glowing_fruit"));
            }
            if (itemInSlot1.is(CustomTags.Items.PINK_FLOWER)) {
                addList.add(StringTag.valueOf("pink_flower"));
            }
            if (itemInSlot1.is(CustomTags.Items.YELLOW_FLOWER)) {
                addList.add(StringTag.valueOf("yellow_flower"));
            }
            if (itemInSlot1.is(CustomTags.Items.WHITE_FLOWER)) {
                addList.add(StringTag.valueOf("white_flower"));
            }
            if (itemInSlot1.is(CustomTags.Items.GREY_FLOWER)) {
                addList.add(StringTag.valueOf("grey_flower"));
            }
            if (itemInSlot1.is(CustomTags.Items.BLUE_FLOWER)) {
                addList.add(StringTag.valueOf("blue_flower"));
            }
            if (itemInSlot1.is(CustomTags.Items.PURPLE_FLOWER1)) {
                addList.add(StringTag.valueOf("purple_flower_1"));
            }
            if (itemInSlot1.is(CustomTags.Items.PURPLE_FLOWER2)) {
                addList.add(StringTag.valueOf("purple_flower_2"));
            }
            if (itemInSlot1.is(CustomTags.Items.RED_FLOWER)) {
                addList.add(StringTag.valueOf("red_flower"));
            }
            if (itemInSlot1.is(CustomTags.Items.END_FLOWER)) {
                addList.add(StringTag.valueOf("end_flower"));
            }
            if (itemInSlot1.is(CustomTags.Items.FIRE_FLOWER)) {
                addList.add(StringTag.valueOf("fire_flower"));
            }
            if (itemInSlot1.is(CustomTags.Items.POT_FLOWER)) {
                addList.add(StringTag.valueOf("pot_flower"));
            }
            if (itemInSlot1.is(CustomTags.Items.WING)) {
                addList.add(StringTag.valueOf("wing"));
            }
            if (itemInSlot1.is(CustomTags.Items.FIRE)) {
                addList.add(StringTag.valueOf("fire"));
            }
            if (itemInSlot1.is(CustomTags.Items.TORRID)) {
                addList.add(StringTag.valueOf("torrid"));
            }
            if (itemInSlot1.is(CustomTags.Items.WITHER)) {
                addList.add(StringTag.valueOf("wither_flower"));
            }
        }

        sortTagList(addList);
        sortTagList(modList);

        outputTag.put("Additives", addList);
        outputTag.put("Mods", modList);

        return outputCopy;
    }

//    @Override
//    public ItemStack assemble(SimpleContainer container, RegistryAccess registryAccess) {
//        ItemStack outputCopy = output.copy();
//        CompoundTag outputTag = outputCopy.getOrCreateTag();
//
//        ItemStack input = container.getItem(0);
//        ItemStack itemInSlot1 = container.getItem(1);
//
//        // Logging to debug NBT transfer
//        LogUtils.getLogger().info("assemble called: input NBT: {}, slot 1 NBT: {}", input.getTag(), itemInSlot1.getTag());
//
//        if (input.hasTag()) {
//            CompoundTag inputTag = input.getTag();
//            if (inputTag != null) {
//                // Copy specific tags from the input to the output
//                if (inputTag.contains("TeaType")) {
//                    outputTag.putString("TeaType", inputTag.getString("TeaType"));
//                }
//                if (inputTag.contains("TP")) {
//                    outputTag.putString("TP", inputTag.getString("TP"));
//                }
//                if (inputTag.contains("Additives")) {
//                    outputTag.put("Additives", inputTag.getList("Additives", 8)); // 8 is the tag type for strings
//                }
//                if (inputTag.contains("Mods")) {
//                    outputTag.put("Mods", inputTag.getList("Mods", 8)); // 8 is the tag type for strings
//                }
//            }
//        }
//
//        // Apply modifications based on the item in slot 1
//        if (itemInSlot1.is(CustomTags.Items.BASE_TEA) && !outputTag.contains("TeaType")) {
//            applyBaseTeaType(outputTag, itemInSlot1);
//        }
//
//        if (itemInSlot1.is(CustomTags.Items.TELEPORTS) && !outputTag.contains("TP")) {
//            applyTeleportType(outputTag, itemInSlot1);
//        }
//
//        if (itemInSlot1.is(CustomTags.Items.MODS)) {
//            applyMods(outputTag, itemInSlot1);
//        }
//
//        if (itemInSlot1.is(CustomTags.Items.ADDITIVES)) {
//            applyAdditives(outputTag, itemInSlot1);
//        }
//
//        LogUtils.getLogger().info("assemble completed: output NBT: {}", outputCopy.getTag());
//
//        return outputCopy;
//    }
//
//    private void applyBaseTeaType(CompoundTag outputTag, ItemStack itemInSlot1) {
//        if (itemInSlot1.is(CustomTags.Items.GRASSY)) {
//            outputTag.putString("TeaType", "grassy");
//        } else if (itemInSlot1.is(CustomTags.Items.WARPED)) {
//            outputTag.putString("TeaType", "warped");
//        } else if (itemInSlot1.is(CustomTags.Items.CRIMSON)) {
//            outputTag.putString("TeaType", "crimson");
//        } else if (itemInSlot1.is(CustomTags.Items.LEAVY)) {
//            outputTag.putString("TeaType", "leavy");
//        } else if (itemInSlot1.is(CustomTags.Items.KELPED)) {
//            outputTag.putString("TeaType", "kelped");
//        } else if (itemInSlot1.is(CustomTags.Items.VINEY)) {
//            outputTag.putString("TeaType", "viney");
//        } else if (itemInSlot1.is(CustomTags.Items.GLOWY)) {
//            outputTag.putString("TeaType", "glowy");
//        } else if (itemInSlot1.is(CustomTags.Items.SCULKED)) {
//            outputTag.putString("TeaType", "sculked");
//        } else if (itemInSlot1.is(CustomTags.Items.ROOTED)) {
//            outputTag.putString("TeaType", "rooted");
//        }
//    }
//
//    private void applyTeleportType(CompoundTag outputTag, ItemStack itemInSlot1) {
//        if (itemInSlot1.is(CustomTags.Items.SPAWN)) {
//            outputTag.putString("TP", "spawn");
//        } else if (itemInSlot1.is(CustomTags.Items.OVERWORLD)) {
//            outputTag.putString("TP", "overworld");
//        } else if (itemInSlot1.is(CustomTags.Items.NETHER)) {
//            outputTag.putString("TP", "nether");
//        } else if (itemInSlot1.is(CustomTags.Items.END)) {
//            outputTag.putString("TP", "end");
//        }
//    }
//
//    private void applyMods(CompoundTag outputTag, ItemStack itemInSlot1) {
//        ListTag modList = outputTag.getList("Mods", 8);
//        if (itemInSlot1.is(Items.REDSTONE)) {
//            modList.add(StringTag.valueOf("redstone"));
//        } else if (itemInSlot1.is(Items.GLOWSTONE_DUST)) {
//            modList.add(StringTag.valueOf("glowstone"));
//        } else if (itemInSlot1.is(Items.GUNPOWDER)) {
//            modList.add(StringTag.valueOf("gunpowder"));
//        }
//        sortTagList(modList);
//        outputTag.put("Mods", modList);
//    }
//
//    private void applyAdditives(CompoundTag outputTag, ItemStack itemInSlot1) {
//        ListTag additivesList = outputTag.getList("Additives", 8);
//        if (itemInSlot1.is(CustomTags.Items.RED_STUFF)) {
//            additivesList.add(StringTag.valueOf("red_stuff"));
//        } else if (itemInSlot1.is(CustomTags.Items.GOLDEN_FRUIT)) {
//            additivesList.add(StringTag.valueOf("golden_fruit"));
//        } else if (itemInSlot1.is(CustomTags.Items.GOD_APPLE)) {
//            additivesList.add(StringTag.valueOf("god_apple"));
//        } else if (itemInSlot1.is(CustomTags.Items.SWEET)) {
//            additivesList.add(StringTag.valueOf("sweet"));
//        } else if (itemInSlot1.is(CustomTags.Items.GLOWING_FRUIT)) {
//            additivesList.add(StringTag.valueOf("glowing_fruit"));
//        } else if (itemInSlot1.is(CustomTags.Items.PINK_FLOWER)) {
//            additivesList.add(StringTag.valueOf("pink_flower"));
//        } else if (itemInSlot1.is(CustomTags.Items.YELLOW_FLOWER)) {
//            additivesList.add(StringTag.valueOf("yellow_flower"));
//        } else if (itemInSlot1.is(CustomTags.Items.WHITE_FLOWER)) {
//            additivesList.add(StringTag.valueOf("white_flower"));
//        } else if (itemInSlot1.is(CustomTags.Items.GREY_FLOWER)) {
//            additivesList.add(StringTag.valueOf("grey_flower"));
//        } else if (itemInSlot1.is(CustomTags.Items.BLUE_FLOWER)) {
//            additivesList.add(StringTag.valueOf("blue_flower"));
//        } else if (itemInSlot1.is(CustomTags.Items.PURPLE_FLOWER1)) {
//            additivesList.add(StringTag.valueOf("purple_flower_1"));
//        } else if (itemInSlot1.is(CustomTags.Items.PURPLE_FLOWER2)) {
//            additivesList.add(StringTag.valueOf("purple_flower_2"));
//        } else if (itemInSlot1.is(CustomTags.Items.RED_FLOWER)) {
//            additivesList.add(StringTag.valueOf("red_flower"));
//        } else if (itemInSlot1.is(CustomTags.Items.END_FLOWER)) {
//            additivesList.add(StringTag.valueOf("end_flower"));
//        } else if (itemInSlot1.is(CustomTags.Items.FIRE_FLOWER)) {
//            additivesList.add(StringTag.valueOf("fire_flower"));
//        } else if (itemInSlot1.is(CustomTags.Items.POT_FLOWER)) {
//            additivesList.add(StringTag.valueOf("pot_flower"));
//        } else if (itemInSlot1.is(CustomTags.Items.WING)) {
//            additivesList.add(StringTag.valueOf("wing"));
//        } else if (itemInSlot1.is(CustomTags.Items.FIRE)) {
//            additivesList.add(StringTag.valueOf("fire"));
//        } else if (itemInSlot1.is(CustomTags.Items.TORRID)) {
//            additivesList.add(StringTag.valueOf("torrid"));
//        } else if (itemInSlot1.is(CustomTags.Items.WITHER)) {
//            additivesList.add(StringTag.valueOf("wither_flower"));
//        }
//        sortTagList(additivesList);
//        outputTag.put("Additives", additivesList);
//    }


    public static void sortTagList(ListTag modList) {

        List<String> modNames = new ArrayList<>();
        for (Tag tag : modList) {
            if (tag instanceof StringTag) {
                modNames.add(tag.getAsString());
            }
        }
        modNames.sort(Comparator.naturalOrder());

        modList.clear();

        for (String modName : modNames) {
            modList.add(StringTag.valueOf(modName));
        }
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }


    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess access) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<KettleRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "kettle";
    }

    public static class Serializer implements RecipeSerializer<KettleRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Unwanted.MODID,"kettle");

        @Override
        public KettleRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new KettleRecipe(id, output, inputs);
        }

        @Override
        public KettleRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new KettleRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, KettleRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.output, false);
        }


        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
}
