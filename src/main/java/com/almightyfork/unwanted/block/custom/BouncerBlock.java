package com.almightyfork.unwanted.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BouncerBlock extends Block {

    public BouncerBlock(Properties pProperties) {
        super(pProperties);

        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pGetter, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(FACING)) {
            case EAST:
                return EAST;
            case SOUTH:
                return SOUTH;
            case WEST:
                return WEST;
            default:
                return NORTH;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public BlockState rotate(BlockState pState, LevelAccessor pWorld, BlockPos pPos, Rotation pDirection) {
        return pState.setValue(FACING, pDirection.rotate(pState.getValue(FACING)));
    }

    public static final VoxelShape NORTH1 = Shapes.box(0, 0, 0, 1, 0.875, 1);
    public static final VoxelShape NORTH2 = Shapes.box(0.125, 0.875, 0, 0.875, 0.9375, 1);
    public static final VoxelShape NORTH3 = Shapes.box(0.3125, 0.9375, 0, 0.6875, 1, 1);
    public static final VoxelShape NORTH = Shapes.or(NORTH1, NORTH2, NORTH3);

    public static final VoxelShape SOUTH1 = Shapes.box(0, 0, 0, 1, 0.875, 1);
    public static final VoxelShape SOUTH2 = Shapes.box(0.125, 0.875, 0, 0.875, 0.9375, 1);
    public static final VoxelShape SOUTH3 = Shapes.box(0.3125, 0.9375, 0, 0.6875, 1, 1);
    public static final VoxelShape SOUTH = Shapes.or(SOUTH1, SOUTH2, SOUTH3);

    public static final VoxelShape EAST1 = Shapes.box(0, 0, 0, 1, 0.875, 1);
    public static final VoxelShape EAST2 = Shapes.box(0, 0.875, 0.125, 1, 0.9375, 0.875);
    public static final VoxelShape EAST3 = Shapes.box(0, 0.9375, 0.3125, 1, 1, 0.6875);
    public static final VoxelShape EAST = Shapes.or(EAST1, EAST2, EAST3);

    public static final VoxelShape WEST1 = Shapes.box(0, 0, 0, 1, 0.875, 1);
    public static final VoxelShape WEST2 = Shapes.box(0, 0.875, 0.125, 1, 0.9375, 0.875);
    public static final VoxelShape WEST3 = Shapes.box(0, 0.9375, 0.3125, 1, 1, 0.6875);
    public static final VoxelShape WEST = Shapes.or(WEST1, WEST2, WEST3);

    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFloat) {
        if (pEntity.isSuppressingBounce()) {
            super.fallOn(pLevel, pState, pPos, pEntity, pFloat);
        } else {
            pEntity.causeFallDamage(pFloat, 0.0F, DamageSource.FALL);
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
            pEntity.setDeltaMovement(vec3.x, -vec3.y +0.3D * d0, vec3.z);
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

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        super.createBlockStateDefinition(builder);
    }
}
