package com.lyghtningwither.honeyfunmods.init;

import com.lyghtningwither.honeyfunmods.world.dimension.ice_age.DimensionIceAge;

import net.minecraft.world.DimensionType;

import net.minecraftforge.common.DimensionManager;

public class DimensionInit {

	public static final DimensionType ICE_AGE = DimensionType.register("Ice_age", "_iceage", 2, DimensionIceAge.class, false);
	
	
	public static void registerDimensions() {
		
		DimensionManager.registerDimension(2, ICE_AGE);
	}
}