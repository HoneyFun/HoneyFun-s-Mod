package com.lyghtningwither.honeyfunmods.blocks;

import net.minecraft.block.material.Material;

public class BlockIcyBedrock extends BlockBase {

	public BlockIcyBedrock(String name, Material material) {
		
		super(name, material);
		setBlockUnbreakable();
		setResistance(1000000);
	}
}
