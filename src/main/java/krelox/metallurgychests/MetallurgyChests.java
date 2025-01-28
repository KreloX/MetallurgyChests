package krelox.metallurgychests;

import krelox.metallurgychests.handler.RegistrationHandler;
import krelox.metallurgychests.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION, dependencies = "required-after:metallurgy")

public class MetallurgyChests {
    @SidedProxy(clientSide = "krelox.metallurgychests.proxy.ClientProxy", serverSide = "krelox.metallurgychests.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Instance
    public static MetallurgyChests instance;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        RegistrationHandler.initRegistries(event);
    }
}
