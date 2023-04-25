package com.almightyfork.unwanted.item.tools;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

public class SuperSwordItem extends SwordItem {
    public SuperSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.setSecondsOnFire(4 + EnchantmentHelper.getEnchantmentLevel(Enchantments.FIRE_ASPECT, pAttacker) * 2);
        pAttacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 150, 6), pAttacker);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
