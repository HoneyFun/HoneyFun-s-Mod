package com.lyghtningwither.honeyfunmods.world.biomes;

import com.lyghtningwither.honeyfunmods.init.ModBlocks;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeIceAgeMountainous extends Biome {

	public BiomeIceAgeMountainous() {
		
		super(new BiomeProperties("Ice Age M").setBaseHeight(1).setHeightVariation(6).setTemperature(0).setRainfall(0.4F).setSnowEnabled());
		
		topBlock = Blocks.PACKED_ICE.getDefaultState();
		fillerBlock = Blocks.PACKED_ICE.getDefaultState();
		
		this.decorator.gravelGen = new WorldGenMinable(ModBlocks.ICY_OPAL_ORE.getDefaultState(), 3);
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		
		this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityPolarBear.class, 12, 1, 5));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityPolarBear.class, 12, 1, 5));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPolarBear.class, 5, 1, 7));
	}
}
