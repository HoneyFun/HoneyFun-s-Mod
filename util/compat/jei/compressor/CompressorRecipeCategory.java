package com.lyghtningwither.honeyfunmods.util.compat.jei.compressor;

import com.lyghtningwither.honeyfunmods.util.Reference;
import com.lyghtningwither.honeyfunmods.util.compat.jei.RecipeCategories;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;

public class CompressorRecipeCategory extends AbstractComprssorRecipeCategory<CompressorRecipe> {
	
	private final IDrawable background;
	private final String name;
	
	public CompressorRecipeCategory(IGuiHelper gui) {
		
		super(gui);
		background = gui.createDrawable(TEXTURES, 4, 12, 100, 80);
		name = "Compressor";
	}

	@Override
	public IDrawable getBackground() {
		
		return background;
	}
	
	@Override
	public void drawExtras(Minecraft minecraft) {
		
		animatedArrow.draw(minecraft, 40, 35);
	}
	
	@Override
	public String getTitle() {
		
		return name;
	}
	
	@Override
	public String getModName() {
		
		return Reference.NAME;
	}
	
	@Override
	public String getUid() {
		
		return RecipeCategories.COMPRESSOR;
	}
	
	public void setRecipe(IRecipeLayout recipeLayout, CompressorRecipe recipeWrapper, IIngredients ingredients) {
		
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(input, true, 52, 5);
		stacks.init(output, false, 112, 23);
		stacks.set(ingredients);
	};
}
