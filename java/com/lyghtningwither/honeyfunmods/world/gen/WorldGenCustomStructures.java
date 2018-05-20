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
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeSnow;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.client.model.pipeline.ForgeBlockModelRenderer;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import scala.actors.threadpool.Arrays;

public class WorldGenCustomStructures implements IWorldGenerator {

	public static final WorldGenStructure SMELTERY = new WorldGenStructure("smeltery");
	public static final WorldGenStructure ICE_TREE_SMALL = new WorldGenStructure("ice_tree_small");
	public static final WorldGenStructure ICE_TREE_MEDIUM = new WorldGenStructure("ice_tree_medium");
	public static final WorldGenStructure ICE_TREE_LARGE = new WorldGenStructure("ice_tree_large");
	public static final WorldGenStructure SILVER_TREE_SMALL = new WorldGenStructure("silver_tree_small");
	public static final WorldGenStructure BACKTRACKER_BLOCK = new WorldGenStructure("backtracker_block");
	public static final WorldGenStructure EXPLODING_BLOCK = new WorldGenStructure("exploding_block");
	public static final StructureHub ICE_AGE_HUB = new StructureHub("ice_age_hub");
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimension()) {
			
		case 1:
			break;
			
		case 0:
			
			generateStructure(SMELTERY, world, random, chunkX, chunkZ, 1000, Blocks.ICE, BiomeIceSheets.class);
			generateStructure(ICE_TREE_SMALL, world, random, chunkX, chunkZ, 100, Blocks.ICE, BiomeIceSheets.class);
			generateStructure(SILVER_TREE_SMALL, world, random, chunkX, chunkZ, 500, Blocks.ICE, BiomeIceSheets.class, BiomeSnow.class);
			break;
			
		case -1:
			break;
			
		case 2:
			
			generateStructure(ICE_TREE_SMALL, world, random, chunkX, chunkZ, 10, Blocks.PACKED_ICE, BiomeIceAge.class);
			generateStructure(ICE_TREE_MEDIUM, world, random, chunkX, chunkZ, 15, Blocks.PACKED_ICE, BiomeIceAge.class);
			generateStructure(ICE_TREE_LARGE, world, random, chunkX, chunkZ, 20, Blocks.PACKED_ICE, BiomeIceAge.class);
			generateStructure(SILVER_TREE_SMALL, world, random, chunkX, chunkZ, 100, Blocks.PACKED_ICE, BiomeIceAge.class);
			generateStructure(ICE_AGE_HUB, world, random, chunkX, chunkZ, 10, Blocks.PACKED_ICE, BiomeIceAge.class);
			generateStructure(BACKTRACKER_BLOCK, world, random, chunkX, chunkZ, 1000, Blocks.AIR, BiomeIceAge.class);
			generateStructure(EXPLODING_BLOCK, world, random, chunkX, chunkZ, 500, Blocks.AIR, BiomeIceAge.class);
			break;
		}
	}
	
	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<? extends Biome>... classes) {
		
		
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
	
	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
		
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0) {
			
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			foundGround = block == topBlock;
		}
		
		return y;
	}
}
