package com.lyghtningwither.honeyfunmods.blocks.machines.energy.electricator;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class RecipesElectricator {
	
	public ArrayList<IElectricatorRecipe> recipes = new ArrayList<IElectricatorRecipe>();
	
	public static final RecipesElectricator INSTANCE = new RecipesElectricator();
	
	private RecipesElectricator() {}
	
	public static RecipesElectricator getInstance() {return INSTANCE;}
	
	public void registerRecipe(IElectricatorRecipe recipe) {
		
		recipes.add(recipe);
	}
	
	public IElectricatorRecipe getItemOutput(ItemStack... items) {
		
		if(items.length > 7) return null;
		else if(items.length < 7) return null;
		else {
			
			for(IElectricatorRecipe recipe : recipes.toArray(new IElectricatorRecipe[0])) {
				
				boolean b1 = false;
				boolean b2 = false;
				boolean b3 = false;
				boolean b4 = false;
				boolean b5 = false;
				boolean b6 = false;
				boolean b7 = false;
				
				if(items[0] == recipe.getSlot1()) b1 = true;
				if(items[1] == recipe.getSlot2()) b2 = true;
				if(items[2] == recipe.getSlot3()) b3 = true;
				if(items[3] == recipe.getSlot4()) b4 = true;
				if(items[4] == recipe.getSlot5()) b5 = true;
				if(items[5] == recipe.getSlot6()) b6 = true;
				if(items[6] == recipe.getSlot7()) b7 = true;
				
				if(b1 && b2 && b3 && b4 && b5 && b6 && b7) return recipe;
			}
			
			return null;
		}
	}
}