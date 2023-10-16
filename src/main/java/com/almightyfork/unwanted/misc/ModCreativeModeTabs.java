package com.almightyfork.unwanted.misc;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Unwanted.MODID);

    public static RegistryObject<CreativeModeTab> ITEMS_TAB = CREATIVE_MODE_TABS.register("items_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("itemGroup.ItemsTab")).build());
    public static RegistryObject<CreativeModeTab> BLOCKS_TAB = CREATIVE_MODE_TABS.register("blocks_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MARBLE.get()))
                    .title(Component.translatable("itemGroup.BlocksTab")).build());
    public static RegistryObject<CreativeModeTab> SLABS_TAB = CREATIVE_MODE_TABS.register("slabs_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MARBLE_SLAB.get()))
                    .title(Component.translatable("itemGroup.SlabsTab")).build());
    public static RegistryObject<CreativeModeTab> STAIRS_TAB = CREATIVE_MODE_TABS.register("stairs_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MARBLE_STAIRS.get()))
                    .title(Component.translatable("itemGroup.StairsTab")).build());
    public static RegistryObject<CreativeModeTab> WALLS_TAB = CREATIVE_MODE_TABS.register("walls_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MARBLE_WALL.get()))
                    .title(Component.translatable("itemGroup.WallsTab")).build());
    public static RegistryObject<CreativeModeTab> TOOLS_TAB = CREATIVE_MODE_TABS.register("tools_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TORRID_EMBARIUM_SWORD.get()))
                    .title(Component.translatable("itemGroup.ToolsTab")).build());
    public static RegistryObject<CreativeModeTab> COMBAT_TAB = CREATIVE_MODE_TABS.register("combat_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TORRID_EMBARIUM_CHESTPLATE.get()))
                    .title(Component.translatable("itemGroup.CombatTab")).build());
    public static RegistryObject<CreativeModeTab> REDSTONE_TAB = CREATIVE_MODE_TABS.register("redstone_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.EBONY_DOOR.get()))
                    .title(Component.translatable("itemGroup.RedstoneTab")).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
