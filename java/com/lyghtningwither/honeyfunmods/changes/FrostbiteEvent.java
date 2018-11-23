package com.lyghtningwither.honeyfunmods.changes;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent;

public class FrostbiteEvent extends LivingEvent {
	
	private EntityLivingBase source;
	private BlockPos pos1;
	private BlockPos pos2;
	
	public FrostbiteEvent(EntityLivingBase entity, EntityLivingBase source, BlockPos pos) {
		
		super(entity);
		this.source = source;
		pos1 = pos;
		pos2 = pos.up();
	}
	
	public EntityLivingBase getSource() { return source; }
	
	public BlockPos getFirstPos() { return pos1; }
	
	public BlockPos getSecondPos() { return pos2; }
}
