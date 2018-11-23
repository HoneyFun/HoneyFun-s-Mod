package com.lyghtningwither.honeyfunmods.blocks.wire.silver;

import com.lyghtningwither.honeyfunmods.blocks.BlockBase;
import com.lyghtningwither.honeyfunmods.blocks.wire.TileEntityWireAbstract;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSilverWire extends BlockBase implements ITileEntityProvider {

	public BlockSilverWire(String name) {
		
		super(name, Material.CIRCUITS);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		
		TileEntityWireAbstract sw = (TileEntityWireAbstract) new SilverWire();
		
		return (TileEntity) sw;
	}
}
