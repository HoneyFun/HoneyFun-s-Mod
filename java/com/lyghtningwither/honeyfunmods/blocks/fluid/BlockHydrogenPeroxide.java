package com.lyghtningwither.honeyfunmods.blocks.fluid;

import com.lyghtningwither.honeyfunmods.init.FluidInit;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

public class BlockHydrogenPeroxide extends BlockFluid {
	
	public BlockHydrogenPeroxide() {
		
		super("hydrogen_peroxide", FluidInit.HYDROGEN_PEROXIDE, Material.WATER);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		
		if(entityIn instanceof EntityLivingBase) {
			
			EntityLivingBase entity = (EntityLivingBase) entityIn;
			
			entity.heal(1);
		}
	}
}
