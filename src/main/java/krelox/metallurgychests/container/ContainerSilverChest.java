package krelox.metallurgychests.container;

import invtweaks.api.container.ChestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

@ChestContainer(rowSize = ContainerSilverChest.ROW_SIZE)
public class ContainerSilverChest extends ContainerMetalChest {
    public static final int ROW_SIZE = 9;

    public ContainerSilverChest(IInventory playerInv, IInventory chestInventory, EntityPlayer player) {
        super(chestInventory, player, ROW_SIZE);

        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < ROW_SIZE; ++j) {
                addSlotToContainer(new Slot(chestInventory, j + i * ROW_SIZE, 8 + j * 18, 20 + i * 18));
            }
        }

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 178 + y * 18));
            }
        }

        for (int x = 0; x < 9; x++) {
            addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 236));
        }
    }
}
