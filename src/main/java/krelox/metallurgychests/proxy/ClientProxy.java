package krelox.metallurgychests.proxy;

import krelox.metallurgychests.renderer.TileEntityMetalChestRenderer;
import krelox.metallurgychests.block.MetallurgyChestsBlocks;
import krelox.metallurgychests.tileentity.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerModels() {
        registerItemRenderer(Item.getItemFromBlock(MetallurgyChestsBlocks.BRASS_CHEST), 0, "inventory");
        registerItemRenderer(Item.getItemFromBlock(MetallurgyChestsBlocks.SILVER_CHEST), 0, "inventory");
        registerItemRenderer(Item.getItemFromBlock(MetallurgyChestsBlocks.ELECTRUM_CHEST), 0, "inventory");
        registerItemRenderer(Item.getItemFromBlock(MetallurgyChestsBlocks.RUBRACIUM_CHEST), 0, "inventory");
        registerItemRenderer(Item.getItemFromBlock(MetallurgyChestsBlocks.PLATINUM_CHEST), 0, "inventory");
    }

    @Override
    public void registerTESRs() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBrassChest.class, new TileEntityMetalChestRenderer("brass_chest"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySilverChest.class, new TileEntityMetalChestRenderer("silver_chest"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectrumChest.class, new TileEntityMetalChestRenderer("electrum_chest"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRubraciumChest.class, new TileEntityMetalChestRenderer("rubracium_chest"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlatinumChest.class, new TileEntityMetalChestRenderer("platinum_chest"));
    }

    private static void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
}
