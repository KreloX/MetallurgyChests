package krelox.metallurgychests.gui;

import krelox.metallurgychests.container.*;
import krelox.metallurgychests.tileentity.TileEntityMetalChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    public static final int BRASS_CHEST = 0;
    public static final int SILVER_CHEST = 1;
    public static final int ELECTRUM_CHEST = 2;
    public static final int RUBRACIUM_CHEST = 3;
    public static final int PLATINUM_CHEST = 4;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        return switch (id) {
            case BRASS_CHEST ->
                    new ContainerBrassChest(player.inventory, (TileEntityMetalChest) world.getTileEntity(new BlockPos(x, y, z)), player);
            case SILVER_CHEST ->
                    new ContainerSilverChest(player.inventory, (TileEntityMetalChest) world.getTileEntity(new BlockPos(x, y, z)), player);
            case ELECTRUM_CHEST ->
                    new ContainerElectrumChest(player.inventory, (TileEntityMetalChest) world.getTileEntity(new BlockPos(x, y, z)), player);
            case RUBRACIUM_CHEST ->
                    new ContainerRubraciumChest(player.inventory, (TileEntityMetalChest) world.getTileEntity(new BlockPos(x, y, z)), player);
            case PLATINUM_CHEST ->
                    new ContainerPlatinumChest(player.inventory, (TileEntityMetalChest) world.getTileEntity(new BlockPos(x, y, z)), player);
            default -> null;
        };
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        return switch (id) {
            case BRASS_CHEST ->
                    new GuiBrassChest(player.inventory, (TileEntityMetalChest) world.getTileEntity(new BlockPos(x, y, z)), player);
            case SILVER_CHEST ->
                    new GuiSilverChest(player.inventory, (TileEntityMetalChest) world.getTileEntity(new BlockPos(x, y, z)), player);
            case ELECTRUM_CHEST ->
                    new GuiElectrumChest(player.inventory, (TileEntityMetalChest) world.getTileEntity(new BlockPos(x, y, z)), player);
            case RUBRACIUM_CHEST ->
                    new GuiRubraciumChest(player.inventory, (TileEntityMetalChest) world.getTileEntity(new BlockPos(x, y, z)), player);
            case PLATINUM_CHEST ->
                    new GuiPlatinumChest(player.inventory, (TileEntityMetalChest) world.getTileEntity(new BlockPos(x, y, z)), player);
            default -> null;
        };
    }
}
