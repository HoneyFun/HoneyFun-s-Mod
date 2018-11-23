package com.lyghtningwither.honeyfunmods.blocks.machines.energy.tileentity;

import com.lyghtningwither.honeyfunmods.blocks.machines.energy.CustomEnergyStorage;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

public class TileEntityEnergyTutorial extends TileEntity implements ITickable {
	
	private CustomEnergyStorage storage = new CustomEnergyStorage(1000000, 10000);
	int removalTick = 0;
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		
		if(capability == CapabilityEnergy.ENERGY) return (T)this.storage;
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		
		if(capability == CapabilityEnergy.ENERGY) return true;
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public void update() {
		
		if (world.getRedstonePower(pos, null) > 0) this.storage.receiveEnergy(10000, false);
		
		removalTick++;
		
		if(removalTick >= 100) this.storage.extractEnergy(10000, false);
	}
}
