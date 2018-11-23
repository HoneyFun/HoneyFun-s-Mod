package com.lyghtningwither.honeyfunmods.init;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.util.handlers.ConfigHandler;
import com.lyghtningwither.honeyfunmods.world.biomes.BiomeIceAge;
import com.lyghtningwither.honeyfunmods.world.biomes.BiomeIceAgeMountainous;
import com.lyghtningwither.honeyfunmods.world.biomes.BiomeIceSheets;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {

	public static final Biome ICE_SHEETS = new BiomeIceSheets();
	public static final Biome ICE_SHEETS_M = new BiomeIceAgeMountainous();
	public static final Biome ICE_AGE = new BiomeIceAge(new BiomeProperties("Ice Age"));
	
	public static void registerBiomes() {
		
		Main.logger.info("Registering Biomes...");
		
		Main.logger.info("Registering Ice Sheets...");
		
		if(ConfigHandler.SPAWN_ICE_SHEETS) {
			
			initBiome(ICE_SHEETS, "The Ice Sheets", BiomeType.ICY, Type.COLD, Type.SNOWY, Type.SPARSE, Type.MAGICAL);
		}
		
		Main.logger.info("Ice Sheets Registered!");
		
		Main.logger.info("Registering Ice Sheets M...");
		
		if(ConfigHandler.SPAWN_ICE_SHEETS_M) {
			
			initBiome(ICE_SHEETS_M, "The Ice Sheets M", BiomeType.ICY, Type.COLD, Type.SNOWY, Type.SPARSE, Type.MAGICAL, Type.MOUNTAIN);
		}
		
		Main.logger.info("Ice Sheets M Registered!");
		
		initBiome(ICE_AGE, "Ice Age", BiomeType.ICY, Type.VOID);
		
		Main.logger.info("Biomes Registered!");
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types) {
		
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}
}