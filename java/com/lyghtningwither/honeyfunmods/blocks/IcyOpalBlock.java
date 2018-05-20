package com.lyghtningwither.honeyfunmods.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class IcyOpalBlock extends BlockBase {

	public IcyOpalBlock(String name, Material material) {
		
		super(name, material);
		setSoundType(SoundType.GLASS);
		setHardness(10.5f);
		setResistance(20000500);
		setHarvestLevel("pickaxe", 2);
	}
}
