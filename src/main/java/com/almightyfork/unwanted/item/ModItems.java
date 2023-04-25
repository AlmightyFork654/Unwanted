package com.almightyfork.unwanted.item;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.item.armor.FireArmorItem;
import com.almightyfork.unwanted.item.armor.SuperArmorItem;
import com.almightyfork.unwanted.item.tools.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> PURE_BLAZE_POWDER = ITEMS.register("pure_blaze_powder",
           () -> new PureBlazePowderItem(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> MARBLE_SHARD = ITEMS.register("marble_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMBARIUM = ITEMS.register("embarium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLAZING_WATER = ITEMS.register("blazing_water",
            () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

    //tools&armor

        //tools

    //embarium
    public static final RegistryObject<Item> EMBARIUM_SWORD = ITEMS.register("embarium_sword",
            () -> new RegenSwordItem(ModTiers.EMBARIUM, 3, 0.5f, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_PICKAXE = ITEMS.register("embarium_pickaxe",
            () -> new SpeedPickaxeItem(ModTiers.EMBARIUM, 1, 0f, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_AXE = ITEMS.register("embarium_axe",
            () -> new AxeItem(ModTiers.EMBARIUM, 6, 0.2f, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_SHOVEL = ITEMS.register("embarium_shovel",
            () -> new ShovelItem(ModTiers.EMBARIUM, 1, 0f, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_HOE = ITEMS.register("embarium_hoe",
            () -> new HoeItem(ModTiers.EMBARIUM, 0, 0f, new Item.Properties()));

    //torrid steel

    public static final RegistryObject<Item> TORRID_STEEL_SWORD = ITEMS.register("torrid_steel_sword",
            () -> new FireSwordItem(ModTiers.TORRID, 3, 0.5f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_STEEL_PICKAXE = ITEMS.register("torrid_steel_pickaxe",
            () -> new PickaxeItem(ModTiers.TORRID, 1, 0f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_STEEL_AXE = ITEMS.register("torrid_steel_axe",
            () -> new AxeItem(ModTiers.TORRID, 6, 0.2f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_STEEL_SHOVEL = ITEMS.register("torrid_steel_shovel",
            () -> new ShovelItem(ModTiers.TORRID, 1, 0f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_STEEL_HOE = ITEMS.register("torrid_steel_hoe",
            () -> new HoeItem(ModTiers.TORRID, 0, 0f, new Item.Properties().fireResistant()));


    //embarium torrid steel
    public static final RegistryObject<Item> TORRID_EMBARIUM_SWORD = ITEMS.register("torrid_embarium_sword",
            () -> new SuperSwordItem(ModTiers.TORRID_EMBARIUM, 3, 0.5f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_PICKAXE = ITEMS.register("torrid_embarium_pickaxe",
            () -> new SuperPickaxeItem(ModTiers.TORRID_EMBARIUM, 1, 0f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_AXE = ITEMS.register("torrid_embarium_axe",
            () -> new AxeItem(ModTiers.TORRID_EMBARIUM, 6, 0.2f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_SHOVEL = ITEMS.register("torrid_embarium_shovel",
            () -> new ShovelItem(ModTiers.TORRID_EMBARIUM, 1, 0f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_HOE = ITEMS.register("torrid_embarium_hoe",
            () -> new HoeItem(ModTiers.TORRID_EMBARIUM, 0, 0f, new Item.Properties().fireResistant()));

    //profundium

    //advanced

    //advanced wood&leather

    //advanced stone&chainmail

    //advanced iron

    //advanced gold

    //advanced diamond

    //advanced netherite

    //advanced profundium

    //armor

    //embarium

    public static final RegistryObject<Item> EMBARIUM_HELMET = ITEMS.register("embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, EquipmentSlot.HEAD, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_CHESTPLATE = ITEMS.register("embarium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, EquipmentSlot.CHEST, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_LEGGINGS = ITEMS.register("embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, EquipmentSlot.LEGS, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_BOOTS = ITEMS.register("embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, EquipmentSlot.FEET, new Item.Properties()));

    public static final RegistryObject<Item> TORRID_HELMET = ITEMS.register("torrid_steel_helmet",
            () -> new ArmorItem(ModArmorMaterials.TORRID, EquipmentSlot.HEAD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_CHESTPLATE = ITEMS.register("torrid_steel_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.TORRID, EquipmentSlot.CHEST, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_LEGGINGS = ITEMS.register("torrid_steel_leggings",
            () -> new ArmorItem(ModArmorMaterials.TORRID, EquipmentSlot.LEGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_BOOTS = ITEMS.register("torrid_steel_boots",
            () -> new ArmorItem(ModArmorMaterials.TORRID, EquipmentSlot.FEET, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TORRID_EMBARIUM_HELMET = ITEMS.register("torrid_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.TORRID_EMBARIUM, EquipmentSlot.HEAD, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_CHESTPLATE = ITEMS.register("torrid_embarium_chestplate",
            () -> new SuperArmorItem(ModArmorMaterials.TORRID_EMBARIUM, EquipmentSlot.CHEST, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_LEGGINGS = ITEMS.register("torrid_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.TORRID_EMBARIUM, EquipmentSlot.LEGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_BOOTS = ITEMS.register("torrid_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.TORRID_EMBARIUM, EquipmentSlot.FEET, new Item.Properties().fireResistant()));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
