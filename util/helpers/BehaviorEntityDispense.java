package com.lyghtningwither.honeyfunmods.util.helpers;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public abstract class BehaviorEntityDispense extends BehaviorDefaultDispenseItem {

	@Override
	public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
		
		World world = source.getWorld();
		IPosition position = BlockDispenser.getDispensePosition(source);
		EnumFacing facing = (EnumFacing) source.getBlockState().getValue(BlockDispenser.FACING);
		Entity entity = this.getEntity(world, position, stack);
		entity.setPosition(source.getX(), source.getY(), source.getZ());
		world.spawnEntity(entity);
		stack.damageItem(1, (EntityLivingBase) entity);
		return stack;
	}
	
	public abstract Entity getEntity(World worldIn, IPosition position, ItemStack stackIn);
	
	@Override
	protected void playDispenseSound(IBlockSource source) {
		
		source.getWorld().playSound(source.getX(), source.getY(), source.getZ(), SoundEvents.BLOCK_DISPENSER_DISPENSE, SoundCategory.BLOCKS, 100, 100, true);
	}
}
