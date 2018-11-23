package com.lyghtningwither.honeyfunmods.blocks.machines.energy.electricator;

import com.lyghtningwither.honeyfunmods.blocks.BlockBase;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockElectricator extends BlockBase {
	
	private TileEntityElectricator tileentity;
	
	public BlockElectricator(String name) {

		super(name, Material.ANVIL);
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		
		tileentity = new TileEntityElectricator();
		return (TileEntity) tileentity;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		
		return true;
	}
}
