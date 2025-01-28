package krelox.metallurgychests.block;

import krelox.metallurgychests.gui.GuiHandler;
import krelox.metallurgychests.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class MetallurgyChestsBlocks {
    public static final ArrayList<Block> BLOCKS = new ArrayList<>();
    public static final ArrayList<Item> ITEMS = new ArrayList<>();

    public static final Block BRASS_CHEST = new BlockMetalChest(GuiHandler.BRASS_CHEST, TileEntityBrassChest::new);
    public static final Block SILVER_CHEST = new BlockMetalChest(GuiHandler.SILVER_CHEST, TileEntitySilverChest::new);
    public static final Block ELECTRUM_CHEST = new BlockMetalChest(GuiHandler.ELECTRUM_CHEST, TileEntityElectrumChest::new);
    public static final Block RUBRACIUM_CHEST = new BlockMetalChest(GuiHandler.RUBRACIUM_CHEST, TileEntityRubraciumChest::new);
    public static final Block PLATINUM_CHEST = new BlockMetalChest(GuiHandler.PLATINUM_CHEST, TileEntityPlatinumChest::new);
}
