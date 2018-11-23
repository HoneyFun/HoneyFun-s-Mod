package com.lyghtningwither.honeyfunmods.enchantments;

import com.lyghtningwither.honeyfunmods.changes.FrostbiteEvent;
import com.lyghtningwither.honeyfunmods.init.EnchantmentInit;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class FrostbiteEnchantment extends Enchantment {

	public FrostbiteEnchantment() {
		
		super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
		this.setName("frostbite");
		this.setRegistryName("frostbite");
		
		EnchantmentInit.ENCHANTMENTS.add(this);
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 10 * enchantmentLevel;
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return this.getMinEnchantability(enchantmentLevel) + 10;
	}
	
	@Override
	public int getMaxLevel() {
		
		return 1;
	}
	
	@Override
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
		
		try {
			BlockPos pos1 = target.getPosition();
			BlockPos pos2 = target.getPosition().up();
			
			World world = target.getEntityWorld();
			
			if(!world.isRemote) {
				
				if(target.height == 1) {
					
					world.setBlockState(pos1, Blocks.FROSTED_ICE.getDefaultState());
				} else {
					
					world.setBlockState(pos1, Blocks.FROSTED_ICE.getDefaultState());
					world.setBlockState(pos2, Blocks.FROSTED_ICE.getDefaultState());
				}
			}
			
			MinecraftForge.EVENT_BUS.post(new FrostbiteEvent((EntityLivingBase) target, user, pos1));
		} catch (ClassCastException e) {
			
			target.getEntityWorld().setBlockState(target.getPosition(), Blocks.FROSTED_ICE.getDefaultState());
		}
	}
}
