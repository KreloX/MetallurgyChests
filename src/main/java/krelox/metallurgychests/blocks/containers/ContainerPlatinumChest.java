package krelox.metallurgychests.blocks.containers;

import invtweaks.api.container.ChestContainer;
import krelox.metallurgychests.blocks.tileentities.TileEntityPlatinumChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

@ChestContainer(rowSize = 12)
public class ContainerPlatinumChest extends Container
{
	private final int numRows;
	private final TileEntityPlatinumChest chestInventory;
	
	public ContainerPlatinumChest(InventoryPlayer playerInv, TileEntityPlatinumChest chestInventory, EntityPlayer player) 
	{
		this.chestInventory = chestInventory;
		this.numRows = chestInventory.getSizeInventory() / 12;
		chestInventory.openInventory(player);
		
		for(int i = 0; i < this.numRows; ++i) 
		{
			for(int j = 0; j < 12; ++j) 
			{
				this.addSlotToContainer(new Slot(chestInventory, j + i*12, 8 + j*18, 20 + i*18));
			}
		}
		
		for(int y = 0; y < 3; y++) 
		{
			for(int x = 0; x < 9; x++) 
			{
				this.addSlotToContainer(new Slot(playerInv, x + y*9 + 9, 35 + x*18, 196 + y*18));
			}
		}
		
		for(int x = 0; x < 9; x++) 
		{
			this.addSlotToContainer(new Slot(playerInv, x, 35 + x*18, 254));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return this.chestInventory.isUsableByPlayer(playerIn);
	}
	
	@Override
	public void onContainerClosed(EntityPlayer playerIn) 
	{
		super.onContainerClosed(playerIn);
		chestInventory.closeInventory(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.numRows * 12)
            {
                if (!this.mergeItemStack(itemstack1, this.numRows * 12, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 12, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
	}
	
	public TileEntityPlatinumChest getChestInventory() 
	{
		return this.chestInventory;
	}
}
