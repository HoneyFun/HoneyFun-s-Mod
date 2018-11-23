package com.lyghtningwither.honeyfunmods.blocks;

import java.util.Random;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.commands.util.Teleport;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;
import com.lyghtningwither.honeyfunmods.util.handlers.ConfigHandler;
import com.lyghtningwither.honeyfunmods.util.handlers.SoundHandler;
import com.lyghtningwither.honeyfunmods.world.dimension.ice_age.DimensionIceAge;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockIcePortal extends BlockBase {

	public static final AxisAlignedBB ICE_PORTAL_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	
	public BlockIcePortal(String name, Material material) {
		
		super(name, material);
		setCreativeTab(Main.honeyfuntab_blocks);
		setResistance(2000);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(!worldIn.isRemote) {
			
			if(playerIn.dimension != 512) {
				
				playerIn.dimension = 512;
				World world = worldIn.getMinecraftServer().getWorld(512);
				world.setBlockState(new BlockPos(hitX,  hitY - 1, hitZ), ModBlocks.ICE_PORTAL_BLOCK.getDefaultState());
				world.playSound(playerIn, pos, SoundHandler.portal, SoundCategory.BLOCKS, 100, 100);
			} else if (playerIn.dimension == 512) {
				
				playerIn.dimension = 0;
				World world = worldIn.getMinecraftServer().getWorld(0);
				world.setBlockState(new BlockPos(hitX, hitY - 1, hitZ), ModBlocks.ICE_PORTAL_BLOCK.getDefaultState());
				world.playSound(playerIn, pos, SoundHandler.portal, SoundCategory.BLOCKS, 100, 100);
			} else {
				
				playerIn.sendStatusMessage(new TextComponentTranslation("tile.ice_portal.notInCorrectDimension", new Object[0]), true);
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
		
		return this.ICE_PORTAL_AABB;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		
		return false;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		return ModItems.COMPRESSED_OBSIDIAN;
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		
		return random.nextInt(4);
	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        for (int i = 0; i < 3; ++i)
        {
            int j = rand.nextInt(2) * 2 - 1;
            int k = rand.nextInt(2) * 2 - 1;
            double d0 = (double)pos.getX() + 0.5D + 0.25D * (double)j;
            double d1 = (double)((float)pos.getY() + rand.nextFloat());
            double d2 = (double)pos.getZ() + 0.5D + 0.25D * (double)k;
            double d3 = (double)(rand.nextFloat() * (float)j);
            double d4 = ((double)rand.nextFloat() - 0.5D) * 0.125D;
            double d5 = (double)(rand.nextFloat() * (float)k);
            worldIn.spawnParticle(EnumParticleTypes.SPELL, d0, d1, d2, d3, d4, d5);
        }
    }
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		
		return new ItemStack(ModBlocks.ICE_PORTAL_BLOCK);
	}
}
