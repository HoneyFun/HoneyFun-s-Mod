package com.lyghtningwither.honeyfunmods.init;

import java.util.ArrayList;
import java.util.List;

import com.lyghtningwither.honeyfunmods.fluids.FluidLiquid;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidInit {
	
	public static final List<Fluid> FLUIDS = new ArrayList<Fluid>();
	
	public static final Fluid HYDROGEN_PEROXIDE = new FluidLiquid("hydrogen_peroxide", new ResourceLocation(Reference.MOD_ID + ":blocks/hydrogen_peroxide_still"), new ResourceLocation(Reference.MOD_ID + ":blocks/hydrogen_peroxide_flow"));
	
	public static void registerFluids() {
		
		registerFluid(HYDROGEN_PEROXIDE);
	}
	
	public static void registerFluid(Fluid fluid) {
		
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
}
