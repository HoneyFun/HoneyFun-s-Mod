package com.lyghtningwither.honeyfunmods.util.handlers;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.entity.EntityExplosionStaff;
import com.lyghtningwither.honeyfunmods.entity.EntityFireExtinguisher;
import com.lyghtningwither.honeyfunmods.entity.EntityLightningStaff;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;
import com.lyghtningwither.honeyfunmods.util.Reference;
import com.lyghtningwither.honeyfunmods.util.helpers.RenderHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHandler {
	
	public static void registerRenderers() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityExplosionStaff.class, new IRenderFactory() {

			@Override
			public Render createRenderFor(RenderManager manager) {
				
				return new RenderSnowball<EntityExplosionStaff>(manager, ModItems.EXPLOSION_STAFF, Minecraft.getMinecraft().getRenderItem());
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityLightningStaff.class, new IRenderFactory() {

			@Override
			public Render createRenderFor(RenderManager manager) {
				
				return new RenderSnowball<EntityLightningStaff>(manager, ModItems.LIGHTNING_STAFF, Minecraft.getMinecraft().getRenderItem());
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFireExtinguisher.class, new IRenderFactory() {

			@Override
			public Render createRenderFor(RenderManager manager) {
				
				return new RenderSnowball<EntityExplosionStaff>(manager, ModItems.FIRE_EXTINGUISHER, Minecraft.getMinecraft().getRenderItem());
			}
		});
	}
	
	public static void registerCustomMeshesAndStates() {
		
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.HYDROGEN_PEROXIDE), new ItemMeshDefinition() {
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				
				return new ModelResourceLocation(Reference.MOD_ID + ":hydrogen_peroxide", "fluid");
			}
		});
		
		ModelLoader.setCustomStateMapper(ModBlocks.HYDROGEN_PEROXIDE, new StateMapperBase() {
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				
				return new ModelResourceLocation(Reference.MOD_ID + ":hydrogen_peroxide", "fluid");
			}
		});
	}
}
