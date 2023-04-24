package com.almightyfork.unwanted.item;

import com.almightyfork.unwanted.Unwanted;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Unwanted.MODID);

    // items

    public static final RegistryObject<Item> ROUGH_RUBY = ITEMS.register("rough_ruby",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PURE_RUBY = ITEMS.register("pure_ruby",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item>  CHISEL = ITEMS.register("chisel",
            () -> new Item(new Item.Properties().stacksTo(1).durability(256)));

    public static final RegistryObject<Item> NETHERITE_CHISEL = ITEMS.register("netherite_chisel",
            () -> new Item(new Item.Properties().fireResistant().stacksTo(1).durability(1024)));

    public static final RegistryObject<Item> TORRID_STEEL_INGOT = ITEMS.register("torrid_steel_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TORRID_STEEL_NUGGET = ITEMS.register("torrid_steel_nugget",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TORRID_STEEL_POWDER = ITEMS.register("torrid_steel_powder",
            () -> new Item(new Item.Properties().fireResistant()));

    //public static final RegistryObject<Item> PURE_BLAZE_POWDER = ITEMS.register("pure_blaze_powder",
    //       () -> new PureBlazePowderItem(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> MARBLE_SHARD = ITEMS.register("marble_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMBARIUM = ITEMS.register("embarium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLAZING_WATER = ITEMS.register("blazing_water",
            () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
