package com.almightyfork.unwanted.potion.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class EnergyEffect extends MobEffect {
    protected EnergyEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int pAmplifier) {
        if (!livingEntity.level.isClientSide()){
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200, 1));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 1));
            livingEntity.setAbsorptionAmount(20F);
            livingEntity.setSprinting(true);
        }
        super.applyEffectTick(livingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        return true;
    }
}
