package com.lyghtningwither.honeyfunmods.blocks;

import java.util.Random;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.blocks.itemblocks.ItemBlockDoor;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;
import com.lyghtningwither.honeyfunmods.util.interfaces.IHasModel;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockDoorBase extends BlockDoor implements IHasModel {
	
	public BlockDoorBase(String name) {
		
		super(Material.GLASS);

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.honeyfuntab_blocks);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockDoor(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		
		return new ItemStack(this);
	}
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
