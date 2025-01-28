package krelox.metallurgychests.handler;

import krelox.metallurgychests.block.MetallurgyChestsBlocks;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {
    public static void registerOres() {
        OreDictionary.registerOre("chestBrass", MetallurgyChestsBlocks.BRASS_CHEST);
        OreDictionary.registerOre("chestSilver", MetallurgyChestsBlocks.SILVER_CHEST);
        OreDictionary.registerOre("chestElectrum", MetallurgyChestsBlocks.ELECTRUM_CHEST);
        OreDictionary.registerOre("chestRubracium", MetallurgyChestsBlocks.RUBRACIUM_CHEST);
        OreDictionary.registerOre("chestPlatinum", MetallurgyChestsBlocks.PLATINUM_CHEST);
    }
}
