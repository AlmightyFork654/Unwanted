package com.almightyfork.unwanted.misc;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Unwanted.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {

    public static CreativeModeTab ITEMS_TAB;
    public static CreativeModeTab BLOCKS_TAB;
    public static CreativeModeTab SLABS_TAB;
    public static CreativeModeTab STAIRS_TAB;
    public static CreativeModeTab WALLS_TAB;
    public static CreativeModeTab TOOLS_TAB;
    public static CreativeModeTab COMBAT_TAB;
    public static CreativeModeTab REDSTONE_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ITEMS_TAB = event.registerCreativeModeTab(new ResourceLocation(Unwanted.MODID, "items_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.RUBY.get()))
                        .title(Component.translatable("itemGroup.ItemsTab")));

        BLOCKS_TAB = event.registerCreativeModeTab(new ResourceLocation(Unwanted.MODID, "blocks_tab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.MARBLE.get()))
                        .title(Component.translatable("itemGroup.BlocksTab")));

        SLABS_TAB = event.registerCreativeModeTab(new ResourceLocation(Unwanted.MODID, "slabs_tab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.MARBLE_SLAB.get()))
                        .title(Component.translatable("itemGroup.SlabsTab")));

        STAIRS_TAB = event.registerCreativeModeTab(new ResourceLocation(Unwanted.MODID, "stairs_tab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.MARBLE_STAIRS.get()))
                        .title(Component.translatable("itemGroup.StairsTab")));

        WALLS_TAB = event.registerCreativeModeTab(new ResourceLocation(Unwanted.MODID, "walls_tab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.MARBLE_WALL.get()))
                        .title(Component.translatable("itemGroup.WallsTab")));

        TOOLS_TAB = event.registerCreativeModeTab(new ResourceLocation(Unwanted.MODID, "tools_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.TORRID_EMBARIUM_SWORD.get()))
                        .title(Component.translatable("itemGroup.ToolsTab")));

        COMBAT_TAB = event.registerCreativeModeTab(new ResourceLocation(Unwanted.MODID, "combat_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.TORRID_EMBARIUM_CHESTPLATE.get()))
                        .title(Component.translatable("itemGroup.CombatTab")));

        REDSTONE_TAB = event.registerCreativeModeTab(new ResourceLocation(Unwanted.MODID, "redstone_tab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.EBONY_DOOR.get()))
                        .title(Component.translatable("itemGroup.RedstoneTab")));
    }
}
