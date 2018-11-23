/*package com.lyghtningwither.honeyfunmods.items.food;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;
import com.lyghtningwither.honeyfunmods.util.interfaces.IHasModel;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.capabilities.Capability;

public class ItemNoodles extends ItemFood implements IHasModel, IPlantable {

	public ItemNoodles(String name, int amount, float saturation, boolean isWolfFood) {
		
		super(amount, saturation, isWolfFood);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.honeyfuntab_items);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		
		return EnumPlantType.Crop;
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		ItemStack itemstack = player.getHeldItem(hand);
		
		IBlockState state = worldIn.getBlockState(pos);
		
		if(facing == EnumFacing.UP && player.canPlayerEdit(pos, facing, itemstack) && state.getBlock().canSustainPlant(state, worldIn, pos, facing, this) && worldIn.isAirBlock(pos.up())) {
			
			worldIn.setBlockState(pos.up(), ModBlocks.NOODLE_PLANT.getDefaultState());
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		} else {
			
			return EnumActionResult.FAIL;
		}
		
	}
	
	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		
		return ModBlocks.NOODLE_PLANT.getDefaultState();
	}

	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
*/