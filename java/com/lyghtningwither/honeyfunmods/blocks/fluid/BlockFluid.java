package com.lyghtningwither.honeyfunmods.blocks.fluid;

import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemBlock;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHealth;
import net.minecraft.potion.PotionHealthBoost;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluid extends BlockFluidClassic {

	public BlockFluid(String name, Fluid fluid, Material material) {
		
		super(fluid, material);
		setUnlocalizedName(name);
		setRegistryName(name);
		ModBlocks.BLOCKS.add(this);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		
		return EnumBlockRenderType.MODEL;
	}
}
