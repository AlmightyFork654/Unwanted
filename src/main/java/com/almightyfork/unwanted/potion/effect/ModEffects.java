package com.almightyfork.unwanted.potion.effect;

import com.almightyfork.unwanted.Unwanted;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Unwanted.MODID);

    public static final RegistryObject<MobEffect> FRAGILE = MOB_EFFECTS.register("fragile",
            () -> new FragileEffct(MobEffectCategory.HARMFUL, 176171129));

    public static void  register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
