package com.lyghtningwither.honeyfunmods.world.dimension.ice_age;

import java.util.Random;

import com.lyghtningwither.honeyfunmods.init.BiomeInit;
import com.lyghtningwither.honeyfunmods.init.DimensionInit;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionIceAge extends WorldProvider {
	
	public DimensionIceAge() {
		
		this.biomeProvider = new BiomeProviderSingle(BiomeInit.ICE_AGE);
		this.hasSkyLight = true;
	}
	
	@Override
	public DimensionType getDimensionType() {
		
		return DimensionInit.ICE_AGE;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		
		return new ChunkGeneratorIceAge(this.world, true, world.getSeed());
	}
	
	@Override
	public boolean canRespawnHere() {
		
		return false;
	}
	
	@Override
	public String getSaveFolder() {
		
		return "ICE_AGE_DIMENSION";
	}
	
	@Override
	public float getCloudHeight() {
		
		return 250;
	}
	
	@Override
	public boolean shouldClientCheckLighting() {

		return true;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		
		return true;
	}
	
	@Override
	public double getMovementFactor() {
		
		return 16.0D;
	}
}
