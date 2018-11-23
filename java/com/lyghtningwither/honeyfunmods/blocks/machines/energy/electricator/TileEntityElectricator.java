package com.lyghtningwither.honeyfunmods.blocks.machines.energy.electricator;

import com.lyghtningwither.honeyfunmods.blocks.machines.energy.CustomEnergyStorage;
import com.lyghtningwither.honeyfunmods.blocks.recipe.CompressorRecipes;
import com.lyghtningwither.honeyfunmods.items.battery.ItemNonRechargableBattery;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityElectricator extends TileEntity implements ITickable {
	
	private CustomEnergyStorage storage = new CustomEnergyStorage(75000);
	public ItemStackHandler handler = new ItemStackHandler(9);
	private String customName = "";
	public int cookTime, energy = storage.getEnergyStored();
	private ItemStack[] smelting = {ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY};
	private boolean powered;
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		if(capability == CapabilityEnergy.ENERGY) return true;
		
		else return false;
	}
	
	@Override
	public void update() {
		
		energy = storage.getEnergyStored();
		
		if(energy >= 80000) powered = false;
		else powered = true;
		
		if(world.isBlockPowered(pos) && powered) storage.receiveEnergy(150, false);
		
		ItemStack[] input = {handler.getStackInSlot(0),handler.getStackInSlot(1),handler.getStackInSlot(2),handler.getStackInSlot(3),handler.getStackInSlot(4),handler.getStackInSlot(5),handler.getStackInSlot(6),handler.getStackInSlot(7)};
		IElectricatorRecipe recipe = RecipesElectricator.getInstance().getItemOutput(input);
		ItemStack output = handler.getStackInSlot(8);
		
		if(recipe != null) {
			
			if(energy > recipe.getEnergy()) {
				
				if(cookTime >= recipe.getTime()) {
					
					cookTime = 0;
					
					if(!output.isEmpty()) {
						
						output.grow(recipe.getOutput().getCount());
						
						input[0].shrink(recipe.getSlot1().getCount());
						input[1].shrink(recipe.getSlot2().getCount());
						input[2].shrink(recipe.getSlot3().getCount());
						input[3].shrink(recipe.getSlot4().getCount());
						input[4].shrink(recipe.getSlot5().getCount());
						input[5].shrink(recipe.getSlot6().getCount());
						input[6].shrink(recipe.getSlot7().getCount());
					} else {
						
						output = recipe.getOutput();
						
						input[0].shrink(recipe.getSlot1().getCount());
						input[1].shrink(recipe.getSlot2().getCount());
						input[2].shrink(recipe.getSlot3().getCount());
						input[3].shrink(recipe.getSlot4().getCount());
						input[4].shrink(recipe.getSlot5().getCount());
						input[5].shrink(recipe.getSlot6().getCount());
						input[6].shrink(recipe.getSlot7().getCount());
					}
					
					energy -= recipe.getEnergy();
				} else {
					
					cookTime++;
				}
			}
		}
		
		if(handler.getStackInSlot(8).getItem() instanceof ItemNonRechargableBattery) {
			
			ItemStack item = handler.getStackInSlot(8);
			
			if(storage.getEnergyStored() < storage.getMaxEnergyStored()) {
				
				ItemNonRechargableBattery battery = (ItemNonRechargableBattery) item.getItem();
				ItemNonRechargableBattery.discharge(battery.getTransferRate(), item);
				storage.receiveEnergy(battery.getTransferRate(), false);
			}
		}
	}
}
