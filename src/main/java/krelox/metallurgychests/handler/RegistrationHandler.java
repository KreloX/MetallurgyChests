package krelox.metallurgychests.handler;

import krelox.metallurgychests.MetallurgyChests;
import krelox.metallurgychests.block.MetallurgyChestsBlocks;
import krelox.metallurgychests.gui.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@EventBusSubscriber
public class RegistrationHandler {
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(MetallurgyChestsBlocks.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(MetallurgyChestsBlocks.BLOCKS.toArray(new Block[0]));
        TileEntityHandler.registerTileEntities();
        MetallurgyChests.proxy.registerTESRs();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        MetallurgyChests.proxy.registerModels();
    }

    public static void initRegistries(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(MetallurgyChests.instance, new GuiHandler());
        OreDictHandler.registerOres();
    }
}
