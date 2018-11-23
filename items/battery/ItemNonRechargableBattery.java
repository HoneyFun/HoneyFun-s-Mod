package com.lyghtningwither.honeyfunmods.items.battery;

import java.util.List;

import com.lyghtningwither.honeyfunmods.items.ItemBase;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class ItemNonRechargableBattery extends ItemBase {
	
	public ItemNonRechargableBattery(String name) {
		
		super(name);
		setMaxDamage(getMaxEnergy());
		setMaxStackSize(1);
	}
	
	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		
		return true;
	}
	
	public abstract int getMaxEnergy();
	
	public abstract int getTransferRate();
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		
		int energy = this.getDamage(stack);
		String color = "";
		
		if(energy <= this.getMaxDamage(stack) / 3) {
			
			color = "\u00a74";
		} else if (energy > this.getMaxDamage(stack) * 2 / 3) {
			
			color = "\u00a72";
		} else {
			
			color = "\u00a7e";
		}
		
		tooltip.add("Max Energy: " + this.getMaxDamage(stack));
		tooltip.add(color + "Energy: " + energy + " gJ / " + this.getMaxDamage(stack));
	}
	
	public static void discharge(int amount, ItemStack stack) {
		
		if(stack.getItem() instanceof ItemNonRechargableBattery) {
			
			stack.damageItem(amount, (EntityLivingBase) null);
		}
	}
}
