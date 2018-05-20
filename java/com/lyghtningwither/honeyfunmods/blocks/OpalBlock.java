package com.lyghtningwither.honeyfunmods.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class OpalBlock extends BlockBase {

	public OpalBlock(String name, Material material) {
		
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(10.5f);
		setResistance(20000500);
		setHarvestLevel("pickaxe", 2);
	}
}
