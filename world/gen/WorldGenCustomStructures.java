package com.lyghtningwither.honeyfunmods.world.gen;

import java.util.ArrayList;
import java.util.Random;

import org.apache.logging.log4j.Level;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.init.BiomeInit;
import com.lyghtningwither.honeyfunmods.world.biomes.BiomeIceAge;
import com.lyghtningwither.honeyfunmods.world.biomes.BiomeIceSheets;

import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomeHills;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.biome.BiomeSnow;
import net.minecraft.world.biome.BiomeTaiga;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.client.model.pipeline.ForgeBlockModelRenderer;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import java.util.Arrays;

public class WorldGenCustomStructures implements IWorldGenerator {

	public static final WorldGenStructure SMELTERY = new WorldGenStructure("smeltery");
	public static final WorldGenStructure ICE_TREE_SMALL = new WorldGenStructure("ice_tree_small");
	public static final WorldGenStructure SILVER_TREE_SMALL = new WorldGenStructure("silver_tree_small");
	public static final WorldGenStructure GREENHOUSE = new WorldGenStructure("greenhouse");
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimension()) {
			
		case 1:
			break;
			
		case 0:
			
			generateStructure(SMELTERY, world, random, chunkX, chunkZ, 1000, Blocks.ICE, BiomeIceSheets.class);
			generateStructure(ICE_TREE_SMALL, world, random, chunkX, chunkZ, 100, Blocks.ICE, BiomeIceSheets.class, BiomeSnow.class);
			generateStructure(SILVER_TREE_SMALL, world, random, chunkX, chunkZ, 500, Blocks.ICE, BiomeIceSheets.class, BiomeSnow.class);
			generateStructure(GREENHOUSE, world, random, chunkX, chunkZ, 100, Blocks.GRASS, BiomePlains.class, BiomeTaiga.class, BiomeForest.class, BiomeSavanna.class, BiomeHills.class);
			break;
			
		case -1:
			break;
		}
	}
	
	public static void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<? extends Biome>... classes) {
		
		
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + random.nextInt(15);
		int z = (chunkZ * 16) + random.nextInt(15);
		int y = calculateGenerationHeight(world, x, z, topBlock);
		
		if(y == 0) {
			
			Main.logger.log(Level.INFO, "Generation located at level 0 - skipping");
			return;
		}
		
		BlockPos pos = new BlockPos(x,y,z);
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT) {
			
			if(classesList.contains(biome)) {
				
				if(random.nextInt(chance) == 0) {
					
					generator.generate(world, random, pos);
				}
			}
		}
	}
	
	public static int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
		
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0) {
			
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			foundGround = block == topBlock;
		}
		
		return y;
	}
}
