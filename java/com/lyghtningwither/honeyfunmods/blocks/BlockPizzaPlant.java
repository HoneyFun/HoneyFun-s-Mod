/*package com.lyghtningwither.honeyfunmods.blocks;

import java.util.Random;

import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPizzaPlant extends BlockCrops {
	
	private static final AxisAlignedBB[] tomato = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};
	
	public BlockPizzaPlant(String name) {
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name).setUnlocalizedName(name));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		return ModItems.PIZZA;
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		
		if(this.isMaxAge(state)) return 1;
		else return random.nextInt(4) + 1;
	}
	
	@Override
	protected Item getSeed() {
		
		return ModItems.PEPPERONI;
	}
	
	@Override
	protected Item getCrop() {
		
		return ModItems.PIZZA;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		
		return tomato[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}
}
*/