package com.almightyfork.unwanted.misc;

import com.almightyfork.unwanted.Unwanted;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType EBONY = WoodType.register(new WoodType(Unwanted.MODID + ":ebony", BlockSetType.DARK_OAK));
}
