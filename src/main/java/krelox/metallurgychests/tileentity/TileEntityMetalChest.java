package krelox.metallurgychests.tileentity;

import krelox.metallurgychests.Tags;
import krelox.metallurgychests.block.BlockMetalChest;
import krelox.metallurgychests.container.ContainerMetalChest;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;

public abstract class TileEntityMetalChest extends TileEntityChest {
    public final String name;
    private NonNullList<ItemStack> chestContents = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
    protected int ticksSinceSync;

    protected TileEntityMetalChest(String name) {
        this.name = name;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : chestContents) {
            if (!stack.isEmpty()) return false;
        }

        return true;
    }

    @Override
    public String getName() {
        return hasCustomName() ? customName : "container." + name;
    }


    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        chestContents = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);

        if (!checkLootAndRead(compound)) ItemStackHelper.loadAllItems(compound, chestContents);
        if (compound.hasKey("CustomName", 8)) customName = compound.getString("CustomName");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        if (!checkLootAndWrite(compound)) ItemStackHelper.saveAllItems(compound, chestContents);
        if (compound.hasKey("CustomName", 8)) compound.setString("CustomName", customName);

        return compound;
    }

    @Override
    public String getGuiID() {
        return Tags.MOD_ID + ":" + name;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return chestContents;
    }

    @Override
    public void update() {
        if (!world.isRemote && numPlayersUsing != 0 && (ticksSinceSync + pos.getX() + pos.getY() + pos.getZ()) % 200 == 0) {
            numPlayersUsing = 0;
            float f = 5.0F;

            for (EntityPlayer entityplayer : world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB((float) pos.getX() - f, (float) pos.getY() - f, (float) pos.getZ() - f, (float) (pos.getX() + 1) + f, (float) (pos.getY() + 1) + f, (float) (pos.getZ() + 1) + f))) {
                if (entityplayer.openContainer instanceof ContainerMetalChest containerMetalChest) {
                    if (containerMetalChest.getChestInventory() == this) {
                        ++numPlayersUsing;
                    }
                }
            }
        }

        prevLidAngle = lidAngle;
        float f1 = 0.1F;

        if (numPlayersUsing > 0 && lidAngle == 0.0F) {
            double d1 = (double) pos.getX() + 0.5D;
            double d2 = (double) pos.getZ() + 0.5D;
            world.playSound(null, d1, (double) pos.getY() + 0.5D, d2, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (numPlayersUsing == 0 && lidAngle > 0.0F || numPlayersUsing > 0 && lidAngle < 1.0F) {
            float f2 = lidAngle;

            if (numPlayersUsing > 0) {
                lidAngle += f1;
            } else {
                lidAngle -= f1;
            }

            if (lidAngle > 1.0F) {
                lidAngle = 1.0F;
            }

            float f3 = 0.5F;

            if (lidAngle < f3 && f2 >= f3) {
                double d3 = (double) pos.getX() + 0.5D;
                double d0 = (double) pos.getZ() + 0.5D;
                world.playSound(null, d3, (double) pos.getY() + 0.5D, d0, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (lidAngle < 0.0F) {
                lidAngle = 0.0F;
            }
        }
    }

    @Override
    public void openInventory(EntityPlayer player) {
        if (!player.isSpectator()) {
            if (numPlayersUsing < 0) {
                numPlayersUsing = 0;
            }

            ++numPlayersUsing;
            world.addBlockEvent(pos, getBlockType(), 1, numPlayersUsing);
            world.notifyNeighborsOfStateChange(pos, getBlockType(), false);

            if (getChestType() == BlockChest.Type.TRAP) {
                world.notifyNeighborsOfStateChange(pos.down(), getBlockType(), false);
            }
        }
    }

    @Override
    public void closeInventory(EntityPlayer player) {
        if (!player.isSpectator() && getBlockType() instanceof BlockMetalChest) {
            --numPlayersUsing;
            world.addBlockEvent(pos, getBlockType(), 1, numPlayersUsing);
            world.notifyNeighborsOfStateChange(pos, getBlockType(), false);

            if (getChestType() == BlockChest.Type.TRAP) {
                world.notifyNeighborsOfStateChange(pos.down(), getBlockType(), false);
            }
        }
    }

    @Override
    public boolean canRenderBreaking() {
        return true;
    }
}
