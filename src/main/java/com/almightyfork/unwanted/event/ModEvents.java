package com.almightyfork.unwanted.event;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.item.ModItems;
import com.almightyfork.unwanted.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Unwanted.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        //Enchanter
        //lv1
        if(event.getType() == ModVillagers.ENCHANTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack lapis = new ItemStack(Items.LAPIS_LAZULI, 16);
            ItemStack ruby = new ItemStack(ModItems.RUBY.get(), 4);
            ItemStack obsidian = new ItemStack(Items.OBSIDIAN, 8);
            ItemStack cryingObsidian = new ItemStack(Items.CRYING_OBSIDIAN, 6);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(),4),
                    lapis,12,3,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.LAPIS_LAZULI,16),
                    ruby,12,3,0.025F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(),24),
                    obsidian,8,4,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(),30),
                    cryingObsidian,8,5,0.02F));
        }
        //lv2
        if(event.getType() == ModVillagers.ENCHANTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack bookshelf = new ItemStack(Items.BOOKSHELF, 8);
            ItemStack XP = new ItemStack(Items.EXPERIENCE_BOTTLE, 16);

            ItemStack BOA = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.BANE_OF_ARTHROPODS, 5));
            ItemStack smite = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.SMITE, 5));
            ItemStack luck = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.FISHING_LUCK, 3));
            ItemStack channeling = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.CHANNELING, 1));
            ItemStack quick_charge = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.QUICK_CHARGE, 3));
            ItemStack power = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.POWER_ARROWS, 5));
            ItemStack sweeping_edge = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.SWEEPING_EDGE, 3));
            ItemStack unbreaking = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.CHANNELING, 1));
            ItemStack fall = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.FALL_PROTECTION, 4));

            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 2),
                    bookshelf,4,1,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 4),
                    XP,12,4,0.02F));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 2),
                    BOA,8,4,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 3),
                    smite,6,5,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 2),
                    luck,8,4,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 4),
                    channeling,4,4,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 3),
                    quick_charge,6,4,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 4),
                    power,4,4,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 3),
                    sweeping_edge,6,4,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 6),
                    unbreaking,3,5,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 6),
                    fall,3,5,0.09F));
        }
        //lv3
        if(event.getType() == ModVillagers.ENCHANTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack enderPearl = new ItemStack(Items.ENDER_PEARL, 12);
            ItemStack enderEye = new ItemStack(Items.ENDER_EYE, 6);
            ItemStack blaze = new ItemStack(Items.BLAZE_POWDER, 8);
            ItemStack blaze_water = new ItemStack(ModItems.BLAZING_WATER.get(), 6);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 6),
                    enderPearl,8,6,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 12),
                    enderEye,6,6,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 12),
                    blaze,12,4,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 12),
                    blaze_water,12,4,0.02F));
        }
        //lv4
        if(event.getType() == ModVillagers.ENCHANTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack mending = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.MENDING, 1));
            ItemStack frostWalker = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.FROST_WALKER, 2));
            ItemStack soulSpeed = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.SOUL_SPEED, 3));
            ItemStack binding = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.BINDING_CURSE, 1));
            ItemStack vanishing = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.VANISHING_CURSE, 1));
            ItemStack prot = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.ALL_DAMAGE_PROTECTION, 4));
            ItemStack riptide = EnchantedBookItem.createForEnchantment(
                    new EnchantmentInstance(Enchantments.RIPTIDE, 3));
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 6),
                    mending,4,6,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 4),
                    frostWalker,2,6,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 5),
                    soulSpeed,2,6,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 2),
                    binding,4,6,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 2),
                   vanishing,4,6,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 5),
                    prot,4,6,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 5),
                    riptide,2,6,0.09F));
        }
        //lv5
        if(event.getType() == ModVillagers.ENCHANTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack Totem = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack Ruby = new ItemStack(ModItems.RUBY.get(), 64);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 64),
                    Totem,2,8,0.0F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.TOTEM_OF_UNDYING, 1),
                    Ruby,12,8,0.0F));
        }
        //Musician
        //lv1
        if(event.getType() == ModVillagers.MUSICIAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack cave = new ItemStack(ModItems.CAVE_WHISPERS_MUSIC_DISK.get(), 1);
            ItemStack note_block = new ItemStack(Items.NOTE_BLOCK, 4);
            ItemStack jukebox = new ItemStack(Items.JUKEBOX, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(),16),
                    cave,4,8,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(),16),
                    note_block,12,4,0.025F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(),6),
                    jukebox,8,4,0.02F));

        }
        //lv2
        if(event.getType() == ModVillagers.MUSICIAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack cat = new ItemStack(Items.MUSIC_DISC_CAT, 1);
            ItemStack ten_three = new ItemStack(Items.MUSIC_DISC_13, 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 18),
                    cat,4,5,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 18),
                    ten_three,4,5,0.02F));
        }
        //lv3
        if(event.getType() == ModVillagers.MUSICIAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack blocks = new ItemStack(Items.MUSIC_DISC_BLOCKS, 1);
            ItemStack chirp = new ItemStack(Items.MUSIC_DISC_CHIRP, 1);
            ItemStack far = new ItemStack(Items.MUSIC_DISC_FAR, 1);
            ItemStack mall = new ItemStack(Items.MUSIC_DISC_MALL, 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 24),
                    blocks,4,5,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 24),
                    chirp,4,5,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 28),
                    far,4,5,0.03F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 28),
                    mall,4,5,0.03F));
        }
        //lv4
        if(event.getType() == ModVillagers.MUSICIAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack mellohi = new ItemStack(Items.MUSIC_DISC_MELLOHI, 1);
            ItemStack stal = new ItemStack(Items.MUSIC_DISC_STAL, 1);
            ItemStack strad = new ItemStack(Items.MUSIC_DISC_FAR, 1);
            ItemStack ward = new ItemStack(Items.MUSIC_DISC_MALL, 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 32),
                    mellohi,4,5,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 32),
                    stal,4,5,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 36),
                    strad,4,5,0.03F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 36),
                    ward,4,5,0.03F));
        }
        //lv5
        if(event.getType() == ModVillagers.MUSICIAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack eleven = new ItemStack(Items.MUSIC_DISC_11, 1);
            ItemStack wait = new ItemStack(Items.MUSIC_DISC_WAIT, 1);
            ItemStack otherside = new ItemStack(Items.MUSIC_DISC_OTHERSIDE, 1);
            ItemStack pigstep = new ItemStack(Items.MUSIC_DISC_PIGSTEP, 1);
            ItemStack darkness = new ItemStack(ModItems.DARKNESS_MUSIC_DISK.get(), 1);
            ItemStack note_block = new ItemStack(Items.NOTE_BLOCK, 4);
            ItemStack jukebox = new ItemStack(Items.JUKEBOX, 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 56),
                    eleven,4,12,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 36),
                    wait,4,8,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 64),
                    otherside,4,16,0.0F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 64),
                    pigstep,4,16,0.0F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 64),
                    darkness,4,16,0.0F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(),16),
                    note_block,12,1,0.025F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(),6),
                    jukebox,8,2,0.02F));
        }
        //Gem Cutter
        //lv1
        if(event.getType() == ModVillagers.GEM_CUTTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack rough_ruby = new ItemStack(ModItems.ROUGH_RUBY.get(), 2);
            ItemStack ruby = new ItemStack(ModItems.RUBY.get(), 2);
            ItemStack pure_ruby = new ItemStack(ModItems.PURE_RUBY.get(), 2);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModBlocks.RUBY_ORE.get(),1),
                    rough_ruby,12,6,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.ROUGH_RUBY.get(),1),
                    ruby,8,6,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(),1),
                    pure_ruby,4,6,0.1F));
        }
        //lv2
        if(event.getType() == ModVillagers.GEM_CUTTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack embarium = new ItemStack(ModItems.EMBARIUM.get(), 4);
            ItemStack lapis = new ItemStack(Items.LAPIS_LAZULI, 6);
            ItemStack deep_lapis = new ItemStack(Items.LAPIS_LAZULI, 8);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModBlocks.EMBARIUM_ORE.get(),1),
                    embarium,12,6,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.LAPIS_ORE,1),
                    lapis,12,5,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.DEEPSLATE_LAPIS_ORE,1),
                        deep_lapis,10,5,0.1F));
        }
        //lv3
        if(event.getType() == ModVillagers.GEM_CUTTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack amethyst = new ItemStack(Items.AMETHYST_SHARD, 4);
            ItemStack emerald = new ItemStack(Items.EMERALD, 6);
            ItemStack deep_emerald = new ItemStack(Items.EMERALD, 8);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.AMETHYST_BLOCK,1),
                    amethyst,12,5,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD_ORE,1),
                    emerald,10,5,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.DEEPSLATE_EMERALD_ORE,1),
                    deep_emerald,10,6,0.1F));
        }
        //lv4
        if(event.getType() == ModVillagers.GEM_CUTTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack dia = new ItemStack(Items.DIAMOND, 6);
            ItemStack deep_dia = new ItemStack(Items.DIAMOND, 8);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND_ORE,1),
                    dia,10,5,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.DEEPSLATE_DIAMOND_ORE,1),
                    deep_dia,10,6,0.1F));
        }
        //lv5
        if(event.getType() == ModVillagers.GEM_CUTTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack Totem = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack Ruby = new ItemStack(ModItems.RUBY.get(), 64);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.RUBY.get(), 64),
                    Totem,2,8,0.0F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.TOTEM_OF_UNDYING, 1),
                    Ruby,12,8,0.0F));

            //temp
        }
    }
}
