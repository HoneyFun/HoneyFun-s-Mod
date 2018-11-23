package com.lyghtningwither.honeyfunmods.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlockBasalt extends BlockBase {
	
	public static final PropertyInteger AGE = PropertyInteger.create("bage", 1, 3);
	
	public BlockBasalt(String name, Material material) {
		
		super(name, material);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(1)));
		this.setTickRandomly(true);
	}
	
	public int getMetaFromState(IBlockState state) {
		 
        return ((Integer)state.getValue(AGE)).intValue();
    }
	
    public IBlockState getStateFromMeta(int meta) {
    	 
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(MathHelper.clamp(meta, 1, 3)));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
    	
    	return new BlockStateContainer(this, AGE);
    }
    
    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
    	
    	double d0 = (double)pos.getX() + 0.55D - (double)(rand.nextFloat() * 0.1F);
        double d1 = (double)pos.getY() + 0.55D - (double)(rand.nextFloat() * 0.1F);
        double d2 = (double)pos.getZ() + 0.55D - (double)(rand.nextFloat() * 0.1F);
        double d3 = (double)(0.4F - (rand.nextFloat() + rand.nextFloat()) * 0.4F);
    	
        worldIn.spawnParticle(EnumParticleTypes.LAVA, d0 * d3, d1 * d3, d2 * d3, rand.nextGaussian() * 0.005D, rand.nextGaussian() * 0.005D, rand.nextGaussian() * 0.005D);
    }
    
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
    	
    	int age = ((Integer)state.getValue(AGE)).intValue();
    	
    	if (age < 3) {
    		
    		IBlockState bState = state;
    		bState = bState.withProperty(BlockBasalt.AGE, age + 1);
    		
            worldIn.setBlockState(pos, bState, 2);
            worldIn.scheduleUpdate(pos, this, MathHelper.getInt(rand, 20, 40));
        }
    	
    	if(age >= 3) {
    		
    		worldIn.setBlockState(pos, Blocks.LAVA.getDefaultState());
    	}
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    	
    	return (Item) null;
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
    	
    	return ItemStack.EMPTY;
    }
}
