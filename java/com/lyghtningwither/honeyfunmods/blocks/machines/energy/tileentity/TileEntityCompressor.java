package com.lyghtningwither.honeyfunmods.blocks.machines.energy.tileentity;

import com.lyghtningwither.honeyfunmods.blocks.machines.energy.BlockElectricFurnace;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.CustomEnergyStorage;
import com.lyghtningwither.honeyfunmods.blocks.recipe.CompressorRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityCompressor extends TileEntity implements ITickable {

	private CustomEnergyStorage storage = new CustomEnergyStorage(75000);
	public ItemStackHandler handler = new ItemStackHandler(2);
	private String customName = "";
	public int cookTime, energy = storage.getEnergyStored();
	private ItemStack smelting = ItemStack.EMPTY;
	private boolean powered;
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		if(capability == CapabilityEnergy.ENERGY) return true;
		else return false;
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.handler;
		if(capability == CapabilityEnergy.ENERGY) return (T)this.storage;
		return super.getCapability(capability, facing);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setTag("Inventory", this.handler.serializeNBT());
		compound.setInteger("CookTime", cookTime);
		compound.setInteger("GuiEnergy", energy);
		this.storage.writeToNBT(compound);
		compound.setString("Name", getDisplayName().toString());
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
		this.storage.readFromNBT(compound);
		this.cookTime = compound.getInteger("CookTime");
		this.energy = compound.getInteger("GuiEnergy");
		if(compound.hasKey("Name")) this.customName = compound.getString("Name");
	}
	
	@Override
	public void update() {
		
		if(energy >= 80000) powered = false;
		else powered = true;
		
		if(world.isBlockPowered(pos) && powered) storage.receiveEnergy(150, false);
		
		ItemStack input = handler.getStackInSlot(0);
		
		if(energy > 0) {
			
			if(cookTime > 0) {
				
				storage.extractEnergy(100, false);
				cookTime++;
				BlockElectricFurnace.setState(true, world, pos);
				if(cookTime >= 100)
				{
					if(handler.getStackInSlot(1).getCount() > 0)
					{
						handler.getStackInSlot(1).grow(1);
					}
					else
					{
						handler.insertItem(1, smelting, false);
					}
					smelting = ItemStack.EMPTY;
					cookTime = 0;
					return;
				}
			} else {
				
				if(!input.isEmpty()) {
					
					ItemStack output = CompressorRecipes.getInstance().getCompressorResult(input);
					
					if(!output.isEmpty()) {
						
						smelting = output;
						cookTime++;
						input.shrink(1);
						handler.setStackInSlot(0, input);
						world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS, 100, 100, false);
						
						storage.extractEnergy(20, false);
					}
				}
			}
		}
		
		energy = storage.getEnergyStored();
		
		if(energy < 0) storage.receiveEnergy(Math.abs(energy), false);
	}
	
	@Override
	public ITextComponent getDisplayName() 
	{
		return new TextComponentTranslation("container.electric_compressor");
	}
	
	public int getEnergyStored()
	{
		return this.energy;
	}
	
	public int getMaxEnergyStored()
	{
		return this.storage.getMaxEnergyStored();
	}
	
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}
	
	public int getField(int id) 
	{
		switch(id) 
		{
		case 0:
			return this.cookTime;
		case 1:
			return this.energy;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) 
	{
		switch(id) 
		{
		case 0:
			this.cookTime = value;
			break;
		case 1:
			this.energy = value;
		}
	}
}
