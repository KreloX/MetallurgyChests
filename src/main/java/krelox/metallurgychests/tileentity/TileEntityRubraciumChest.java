package krelox.metallurgychests.tileentity;

import krelox.metallurgychests.container.ContainerRubraciumChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class TileEntityRubraciumChest extends TileEntityMetalChest {
    public TileEntityRubraciumChest() {
        super("rubracium_chest");
    }

    @Override
    public int getSizeInventory() {
        return 90;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerRubraciumChest(playerInventory, this, playerIn);
    }
}
