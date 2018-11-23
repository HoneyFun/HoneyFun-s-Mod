package com.lyghtningwither.honeyfunmods.blocks;

import java.util.Random;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.commands.CommandDimensionTeleport;
import com.lyghtningwither.honeyfunmods.commands.util.Teleport;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.util.handlers.SoundHandler;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.chat.OverlayChatListener;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import scala.swing.TextComponent;

public class BlockBacktracker extends BlockBase {

	public BlockBacktracker(String name, Material material) {
		
		super(name, material);
		setCreativeTab(Main.honeyfuntab_blocks);
		setResistance(2000);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(!worldIn.isRemote) {
			
			if(playerIn.dimension == 0) {
				
				playerIn.sendStatusMessage(new TextComponentTranslation("tile.backtracker.inOverworld", new Object[0]), true);
			} else {
				
				playerIn.dimension = 0;
				MinecraftServer server = worldIn.getMinecraftServer();
				server.getWorld(0).playSound(pos.getX(), pos.getY(), pos.getZ(), SoundHandler.portal, SoundCategory.BLOCKS, 100, 100, true);
			}
		}
		
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		
		return false;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		return null;
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		
		return new ItemStack(ModBlocks.BACKTRACKER);
	}
}
