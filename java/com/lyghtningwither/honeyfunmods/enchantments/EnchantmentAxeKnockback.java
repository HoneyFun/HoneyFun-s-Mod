package com.lyghtningwither.honeyfunmods.enchantments;

import com.lyghtningwither.honeyfunmods.init.EnchantmentInit;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class EnchantmentAxeKnockback extends Enchantment {

	public EnchantmentAxeKnockback() {
		
		super(Rarity.RARE, EnumEnchantmentType.ALL, new EntityEquipmentSlot [] {EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
		this.setName("Axe Knockback");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + "axe_knockback"));
		
		EnchantmentInit.ENCHANTMENTS.add(this);
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 15 * enchantmentLevel;
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return this.getMinEnchantability(enchantmentLevel) + 15;
	}
	
	@Override
	public int getMaxLevel() {

		return 2;
	}
}
