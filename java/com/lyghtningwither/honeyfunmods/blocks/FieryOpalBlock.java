package com.lyghtningwither.honeyfunmods.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class FieryOpalBlock extends BlockBase {

	public FieryOpalBlock(String name, Material material) {
		
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(5);
		setResistance(3000000);
		setHarvestLevel("pickaxe", 2);
	}

	
}
