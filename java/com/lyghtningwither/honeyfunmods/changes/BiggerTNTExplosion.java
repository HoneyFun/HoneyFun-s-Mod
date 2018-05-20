package com.lyghtningwither.honeyfunmods.changes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BiggerTNTExplosion {
	
	float power = 32.0f;
	
	@SubscribeEvent
	public void explode(EntityJoinWorldEvent event) {
		
		if(!(event.getEntity() instanceof EntityTNTPrimed)) {
			
			return;
		}
		
		Entity entity = event.getEntity();
		event.getEntity().world.createExplosion(entity, entity.posX, entity.posY, entity.posZ, power, true);
	}
}
