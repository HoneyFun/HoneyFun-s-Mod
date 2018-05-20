package com.lyghtningwither.honeyfunmods.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.lyghtningwither.honeyfunmods.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class SilverOre extends BlockBase {

	public SilverOre(String name, Material material) {
		
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(3.0f);
		setResistance(15);
		setHarvestLevel("pickaxe", 2);
	}
}
