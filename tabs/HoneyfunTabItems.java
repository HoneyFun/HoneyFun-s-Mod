package com.lyghtningwither.honeyfunmods.tabs;

import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HoneyfunTabItems extends CreativeTabs {

	public HoneyfunTabItems(String label) {
		
		super("honeyfuntab_items");
	}
	
	@Override
	public ItemStack getTabIconItem() {
		
		return new ItemStack(ModItems.OPAL);
	}
}
