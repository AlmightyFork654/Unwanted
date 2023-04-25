package com.almightyfork.unwanted.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NetherFlowerBlock extends BushBlock {
    protected static final float AABB_OFFSET = 3.0F;
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private final MobEffect suspiciousStewEffect;
    private final int effectDuration;

    public NetherFlowerBlock(MobEffect p_53512_, int p_53513_, Properties p_53514_) {
        super(p_53514_);
        this.suspiciousStewEffect = p_53512_;
        if (p_53512_.isInstantenous()) {
            this.effectDuration = p_53513_;
        } else {
            this.effectDuration = p_53513_ * 20;
        }

    }

    public VoxelShape getShape(BlockState p_53517_, BlockGetter p_53518_, BlockPos p_53519_, CollisionContext p_53520_) {
        Vec3 vec3 = p_53517_.getOffset(p_53518_, p_53519_);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public MobEffect getSuspiciousStewEffect() {
        return this.suspiciousStewEffect;
    }

    public int getEffectDuration() {
        return this.effectDuration;
    }

    protected boolean mayPlaceOn(BlockState p_54960_, BlockGetter p_54961_, BlockPos p_54962_) {
        return p_54960_.is(BlockTags.NYLIUM) || p_54960_.is(Blocks.SOUL_SOIL) || p_54960_.is(BlockTags.BASE_STONE_NETHER) || super.mayPlaceOn(p_54960_, p_54961_, p_54962_);
    }
}
