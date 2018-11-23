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
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeIceSheets extends Biome {

	//Do ice trees later
	//Use structure blocks to do so
	
	public BiomeIceSheets() {
		
		super(new BiomeProperties("The Ice Sheets").setBaseHeight(0.125F).setHeightVariation(4.5F).setTemperature(0F).setRainfall(0.4F).setSnowEnabled());
		
		topBlock = Blocks.ICE.getDefaultState();
		fillerBlock = Blocks.PACKED_ICE.getDefaultState();
		
		this.decorator.gravelGen = new WorldGenMinable(ModBlocks.OPAL_ORE.getDefaultState(), 10);
		this.decorator.generateFalls = true;
		
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 10, 20));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 11, 10, 20));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPolarBear.class, 12, 10, 20));
		
		this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityCreeper.class, 13, 1, 5));
		this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityZombie.class, 14, 1, 5));
		this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityBat.class, 18, 1, 5));
		
		this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 15, 1, 5));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 16, 1, 5));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityStray.class, 17, 1, 5));
		
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 19, 1, 5));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityPolarBear.class, 20, 1, 5));
	}
}
