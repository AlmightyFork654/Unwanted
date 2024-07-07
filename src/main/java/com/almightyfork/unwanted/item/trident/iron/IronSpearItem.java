package com.almightyfork.unwanted.item.trident.iron;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class IronSpearItem extends Item implements Vanishable {
    public static final int THROW_THRESHOLD_TIME = 10;
    public static final float BASE_DAMAGE = 5.0F;
    public static final float SHOOT_POWER = 3.5F;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    public final float damageVal;

    public IronSpearItem(Item.Properties p_43381_, double damage, float speed) {
        super(p_43381_);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", damage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double)speed, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
        this.damageVal = ((float) damage);
    }

    public boolean canAttackBlock(BlockState p_43409_, Level p_43410_, BlockPos p_43411_, Player p_43412_) {
        return !p_43412_.isCreative();
    }

    public UseAnim getUseAnimation(ItemStack p_43417_) {
        return UseAnim.SPEAR;
    }

    public int getUseDuration(ItemStack p_43419_) {
        return 48000;
    }

//    public void releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
//        if (p_43396_ instanceof Player player) {
//            int i = this.getUseDuration(p_43394_) - p_43397_;
//            if (i >= 10) {
//                int j = EnchantmentHelper.getRiptide(p_43394_);
//                if (j <= 0 || player.isInWaterOrRain()) {
//                    if (!p_43395_.isClientSide) {
//                        p_43394_.hurtAndBreak(1, player, (p_43388_) -> {
//                            p_43388_.broadcastBreakEvent(p_43396_.getUsedItemHand());
//                        });
//                        if (j == 0) {
//                            ThrownSpear thrownSpear = new ThrownSpear(p_43395_, player, p_43394_);
//                            thrownSpear.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + (float)j * 0.5F, 1.0F);
//                            if (player.getAbilities().instabuild) {
//                                thrownSpear.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
//                            }
//
//                            p_43395_.addFreshEntity(thrownSpear);
//                            p_43395_.playSound((Player)null, thrownSpear, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
//                            if (!player.getAbilities().instabuild) {
//                                player.getInventory().removeItem(p_43394_);
//                            }
//                        }
//                    }
//
//                    player.awardStat(Stats.ITEM_USED.get(this));
//                    if (j > 0) {
//                        float f7 = player.getYRot();
//                        float f = player.getXRot();
//                        float f1 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
//                        float f2 = -Mth.sin(f * ((float)Math.PI / 180F));
//                        float f3 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
//                        float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
//                        float f5 = 3.0F * ((1.0F + (float)j) / 4.0F);
//                        f1 *= f5 / f4;
//                        f2 *= f5 / f4;
//                        f3 *= f5 / f4;
//                        player.push((double)f1, (double)f2, (double)f3);
//                        player.startAutoSpinAttack(20);
//                        if (player.onGround()) {
//                            float f6 = 1.1999999F;
//                            player.move(MoverType.SELF, new Vec3(0.0D, (double)1.1999999F, 0.0D));
//                        }
//
//                        SoundEvent soundevent;
//                        if (j >= 3) {
//                            soundevent = SoundEvents.TRIDENT_RIPTIDE_3;
//                        } else if (j == 2) {
//                            soundevent = SoundEvents.TRIDENT_RIPTIDE_2;
//                        } else {
//                            soundevent = SoundEvents.TRIDENT_RIPTIDE_1;
//                        }
//
//                        p_43395_.playSound((Player)null, player, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
//                    }
//
//                }
//            }
//        }
//    }

    public void releaseUsing (ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof Player player) {
            int i = this.getUseDuration(p_43394_) - p_43397_;
            if (i >= 10) {
                IronThrownSpear thrownSpear = new IronThrownSpear(p_43395_, player, p_43394_, damageVal);
                thrownSpear.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + (float) 0 * 0.5F, 1.0F);
                if (player.getAbilities().instabuild) {
                    thrownSpear.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                }

                p_43395_.addFreshEntity(thrownSpear);
                p_43395_.playSound((Player) null, thrownSpear, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!player.getAbilities().instabuild) {
                    player.getInventory().removeItem(p_43394_);
                }
            }
        }
    }

    public InteractionResultHolder<ItemStack> use(Level p_43405_, Player p_43406_, InteractionHand p_43407_) {
        ItemStack itemstack = p_43406_.getItemInHand(p_43407_);
        if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 1) {
            return InteractionResultHolder.fail(itemstack);
//        } else if (EnchantmentHelper.getRiptide(itemstack) > 0 && !p_43406_.isInWaterOrRain()) {
//            return InteractionResultHolder.fail(itemstack);
        } else {
            p_43406_.startUsingItem(p_43407_);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public boolean hurtEnemy(ItemStack p_43390_, LivingEntity p_43391_, LivingEntity p_43392_) {
        p_43390_.hurtAndBreak(1, p_43392_, (p_43414_) -> {
            p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean mineBlock(ItemStack p_43399_, Level p_43400_, BlockState p_43401_, BlockPos p_43402_, LivingEntity p_43403_) {
        if ((double)p_43401_.getDestroySpeed(p_43400_, p_43402_) != 0.0D) {
            p_43399_.hurtAndBreak(2, p_43403_, (p_43385_) -> {
                p_43385_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_43383_) {
        return p_43383_ == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(p_43383_);
    }

    public int getEnchantmentValue() {
        return 2;
    }

    public boolean isValidRepairItem(ItemStack p_43091_, ItemStack p_43092_) {
        return p_43092_.is(Items.IRON_INGOT) || super.isValidRepairItem(p_43091_, p_43092_);
    }
}
