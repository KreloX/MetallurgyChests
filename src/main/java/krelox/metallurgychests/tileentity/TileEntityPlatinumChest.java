package krelox.metallurgychests.tileentity;

import krelox.metallurgychests.container.ContainerPlatinumChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class TileEntityPlatinumChest extends TileEntityMetalChest {
    public TileEntityPlatinumChest() {
        super("platinum_chest");
    }

    @Override
    public int getSizeInventory() {
        return 108;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerPlatinumChest(playerInventory, this, playerIn);
    }
}
