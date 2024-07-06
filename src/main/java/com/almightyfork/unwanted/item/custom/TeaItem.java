package com.almightyfork.unwanted.item.custom;

import com.almightyfork.unwanted.item.ModItems;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TeaItem extends Item {
    private static final int DRINK_DURATION = 32;
    private final List<MobEffectInstance> effectsToRemove;
    private final Optional<List<MobEffectInstance>> effectsToGive;

    public TeaItem(Item.Properties properties, List<MobEffectInstance> effectsToRemove, Optional<List<MobEffectInstance>> effectsToGive) {
        super(properties);
        this.effectsToRemove = effectsToRemove;
        this.effectsToGive = effectsToGive;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        super.finishUsingItem(stack, world, entity);
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverplayer = (ServerPlayer)entity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, stack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!world.isClientSide) {
            for (MobEffectInstance effectInstance : effectsToRemove) {
                if (entity.hasEffect(effectInstance.getEffect())) {
                    entity.removeEffect(effectInstance.getEffect());
                }
            }

            effectsToGive.ifPresent(effects -> {
                for (MobEffectInstance effectInstance : effects) {
                    entity.addEffect(new MobEffectInstance(effectInstance));
                }
            });
        }

        if (stack.isEmpty()) {
            return new ItemStack(ModItems.TEA_CUP.get());
        } else {
            if (entity instanceof Player && !((Player)entity).getAbilities().instabuild) {
                ItemStack itemstack = new ItemStack(ModItems.TEA_CUP.get());
                Player player = (Player)entity;
                if (!player.getInventory().add(itemstack)) {
                    player.drop(itemstack, false);
                }
            }

            return stack;
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return DRINK_DURATION;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        List<Pair<Attribute, AttributeModifier>> removedList = Lists.newArrayList();
        pTooltipComponents.add(Component.literal("§cRemoved effects:"));
        for(MobEffectInstance mobeffectinstance : effectsToRemove) {
            MutableComponent mutablecomponent = Component.translatable(mobeffectinstance.getDescriptionId());
            MobEffect mobeffect = mobeffectinstance.getEffect();
            Map<Attribute, AttributeModifier> map = mobeffect.getAttributeModifiers();
            if (!map.isEmpty()) {
                for(Map.Entry<Attribute, AttributeModifier> entry : map.entrySet()) {
                    AttributeModifier attributemodifier = entry.getValue();
                    AttributeModifier attributemodifier1 = new AttributeModifier(attributemodifier.getName(), mobeffect.getAttributeModifierValue(mobeffectinstance.getAmplifier(), attributemodifier), attributemodifier.getOperation());
                    removedList.add(new Pair<>(entry.getKey(), attributemodifier1));
                }
            }

            pTooltipComponents.add(mutablecomponent.withStyle(mobeffect.getCategory().getTooltipFormatting()));
        }
        List<Pair<Attribute, AttributeModifier>> addedList = Lists.newArrayList();
        effectsToGive.ifPresent(effects -> {
            pTooltipComponents.add(Component.literal("§9Added effects:"));
            for(MobEffectInstance mobeffectinstance : effects) {
                MutableComponent mutablecomponent = Component.translatable(mobeffectinstance.getDescriptionId());
                MobEffect mobeffect = mobeffectinstance.getEffect();
                Map<Attribute, AttributeModifier> map = mobeffect.getAttributeModifiers();
                if (!map.isEmpty()) {
                    for(Map.Entry<Attribute, AttributeModifier> entry : map.entrySet()) {
                        AttributeModifier attributemodifier = entry.getValue();
                        AttributeModifier attributemodifier1 = new AttributeModifier(attributemodifier.getName(), mobeffect.getAttributeModifierValue(mobeffectinstance.getAmplifier(), attributemodifier), attributemodifier.getOperation());
                        addedList.add(new Pair<>(entry.getKey(), attributemodifier1));
                    }
                }

                if (mobeffectinstance.getAmplifier() > 0) {
                    mutablecomponent = Component.translatable("potion.withAmplifier", mutablecomponent, Component.translatable("potion.potency." + mobeffectinstance.getAmplifier()));
                }

//                if (!mobeffectinstance.endsWithin(20)) {
//                    mutablecomponent = Component.translatable("potion.withDuration", mutablecomponent, MobEffectUtil.formatDuration(mobeffectinstance, p_259949_));
//                }

                pTooltipComponents.add(mutablecomponent.withStyle(mobeffect.getCategory().getTooltipFormatting()));
            }
        });
    }
}