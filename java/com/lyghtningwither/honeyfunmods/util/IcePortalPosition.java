package com.lyghtningwither.honeyfunmods.util;

import net.minecraft.util.math.BlockPos;

public class IcePortalPosition extends BlockPos {

	public long lastUpdateTime;
	
	public IcePortalPosition(BlockPos pos, long lastUpdateTime) {
		
		super(pos.getX(), pos.getY(), pos.getZ());
		
		this.lastUpdateTime = lastUpdateTime;
	}
}
