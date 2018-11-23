package com.lyghtningwither.honeyfunmods.util.compat.jei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Map.Entry;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.container.ContainerElectricCompressor;
import com.lyghtningwither.honeyfunmods.blocks.recipe.CompressorRecipes;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.util.compat.jei.compressor.CompressorRecipe;
import com.lyghtningwither.honeyfunmods.util.compat.jei.compressor.CompressorRecipeCategory;
import com.lyghtningwither.honeyfunmods.util.compat.jei.compressor.CompressorRecipeMaker;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

@JEIPlugin
public class JEICompat implements IModPlugin {
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		
		final IJeiHelpers helpers = registry.getJeiHelpers();
		final IGuiHelper gui = helpers.getGuiHelper();
		
		registry.addRecipeCategories(new CompressorRecipeCategory(gui));
	}
	
	@Override
	public void register(IModRegistry registry) {
		
		final IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
		final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();
		
		registry.addRecipes(CompressorRecipeMaker.getRecipes(jeiHelpers), RecipeCategories.COMPRESSOR);
		registry.addDescription(new ItemStack(ModBlocks.COMPRESSOR), "Allows you to compress blocks into their compressed varieties.");
		recipeTransfer.addRecipeTransferHandler(ContainerElectricCompressor.class, RecipeCategories.COMPRESSOR, 0, 1, 2, 36);
	}
	
	public static String translateToLocal(String key) {
		
		if(I18n.canTranslate(key)) return I18n.translateToLocal(key);
		else return I18n.translateToFallback(key);
	}
	
	public static String translateToLocalFormatted(String key, Object... format) {
		
		String s = translateToLocal(key);
		
		try {return String.format(s, format);}
		catch (IllegalFormatException e) {return "Format Error: " + s;}
	}
}
