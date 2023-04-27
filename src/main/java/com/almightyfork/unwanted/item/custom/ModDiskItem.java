package com.almightyfork.unwanted.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class ModDiskItem extends RecordItem {

    public ModDiskItem(int comparatorValue, Supplier<SoundEvent> soundSupplier, int lengthInSeconds) {
        super(comparatorValue, soundSupplier, new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.RARE), lengthInSeconds * 20);
    }
}
