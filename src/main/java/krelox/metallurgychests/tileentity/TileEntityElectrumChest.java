package krelox.metallurgychests.tileentity;

import krelox.metallurgychests.container.ContainerElectrumChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class TileEntityElectrumChest extends TileEntityMetalChest {
    public TileEntityElectrumChest() {
        super("electrum_chest");
    }

    @Override
    public int getSizeInventory() {
        return 81;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerElectrumChest(playerInventory, this, playerIn);
    }
}
