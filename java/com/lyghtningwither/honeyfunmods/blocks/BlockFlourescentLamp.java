package com.lyghtningwither.honeyfunmods.blocks;

import java.util.Random;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockFlourescentLamp extends BlockBase
{
    public static final PropertyBool IS_ON = PropertyBool.create("on");
    
    private boolean isOn;

    public BlockFlourescentLamp(String name, Material material) {
    	
        super(name, material);
        this.setHardness(3);
        this.setResistance(5);
        this.setHarvestLevel("pickaxe", 2);
        this.setDefaultState(this.getDefaultState().withProperty(IS_ON, false));
        setCreativeTab(Main.honeyfuntab_blocks);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
    	
    	return false;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
    	
    	return new BlockStateContainer(this, IS_ON);
    }
    
    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            if (!worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.FLOURESCENT_LAMP.getDefaultState(), 2);
                this.isOn = false;
            }
            else if (worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.FLOURESCENT_LAMP.getDefaultState().withProperty(IS_ON, true), 2);
                this.isOn = true;
            }
        }
    }
    
    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!worldIn.isRemote)
        {
            if (!worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.FLOURESCENT_LAMP.getDefaultState(), 2);
                this.isOn = false;
            }
            else if (worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.FLOURESCENT_LAMP.getDefaultState().withProperty(IS_ON, true), 2);
                this.isOn = true;
            }
        }
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (!worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.FLOURESCENT_LAMP.getDefaultState(), 2);
                this.isOn = false;
            }
        }
    }
    
    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.FLOURESCENT_LAMP);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.FLOURESCENT_LAMP);
    }

    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(ModBlocks.FLOURESCENT_LAMP);
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta) {
    	
    	return this.getDefaultState().withProperty(IS_ON, isOn);
    }
    
    @Override
    public int getMetaFromState(IBlockState state) {
    	
    	int ioi;
    	
    	if(state.getValue(IS_ON)) ioi = 1;
    	else ioi = 0;
    	
    	return ioi;
    }
}