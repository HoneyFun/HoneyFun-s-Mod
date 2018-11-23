package com.lyghtningwither.honeyfunmods.init;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.util.handlers.ConfigHandler;
import com.lyghtningwither.honeyfunmods.world.dimension.ice_age.DimensionIceAge;

import net.minecraft.world.DimensionType;

import net.minecraftforge.common.DimensionManager;

public class DimensionInit {

	public static final DimensionType ICE_AGE = DimensionType.register("Ice_age", "_iceage", 512, DimensionIceAge.class, false);
	
	public static void registerDimensions() {
		
		Main.logger.info("Registering Ice Age");
		
		if(!DimensionManager.isDimensionRegistered(512)) {
			
			DimensionManager.registerDimension(512, ICE_AGE);
			Main.logger.info("Ice Age is registered.");
		} else Main.logger.error("Another dimension has already been registered with the same dimension ID as the Ice Age. Contact the mod owner to see if they can do anything.");
		
		Main.logger.info("Dimensions Registered!");
	}
}