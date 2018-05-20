package com.lyghtningwither.honeyfunmods.world.types;

import com.lyghtningwither.honeyfunmods.init.BiomeInit;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;

public class WorldTypeCustom extends WorldType {

	public WorldTypeCustom() {
		
		super("GrassySheets");
	}

	@Override
	public BiomeProvider getBiomeProvider(World world) {
		// TODO Auto-generated method stub
		return new BiomeProviderSingle(BiomeInit.ICE_SHEETS);
	}
}
