package com.almightyfork.unwanted.block.custom;

import com.almightyfork.unwanted.block.entity.ModHangingSignBlockEntity;
import com.almightyfork.unwanted.block.entity.ModSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWallHangingSignBlock extends WallHangingSignBlock {
    public ModWallHangingSignBlock(Properties p_251606_, WoodType p_252140_) {
        super(p_251606_, p_252140_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pBlockState) {
        return new ModHangingSignBlockEntity(pPos, pBlockState);
    }
}
