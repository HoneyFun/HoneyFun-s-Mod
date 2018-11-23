package com.lyghtningwither.honeyfunmods.blocks.machines.tntminer;

import java.util.Random;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.blocks.BlockBase;
import com.lyghtningwither.honeyfunmods.blocks.machines.redstone.BlockRedstoneMachine;
import com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.tileentity.TileEntityTNTMiner;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTNTMiner extends BlockBase implements ITileEntityProvider {
	
	private TileEntityTNTMiner tileentity;
	
	public BlockTNTMiner(String name, Material material) {
		
		super(name, material);
		setResistance(200);
		setHardness(10);
		setHarvestLevel("pickaxe", 1);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		
		this.tileentity = new TileEntityTNTMiner();
		return tileentity;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(worldIn.isRemote) return false;
		
		playerIn.openGui(Main.instance, Reference.GUI_TNT_MINER, worldIn, pos.getX(), pos.getY(), pos.getZ());
		
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		
		super.breakBlock(worldIn, pos, state);
		
		InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
	}
}
