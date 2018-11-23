package com.lyghtningwither.honeyfunmods.util.handlers;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundHandler {

	public static SoundEvent drilling;
	
	public static SoundEvent portal;
	
	public static void registerSounds() {
		
		Main.logger.info("Registering Sounds...");
		drilling = registerSound("block.miner.mining");
		portal = registerSound("blocks.portal.teleport_sound");
		Main.logger.info("Registered Sounds!");
	}
	
	private static SoundEvent registerSound(String name) {

		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);

		SoundEvent event = new SoundEvent(location);

		event.setRegistryName(name);

		ForgeRegistries.SOUND_EVENTS.register(event);

		return event;
	}
}
