package krelox.metallurgychests.tileentity;

import krelox.metallurgychests.container.ContainerBrassChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class TileEntityBrassChest extends TileEntityMetalChest {
    public TileEntityBrassChest() {
        super("brass_chest");
    }

    @Override
    public int getSizeInventory() {
        return 54;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerBrassChest(playerInventory, this, playerIn);
    }
}
