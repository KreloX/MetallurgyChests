package krelox.metallurgychests.tileentity;

import krelox.metallurgychests.container.ContainerSilverChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class TileEntitySilverChest extends TileEntityMetalChest {
    public TileEntitySilverChest() {
        super("silver_chest");
    }

    @Override
    public int getSizeInventory() {
        return 72;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerSilverChest(playerInventory, this, playerIn);
    }
}
