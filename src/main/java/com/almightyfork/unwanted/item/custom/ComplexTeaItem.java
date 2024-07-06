package com.almightyfork.unwanted.item.custom;

import com.almightyfork.unwanted.item.ModItems;
import com.almightyfork.unwanted.potion.effect.ModEffects;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.gameevent.GameEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ComplexTeaItem extends Item {
    private static final int DRINK_DURATION = 32;

    public ComplexTeaItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        super.finishUsingItem(stack, world, entity);

        Player player = entity instanceof Player ? (Player)entity : null;
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverplayer = (ServerPlayer) entity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, stack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!world.isClientSide) {
            CompoundTag tag = stack.getTag();
            if (tag != null) {
                // Remove specified effects
                List<MobEffectInstance> effectsToRemove = getEffectsToRemove(tag);
                for (MobEffectInstance effectInstance : effectsToRemove) {
                    if (entity.hasEffect(effectInstance.getEffect())) {
                        entity.removeEffect(effectInstance.getEffect());
                    }
                }

                // Add specified effects
                List<MobEffectInstance> effectsToAdd = getEffectsToAdd(tag);
                for (MobEffectInstance effectInstance : effectsToAdd) {
                    entity.addEffect(new MobEffectInstance(effectInstance));
                }

                TryTeleport(stack.getTag(), entity);
            }
        }

        if (player == null || !player.getAbilities().instabuild) {
            if (stack.isEmpty()) {
                stack.shrink(1);
                return new ItemStack(ModItems.TEA_CUP.get());
            }

            if (player != null) {
                stack.shrink(1);
                player.getInventory().add(new ItemStack(ModItems.TEA_CUP.get()));
            }
        }

        entity.gameEvent(GameEvent.DRINK);
        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {

        if (stack.hasTag()) {
            CompoundTag tag = stack.getTag();
            if (tag.contains("Mods")) {
                ListTag mods = tag.getList("Mods", Tag.TAG_STRING);
                for (Tag ModTag : mods) {
                    String mod = ModTag.getAsString();

                    if (mod.equals("gunpowder")) {
                        return DRINK_DURATION / 2;
                    }
                }
            }
        }
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
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        CompoundTag tag = stack.getTag();
        if (tag != null) {
            tooltip.add(Component.literal("§cRemoved effects:"));
            List<MobEffectInstance> effectsToRemove = getEffectsToRemove(tag);
            for (MobEffectInstance effectInstance : effectsToRemove) {
                MutableComponent component = Component.translatable(effectInstance.getDescriptionId());
                tooltip.add(component.withStyle(effectInstance.getEffect().getCategory().getTooltipFormatting()));
            }
            tooltip.add(Component.literal(""));
            tooltip.add(Component.literal("§9Added effects:"));
            List<MobEffectInstance> effectsToAdd = getEffectsToAdd(tag);
            PotionUtils.addPotionTooltip(effectsToAdd, tooltip, 1.0F);

            tooltip.add(Component.literal(""));
            if (tag.contains("TP")) {
                String tp = tag.getString("TP");
                tooltip.add(Component.literal("§bTeleports to: " + tp));
                tooltip.add(Component.literal(""));
            }

            tooltip.add(Component.literal("§aMods:"));
            if (tag.contains("Mods")) {
                int redCount = 0;
                int glowCount = 0;
                ListTag mods = tag.getList("Mods", Tag.TAG_STRING);
                for (Tag ModTag : mods) {
                    String mod = ModTag.getAsString();
                    if (mod.equals("redstone")) {
                        redCount ++;
                    }
                    if (mod.equals("glowstone")) {
                        glowCount ++;
                    }
                }
                if (redCount > 0) {
                    tooltip.add(Component.literal("§aRedstone " + redCount + "x"));
                }
                if (glowCount > 0) {
                    tooltip.add(Component.literal("§aGlowstone Dust " + glowCount + "x"));
                }
                if (mods.toString().contains("gunpowder")) {
                    tooltip.add(Component.literal("§aGunpowder"));
                }
            }
        }
    }

    private List<MobEffectInstance> getEffectsToRemove(CompoundTag tag) {
        List<MobEffectInstance> effects = new ArrayList<>();
        String teaType = tag.getString("TeaType");

        switch (teaType) {
            case "grassy":
                effects.add(new MobEffectInstance(MobEffects.POISON));
                break;
            case "warped":
                effects.add(new MobEffectInstance(ModEffects.FRAGILE.get()));
                break;
            case "crimson":
                effects.add(new MobEffectInstance(MobEffects.WEAKNESS));
                break;
            case "leavy":
                effects.add(new MobEffectInstance(MobEffects.CONFUSION));
                break;
            case "kelped":
                effects.add(new MobEffectInstance(MobEffects.DIG_SLOWDOWN));
                break;
            case "viney":
                effects.add(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN));
                break;
            case "glowy":
                effects.add(new MobEffectInstance(MobEffects.GLOWING));
                break;
            case "sculked":
                effects.add(new MobEffectInstance(MobEffects.DARKNESS));
                effects.add(new MobEffectInstance(MobEffects.BLINDNESS));
                break;
            case "rooted":
                effects.add(new MobEffectInstance(MobEffects.HUNGER));
                break;
        }

        if (tag.contains("Additives")) {
            ListTag additives = tag.getList("Additives", Tag.TAG_STRING);
            for (Tag additiveTag : additives) {
                String additive = additiveTag.getAsString();

                if (additive.equals("white_flower")) {
                    effects.add(new MobEffectInstance(MobEffects.BAD_OMEN));
                }
                if (additive.equals("end_flower")) {
                    effects.add(new MobEffectInstance(MobEffects.LEVITATION));
                }
                if (additive.equals("wither_flower")) {
                    effects.add(new MobEffectInstance(MobEffects.WITHER));
                }
            }
        }

        return effects;
    }

    private List<MobEffectInstance> getEffectsToAdd(CompoundTag tag) {
        List<MobEffectInstance> effects = new ArrayList<>();

        if (tag.contains("Additives")) {
            ListTag additives = tag.getList("Additives", Tag.TAG_STRING);
            for (Tag additiveTag : additives) {
                String additive = additiveTag.getAsString();

                // fruits
                if (additive.equals("red_stuff")) {
                    if (!additives.toString().contains("golden_fruit")) {
                        if (!additives.toString().contains("god_apple")) {
                            effects.add(new MobEffectInstance(MobEffects.REGENERATION, 300, 0));
                        }
                    }
                }
                if (additive.equals("golden_fruit")) {
                    if (!additives.toString().contains("god_apple")) {
                        effects.add(new MobEffectInstance(MobEffects.REGENERATION, 600, 1));
                        effects.add(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0));
                    }
                }
                if (additive.equals("god_apple")) {
                    effects.add(new MobEffectInstance(MobEffects.REGENERATION, 800, 1));
                    effects.add(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3));
                    effects.add(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0));
                    effects.add(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0));
                }
                if (additive.equals("sweet")) {
                    effects.add(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0));
                    effects.add(new MobEffectInstance(MobEffects.JUMP, 300, 0));
                }
                if (additive.equals("glowing_fruit")) {
                    effects.add(new MobEffectInstance(MobEffects.GLOWING, 300, 0));
                }

                // flowers
                if (additive.equals("pink_flower")) {
                    effects.add(new MobEffectInstance(MobEffects.INVISIBILITY, 300, 0));
                }
                if (additive.equals("yellow_flower")) {
                    effects.add(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0));
                    effects.add(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0));
                }
                if (additive.equals("white_flower")) {
                    effects.add(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 300, 0));
                }
                if (additive.equals("grey_flower")) {
                    effects.add(new MobEffectInstance(MobEffects.SATURATION, 300, 0));
                }
                if (additive.equals("blue_flower")) {
                    effects.add(new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0));
                    effects.add(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 300, 0));
                    effects.add(new MobEffectInstance(MobEffects.CONDUIT_POWER, 300, 0));
                }
                if (additive.equals("purple_flower_1")) {
                    if (!additives.toString().contains("sweet")) {
                        effects.add(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0));
                    }
                }
                if (additive.equals("purple_flower_2")) {
                    if (!additives.toString().contains("sweet")) {
                        effects.add(new MobEffectInstance(MobEffects.JUMP, 300, 0));
                    }
                }
                if (additive.equals("red_flower")) {
                    effects.add(new MobEffectInstance(MobEffects.HEALTH_BOOST, 300, 0));
                    effects.add(new MobEffectInstance(MobEffects.HEAL, 300, 0));
                }
                if (additive.equals("end_flower")) {
                    effects.add(new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0));
                }
                if (additive.equals("fire_flower")) {
                    if (!additives.toString().contains("god_apple")) {
                        effects.add(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0));
                    }
                    effects.add(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0));
                }
                if (additive.equals("pot_flower")) {
                    if ((!additives.toString().contains("god_apple"))) {
                        if ((!additives.toString().contains("golden_fruit"))) {
                            effects.add(new MobEffectInstance(MobEffects.ABSORPTION, 300, 0));
                        }
                        effects.add(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 0));
                    }
                }

                // other
                if (additive.equals("wing")) {
                    effects.add(new MobEffectInstance(MobEffects.LEVITATION, 300, 0));
                }
                if (additive.equals("fire")) {
                    if (!additives.toString().contains("fire_flower")) {
                        effects.add(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0));
                    }
                }
                if (additive.equals("torrid")) {
                    if (!additives.toString().contains("yellow_flower")) {
                        effects.add(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0));
                    }
                }
            }
        }

        return ModifyEffects(effects, tag);
    }

    private List<MobEffectInstance> ModifyEffects(List<MobEffectInstance> effectInstanceList, CompoundTag tag) {

        if (tag.contains("Mods")) {
            ListTag mods = tag.getList("Mods", Tag.TAG_STRING);
            for (Tag ModTag : mods) {
                String mod = ModTag.getAsString();

                if (mod.equals("redstone")) {
                    for (MobEffectInstance effect : effectInstanceList) {
                        effect.update(new MobEffectInstance(effect.getEffect(), effect.getDuration() + 100, effect.getAmplifier()));
                    }
                }
                if (mod.equals("glowstone")) {
                    for (MobEffectInstance effect : effectInstanceList) {
                        if (effect.getAmplifier() < 4) {
                            effect.update(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier() + 1));
                        }
                    }
                }

            }
        }

        return effectInstanceList;
    }

    private void TryTeleport(CompoundTag tag, LivingEntity entity) {

        if (tag.contains("TP")) {
            String tpTarget = tag.getString("TP");

            if (tpTarget.equals("spawn")) {
                    if (entity instanceof ServerPlayer) {
                        ServerPlayer player = (ServerPlayer) entity;
                        BlockPos respawnPos = player.getRespawnPosition();
                        ServerLevel overworld = player.getServer().getLevel(Level.OVERWORLD);

                        if (respawnPos != null) {
                            if (player.level().dimension() == Level.OVERWORLD) {
                                player.teleportTo(respawnPos.getX(), respawnPos.getY(), respawnPos.getZ());
                            }
                            else if (player.level().dimension() == Level.NETHER){
                                player.changeDimension(overworld);
                                player.teleportTo(respawnPos.getX(), respawnPos.getY(), respawnPos.getZ());
                            }
                            else if (player.level().dimension() == Level.END){
                                player.changeDimension(overworld);
                                player.teleportTo(respawnPos.getX(), respawnPos.getY(), respawnPos.getZ());
                            }
                        }
                    }
                }
            else if (tpTarget.equals("overworld")) {
                    if (entity instanceof ServerPlayer) {
                        ServerPlayer player = (ServerPlayer) entity;
                        ServerLevel overworld = player.getServer().getLevel(Level.OVERWORLD);

                        if (player.level().dimension() == Level.OVERWORLD) {
                            BlockPos safePos = findSafePosition(overworld, new BlockPos(1, overworld.getLogicalHeight() / 2, 1));

                            if (safePos != null) {
                                player.teleportTo(safePos.getX(), safePos.getY(), safePos.getZ());
                            }
                        }
                        else if (player.level().dimension() == Level.NETHER) {
                            int overX = player.blockPosition().getX() * 8;
                            int overZ = player.blockPosition().getZ() * 8;

                            BlockPos safePos = findSafePosition(overworld, new BlockPos(overX, overworld.getLogicalHeight() / 2, overZ));

                            if (safePos != null) {
                                player.changeDimension(overworld);
                                player.teleportTo(safePos.getX(), safePos.getY(), safePos.getZ());
                            }
                        }
                        else if (player.level().dimension() == Level.END) {
                            BlockPos safePos = findSafePosition(overworld, new BlockPos(1, overworld.getLogicalHeight() / 2, 1));
                            if (safePos != null) {
                                player.changeDimension(overworld);
                                player.teleportTo(safePos.getX(), safePos.getY(), safePos.getZ());
                            }
                        }
                    }
                }
            else if (tpTarget.equals("nether")) {
                if (entity instanceof ServerPlayer) {
                    ServerPlayer player = (ServerPlayer) entity;
                    ServerLevel nether = player.getServer().getLevel(Level.NETHER);

                    if (player.level().dimension() == Level.NETHER) {
                        BlockPos safePos = findSafePosition(nether, new BlockPos(1, nether.getLogicalHeight() / 2, 1));

                        if (safePos != null) {
                            player.teleportTo(safePos.getX(), safePos.getY(), safePos.getZ());
                        }
                    }
                    else if (player.level().dimension() == Level.OVERWORLD) {
                        int netherX = player.blockPosition().getX() / 8;
                        int netherZ = player.blockPosition().getZ() / 8;

                        BlockPos safePos = findSafePosition(nether, new BlockPos(netherX, nether.getLogicalHeight() / 2, netherZ));

                        if (safePos != null) {
                            player.changeDimension(nether);
                            player.teleportTo(safePos.getX(), safePos.getY(), safePos.getZ());
                        }
                    }
                    else if (player.level().dimension() == Level.END) {
                        BlockPos safePos = findSafePosition(nether, new BlockPos(1, nether.getLogicalHeight() / 2, 1));
                        if (safePos != null) {
                            player.changeDimension(nether);
                            player.teleportTo(safePos.getX(), safePos.getY(), safePos.getZ());
                        }
                    }
                }
                }
            else if (tpTarget.equals("end")) {
                if (entity instanceof ServerPlayer) {
                    ServerPlayer player = (ServerPlayer) entity;
                    ServerLevel end = player.getServer().getLevel(Level.END);

                    if (player.level().dimension() == Level.NETHER) {
                        player.changeDimension(end);
                    }
                    else if (player.level().dimension() == Level.OVERWORLD) {
                        player.changeDimension(end);
                    }
                    else if (player.level().dimension() == Level.END) {
                        player.teleportTo(100, 49, 0);
                    }
                }
            }
        }
    }



    private BlockPos findSafePosition(ServerLevel world, BlockPos initialPos) {
        int minY = 0;
        int maxY = world.getLogicalHeight() - 3;
        BlockPos.MutableBlockPos checkPos = new BlockPos.MutableBlockPos(initialPos.getX(), minY, initialPos.getZ());

        for (int y = maxY - 3; y >= minY; y--) {
            checkPos.setY(y);
            if (world.getBlockState(checkPos).isSolid() && world.getBlockState(checkPos.above()).isAir() && world.getBlockState(checkPos.above(2)).isAir()) {
                return checkPos.above();
            }
        }
        return null;
    }
}

