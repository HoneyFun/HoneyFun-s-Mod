package com.lyghtningwither.honeyfunmods.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.lyghtningwither.honeyfunmods.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class IcyOpalOre extends BlockBase {

	public IcyOpalOre(String name, Material material) {
		
		super(name, material);
		setSoundType(SoundType.GLASS);
		setHardness(3.0f);
		setResistance(25.5f);
		setHarvestLevel("pickaxe", 4);
	}
	
	@Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
        return ModItems.ICY_OPAL;
    }
	
	@Override
	public int quantityDropped(Random random) {
		
		return random.nextInt(1) + 1;
	}

	@Override
	protected boolean canSilkHarvest() {
		
		return true;
	}
}
