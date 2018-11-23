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

public class BiomeIceAge extends Biome {

	public BiomeIceAge(BiomeProperties properties) {
		
		super(new BiomeProperties("Ice Age").setBaseHeight(0.125F).setHeightVariation(4.5F).setTemperature(0F).setRainfall(0.4F).setSnowEnabled());
	}
}
