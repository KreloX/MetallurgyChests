package krelox.metallurgychests.util;

import krelox.metallurgychests.blocks.animations.RenderBrassChest;
import krelox.metallurgychests.blocks.animations.RenderElectrumChest;
import krelox.metallurgychests.blocks.animations.RenderPlatinumChest;
import krelox.metallurgychests.blocks.animations.RenderRubraciumChest;
import krelox.metallurgychests.blocks.animations.RenderSilverChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityBrassChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityElectrumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityPlatinumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntityRubraciumChest;
import krelox.metallurgychests.blocks.tileentities.TileEntitySilverChest;
import krelox.metallurgychests.init.BlockInit;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerModels()
	{
		registerItemRenderer(Item.getItemFromBlock(BlockInit.BRASS_CHEST), 0, "inventory");
		registerItemRenderer(Item.getItemFromBlock(BlockInit.SILVER_CHEST), 0, "inventory");
		registerItemRenderer(Item.getItemFromBlock(BlockInit.ELECTRUM_CHEST), 0, "inventory");
		registerItemRenderer(Item.getItemFromBlock(BlockInit.RUBRACIUM_CHEST), 0, "inventory");
		registerItemRenderer(Item.getItemFromBlock(BlockInit.PLATINUM_CHEST), 0, "inventory");
	}

	@Override
	public void registerTESRs()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBrassChest.class, new RenderBrassChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySilverChest.class, new RenderSilverChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectrumChest.class, new RenderElectrumChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRubraciumChest.class, new RenderRubraciumChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlatinumChest.class, new RenderPlatinumChest());
	}

	private static void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
}
