package com.lyghtningwither.honeyfunmods.blocks.trees;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;
import com.lyghtningwither.honeyfunmods.items.ItemBlockVariants;
import com.lyghtningwither.honeyfunmods.util.handlers.EnumHandler;
import com.lyghtningwither.honeyfunmods.util.interfaces.IHasMetaName;
import com.lyghtningwither.honeyfunmods.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlanks extends Block implements IHasModel, IHasMetaName {

	public static final PropertyEnum<EnumHandler.PlanksVariants> VARIANT = PropertyEnum.<EnumHandler.PlanksVariants>create("variant", EnumHandler.PlanksVariants.class);
	
	private String name;
	
	public BlockPlanks(String name, Material materialIn) {
		
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.honeyfuntab_blocks);
		setSoundType(SoundType.WOOD);
		
		this.name = name;
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean isWood(IBlockAccess world, BlockPos pos) {
		
		return true;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		
		return ((EnumHandler.PlanksVariants)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		
		return ((EnumHandler.PlanksVariants)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		
		return this.getDefaultState().withProperty(VARIANT, EnumHandler.PlanksVariants.byMetaData(meta));
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		
		for(EnumHandler.PlanksVariants variant : EnumHandler.PlanksVariants.values()) {
			
			items.add(new ItemStack(this, 1, variant.getMeta()));
		}
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		
		return EnumHandler.PlanksVariants.values()[stack.getItemDamage()].getName();
	}

	@Override
	public void registerModels() {
		
		for(int i = 0; i < EnumHandler.PlanksVariants.values().length; i++) {
			
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "plank_" + EnumHandler.PlanksVariants.values()[i].getName(), "inventory");
		}
	}
	
	
}