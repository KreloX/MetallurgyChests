package krelox.metallurgychests.blocks.containers;

import invtweaks.api.container.ChestContainer;
import krelox.metallurgychests.blocks.tileentities.TileEntityPlatinumChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

@ChestContainer(rowSize = 9)
public class ContainerPlatinumChest extends Container
{
	private final int numRows;
	private final TileEntityPlatinumChest chestInventory;
	
	public ContainerPlatinumChest(InventoryPlayer playerInv, TileEntityPlatinumChest chestInventory, EntityPlayer player) 
	{
		this.chestInventory = chestInventory;
		this.numRows = chestInventory.func_70302_i_() / 12;
		chestInventory.func_174889_b(player);
		
		for(int i = 0; i < this.numRows; ++i) 
		{
			for(int j = 0; j < 12; ++j) 
			{
				this.func_75146_a(new Slot(chestInventory, j + i*9, 8 + j*18, 20 + i*18));
			}
		}
		
		for(int y = 0; y < 3; y++) 
		{
			for(int x = 0; x < 9; x++) 
			{
				this.func_75146_a(new Slot(playerInv, x + y*9 + 9, 35 + x*18, 196 + y*18));
			}
		}
		
		for(int x = 0; x < 9; x++) 
		{
			this.func_75146_a(new Slot(playerInv, x, 35 + x*18, 254));
		}
	}
	
	@Override
	public boolean func_75145_c(EntityPlayer playerIn) 
	{
		return this.chestInventory.func_70300_a(playerIn);
	}
	
	@Override
	public void func_75134_a(EntityPlayer playerIn) 
	{
		super.func_75134_a(playerIn);
		chestInventory.func_174886_c(playerIn);
	}
	
	@Override
	public ItemStack func_82846_b(EntityPlayer playerIn, int index)
	{
		ItemStack itemstack = ItemStack.field_190927_a;
        Slot slot = this.field_75151_b.get(index);

        if (slot != null && slot.func_75216_d())
        {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();

            if (index < this.numRows * 9)
            {
                if (!this.func_75135_a(itemstack1, this.numRows * 9, this.field_75151_b.size(), true))
                {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.func_75135_a(itemstack1, 0, this.numRows * 9, false))
            {
                return ItemStack.field_190927_a;
            }

            if (itemstack1.func_190926_b())
            {
                slot.func_75215_d(ItemStack.field_190927_a);
            }
            else
            {
                slot.func_75218_e();
            }
        }

        return itemstack;
	}
	
	public TileEntityPlatinumChest getChestInventory() 
	{
		return this.chestInventory;
	}
}
