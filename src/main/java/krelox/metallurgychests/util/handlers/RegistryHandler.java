package krelox.metallurgychests.util.handlers;

import krelox.metallurgychests.MetallurgyChests;
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
import krelox.metallurgychests.init.ItemInit;
import krelox.metallurgychests.util.IHasModel;
import krelox.metallurgychests.util.OreDict;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void RegisterItems(RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) 
	{
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBrassChest.class, new RenderBrassChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySilverChest.class, new RenderSilverChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectrumChest.class, new RenderElectrumChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRubraciumChest.class, new RenderRubraciumChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlatinumChest.class, new RenderPlatinumChest());
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) 
	{
		MetallurgyChests.proxy.registerItemRenderer(Item.getItemFromBlock(BlockInit.BRASS_CHEST), 0, "inventory");
		MetallurgyChests.proxy.registerItemRenderer(Item.getItemFromBlock(BlockInit.SILVER_CHEST), 0, "inventory");
		MetallurgyChests.proxy.registerItemRenderer(Item.getItemFromBlock(BlockInit.ELECTRUM_CHEST), 0, "inventory");
		MetallurgyChests.proxy.registerItemRenderer(Item.getItemFromBlock(BlockInit.RUBRACIUM_CHEST), 0, "inventory");
		MetallurgyChests.proxy.registerItemRenderer(Item.getItemFromBlock(BlockInit.PLATINUM_CHEST), 0, "inventory");
		
		for(Item item : ItemInit.ITEMS) 
		{
			if(item instanceof IHasModel) 
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : BlockInit.BLOCKS) 
		{
			if(block instanceof IHasModel) 
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void preInitRegistries(FMLPreInitializationEvent event) 
	{}
	
	public static void initRegistries(FMLInitializationEvent event) 
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(MetallurgyChests.instance, new GuiHandler());
		OreDict.registerOres();
	}
}
