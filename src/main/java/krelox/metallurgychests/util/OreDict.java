package krelox.metallurgychests.util;

import krelox.metallurgychests.init.BlockInit;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict 
{
	public static void registerOres() 
	{
		OreDictionary.registerOre("chestBrass", BlockInit.BRASS_CHEST);
		OreDictionary.registerOre("chestSilver", BlockInit.SILVER_CHEST);
		OreDictionary.registerOre("chestElectrum", BlockInit.ELECTRUM_CHEST);
		OreDictionary.registerOre("chestRubracium", BlockInit.RUBRACIUM_CHEST);
		OreDictionary.registerOre("chestPlatinum", BlockInit.PLATINUM_CHEST);
	}
}
