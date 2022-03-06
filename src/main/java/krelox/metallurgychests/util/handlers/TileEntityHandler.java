package krelox.metallurgychests.util.handlers;

import krelox.metallurgychests.blocks.tileentities.TileEntityBrassChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityElectrumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityPlatinumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityRubraciumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntitySilverChest;
import krelox.metallurgychests.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities() 
	{
		GameRegistry.registerTileEntity(TileEntityBrassChest.class, new ResourceLocation(Reference.MODID + ":brass_chest"));
		GameRegistry.registerTileEntity(TileEntitySilverChest.class, new ResourceLocation(Reference.MODID + ":silver_chest"));
		GameRegistry.registerTileEntity(TileEntityElectrumChest.class, new ResourceLocation(Reference.MODID + ":electrum_chest"));
		GameRegistry.registerTileEntity(TileEntityRubraciumChest.class, new ResourceLocation(Reference.MODID + ":rubracium_chest"));
		GameRegistry.registerTileEntity(TileEntityPlatinumChest.class, new ResourceLocation(Reference.MODID + ":platinum_chest"));
	}
}
