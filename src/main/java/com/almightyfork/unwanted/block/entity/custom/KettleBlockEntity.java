package com.almightyfork.unwanted.block.entity.custom;
import com.almightyfork.unwanted.item.ModItems;
import com.almightyfork.unwanted.misc.CustomTags;
import com.almightyfork.unwanted.recipe.KettleRecipe;
import com.almightyfork.unwanted.block.entity.ModBlockEntities;
import com.almightyfork.unwanted.screen.KettleMenu;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Optional;

public class KettleBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()){
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 12;

    public KettleBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.KETTLE_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0: return KettleBlockEntity.this.progress;
                    case 1: return KettleBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: KettleBlockEntity.this.progress = value; break;
                    case 1: KettleBlockEntity.this.maxProgress = value; break;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }

//    public ItemStack getRenderStack() {
//        return itemHandler.getStackInSlot(2);
//    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Kettle");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new KettleMenu(pContainerId, pInventory, this, this.data);

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
        tag.putInt("kettle.progress", progress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("kettle.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, KettleBlockEntity pBlockEntity) {
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

    private static boolean hasRecipe(KettleBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<KettleRecipe> match = level.getRecipeManager()
                .getRecipeFor(KettleRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().output) && !IsAlreadyNBT(inventory)
                && tagsMatch(inventory, match.get().assemble(inventory, level.registryAccess()));
    }

    private static boolean IsAlreadyNBT(SimpleContainer container) {

        ItemStack input = container.getItem(0);
        ItemStack ingredient = container.getItem(1);

        if (input.hasTag()) {
            CompoundTag tag = input.getTag();
            if (tag.contains("TP") && ingredient.is(CustomTags.Items.TELEPORTS)) {
                return true;
            }
            if (tag.contains("Additives")) {
                ListTag additives = tag.getList("Additives", Tag.TAG_STRING);
                for (Tag additiveTag : additives) {
                    String additive = additiveTag.getAsString();

                    if (additive.equals("red_stuff") && ingredient.is(CustomTags.Items.RED_STUFF)) {
                        return true;
                    }
                    if (additive.equals("golden_fruit") && ingredient.is(CustomTags.Items.GOLDEN_FRUIT)) {
                        return true;
                    }
                    if (additive.equals("god_apple") && ingredient.is(CustomTags.Items.GOD_APPLE)) {
                        return true;
                    }
                    if (additive.equals("sweet") && ingredient.is(CustomTags.Items.SWEET)) {
                        return true;
                    }
                    if (additive.equals("glow_berries") && ingredient.is(CustomTags.Items.GLOWING_FRUIT)) {
                        return true;
                    }
                    if (additive.equals("pink_flower") && ingredient.is(CustomTags.Items.PINK_FLOWER)) {
                        return true;
                    }
                    if (additive.equals("yellow_flower") && ingredient.is(CustomTags.Items.YELLOW_FLOWER)) {
                        return true;
                    }
                    if (additive.equals("white_flower") && ingredient.is(CustomTags.Items.WHITE_FLOWER)) {
                        return true;
                    }
                    if (additive.equals("grey_flower") && ingredient.is(CustomTags.Items.GREY_FLOWER)) {
                        return true;
                    }
                    if (additive.equals("blue_flower") && ingredient.is(CustomTags.Items.BLUE_FLOWER)) {
                        return true;
                    }
                    if (additive.equals("purple_flower_1") && ingredient.is(CustomTags.Items.PURPLE_FLOWER1)) {
                        return true;
                    }
                    if (additive.equals("purple_flower_2") && ingredient.is(CustomTags.Items.PURPLE_FLOWER2)) {
                        return true;
                    }
                    if (additive.equals("red_flower") && ingredient.is(CustomTags.Items.RED_FLOWER)) {
                        return true;
                    }
                    if (additive.equals("end_flower") && ingredient.is(CustomTags.Items.END)) {
                        return true;
                    }
                    if (additive.equals("fire_flower") && ingredient.is(CustomTags.Items.FIRE_FLOWER)) {
                        return true;
                    }
                    if (additive.equals("pot_flower") && ingredient.is(CustomTags.Items.POT_FLOWER)) {
                        return true;
                    }
                    if (additive.equals("wing") && ingredient.is(CustomTags.Items.WING)) {
                        return true;
                    }
                    if (additive.equals("fire") && ingredient.is(CustomTags.Items.FIRE)) {
                        return true;
                    }
                    if (additive.equals("torrid") && ingredient.is(CustomTags.Items.TORRID)) {
                        return true;
                    }
                    if (additive.equals("wither_flower") && ingredient.is(CustomTags.Items.WITHER)) {
                        return true;
                    }
                }
            }

            if (tag.contains("Mods")) {
                ListTag mods = tag.getList("Mods", Tag.TAG_STRING);
                int GlowCounter = 0;
                for (Tag ModsTag : mods) {
                    String mod = ModsTag.getAsString();

                    if (mod.equals("gunpowder") && ingredient.is(Items.GUNPOWDER)) {
                        return true;
                    }
                    if (mod.equals("glowstone") && ingredient.is(Items.GLOWSTONE_DUST)) {
                        if (GlowCounter < 3) {
                            GlowCounter ++;
                        }
                        else {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void craftItem(KettleBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<KettleRecipe> match = level.getRecipeManager()
                .getRecipeFor(KettleRecipe.Type.INSTANCE, inventory, level);

        if (match.isPresent()) {
            ItemStack craftedItem = match.get().assemble(inventory, level.registryAccess());

            entity.itemHandler.extractItem(0, 1, false);
            entity.itemHandler.extractItem(1, 1, false);

            ItemStack outputStack = entity.itemHandler.getStackInSlot(2);
            if (outputStack.isEmpty()) {
                entity.itemHandler.setStackInSlot(2, craftedItem);
            } else {
                outputStack.grow(1);
            }

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(2).getItem() == output.getItem() || inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }

    private static boolean tagsMatch(SimpleContainer inventory, ItemStack output) {
        ItemStack itemInSlot2 = inventory.getItem(2);

        if (itemInSlot2.isEmpty()) {
            return true;
        }

        if (itemInSlot2.hasTag() && output.hasTag()) {
            CompoundTag slot2Tag = itemInSlot2.getTag();
            CompoundTag outputTag = output.getTag();
            return Objects.equals(slot2Tag, outputTag);
        }

        return !itemInSlot2.hasTag() && !output.hasTag();
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}
