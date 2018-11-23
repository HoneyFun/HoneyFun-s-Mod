package com.lyghtningwither.honeyfunmods.entity;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.world.World;

public class EntityIcyMinecart extends EntityMinecart {

	public EntityIcyMinecart(World worldIn) {
		
		super(worldIn);
	}

	@Override
	public Type getType() {
		
		return Type.RIDEABLE;
	}
	
	@Override
	protected double getMaximumSpeed() {
		
		return 5.5D;
	}
	
	
}
