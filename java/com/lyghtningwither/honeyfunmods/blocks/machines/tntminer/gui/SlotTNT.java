package com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.gui;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class SlotTNT extends Slot {

	public SlotTNT(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		
		Item item = stack.getItem();
		
		if(!(item instanceof ItemBlock)) return false;
		
		if(!(Block.getBlockFromItem(item) == Blocks.TNT)) return false;
		
		return true;
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		
		return 256;
	}
}
