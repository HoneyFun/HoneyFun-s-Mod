package com.lyghtningwither.honeyfunmods.init;

import java.util.ArrayList;

import com.lyghtningwither.honeyfunmods.enchantments.FrostbiteEnchantment;
import com.lyghtningwither.honeyfunmods.enchantments.HeatTraverserEnchantment;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentInit {

	public static final ArrayList<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();
	
	public static final FrostbiteEnchantment FROSTBITE_ENCHANTMENT = new FrostbiteEnchantment();

	public static final Enchantment HEAT_TRAVERSER = new HeatTraverserEnchantment();
}