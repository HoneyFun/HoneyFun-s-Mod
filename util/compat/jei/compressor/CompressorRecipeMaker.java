package com.lyghtningwither.honeyfunmods.util.compat.jei.compressor;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.lyghtningwither.honeyfunmods.blocks.recipe.CompressorRecipes;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class CompressorRecipeMaker {
	
	public static List<CompressorRecipe> getRecipes(IJeiHelpers helpers) {
		
		IStackHelper stackHelper = helpers.getStackHelper();
		CompressorRecipes instance = CompressorRecipes.getInstance();
		Map<ItemStack, ItemStack> recipes = instance.getDualSmeltingList();
		
		List<CompressorRecipe> jeiRecipes = Lists.newArrayList();
		
		for (Entry<ItemStack, ItemStack> entry : recipes.entrySet()) {
			
            ItemStack input = entry.getValue();
            ItemStack output = entry.getKey();
            
            CompressorRecipe recipe = new CompressorRecipe(input, output);
        }
		
		return jeiRecipes;
	}
}
