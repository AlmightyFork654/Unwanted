package com.almightyfork.unwanted.item;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.entity.custom.ModBoatEntity;
import com.almightyfork.unwanted.item.armor.*;
import com.almightyfork.unwanted.item.custom.*;
import com.almightyfork.unwanted.item.tools.*;
import com.almightyfork.unwanted.item.tools.pickaxe.SpeedPickaxeItem;
import com.almightyfork.unwanted.item.tools.pickaxe.SuperPickaxeItem;
import com.almightyfork.unwanted.item.tools.sword.FireSwordItem;
import com.almightyfork.unwanted.item.tools.sword.RegenSwordItem;
import com.almightyfork.unwanted.item.tools.sword.SuperSwordItem;
import com.almightyfork.unwanted.item.trident.iron.IronSpearItem;
import com.almightyfork.unwanted.item.trident.wood.WoodenSpearItem;
import com.almightyfork.unwanted.potion.effect.ModEffects;
import com.almightyfork.unwanted.sound.ModSounds;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Optional;

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

    public static final RegistryObject<Item> PROFUNDIUM_FLAKE = ITEMS.register("profundium_flake",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PROFUNDIUM_SCRAP = ITEMS.register("profundium_scrap",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PROFUNDIUM_INGOT = ITEMS.register("profundium_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> BLAZING_WATER = ITEMS.register("blazing_water",
            () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

    public static final RegistryObject<Item> GEM_INFUSER_ITEM = ITEMS.register("gem_infuser",
            () -> new GemInfuserItem(ModBlocks.GEM_INFUSER.get(), new Item.Properties()));

    public static final RegistryObject<Item> EBONY_SIGN = ITEMS.register("ebony_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.EBONY_SIGN.get(), ModBlocks.EBONY_WALL_SIGN.get()));
    public static final RegistryObject<Item> EBONY_HANGING_SIGN = ITEMS.register("ebony_hanging_sign",
            () -> new HangingSignItem(ModBlocks.EBONY_HANGING_SIGN.get(), ModBlocks.EBONY_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> EBONY_BOAT = ITEMS.register("ebony_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.EBONY, new Item.Properties()));
    public static final RegistryObject<Item> EBONY_CHEST_BOAT = ITEMS.register("ebony_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.EBONY, new Item.Properties()));

    public static final RegistryObject<Item> WOODEN_SPEAR_HEAD = ITEMS.register("wooden_spear_head",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TEA_CUP = ITEMS.register("tea_cup",
            ()-> new TeaCup(new Item.Properties()));

    public static final RegistryObject<Item> CUP_OF_WATER = ITEMS.register("cup_of_water",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GRASSY_TEA = ITEMS.register("grassy_tea",
            ()-> new ComplexTeaItem(new Item.Properties()));
    public static final RegistryObject<Item> WARPED_TEA = ITEMS.register("warped_tea",
            ()-> new ComplexTeaItem(new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_TEA = ITEMS.register("crimson_tea",
            ()-> new ComplexTeaItem(new Item.Properties()));
    public static final RegistryObject<Item> LEAVY_TEA = ITEMS.register("leavy_tea",
            ()-> new ComplexTeaItem(new Item.Properties()));
    public static final RegistryObject<Item> KELPED_TEA = ITEMS.register("kelped_tea",
            ()-> new ComplexTeaItem(new Item.Properties()));
    public static final RegistryObject<Item> VINEY_TEA = ITEMS.register("viney_tea",
            ()-> new ComplexTeaItem(new Item.Properties()));
    public static final RegistryObject<Item> GLOWY_TEA = ITEMS.register("glowy_tea",
            ()-> new ComplexTeaItem(new Item.Properties()));
    public static final RegistryObject<Item> SCULKED_TEA = ITEMS.register("sculked_tea",
            ()-> new ComplexTeaItem(new Item.Properties()));
    public static final RegistryObject<Item> ROOTED_TEA = ITEMS.register("rooted_tea",
            ()-> new ComplexTeaItem(new Item.Properties()));

    //music

    public static final RegistryObject<Item> DARKNESS_MUSIC_DISK = ITEMS.register("darkness_music_disc",
            () -> new ModDiskItem(15, ModSounds.DARKNESS, 69));

    public static final RegistryObject<Item> CAVE_WHISPERS_MUSIC_DISK = ITEMS.register("cave_whispers_music_disc",
            () -> new ModDiskItem(15, ModSounds.CAVE_WHISPERS, 132));

    //tools&armor

        //tools

    public static final RegistryObject<Item> WOODEN_SPEAR = ITEMS.register("wooden_spear",
            () -> new WoodenSpearItem(new Item.Properties().durability(32), 3.0D, -1F));

    public static final RegistryObject<Item> IRON_SPEAR = ITEMS.register("iron_spear",
            () -> new IronSpearItem(new Item.Properties().durability(64), 5.0D, -1F));

    //Ruby detector

    public static final RegistryObject<Item> RUBY_DETECTOR = ITEMS.register("ruby_detector",
            () -> new RubyDetectorItem(new Item.Properties().durability(32).fireResistant()));

    //embarium
    public static final RegistryObject<Item> EMBARIUM_SWORD = ITEMS.register("embarium_sword",
            () -> new RegenSwordItem(ModTiers.EMBARIUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_PICKAXE = ITEMS.register("embarium_pickaxe",
            () -> new SpeedPickaxeItem(ModTiers.EMBARIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_AXE = ITEMS.register("embarium_axe",
            () -> new AxeItem(ModTiers.EMBARIUM, 6.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_SHOVEL = ITEMS.register("embarium_shovel",
            () -> new ShovelItem(ModTiers.EMBARIUM, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_HOE = ITEMS.register("embarium_hoe",
            () -> new HoeItem(ModTiers.EMBARIUM, -2, -1.0F, new Item.Properties()));

    //torrid steel

    public static final RegistryObject<Item> TORRID_STEEL_SWORD = ITEMS.register("torrid_steel_sword",
            () -> new FireSwordItem(ModTiers.TORRID, 3, -2.4F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_STEEL_PICKAXE = ITEMS.register("torrid_steel_pickaxe",
            () -> new PickaxeItem(ModTiers.TORRID, 1, -2.8F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_STEEL_AXE = ITEMS.register("torrid_steel_axe",
            () -> new AxeItem(ModTiers.TORRID, 5.0F, -3.1F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_STEEL_SHOVEL = ITEMS.register("torrid_steel_shovel",
            () -> new ShovelItem(ModTiers.TORRID, 0.5F, -3.0F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_STEEL_HOE = ITEMS.register("torrid_steel_hoe",
            () -> new HoeItem(ModTiers.TORRID, -3, -1.0F, new Item.Properties().fireResistant()));


    //embarium torrid steel
    public static final RegistryObject<Item> TORRID_EMBARIUM_SWORD = ITEMS.register("torrid_embarium_sword",
            () -> new SuperSwordItem(ModTiers.TORRID_EMBARIUM, 3, -2.4F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_PICKAXE = ITEMS.register("torrid_embarium_pickaxe",
            () -> new SuperPickaxeItem(ModTiers.TORRID_EMBARIUM, 1, -2.8F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_AXE = ITEMS.register("torrid_embarium_axe",
            () -> new AxeItem(ModTiers.TORRID_EMBARIUM, 5.0F, -3.1F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_SHOVEL = ITEMS.register("torrid_embarium_shovel",
            () -> new ShovelItem(ModTiers.TORRID_EMBARIUM, 0.5F, -3.0F, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_HOE = ITEMS.register("torrid_embarium_hoe",
            () -> new HoeItem(ModTiers.TORRID_EMBARIUM, -3, -1.0F, new Item.Properties().fireResistant()));

    //profundium
    public static final RegistryObject<Item> PROFUNDIUM_SWORD = ITEMS.register("profundium_sword",
            () -> new SwordItem(ModTiers.PROFUNDIUM, 4, -1.4F, (new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> PROFUNDIUM_PICKAXE = ITEMS.register("profundium_pickaxe",
            () -> new PickaxeItem(ModTiers.PROFUNDIUM, 2, -2.4F, (new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> PROFUNDIUM_AXE = ITEMS.register("profundium_axe",
            () -> new AxeItem(ModTiers.PROFUNDIUM, 6.0F, -2.0F, (new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> PROFUNDIUM_SHOVEL = ITEMS.register("profundium_shovel",
            () -> new ShovelItem(ModTiers.PROFUNDIUM, 2.5F, -2.0F, (new Item.Properties()).fireResistant()));
    public static final RegistryObject<Item> PROFUNDIUM_HOE = ITEMS.register("profundium_hoe",
            () -> new HoeItem(ModTiers.PROFUNDIUM, -3, -1.0F, (new Item.Properties()).fireResistant()));

    //advanced

    //advanced wood&leather

    //advanced stone&chainmail

    //advanced iron

    //advanced gold

    //advanced diamond

    //advanced netherite

    //advanced profundium
        // Torrid, Embarium, Profundium...

    //armor

    //elytra armors

    public static final RegistryObject<Item> ELYTRA_GLIDER = ITEMS.register("elytra_glider",
            () -> new ElytraGliderItem(new Item.Properties().durability(128)));

    public static final RegistryObject<Item> MECHANICAL_ELYTRA = ITEMS.register("mechanical_elytra",
            () -> new MechanicalElytraItem(new Item.Properties().stacksTo(1)));

    //embarium

    public static final RegistryObject<Item> EMBARIUM_HELMET = ITEMS.register("embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_CHESTPLATE = ITEMS.register("embarium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_LEGGINGS = ITEMS.register("embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> EMBARIUM_BOOTS = ITEMS.register("embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> TORRID_HELMET = ITEMS.register("torrid_steel_helmet",
            () -> new ArmorItem(ModArmorMaterials.TORRID, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_CHESTPLATE = ITEMS.register("torrid_steel_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.TORRID, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_LEGGINGS = ITEMS.register("torrid_steel_leggings",
            () -> new ArmorItem(ModArmorMaterials.TORRID, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_BOOTS = ITEMS.register("torrid_steel_boots",
            () -> new ArmorItem(ModArmorMaterials.TORRID, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TORRID_EMBARIUM_HELMET = ITEMS.register("torrid_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.TORRID_EMBARIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_CHESTPLATE = ITEMS.register("torrid_embarium_chestplate",
            () -> new SuperArmorItem(ModArmorMaterials.TORRID_EMBARIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_LEGGINGS = ITEMS.register("torrid_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.TORRID_EMBARIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> TORRID_EMBARIUM_BOOTS = ITEMS.register("torrid_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.TORRID_EMBARIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> PROFUNDIUM_HELMET = ITEMS.register("profundium_helmet",
            () -> new ProArmorItem(ModArmorMaterials.PROFUNDIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> PROFUNDIUM_CHESTPLATE = ITEMS.register("profundium_chestplate",
            () -> new ProArmorItem(ModArmorMaterials.PROFUNDIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> PROFUNDIUM_LEGGINGS = ITEMS.register("profundium_leggings",
            () -> new ProArmorItem(ModArmorMaterials.PROFUNDIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> PROFUNDIUM_BOOTS = ITEMS.register("profundium_boots",
            () -> new ProArmorItem(ModArmorMaterials.PROFUNDIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
