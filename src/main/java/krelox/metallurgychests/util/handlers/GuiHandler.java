package krelox.metallurgychests.util.handlers;

import krelox.metallurgychests.blocks.containers.ContainerBrassChest;
import krelox.metallurgychests.blocks.containers.ContainerElectrumChest;
import krelox.metallurgychests.blocks.containers.ContainerPlatinumChest;
import krelox.metallurgychests.blocks.containers.ContainerRubraciumChest;
import krelox.metallurgychests.blocks.containers.ContainerSilverChest;
import krelox.metallurgychests.blocks.gui.GuiBrassChest;
import krelox.metallurgychests.blocks.gui.GuiElectrumChest;
import krelox.metallurgychests.blocks.gui.GuiPlatinumChest;
import krelox.metallurgychests.blocks.gui.GuiRubraciumChest;
import krelox.metallurgychests.blocks.gui.GuiSilverChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityBrassChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityElectrumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityPlatinumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityRubraciumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntitySilverChest;
import krelox.metallurgychests.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_BRASS_CHEST) return new ContainerBrassChest(player.inventory, (TileEntityBrassChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_SILVER_CHEST) return new ContainerSilverChest(player.inventory, (TileEntitySilverChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_ELECTRUM_CHEST) return new ContainerElectrumChest(player.inventory, (TileEntityElectrumChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_RUBRACIUM_CHEST) return new ContainerRubraciumChest(player.inventory, (TileEntityRubraciumChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_PLATINUM_CHEST) return new ContainerPlatinumChest(player.inventory, (TileEntityPlatinumChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		return null;
		
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_BRASS_CHEST) return new GuiBrassChest(player.inventory, (TileEntityBrassChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_SILVER_CHEST) return new GuiSilverChest(player.inventory, (TileEntitySilverChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_ELECTRUM_CHEST) return new GuiElectrumChest(player.inventory, (TileEntityElectrumChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_RUBRACIUM_CHEST) return new GuiRubraciumChest(player.inventory, (TileEntityRubraciumChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_PLATINUM_CHEST) return new GuiPlatinumChest(player.inventory, (TileEntityPlatinumChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		return null;

	}
}
