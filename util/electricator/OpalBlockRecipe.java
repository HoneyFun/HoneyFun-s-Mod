package com.lyghtningwither.honeyfunmods.util.electricator;

import com.lyghtningwither.honeyfunmods.blocks.machines.energy.electricator.IElectricatorRecipe;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;

import net.minecraft.item.ItemStack;

public class OpalBlockRecipe implements IElectricatorRecipe {

	@Override
	public ItemStack getSlot1() {
		
		return new ItemStack(ModItems.OPAL);
	}

	@Override
	public ItemStack getSlot2() {
		
		return new ItemStack(ModItems.OPAL);
	}

	@Override
	public ItemStack getSlot3() {
		
		return new ItemStack(ModItems.OPAL);
	}

	@Override
	public ItemStack getSlot4() {
		
		return new ItemStack(ModItems.OPAL);
	}

	@Override
	public ItemStack getSlot5() {
		
		return new ItemStack(ModItems.OPAL);
	}

	@Override
	public ItemStack getSlot6() {
		
		return new ItemStack(ModItems.OPAL);
	}

	@Override
	public ItemStack getSlot7() {
		
		return new ItemStack(ModItems.OPAL);
	}

	@Override
	public int getEnergy() {
		
		return 150;
	}

	@Override
	public int getTime() {
		
		return 30;
	}

	@Override
	public ItemStack getOutput() {
		
		return new ItemStack(ModBlocks.OPAL_BLOCK);
	}
}
