package com.lyghtningwither.honeyfunmods.tabs;

import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HoneyfunTabToolsAndWeapons extends CreativeTabs {

	public HoneyfunTabToolsAndWeapons(String label) {
		
		super("honeyfuntab_tools_weapons");
	}
	
	@Override
	public ItemStack getTabIconItem() {
		
		return new ItemStack(ModItems.OBSIDIAN_SWORD);
	}	
}