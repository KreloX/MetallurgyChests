package krelox.metallurgychests;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import krelox.metallurgychests.util.CommonProxy;
import krelox.metallurgychests.util.Reference;
import krelox.metallurgychests.util.handlers.RegistryHandler;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)

public class MetallurgyChests 
{	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy proxy;
	
	@Instance
	public static MetallurgyChests instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		RegistryHandler.preInitRegistries(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		RegistryHandler.initRegistries(event);
	}
}
