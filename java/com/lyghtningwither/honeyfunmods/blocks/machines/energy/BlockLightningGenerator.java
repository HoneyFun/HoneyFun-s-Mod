package com.lyghtningwither.honeyfunmods.blocks.machines.energy;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.blocks.BlockBase;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.tileentity.TileEntityLightningGenerator;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockLightningGenerator extends BlockBase {
	
	private TileEntityLightningGenerator tileentity;
	
	public BlockLightningGenerator(String name) {
		
		super(name, Material.IRON);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(!worldIn.isRemote)
			playerIn.openGui(Main.instance, Reference.GUI_LIGHTNING_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
		
		return true;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		
		tileentity = new TileEntityLightningGenerator();
		return tileentity;
	}
}
