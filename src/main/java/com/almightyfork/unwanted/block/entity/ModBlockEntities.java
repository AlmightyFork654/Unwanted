package com.almightyfork.unwanted.block.entity;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.block.ModBlocks;
import com.almightyfork.unwanted.block.custom.ModHangingSignBlock;
import com.almightyfork.unwanted.block.entity.custom.GemCuttingStationBlockEntity;
import com.almightyfork.unwanted.block.entity.custom.GemInfuserBlockEntity;
import com.almightyfork.unwanted.block.entity.custom.KettleBlockEntity;
import com.almightyfork.unwanted.block.entity.custom.TorridFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
    DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Unwanted.MODID);

    public static final RegistryObject<BlockEntityType<GemCuttingStationBlockEntity>> GEM_CUTTING_STATION_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("gem_cutting_station_block_entity",
            () -> BlockEntityType.Builder.of(GemCuttingStationBlockEntity::new, ModBlocks.GEM_CUTTING_STATION.get()).build(null));

    public static final RegistryObject<BlockEntityType<GemInfuserBlockEntity>> GEM_INFUSER_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("gem_infuser_block_entity",
            () -> BlockEntityType.Builder.of(GemInfuserBlockEntity::new, ModBlocks.GEM_INFUSER.get()).build(null));

    public static final RegistryObject<BlockEntityType<TorridFurnaceBlockEntity>> TORRID_FURNACE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("torrid_furnace_block_entity",
            () -> BlockEntityType.Builder.of(TorridFurnaceBlockEntity::new, ModBlocks.TORRID_FURNACE.get()).build(null));

    public static final RegistryObject<BlockEntityType<KettleBlockEntity>> KETTLE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("kettle_block_entity",
            () -> BlockEntityType.Builder.of(KettleBlockEntity::new, ModBlocks.KETTLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN = BLOCK_ENTITY_TYPES.register("mod_sign",
            () -> BlockEntityType.Builder.of(ModSignBlockEntity::new, ModBlocks.EBONY_SIGN.get(), ModBlocks.EBONY_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN = BLOCK_ENTITY_TYPES.register("mod_hanging_sign",
            () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, ModBlocks.EBONY_HANGING_SIGN.get(), ModBlocks.EBONY_WALL_HANGING_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
