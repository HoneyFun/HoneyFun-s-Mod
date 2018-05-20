package com.lyghtningwither.honeyfunmods.init;

import java.util.ArrayList;

import com.lyghtningwither.honeyfunmods.enchantments.EnchantmentAxeKnockback;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Reference.MOD_ID)
public class EnchantmentInit {

	public static ArrayList<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();
	
	//public static final Enchantment AXE_KNOCKBACK = new EnchantmentAxeKnockback();
}
