package com.almightyfork.unwanted.potion.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class FragileEffct extends MobEffect {
    protected FragileEffct(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        // Increase the damage taken by the entity
        // You can do this by manipulating the damage taken in the relevant events
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true; // Ensure the effect is always ticking
    }
}
