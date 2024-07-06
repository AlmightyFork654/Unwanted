package com.almightyfork.unwanted.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class EbonyTrunkPlacer extends TrunkPlacer {
    public static final Codec<EbonyTrunkPlacer> CODEC = RecordCodecBuilder.create(ebonyTrunkPlacerInstance ->
            trunkPlacerParts(ebonyTrunkPlacerInstance).apply(ebonyTrunkPlacerInstance, EbonyTrunkPlacer::new));

    public EbonyTrunkPlacer(int baseHeight, int HeightRandA, int HeightRandB) {
        super(baseHeight, HeightRandA, HeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.EBONY_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int treeHeight, BlockPos pos, TreeConfiguration configuration) {

        List<FoliagePlacer.FoliageAttachment> list = new ArrayList();
        //Block placing logic
        setDirtAt(level, blockSetter, random, pos.below(), configuration);
        int height = treeHeight + random.nextInt(heightRandA - 1, heightRandA) + random.nextInt(heightRandB - 2, heightRandB);

        for(int i = 0; i < height; i++) {
            placeLog(level, blockSetter, random, pos.above(i), configuration);

            if (i != 0) {
                if ((i + 1) % 2 == 0) {
                    if(random.nextFloat() > 0.2) {
                        if (random.nextFloat() > 0.05) {
                            int x = random.nextInt(3, 4);
                            if (i >= 5) {
                                x = random.nextInt(i - 2, i);
                            }
                            for (int j = 0; j < x; j++) {
                                blockSetter.accept(pos.above(i).relative(Direction.NORTH, j), ((BlockState)
                                        Function.identity().apply(configuration.trunkProvider.getState(random, pos)
                                                .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
                                if(j == x-1) {
                                    int max = random.nextInt(2, 3);
                                    for (int h = 0; h < max; h++) {
                                        placeLog(level, blockSetter, random, pos.above(i + h).relative(Direction.NORTH, j), configuration);
                                        if (h == max-1) {
                                            list.add(new FoliagePlacer.FoliageAttachment(pos.above(h+i).offset(0, -1, -j), 0, false));
                                            if(random.nextFloat() < 0.3) {
                                                int nmax = random.nextInt(2, 4);
                                                for (int k = 0; k < nmax; k++) {
                                                    blockSetter.accept(pos.above(i + h).relative(Direction.NORTH, k + j), ((BlockState)
                                                            Function.identity().apply(configuration.trunkProvider.getState(random, pos)
                                                                    .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
                                                    if (k == nmax - 1){
                                                        list.add(new FoliagePlacer.FoliageAttachment(pos.above(h+i).offset(0, -1, -(j + k)), 0, false));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (random.nextFloat() > 0.05) {
                            int x = random.nextInt(3, 4);
                            if (i >= 5) {
                                x = random.nextInt(i - 2, i);
                            }
                            for (int j = 0; j < x; j++) {
                                blockSetter.accept(pos.above(i).relative(Direction.SOUTH, j), ((BlockState)
                                        Function.identity().apply(configuration.trunkProvider.getState(random, pos)
                                                .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
                                if(j == x-1) {
                                    int max = random.nextInt(2, 3);
                                    for (int h = 0; h < max; h++) {
                                        placeLog(level, blockSetter, random, pos.above(i + h).relative(Direction.SOUTH, j), configuration);
                                        if (h == max-1) {
                                            list.add(new FoliagePlacer.FoliageAttachment(pos.above(h+i).offset(0, -1, j), 0, false));
                                            if(random.nextFloat() < 0.3) {
                                                int nmax = random.nextInt(2, 4);
                                                for (int k = 0; k < nmax; k++) {
                                                    blockSetter.accept(pos.above(i + h).relative(Direction.SOUTH, k + j), ((BlockState)
                                                            Function.identity().apply(configuration.trunkProvider.getState(random, pos)
                                                                    .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
                                                    if (k == nmax - 1){
                                                        list.add(new FoliagePlacer.FoliageAttachment(pos.above(h+i).offset(0, -1, (j + k)), 0, false));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(random.nextFloat() > 0.2) {
                        if (random.nextFloat() > 0.05) {
                            int x = random.nextInt(3, 4);
                            if (i >= 5) {
                                x = random.nextInt(i - 2, i);
                            }
                            for (int j = 0; j < x; j++) {
                                blockSetter.accept(pos.above(i).relative(Direction.EAST, j), ((BlockState)
                                        Function.identity().apply(configuration.trunkProvider.getState(random, pos)
                                                .setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
                                if(j == x-1) {
                                    int max = random.nextInt(2, 3);
                                    for (int h = 0; h < max; h++) {
                                        placeLog(level, blockSetter, random, pos.above(i + h).relative(Direction.EAST, j), configuration);
                                        if (h == max-1) {
                                            list.add(new FoliagePlacer.FoliageAttachment(pos.above(h+i).offset(j, -1, 0), 0, false));
                                            if(random.nextFloat() < 0.3) {
                                                int nmax = random.nextInt(2, 4);
                                                for (int k = 0; k < nmax; k++) {
                                                    blockSetter.accept(pos.above(i + h).relative(Direction.EAST, k + j), ((BlockState)
                                                            Function.identity().apply(configuration.trunkProvider.getState(random, pos)
                                                                    .setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
                                                    if (k == nmax - 1){
                                                        list.add(new FoliagePlacer.FoliageAttachment(pos.above(h+i).offset((j+k), -1, 0), 0, false));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (random.nextFloat() > 0.05) {
                            int x = random.nextInt(3, 4);
                            if (i >= 5) {
                                x = random.nextInt(i - 2, i);
                            }
                            for (int j = 0; j < x; j++) {
                                blockSetter.accept(pos.above(i).relative(Direction.WEST, j), ((BlockState)
                                        Function.identity().apply(configuration.trunkProvider.getState(random, pos)
                                                .setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
                                if(j == x-1) {
                                    int max = random.nextInt(2, 3);
                                    for (int h = 0; h < max; h++) {
                                        placeLog(level, blockSetter, random, pos.above(i + h).relative(Direction.WEST, j), configuration);
                                        if (h == max-1) {
                                            list.add(new FoliagePlacer.FoliageAttachment(pos.above(h+i).offset(-j, -1, 0), 0, false));
                                            if(random.nextFloat() < 0.3) {
                                                int nmax = random.nextInt(2, 4);
                                                for (int k = 0; k < nmax; k++) {
                                                    blockSetter.accept(pos.above(i + h).relative(Direction.WEST, k + j), ((BlockState)
                                                            Function.identity().apply(configuration.trunkProvider.getState(random, pos)
                                                                    .setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
                                                    if (k == nmax - 1){
                                                        list.add(new FoliagePlacer.FoliageAttachment(pos.above(h+i).offset(-(j+k), -1, 0), 0, false));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        list.add(new FoliagePlacer.FoliageAttachment(pos.above(height), 0, false));

        return list;
    }
}
