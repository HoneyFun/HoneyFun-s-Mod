package com.lyghtningwither.honeyfunmods.blocks.machines.energy.tileentity;

import java.io.ObjectInputStream.GetField;

import com.lyghtningwither.honeyfunmods.blocks.machines.energy.CustomEnergyStorage;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityLightningGenerator extends TileEntity implements ITickable {
	
	private CustomEnergyStorage storage = new CustomEnergyStorage(800000, 10000);
	private String customName;
	public int strikeTime = 0;
	public int energy = storage.getEnergyStored();
	private boolean generating = true;
	
	@Override
	public void update() {
		
		if(world.getRedstonePower(pos, null) >= 1) {
		
			if(this.energy >= 8000000) generating = false;
			else generating = true;
			
			if(generating) {
				
				storage.receiveEnergy(15000, false);
				strikeTime++;
			}
			
			if(strikeTime >= 100 && generating) {
				
				world.addWeatherEffect(new EntityLightningBolt(world, pos.getX(), pos.getY() + 1, pos.getZ(), false));
				strikeTime = 0;
			}
		}
		
		if(world.getBlockState(pos.down()).getBlock().hasTileEntity(world.getBlockState(pos.down()))) {
			
			if(world.getTileEntity(pos.down()).getCapability(CapabilityEnergy.ENERGY, null) != null) {
				
				if(energy >= 10000) {
					
					this.storage.extractEnergy(10000, false);
					world.getTileEntity(pos.down()).getCapability(CapabilityEnergy.ENERGY, null).receiveEnergy(10000, false);
				}
			}
		}
		
		energy = storage.getEnergyStored();
	}
	
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
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		
		super.writeToNBT(compound);
		compound.setInteger("Energy", this.energy);
		compound.setString("Name", getDisplayName().toString());
		compound.setInteger("StrikeTime", strikeTime);
		this.storage.writeToNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
		super.readFromNBT(compound);
		this.energy = compound.getInteger("Energy");
		this.customName = compound.getString("Name");
		strikeTime = compound.getInteger("StrikeTime");
		this.storage.readFromNBT(compound);
	}
	
	@Override
	public ITextComponent getDisplayName() {
		
		return new TextComponentTranslation("container.lightning_generator");
	}
	
	public int getEnergyStored() {
		
		return this.energy;
	}
	
	public int getMaxEnergyStored() {
		
		return this.storage.getMaxEnergyStored();
	}
	
	public int getField(int id) {
		
		switch(id) {
			
		case 0:
			return this.energy;
		case 1:
			return this.strikeTime;
		default:
			return 0;
		}
	}
	
	public void setField(int id, int value) {
		
		switch(id) {
		
		case 0: this.energy = value;
		case 1: this.strikeTime = value;
		}
	}
	
	public boolean isUsableByPlayer(EntityPlayer player) {
		
		return this.world.getTileEntity(this.pos) != this ? false

				: player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,

						(double) this.pos.getZ() + 0.5D) <= 64.0D;
	}
}
