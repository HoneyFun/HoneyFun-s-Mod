package com.lyghtningwither.honeyfunmods.fluids;

import com.lyghtningwither.honeyfunmods.init.FluidInit;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidLiquid extends Fluid {
	
	public FluidLiquid(String name, ResourceLocation still, ResourceLocation flow) {
		
		super(name, still, flow);
		setUnlocalizedName(name);
	}
}
