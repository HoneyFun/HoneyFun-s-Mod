package com.lyghtningwither.honeyfunmods.util.compat;

import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryCompact {

	public static void registerOres() {
		
		OreDictionary.registerOre("ingotSilver", ModItems.SILVER_INGOT);
		OreDictionary.registerOre("oreOpal", ModBlocks.OPAL_ORE);
		OreDictionary.registerOre("oreSilicon", ModBlocks.SILICON_ORE);
		OreDictionary.registerOre("ingotSilicon", ModItems.SILICON_ROD);
		OreDictionary.registerOre("blockOpal", ModBlocks.OPAL_BLOCK);
		OreDictionary.registerOre("gemOpal", ModItems.OPAL);
		OreDictionary.registerOre("ingotObsidian", ModItems.COMPRESSED_OBSIDIAN);
	}
}
