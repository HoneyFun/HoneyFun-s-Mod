package com.lyghtningwither.honeyfunmods.changes;

import com.lyghtningwither.honeyfunmods.init.ModBlocks;

import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ExplodingOre {

	@SubscribeEvent
	public void explode(BreakEvent event) {
		
		if(event.getState().getBlock() != ModBlocks.EXPLODING_ORE) {
			
			return;
		}
		
		event.getWorld().createExplosion(null, event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), 10, true);
	}
}
