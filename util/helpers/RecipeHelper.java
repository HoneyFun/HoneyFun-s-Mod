package com.lyghtningwither.honeyfunmods.util.helpers;

import com.google.gson.JsonObject;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class RecipeHelper {

	public static void addCraftingRecipe(String recipeName) {
		
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID + ":" + recipeName);
		
		AddCraftingRecipe(location);
	}
	
	public static void AddCraftingRecipe(ResourceLocation location) {
		
		CraftingHelper.register(location, new IRecipeFactory() {
			
			@Override
			public IRecipe parse(JsonContext context, JsonObject json) {
				
				return CraftingHelper.getRecipe(json, context);
			}
		});
	}
	
	public static void AddCraftingRecipe(String modId, String recipeName) {
		
		ResourceLocation location = new ResourceLocation(modId + ":" + recipeName);
		
		AddCraftingRecipe(location);
	}
}
