package com.lyghtningwither.honeyfunmods.commands;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class Explosion extends CommandBase {

	@Override
	public String getName() {
		
		return "explosion";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		
		return "/explosion <x> <y> <z> <radius> [dimension ID]";
	}

	@Override
	public int getRequiredPermissionLevel() {
		
		return 2;
	}
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length < 4) return;
		
		int x = 0;
		int y = 0;
		int z = 0;
		int radius = 0;
		int dimensionId = 0;
		
		try {
			
			x = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "X cooirdinate invalid."));
			return;
		}
		
		try {
			
			y = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Y cooirdinate invalid."));
			return;
		}
		
		try {
			
			z = Integer.parseInt(args[2]);
		} catch (NumberFormatException e) {
			
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Z cooidinate invalid."));
			return;
		}
		
		try {
			
			radius = Integer.parseInt(args[3]);
		} catch (NumberFormatException e) {
			
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Radius invalid."));
			return;
		}
		
		if(args[4] != "") {
			
			try {
				
				dimensionId = Integer.parseInt(args[4]);
			} catch (NumberFormatException e) {
				
				sender.sendMessage(new TextComponentString(TextFormatting.RED + "Dimension ID invalid."));
				return;
			}
		}
		
		if(args[4] != "") {
			
			server.getWorld(dimensionId).createExplosion(null, x, y, z, radius, false);
			sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "Explosion created."));
		} else {
			
			server.getWorld(0).createExplosion(null, x, y, z, radius, false);
			sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "Explosion created."));
		}
	}
}
