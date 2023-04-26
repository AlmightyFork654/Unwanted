package com.almightyfork.unwanted.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SpeederBlock extends Block {
    public SpeederBlock(Properties p_56402_) {
        super(p_56402_);
    }

    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFloat) {
        if (pEntity.isSuppressingBounce()) {
            super.fallOn(pLevel, pState, pPos, pEntity, pFloat);
        } else {
            pEntity.causeFallDamage(pFloat, 0.0F, pLevel.damageSources().fall());
        }

    }

    public void updateEntityAfterFallOn(BlockGetter pGetter, Entity pEntity) {
        if (pEntity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(pGetter, pEntity);
        } else {
            this.bounceUp(pEntity);
        }

    }

    private void bounceUp(Entity pEntity) {
        Vec3 vec3 = pEntity.getDeltaMovement();
        if (vec3.y < 0.0D) {
            double d0 = pEntity instanceof LivingEntity ? 1.0D : 1.5D;
            pEntity.setDeltaMovement(vec3.x, -vec3.y * d0, vec3.z);
        }

    }

    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        double d0 = Math.abs(pEntity.getDeltaMovement().y);
        if (d0 < 0.1D && !pEntity.isSteppingCarefully()) {
            double d1 = 1.4D + d0 * 1.2D;
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().multiply(d1, 1.0D, d1));
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
