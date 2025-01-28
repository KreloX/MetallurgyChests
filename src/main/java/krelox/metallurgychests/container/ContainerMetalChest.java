package krelox.metallurgychests.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class ContainerMetalChest extends Container {
    private final IInventory chestInventory;
    protected final int numRows;

    protected ContainerMetalChest(IInventory chestInventory, EntityPlayer player, int rowSize) {
        this.chestInventory = chestInventory;
        numRows = chestInventory.getSizeInventory() / rowSize;
        chestInventory.openInventory(player);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return chestInventory.isUsableByPlayer(playerIn);
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        chestInventory.closeInventory(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (index < chestInventory.getSizeInventory()) {
                if (!mergeItemStack(itemStack1, chestInventory.getSizeInventory(), inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!mergeItemStack(itemStack1, 0, chestInventory.getSizeInventory(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemStack;
    }

    public IInventory getChestInventory() {
        return chestInventory;
    }
}
