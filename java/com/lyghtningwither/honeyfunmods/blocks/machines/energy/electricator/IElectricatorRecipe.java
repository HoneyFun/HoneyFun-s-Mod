package com.lyghtningwither.honeyfunmods.blocks.machines.energy.electricator;

import net.minecraft.item.ItemStack;

public interface IElectricatorRecipe {
	
	public ItemStack getSlot1();
	public ItemStack getSlot2();
	public ItemStack getSlot3();
	public ItemStack getSlot4();
	public ItemStack getSlot5();
	public ItemStack getSlot6();
	public ItemStack getSlot7();
	public ItemStack getOutput();
	
	public int getEnergy();
	public int getTime();
}
