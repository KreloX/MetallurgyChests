package krelox.metallurgychests.util.handlers;

import krelox.metallurgychests.MetallurgyChests;
import krelox.metallurgychests.init.BlockInit;
import krelox.metallurgychests.init.ItemInit;
import krelox.metallurgychests.util.OreDict;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) 
	{
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
		MetallurgyChests.proxy.registerTESRs();
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) 
	{
		MetallurgyChests.proxy.registerModels();
	}
	
	public static void preInitRegistries(FMLPreInitializationEvent event) 
	{}
	
	public static void initRegistries(FMLInitializationEvent event) 
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(MetallurgyChests.instance, new GuiHandler());
		OreDict.registerOres();
	}
}
