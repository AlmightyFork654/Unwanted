package com.almightyfork.unwanted.block.entity.custom;

import com.almightyfork.unwanted.block.entity.ModBlockEntities;
import com.almightyfork.unwanted.item.ModItems;
import com.almightyfork.unwanted.recipe.GemInfuserRecipe;
import com.almightyfork.unwanted.screen.GemInfuserMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;


import javax.annotation.Nonnull;
import java.util.Optional;

public class GemInfuserBlockEntity extends BlockEntity implements MenuProvider, GeoBlockEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;

    public GemInfuserBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.GEM_INFUSER_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0: return GemInfuserBlockEntity.this.progress;
                    case 1: return GemInfuserBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: GemInfuserBlockEntity.this.progress = value; break;
                    case 1: GemInfuserBlockEntity.this.maxProgress = value; break;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Gem Infuser");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new GemInfuserMenu(pContainerId, pInventory, this, this.data);

    }
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("gem_infuser.progress", progress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("gem_infuser.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, GemInfuserBlockEntity pBlockEntity) {
        if(hasRecipe(pBlockEntity)) {
            pBlockEntity.progress++;
            setChanged(pLevel, pPos, pState);
            if(pBlockEntity.progress > pBlockEntity.maxProgress) {
                craftItem(pBlockEntity);
            }
        } else {
            pBlockEntity.resetProgress();
            setChanged(pLevel, pPos, pState);
        }
    }

    public static boolean hasRecipe(GemInfuserBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<GemInfuserRecipe> match = level.getRecipeManager()
                .getRecipeFor(GemInfuserRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().output)
                && hasWaterInWaterSlot(entity);
    }

    private static boolean hasWaterInWaterSlot(GemInfuserBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(0).getItem() == ModItems.BLAZING_WATER.get();
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    private static boolean hasGemInGemSlot(GemInfuserBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).getItem() == ModItems.EMBARIUM.get();
    }

    public static void craftItem(GemInfuserBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<GemInfuserRecipe> match = level.getRecipeManager()
                .getRecipeFor(GemInfuserRecipe.Type.INSTANCE, inventory, level);

        if(match.isPresent()) {
            ItemStack input = entity.itemHandler.getStackInSlot(1);

            entity.itemHandler.extractItem(0,1, false);
            entity.itemHandler.extractItem(1,1, false);
            entity.itemHandler.extractItem(2,1, false);

            ItemStack result = match.get().output.copy();
            result.setDamageValue(input.getDamageValue());
            EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(input), result);
            if(input.hasCustomHoverName()) {
                result.setHoverName(input.getHoverName());
            }
            result.setRepairCost(input.getBaseRepairCost());
            entity.itemHandler.setStackInSlot(3, result);

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(3).getItem() == output.getItem() || inventory.getItem(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(isCrafting()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.gem_infuser.use", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        else {
            return PlayState.STOP;
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object blockEntity) {
        return RenderUtils.getCurrentTick();
    }
}