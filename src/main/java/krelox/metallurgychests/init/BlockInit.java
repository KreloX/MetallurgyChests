package krelox.metallurgychests.init;

import krelox.metallurgychests.blocks.BlockBrassChest;
import krelox.metallurgychests.blocks.BlockElectrumChest;
import krelox.metallurgychests.blocks.BlockPlatinumChest;
import krelox.metallurgychests.blocks.BlockRubraciumChest;
import krelox.metallurgychests.blocks.BlockSilverChest;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final Block BRASS_CHEST = new BlockBrassChest("brass_chest");
	public static final Block SILVER_CHEST = new BlockSilverChest("silver_chest");
	public static final Block ELECTRUM_CHEST = new BlockElectrumChest("electrum_chest");
	public static final Block RUBRACIUM_CHEST = new BlockRubraciumChest("rubracium_chest");
	public static final Block PLATINUM_CHEST = new BlockPlatinumChest("platinum_chest");
}
