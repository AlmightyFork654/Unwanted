package com.almightyfork.unwanted.entity;

import com.almightyfork.unwanted.Unwanted;
import com.almightyfork.unwanted.entity.custom.ModBoatEntity;
import com.almightyfork.unwanted.entity.custom.ModChestBoatEntity;
import com.almightyfork.unwanted.item.trident.iron.IronThrownSpear;
import com.almightyfork.unwanted.item.trident.wood.WoodenThrownSpear;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Unwanted.MODID);

    public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT =
            ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
                    MobCategory.MISC).sized(1.375f, 0.5625f).build("mod_boat"));
    public static final RegistryObject<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT =
            ENTITY_TYPES.register("mod_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new,
                    MobCategory.MISC).sized(1.375f, 0.5625f).build("mod_chest_boat"));

    public static final RegistryObject<EntityType<WoodenThrownSpear>> WOODEN_SPEAR =
            ENTITY_TYPES.register("wooden_spear", () -> EntityType.Builder.<WoodenThrownSpear>of(WoodenThrownSpear::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("wooden_spear"));

    public static final RegistryObject<EntityType<IronThrownSpear>> IRON_SPEAR =
            ENTITY_TYPES.register("iron_spear", () -> EntityType.Builder.<IronThrownSpear>of(IronThrownSpear::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("iron_spear"));


    public static void register(IEventBus eventBus) {ENTITY_TYPES.register(eventBus);}
}
