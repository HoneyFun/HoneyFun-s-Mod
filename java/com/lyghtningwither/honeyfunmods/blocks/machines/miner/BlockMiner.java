package com.lyghtningwither.honeyfunmods.blocks.machines.miner;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.blocks.BlockBase;
import com.lyghtningwither.honeyfunmods.blocks.machines.miner.tileentity.TileEntityMiner;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMiner extends BlockBase implements ITileEntityProvider {

	public TileEntityMiner tileentity;
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public static final PropertyBool MINING = PropertyBool.create("mining");
	
	public EnumFacing facing;
	
	public IBlockState state;
	
	public BlockMiner(String name, Material material) {
		
		super(name, material);
		setHardness(10);
		setResistance(30);
		setHarvestLevel("pickaxe", 1);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(MINING, false));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(worldIn.isRemote) return false;
		
		for(Item item : FuelTypes.ITEMS) {
			
			if(playerIn.getHeldItem(hand).getItem() == item) {
				
				worldIn.setBlockState(pos, this.tileentity.getWorld().getBlockState(this.tileentity.getPos()).withProperty(MINING, true));
				
				tileentity.burningTimeInTicks = 10000;
				
				if(!playerIn.capabilities.isCreativeMode) {
					
					playerIn.getHeldItemMainhand().shrink(1);
				}
			}
		}
		
		return true;
	}
	
	public static void setState(World world, BlockPos pos, boolean active, int burningTime) {
		
		IBlockState state = world.getBlockState(pos);
		TileEntityMiner te = (TileEntityMiner) world.getTileEntity(pos);
		
		if(active) world.setBlockState(pos, ModBlocks.MINER.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(MINING, true));
		else world.setBlockState(pos, ModBlocks.MINER.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(MINING, false));
		
		if(te != null) {
			
			te.burningTimeInTicks = burningTime;
			te.isOn = true;
		}
	}
	
	public static void setState(World world, BlockPos pos, boolean active) {
		
		IBlockState state = world.getBlockState(pos);
		
		if(active) world.setBlockState(pos, ModBlocks.MINER.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(MINING, true));
		else world.setBlockState(pos, ModBlocks.MINER.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(MINING, false));
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		
		this.tileentity = new TileEntityMiner();
		this.tileentity.isOn = false;
		return this.tileentity;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		
		this.tileentity = new TileEntityMiner();
		this.tileentity.isOn = false;
		return this.tileentity;
	}
	
	@Override
	public boolean hasTileEntity() {
		
		return true;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		
		if(!worldIn.isRemote) {
			
			IBlockState north = worldIn.getBlockState(pos.north());
			IBlockState south = worldIn.getBlockState(pos.south());
			IBlockState east = worldIn.getBlockState(pos.east());
			IBlockState west = worldIn.getBlockState(pos.west());
			EnumFacing face = (EnumFacing) state.getValue(FACING);
			
			if(face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH;
			else if (face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) face = EnumFacing.NORTH;
			else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) face = EnumFacing.EAST;
			else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) face = EnumFacing.WEST;
			worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);
			this.state = state.withProperty(FACING, face);
			
			this.facing = face;
		}
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		
		worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		
		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		
		return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		
		return new BlockStateContainer(this, new IProperty[] {FACING, MINING});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		
		EnumFacing facing = EnumFacing.getFront(meta);
		if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
		return this.getDefaultState().withProperty(FACING, facing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		
		return ((EnumFacing) state.getValue(FACING)).getIndex();
	}
}
