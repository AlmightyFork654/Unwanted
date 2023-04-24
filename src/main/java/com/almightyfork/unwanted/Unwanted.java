package com.almightyfork.unwanted;

import com.almightyfork.unwanted.item.ModItems;
import com.almightyfork.unwanted.misc.ModCreativeModeTabs;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Unwanted.MODID)
public class Unwanted
{
    public static final String MODID = "unwanted";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Unwanted()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {

        if(event.getTab() == ModCreativeModeTabs.ITEMS_TAB) {
            event.accept(ModItems.ROUGH_RUBY);
            event.accept(ModItems.RUBY);
            event.accept(ModItems.PURE_RUBY);
            event.accept(ModItems.TORRID_STEEL_INGOT);
            event.accept(ModItems.TORRID_STEEL_NUGGET);
            event.accept(ModItems.TORRID_STEEL_POWDER);
            event.accept(ModItems.EMBARIUM);
            event.accept(ModItems.CHISEL);
            event.accept(ModItems.NETHERITE_CHISEL);
            event.accept(ModItems.MARBLE_SHARD);
            event.accept(ModItems.BLAZING_WATER);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
