package com.almightyfork.unwanted.event;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.potion.effect.ModEffects;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Unwanted.MODID)
public class ModEventHandler {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if(event.getEntity().hasEffect(ModEffects.FRAGILE.get())) {
            float multiplier = (event.getEntity().getEffect(ModEffects.FRAGILE.get()).getAmplifier() + 1) * 0.5F;
            event.setAmount(event.getAmount() + multiplier);
        }
    }
}