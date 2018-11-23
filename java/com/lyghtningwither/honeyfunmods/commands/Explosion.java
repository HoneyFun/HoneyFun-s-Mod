package com.lyghtningwither.honeyfunmods.commands;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.DimensionManager;

public class Explosion extends CommandBase {

	@Override
	public String getName() {
		
		return "explosion";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		
		return "/explosion <x> <y> <z> <radius> [dimension ID, default Overworld]";
	}

	@Override
	public int getRequiredPermissionLevel() {
		
		return 2;
	}
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length < 4) return;
		
		if(args.length == 4) {
			
			int x = 0;
			int y = 0;
			int z = 0;
			int radius = 0;
			
			try {
				
				x = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				
				if(args[0] == "~") x = sender.getPosition().getX();
				else {
					
					sender.sendMessage(new TextComponentTranslation("command.numberFormattingException", new Object[] {args[0]}));
					return;
				}
			}
			
			try {
				
				y = Integer.parseInt(args[1]);
			} catch (NumberFormatException e) {
				
				if(args[1] == "~") y = sender.getPosition().getY();
				else {
					
					sender.sendMessage(new TextComponentTranslation("command.numberFormattingException", new Object[] {args[1]}));
					return;
				}
			}
			
			try {
				
				z = Integer.parseInt(args[2]);
			} catch (NumberFormatException e) {
				
				if(args[2] == "~") z = sender.getPosition().getZ();
				else {
					
					sender.sendMessage(new TextComponentTranslation("command.numberFormattingException", new Object[] {args[2]}));
					return;
				}
			}
			
			try {
				
				radius = Integer.parseInt(args[3]);
			} catch (NumberFormatException e) {
				
				sender.sendMessage(new TextComponentTranslation("command.numberFormattingException", new Object[] {args[3]}));
				return;
			}
			
			server.getWorld(0).createExplosion(null, x, y, z, radius, false);
			
			sender.sendMessage(new TextComponentTranslation("command.explosion.success", new Object[0]));
		} else if (args.length >= 5) {
			
			int x = 0;
			int y = 0;
			int z = 0;
			int radius = 0;
			int dimensionID = 0;
			
			try {
				
				x = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				
				if(args[0] == "~") x = sender.getPosition().getX();
				else {
					
					sender.sendMessage(new TextComponentTranslation("command.numberFormattingException", new Object[] {args[0]}));
					return;
				}
			}
			
			try {
				
				y = Integer.parseInt(args[1]);
			} catch (NumberFormatException e) {
				
				if(args[1] == "~") y = sender.getPosition().getY();
				else {
					
					sender.sendMessage(new TextComponentTranslation("command.numberFormattingException", new Object[] {args[1]}));
					return;
				}
			}
			
			try {
				
				z = Integer.parseInt(args[2]);
			} catch (NumberFormatException e) {
				
				if(args[2] == "~") z = sender.getPosition().getX();
				else {
					
					sender.sendMessage(new TextComponentTranslation("command.numberFormattingException", new Object[] {args[2]}));
					return;
				}
			}
			
			try {
				
				radius = Integer.parseInt(args[3]);
			} catch (NumberFormatException e) {
				
				sender.sendMessage(new TextComponentTranslation("command.numberFormattingException", new Object[] {args[3]}));
				return;
			}
			
			try {
				
				dimensionID = Integer.parseInt(args[4]);
			} catch (NumberFormatException e) {
				
				sender.sendMessage(new TextComponentTranslation("command.numberFormattingException", new Object[] {args[4]}));
				return;
			}
			
			if(!DimensionManager.isDimensionRegistered(dimensionID)) {
				
				sender.sendMessage(new TextComponentTranslation("command.explosion.invalidDimensionID", new Object[] {args[5]}));
				return;
			}
			
			server.getWorld(dimensionID).createExplosion(null, x, y, z, radius, false);
			
			sender.sendMessage(new TextComponentTranslation("command.explosion.success", new Object[0]));
		}
	}
}
