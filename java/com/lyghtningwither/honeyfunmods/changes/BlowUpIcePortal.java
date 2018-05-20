package com.lyghtningwither.honeyfunmods.changes;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlowUpIcePortal {

	@SubscribeEvent
	public void BlowUpPortal(PlaceEvent event) {
		
		if(event.getWorld().isRemote) return;
		
		if(event.getPlayer().dimension == -1 || event.getPlayer().dimension == 1) {
			
			event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState());
			event.getWorld().createExplosion((Entity)null, event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), 10, false);
		} else return;
	}
}
