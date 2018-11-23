package com.lyghtningwither.honeyfunmods.blocks.wire.silver;

import com.lyghtningwither.honeyfunmods.blocks.wire.TileEntityWireAbstract;
import com.lyghtningwither.honeyfunmods.blocks.wire.UpdateContext;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SilverWire extends TileEntityWireAbstract {

	@Override
	public boolean checkBlockstate(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TileEntity updateBlockState(World world, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UpdateContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleUpdate(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	protected int getTransferRate() {
		
		return 1500;
	}
}
