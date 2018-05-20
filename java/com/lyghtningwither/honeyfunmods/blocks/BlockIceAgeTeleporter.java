package com.lyghtningwither.honeyfunmods.blocks;

import java.util.Random;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.commands.util.Teleport;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.world.dimension.ice_age.DimensionIceAge;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockIceAgeTeleporter extends BlockBase {

	public static final AxisAlignedBB ICE_PORTAL_AABB = new AxisAlignedBB(.365D, 0, .365D, .635D, .625D, .635D);
	
	public BlockIceAgeTeleporter(String name, Material material) {
		
		super(name, material);
		setCreativeTab(Main.honeyfuntab_blocks);
		setResistance(2000);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(!worldIn.isRemote) {
			
			if(playerIn.dimension != 2) {
				
				Teleport.TeleportToDimension(playerIn, 2, playerIn.posX, playerIn.posY, playerIn.posZ);
				World world = playerIn.world;
				world.setBlockState(new BlockPos(hitX,  hitY - 1, hitZ), ModBlocks.ICE_PORTAL_BLOCK.getDefaultState());
			} else if (playerIn.dimension == 2) {
				
				Teleport.TeleportToDimension(playerIn, 0, pos.getX(), pos.getY(), pos.getZ());
				World world = playerIn.world;
				world.setBlockState(new BlockPos(hitX, hitY - 1, hitZ), ModBlocks.ICE_PORTAL_BLOCK.getDefaultState());
			}
		}
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		
		return ICE_PORTAL_AABB;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		
		return false;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		return null;
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		
		return new ItemStack(ModBlocks.ICE_PORTAL_BLOCK);
	}
}
