package com.lyghtningwither.honeyfunmods.util.helpers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHelper {

	public static void registerRenderer(Class<? extends Entity> entityClass, Render render) {
		
		RenderingRegistry.registerEntityRenderingHandler(entityClass, new IRenderFactory() {

			@Override
			public Render createRenderFor(RenderManager manager) {
				
				return render;
			}
		});
	}
}
