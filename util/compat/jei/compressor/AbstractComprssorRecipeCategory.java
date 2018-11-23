package com.lyghtningwither.honeyfunmods.util.compat.jei.compressor;

import com.lyghtningwither.honeyfunmods.util.Reference;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class AbstractComprssorRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T> {
	
	protected static final int input = 0;
	protected static final int output = 1;
	
	protected final IDrawableAnimated animatedArrow;
	
	protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/electric_compressor.png");
	
	public AbstractComprssorRecipeCategory(IGuiHelper helper) {
		
		IDrawableStatic staticArrow = helper.createDrawable(TEXTURES, 80, 35, 22, 16);
		animatedArrow = helper.createAnimatedDrawable(staticArrow, 40, IDrawableAnimated.StartDirection.LEFT, false);
	}
}