package com.lyghtningwither.honeyfunmods.util.handlers;

import com.lyghtningwither.honeyfunmods.entity.EntityExplosionStaff;
import com.lyghtningwither.honeyfunmods.entity.EntityFireExtinguisher;
import com.lyghtningwither.honeyfunmods.entity.EntityLightningStaff;
import com.lyghtningwither.honeyfunmods.init.ModItems;
import com.lyghtningwither.honeyfunmods.util.helpers.BehaviorEntityDispense;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Bootstrap;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DispenserHandler {
	
	public static void registerDispenserProjectiles() {
		 
		/*BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(ModItems.FIRE_EXTINGUISHER, new BehaviorEntityDispense() {
			
			@Override
			public Entity getEntity(World worldIn, IPosition position, ItemStack stackIn) {
				
				return new EntityFireExtinguisher(worldIn,, 3, 3, 3);
			}
		});
		
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(ModItems.LIGHTNING_STAFF, new BehaviorEntityDispense() {
			
			@Override
			public Entity getEntity(World worldIn, IPosition position, ItemStack stackIn) {
				
				return new EntityLightningStaff(worldIn, null, 3, 3, 3);
			}
		});
		
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(ModItems.EXPLOSION_STAFF, new BehaviorEntityDispense() {
			
			@Override
			public Entity getEntity(World worldIn, IPosition position, ItemStack stackIn) {
				
				return new EntityExplosionStaff(worldIn, null, 3, 3, 3, 3);
			}
		});*/
	}
}
