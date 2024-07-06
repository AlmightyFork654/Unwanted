package com.almightyfork.unwanted.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class EbonyFoliagePlacer extends FoliagePlacer {
    public static final Codec<EbonyFoliagePlacer> CODEC = RecordCodecBuilder.create(ebonyFoliagePlacerInstance ->
            foliagePlacerParts(ebonyFoliagePlacerInstance).and(Codec.intRange(0, 16)
                    .fieldOf("height").forGetter(fp -> fp.height)).apply(ebonyFoliagePlacerInstance, EbonyFoliagePlacer::new));

    private final int height;

    public EbonyFoliagePlacer(IntProvider interger1, IntProvider interger2, int height) {
        super(interger1, interger2);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.EBONY_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter setter, RandomSource source, TreeConfiguration config, int max, FoliageAttachment attachment, int height, int radius, int offset) {
        int i = radius + attachment.radiusOffset() - 2;
        this.placeLeavesRow(level, setter, source, config, attachment.pos().above(height -1), i - 1, 0, false);
        this.placeLeavesRow(level, setter, source, config, attachment.pos().above(height - 2), i, 0, false);
        this.placeLeavesRowWithHangingLeavesBelow(level, setter, source, config, attachment.pos().above(height - 3), 3, 0, false, 0.8F, 0.5F);
        this.placeLeavesRowWithHangingLeavesBelow(level, setter, source, config, attachment.pos().above(height - 4), 3, 0, false, 0.3F, 0.6F);
    }

    @Override
    public int foliageHeight(RandomSource p_225601_, int p_225602_, TreeConfiguration p_225603_) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource p_225595_, int p_225596_, int p_225597_, int p_225598_, int p_225599_, boolean p_225600_) {
        return false;
    }
}
