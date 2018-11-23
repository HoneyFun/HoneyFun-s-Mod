package com.lyghtningwither.honeyfunmods.blocks.recipe;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;

import net.minecraft.item.ItemStack;

public class CompressorRecipes {

	private static final CompressorRecipes INSTANCE = new CompressorRecipes();
	private final Map<ItemStack, ItemStack> smeltingList = Maps.<ItemStack, ItemStack>newHashMap();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static CompressorRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private CompressorRecipes() 
	{
		
	}

	
	public void addCompressorRecipe(ItemStack input, ItemStack result, float experience) 
	{
		if (getCompressorResult(input) != ItemStack.EMPTY) { Main.logger.info("Ignored compressing recipe with conflicting input: {} = {}", input, result); return; }
        this.smeltingList.put(input, result);
        this.experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getCompressorResult(ItemStack input) 
	{
		for (Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet())
        {
            if (this.compareItemStacks(input, entry.getKey()))
            {
                return entry.getValue();
            }
        }

        return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Map<ItemStack, ItemStack> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	public float getSinteringExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}

}
