package com.lyghtningwither.honeyfunmods.util.handlers;

import java.io.File;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {

	public static Configuration config;
	
	public static boolean SPAWN_ICE_SHEETS;
	public static boolean SPAWN_ICE_SHEETS_M;
	public static boolean SPAWN_ICE_TREES;
	public static boolean SPAWN_SILVER_TREES;
	
	public static int AMOUNT_OF_OPAL_ORE;
	public static int AMOUNT_OF_FIERY_OPAL_ORE;
	public static int AMOUNT_OF_ENDER_OPAL_ORE;
	public static int AMOUNT_OF_ICY_OPAL_ORE;
	public static int AMOUNT_OF_EXPLODING_ORE;
	public static int AMOUNT_OF_SILVER_ORE;
	public static int AMOUNT_OF_SILICON_ORE;
	
	public static boolean SPAWN_OPAL_ORE;
	public static boolean SPAWN_FIERY_OPAL_ORE;
	public static boolean SPAWN_ENDER_OPAL_ORE;
	public static boolean SPAWN_ICY_OPAL_ORE;
	public static boolean SPAWN_EXPLODING_ORE;
	public static boolean SPAWN_SILVER_ORE;
	public static boolean SPAWN_SILICON_ORE;
	
	public static int ENTITY_EXPLOSION_STAFF = 296;
	public static int GUI_TNT_MINER = 127;
	
	public static void init(File file) {
		
		config = new Configuration(file);
		
		String category;
		
		category = "Ore Spawning";
		config.addCustomCategoryComment(category, "Set ores to spawn");
		SPAWN_OPAL_ORE = config.getBoolean("Spawn Opal Ore", category, true, "Do you want opal ore to spawn?");
		SPAWN_FIERY_OPAL_ORE = config.getBoolean("Spawn Fiery Opal Ore", category, true, "Do you want fiery opal ore to spawn?");
		SPAWN_ENDER_OPAL_ORE = config.getBoolean("Spawn Ender Opal Ore", category, true, "Do you want ender opal ore to spawn?");
		SPAWN_ICY_OPAL_ORE = config.getBoolean("Spawn Icy Opal Ore", category, true, "Do you want icy opal ore to spawn?");
		SPAWN_EXPLODING_ORE = config.getBoolean("Spawn Exploding Ore", category, true, "Do you want exploding ore to spawn?");
		SPAWN_SILVER_ORE = config.getBoolean("Spawn Silver Ore", category, true, "Do you want silver ore to spawn?");
		SPAWN_SILICON_ORE = config.getBoolean("Spawn Silicon Ore", category, true, "Do you want silicon ore to spawn?");
		
		category = "Ore Amounts";
		config.addCustomCategoryComment(category, "Set amount in ore deposits");
		AMOUNT_OF_OPAL_ORE = config.getInt("Amount of Opal Ore", category, 5, 1, 200, "What is the max amount of opal ore that can spawn in a deposit?");
		AMOUNT_OF_FIERY_OPAL_ORE = config.getInt("Amount of Fiery Opal Ore", category, 5, 1, 200, "What is the max amount of fiery opal ore that can spawn in a deposit?");
		AMOUNT_OF_ENDER_OPAL_ORE = config.getInt("Amount of Ender Opal Ore", category, 5, 1, 200, "What is the max amount of ender opal ore that can spawn in a deposit?");
		AMOUNT_OF_ICY_OPAL_ORE = config.getInt("Amount of Icy Opal Ore", category, 5, 1, 200, "What is the max amount of icy opal ore that can spawn in a deposit?");
		AMOUNT_OF_EXPLODING_ORE = config.getInt("Amount of Exploding Ore", category, 1, 1, 50000, "What is the max amount of exploding ore that can spawn in a deposit?");
		AMOUNT_OF_SILVER_ORE = config.getInt("Amount of Silver Ore", category, 3, 1, 200, "What is the max amount of silver ore that can spawn in a deposit?");
		AMOUNT_OF_SILICON_ORE = config.getInt("Amount of Silicon Ore", category, 2, 1, 200, "What is the max amount of silicon ore that can spawn in a deposit?");
		
		category = "Biome and Biome Feature Spawning";
		config.addCustomCategoryComment(category, "Set biomes and their features to spawn");
		SPAWN_ICE_SHEETS = config.getBoolean("Spawn Ice Sheet Biome", category, true, "Do you want the Ice Sheets Biome to spawn?");
		SPAWN_ICE_SHEETS_M = config.getBoolean("Spawn Ice Sheets M", category, true, "Do you want the Ice Sheets M Biome to spawn?");
		SPAWN_ICE_TREES = config.getBoolean("Spawn Ice Trees", category, true, "Do you want ice trees to spawn?");
		SPAWN_SILVER_TREES = config.getBoolean("Spawn Silver Trees", category, true, "Do you want silver trees to spawn?");
		
		category = "Compatability";
		config.addCustomCategoryComment(category, "For people who have conflicting mods (e.g. same GUI ID for something)");
		GUI_TNT_MINER = config.getInt("GUI ID of the TNT Miner", category, 127, 0, 999, "Self-explanatory.");
		ENTITY_EXPLOSION_STAFF = config.getInt("Entity ID of the Explosion Staff Projectile", category, 127, 0, 999, "Again, self-explanatory.");
		
		config.save();
	}
	
	public static void registerConfig(FMLPreInitializationEvent event) {
		
		Main.config = new File(event.getModConfigurationDirectory(), Reference.MOD_ID);
		Main.config.mkdirs();
		init(new File(Main.config.getPath(), Reference.MOD_ID + ".cfg"));
	}
}
