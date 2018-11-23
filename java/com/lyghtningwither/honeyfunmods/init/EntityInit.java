package com.lyghtningwither.honeyfunmods.init;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.entity.EntityCentaur;
import com.lyghtningwither.honeyfunmods.entity.EntityExplosionStaff;
import com.lyghtningwither.honeyfunmods.entity.EntityFireExtinguisher;
import com.lyghtningwither.honeyfunmods.entity.EntityIcyMinecart;
import com.lyghtningwither.honeyfunmods.entity.EntityLightningStaff;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {

	public static void registerEntities() {
		
		Main.logger.info("Registering Entities...");
		
		registerNonLivingEntity("staff_explosion", EntityExplosionStaff.class, Reference.ENTITY_EXPLOSION_STAFF, 10);
		registerNonLivingEntity("staff_lightning", EntityLightningStaff.class, Reference.ENTITY_LIGHTNING_STAFF, 10);
		registerNonLivingEntity("fire_extinguisher", EntityFireExtinguisher.class, Reference.ENTITY_FIRE_EXTINGUISHER, 10);
		
		Main.logger.info("Registered Entities!");
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
	
	private static void registerNonLivingEntity(String name, Class<? extends Entity> entity, int id, int range) {
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true);
	}
}
