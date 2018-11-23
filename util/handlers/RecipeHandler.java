package com.lyghtningwither.honeyfunmods.util.handlers;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.electricator.RecipesElectricator;
import com.lyghtningwither.honeyfunmods.blocks.recipe.CompressorRecipes;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;
import com.lyghtningwither.honeyfunmods.util.Reference;
import com.lyghtningwither.honeyfunmods.util.electricator.OpalBlockRecipe;
import com.lyghtningwither.honeyfunmods.util.helpers.RecipeHelper;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class RecipeHandler {

	public static void registerRecipes() {
		
		Main.logger.info("Registering Recipes...");
		Main.logger.info("Now starting to register crafting recipes...");
		
		//Crafting Recipes
		RecipeHelper.addCraftingRecipe("opal_block_recipe.json");
		RecipeHelper.addCraftingRecipe("miner_recipe.json");
		RecipeHelper.addCraftingRecipe("obsidian_recipe.json");
		RecipeHelper.addCraftingRecipe("obsidian_ingot_recipe.json");
		RecipeHelper.addCraftingRecipe("ice_portal_recipe.json");
		RecipeHelper.addCraftingRecipe("obsidian_axe_recipe.json");
		RecipeHelper.addCraftingRecipe("obsidian_boots_recipe.json");
		RecipeHelper.addCraftingRecipe("obsidian_chestplate_recipe.json");
		RecipeHelper.addCraftingRecipe("obsidian_helmet_recipe.json");
		RecipeHelper.addCraftingRecipe("obsidian_hoe_recipe.json");
		RecipeHelper.addCraftingRecipe("obsidian_leggings_recipe.json");
		RecipeHelper.addCraftingRecipe("obsidian_pickaxe_recipe.json");
		RecipeHelper.addCraftingRecipe("obsidian_shovel_recipe.json");
		RecipeHelper.addCraftingRecipe("obsidian_sword_recipe.json");
		RecipeHelper.addCraftingRecipe("fiery_opal_block_recipe.json");
		RecipeHelper.addCraftingRecipe("ender_opal_block_recipe.json");
		RecipeHelper.addCraftingRecipe("icy_opal_block_recipe.json");
		RecipeHelper.addCraftingRecipe("led_recipe.json");
		RecipeHelper.addCraftingRecipe("flourescent_lamp_recipe.json");
		RecipeHelper.addCraftingRecipe("backtracker_recipe.json");
		RecipeHelper.addCraftingRecipe("exploding_ore_recipe.json");
		RecipeHelper.addCraftingRecipe("backtracker_recipe_shapeless.json");
		RecipeHelper.addCraftingRecipe("lightning_staff_recipe.json");
		RecipeHelper.addCraftingRecipe("extinguisher_recipe_left.json");
		RecipeHelper.addCraftingRecipe("extinghisher_recipe_right.json");
		RecipeHelper.addCraftingRecipe("explosion_staff_recipe.json");
		RecipeHelper.addCraftingRecipe("compressor_recipe.json");
		RecipeHelper.addCraftingRecipe("lightning__generator_reicipe.json");
		
		Main.logger.info("Crafting Recipes Registered!");
		Main.logger.info("Now starting to register furnace recipes...");
		
		//Furnace Recipes
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.SILVER_ORE), new ItemStack(ModItems.SILVER_INGOT), 5);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.OPAL_ORE), new ItemStack(ModItems.OPAL, 3), 10);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.FIREY_OPAL_ORE), new ItemStack(ModItems.FIERY_OPAL, 3), 10);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.ENDER_OPAL_ORE), new ItemStack(ModItems.ENDER_OPAL, 3), 10);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.ICY_OPAL_ORE), new ItemStack(ModItems.ICY_OPAL, 3), 20);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.SILICON_ORE), new ItemStack(ModItems.SILICON_ROD), 10);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModBlocks.EXPLODING_ORE), new ItemStack(Blocks.TNT), 10);
		
		Main.logger.info("Furnace Recipes Registered!");
		Main.logger.info("Now starting to register compressor recipes...");
		
		CompressorRecipes.getInstance().addCompressorRecipe(new ItemStack(Blocks.QUARTZ_BLOCK), new ItemStack(Items.QUARTZ), 5);
		CompressorRecipes.getInstance().addCompressorRecipe(new ItemStack(ModBlocks.OPAL_BLOCK), new ItemStack(ModItems.OPAL), 5);
		CompressorRecipes.getInstance().addCompressorRecipe(new ItemStack(ModBlocks.FIERY_OPAL_BLOCK), new ItemStack(ModItems.FIERY_OPAL), 5);
		CompressorRecipes.getInstance().addCompressorRecipe(new ItemStack(ModBlocks.ENDER_OPAL_BLOCK), new ItemStack(ModItems.ENDER_OPAL), 5);
		CompressorRecipes.getInstance().addCompressorRecipe(new ItemStack(ModBlocks.ICY_OPAL_BLOCK), new ItemStack(ModItems.ICY_OPAL), 5);
		CompressorRecipes.getInstance().addCompressorRecipe(new ItemStack(Blocks.DIAMOND_BLOCK), new ItemStack(Items.DIAMOND), 5);
		CompressorRecipes.getInstance().addCompressorRecipe(new ItemStack(Blocks.IRON_BLOCK), new ItemStack(Items.IRON_INGOT), 5);
		
		Main.logger.info("Compressor Recipes Registered!");
		Main.logger.info("Now starting to register electricator recipes...");
		
		RecipesElectricator.getInstance().registerRecipe(new OpalBlockRecipe());
		
		Main.logger.info("Electricator Recipes Registered!");
		Main.logger.info("All recipes have been registered.");
	}
}
