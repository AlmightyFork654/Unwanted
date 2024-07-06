package com.almightyfork.unwanted.block.custom;

import com.almightyfork.unwanted.block.entity.ModHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModHangingSignBlock extends CeilingHangingSignBlock {
    public ModHangingSignBlock(Properties p_250481_, WoodType p_248716_) {
        super(p_250481_, p_248716_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pBlockState) {
        return new ModHangingSignBlockEntity(pPos, pBlockState);
    }
}
