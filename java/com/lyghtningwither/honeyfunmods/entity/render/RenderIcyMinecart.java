package com.lyghtningwither.honeyfunmods.entity.render;

import com.lyghtningwither.honeyfunmods.entity.EntityIcyMinecart;
import com.lyghtningwither.honeyfunmods.entity.model.ModelIcyMinecart;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.util.ResourceLocation;

public class RenderIcyMinecart extends RenderMinecart<EntityIcyMinecart> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/icy_minecart.png");
	
	public RenderIcyMinecart(RenderManager renderManager) {
		
		super(renderManager);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityIcyMinecart entity) {
		
		return TEXTURES;
	}
}
