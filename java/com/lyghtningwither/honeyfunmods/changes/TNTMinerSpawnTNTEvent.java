package com.lyghtningwither.honeyfunmods.changes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class TNTMinerSpawnTNTEvent extends EntityJoinWorldEvent {

	public TNTMinerSpawnTNTEvent(EntityTNTPrimed entity, World world) {
		
		super(entity, world);
	}
}
