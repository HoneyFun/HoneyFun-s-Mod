package com.lyghtningwither.honeyfunmods.changes;

import java.util.UUID;

import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventHandlerHF {

	@SubscribeEvent
	public void LyghtningWitherLightning(EntityJoinWorldEvent event) {
		
		if(!(event.getEntity() instanceof EntityPlayer)) return;
		
		EntityPlayer player = (EntityPlayer) event.getEntity();
		
		if(player.getUniqueID() == UUID.fromString("65b35241-8a5a-4636-a9d7-e0d60402b4c4")) {
			
			EntityLightningBolt lightningBolt = new EntityLightningBolt(player.getEntityWorld(), player.posX, player.posY, player.posZ, true);
			
			player.getEntityWorld().spawnEntity(lightningBolt);
		}
	}
}
