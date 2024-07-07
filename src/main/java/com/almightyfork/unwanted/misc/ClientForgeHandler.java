package com.almightyfork.unwanted.misc;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.item.armor.MechanicalElytraItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.RelativeMovement;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.EnumSet;

@Mod.EventBusSubscriber(modid = Unwanted.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeHandler {

    private static final long COOLDOWN = 5000; // 5 seconds cooldown
    private static long lastBoostTime = 0;

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        LocalPlayer player = Minecraft.getInstance().player;

        if (player != null) {
            if (KeyBindings.KEY_BINDINGS.boost.isDown() && player.isFallFlying() && player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof MechanicalElytraItem) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastBoostTime >= COOLDOWN) {
                    boostPlayer(player);
                    lastBoostTime = currentTime;
                }
                else {
                    Minecraft.getInstance().player.displayClientMessage(Component.literal("Can Not Boost Yet."), true);
                }
            }

//            if (KeyBindings.KEY_BINDINGS.craw.isDown() && !player.isSpectator() && player.onGround()) {
//                toggleCrawlMode(player);
//            }
        }
    }

    private static void boostPlayer(LocalPlayer player) {
        float boostSpeed = 3.0f; // Adjust boost speed as needed
        player.setDeltaMovement(player.getLookAngle().scale(boostSpeed));
    }

//    private static void toggleCrawlMode(LocalPlayer player) {
//        if (player.getPose() == Pose.STANDING) {
//            player.setPose(Pose.SWIMMING);
//        } else if (player.getPose() == Pose.SWIMMING) {
//            player.setPose(Pose.STANDING);
//        }
//
//        // Send a position packet to update the player's bounding box
//        EnumSet<RelativeMovement> relativeArguments = EnumSet.noneOf(RelativeMovement.class);
//        player.connection.send(new ClientboundPlayerPositionPacket(player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot(), relativeArguments, 0));
//    }
}
