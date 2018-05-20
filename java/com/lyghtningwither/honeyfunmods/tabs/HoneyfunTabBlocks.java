package com.lyghtningwither.honeyfunmods.tabs;

import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HoneyfunTabBlocks extends CreativeTabs {

	public HoneyfunTabBlocks(String label) {
		
		super("honeyfuntab_blocks");
	}
	
	@Override
	public ItemStack getTabIconItem() {
		
		return new ItemStack(Item.getItemFromBlock(ModBlocks.ICE_PORTAL_BLOCK));
	}
}
