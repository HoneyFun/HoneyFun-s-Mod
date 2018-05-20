package com.lyghtningwither.honeyfunmods.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.lyghtningwither.honeyfunmods.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class FieryOpalOre extends BlockBase {

	public FieryOpalOre(String name, Material material) {
		
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(3.0f);
		setResistance(25.5f);
		setHarvestLevel("pickaxe", 4);
	}
	
	@Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
        return ModItems.FIERY_OPAL;
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
