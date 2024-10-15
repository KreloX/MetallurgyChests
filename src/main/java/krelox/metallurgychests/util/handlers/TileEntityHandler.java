package krelox.metallurgychests.util.handlers;

import krelox.metallurgychests.Tags;
import krelox.metallurgychests.blocks.tileentities.TileEntityBrassChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityElectrumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityPlatinumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityRubraciumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntitySilverChest;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities() 
	{
		GameRegistry.registerTileEntity(TileEntityBrassChest.class, new ResourceLocation(Tags.MOD_ID, "brass_chest"));
		GameRegistry.registerTileEntity(TileEntitySilverChest.class, new ResourceLocation(Tags.MOD_ID, "silver_chest"));
		GameRegistry.registerTileEntity(TileEntityElectrumChest.class, new ResourceLocation(Tags.MOD_ID, "electrum_chest"));
		GameRegistry.registerTileEntity(TileEntityRubraciumChest.class, new ResourceLocation(Tags.MOD_ID, "rubracium_chest"));
		GameRegistry.registerTileEntity(TileEntityPlatinumChest.class, new ResourceLocation(Tags.MOD_ID, "platinum_chest"));
	}
}
