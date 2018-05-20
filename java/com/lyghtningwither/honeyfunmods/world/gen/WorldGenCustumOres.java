package com.lyghtningwither.honeyfunmods.world.gen;

import java.util.Random;

import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.util.handlers.ConfigHandler;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustumOres implements IWorldGenerator {

	private WorldGenerator opal_ore, opal_ore_nether, opal_ore_end, exploding_ore_overworld_coal, exploding_ore_nether, exploding_ore_end, exploding_ore_overworld_iron, exploding_ore_overworld_redstone, exploding_ore_overworld_lapis, exploding_ore_overworld_stone, exploding_ore_ice_age_ice, exploding_ore_ice_age_air, icy_opal_ore, icy_opal_ore_overworld, backtracker_ice_age, silver_ore_overworld, silicon_ore_overworld;
	
	public WorldGenCustumOres() {
		
		opal_ore = new WorldGenMinable(ModBlocks.OPAL_ORE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		opal_ore_nether = new WorldGenMinable(ModBlocks.FIREY_OPAL_ORE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.NETHERRACK));
		opal_ore_end = new WorldGenMinable(ModBlocks.ENDER_OPAL_ORE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.END_STONE));
		exploding_ore_overworld_coal = new WorldGenMinable(ModBlocks.EXPLODING_ORE.getDefaultState(), 1, BlockMatcher.forBlock(Blocks.COAL_ORE));
		exploding_ore_overworld_iron = new WorldGenMinable(ModBlocks.EXPLODING_ORE.getDefaultState(), 1, BlockMatcher.forBlock(Blocks.IRON_ORE));
		exploding_ore_overworld_redstone = new WorldGenMinable(ModBlocks.EXPLODING_ORE.getDefaultState(), 1, BlockMatcher.forBlock(Blocks.REDSTONE_ORE));
		exploding_ore_overworld_lapis = new WorldGenMinable(ModBlocks.EXPLODING_ORE.getDefaultState(), 1, BlockMatcher.forBlock(Blocks.LAPIS_ORE));
		exploding_ore_nether = new WorldGenMinable(ModBlocks.EXPLODING_ORE.getDefaultState(), 1, BlockMatcher.forBlock(Blocks.QUARTZ_ORE));
		exploding_ore_end = new WorldGenMinable(ModBlocks.EXPLODING_ORE.getDefaultState(), 1, BlockMatcher.forBlock(ModBlocks.ENDER_OPAL_ORE));
		exploding_ore_overworld_stone = new WorldGenMinable(ModBlocks.EXPLODING_ORE.getDefaultState(), 1, BlockMatcher.forBlock(Blocks.STONE));
		exploding_ore_ice_age_ice = new WorldGenMinable(ModBlocks.EXPLODING_ORE.getDefaultState(), 1, BlockMatcher.forBlock(Blocks.PACKED_ICE));
		exploding_ore_ice_age_air = new WorldGenMinable(ModBlocks.EXPLODING_ORE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.AIR));
		icy_opal_ore = new WorldGenMinable(ModBlocks.ICY_OPAL_ORE.getDefaultState(), 1, BlockMatcher.forBlock(Blocks.ICE));
		icy_opal_ore_overworld = new WorldGenMinable(ModBlocks.ICY_OPAL_ORE.getDefaultState(), 1, BlockMatcher.forBlock(Blocks.STONE));
		silver_ore_overworld = new WorldGenMinable(ModBlocks.SILVER_ORE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
		silicon_ore_overworld = new WorldGenMinable(ModBlocks.SILICON_ORE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimension()) {
		
		case -1:
			
			if(ConfigHandler.SPAWN_FIERY_OPAL_ORE) {
				
				runGenerator(opal_ore_nether, world, random, chunkX, chunkZ, 100, 5, 23);
			}
			
			if(ConfigHandler.SPAWN_EXPLODING_ORE) {
				
				runGenerator(exploding_ore_nether, world, random, chunkX, chunkZ, 150, 1, 255);
			}
			break;
		
		
		case 0:
			
			if(ConfigHandler.SPAWN_OPAL_ORE) {
				
				runGenerator(opal_ore, world, random, chunkX, chunkZ, 100, 5, 23);
			}
			
			if(ConfigHandler.SPAWN_EXPLODING_ORE) {
				
				runGenerator(exploding_ore_overworld_coal, world, random, chunkX, chunkZ, 150, 1, 255);
				runGenerator(exploding_ore_overworld_iron, world, random, chunkX, chunkZ, 150, 1, 255);
				runGenerator(exploding_ore_overworld_redstone, world, random, chunkX, chunkZ, 150, 1, 255);
				runGenerator(exploding_ore_overworld_lapis, world, random, chunkX, chunkZ, 150, 1, 255);
				runGenerator(exploding_ore_overworld_stone, world, random, chunkX, chunkZ, 50, 1, 255);
			}
			
			if(ConfigHandler.SPAWN_ICY_OPAL_ORE) {
			
				runGenerator(icy_opal_ore, world, random, chunkX, chunkZ, 500, 5, 11);
			}
			
			if(ConfigHandler.SPAWN_SILVER_ORE) {
			
				runGenerator(silver_ore_overworld, world, random, chunkX, chunkZ, 150, 5, 29);
			}
				
			if(ConfigHandler.SPAWN_SILICON_ORE) {
			
				runGenerator(silicon_ore_overworld, world, random, chunkX, chunkZ, 150, 5, 23);
			}
			
			break;
			
		case 1:
			
			if(ConfigHandler.SPAWN_ENDER_OPAL_ORE) {
			
				runGenerator(opal_ore_end, world, random, chunkX, chunkZ, 250, 1, 15);
			}
			
			if(ConfigHandler.SPAWN_EXPLODING_ORE) {
			
				runGenerator(exploding_ore_end, world, random, chunkX, chunkZ, 150, 1, 255);
			}
			break;
			
		case 2:
			
			runGenerator(opal_ore_end, world, random, chunkX, chunkZ, 50, 1, 35);
			runGenerator(opal_ore, world, random, chunkX, chunkZ, 150, 1, 30);
			runGenerator(icy_opal_ore, world, random, chunkX, chunkZ, 70, 1, 255);
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
		
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds.");
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++){
			
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
