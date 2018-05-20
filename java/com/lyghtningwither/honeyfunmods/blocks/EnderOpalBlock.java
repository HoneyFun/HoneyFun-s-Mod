package com.lyghtningwither.honeyfunmods.blocks;

import com.lyghtningwither.honeyfunmods.Main;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnderOpalBlock extends BlockBase {

	public EnderOpalBlock(String name, Material material) {
		
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(15);
		setResistance(1000000);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(Main.honeyfuntab_blocks);
	}
}
