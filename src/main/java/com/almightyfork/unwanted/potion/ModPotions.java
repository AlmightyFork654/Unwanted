package com.almightyfork.unwanted.potion;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.potion.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, Unwanted.MODID);

    public static final RegistryObject<Potion> FRAGILE_POTION = POTIONS.register("fragile_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FRAGILE.get(), 1800, 0)));

    public static void register(IEventBus eventBus){
        POTIONS.register(eventBus);
    }
}
