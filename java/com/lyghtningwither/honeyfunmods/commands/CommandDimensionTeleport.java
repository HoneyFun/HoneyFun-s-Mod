package com.lyghtningwither.honeyfunmods.commands;

import java.util.List;

import com.google.common.collect.Lists;
import com.lyghtningwither.honeyfunmods.commands.util.Teleport;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class CommandDimensionTeleport extends CommandBase {

	private final List<String> aliases = Lists.newArrayList(Reference.MOD_ID, "teleport", "dtp", "teleportd", "tpdim", "teleportdimension", "tpdimension", "tpd");
	
	@Override
	public String getName() {
		
		return "tpdimension";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		
		return "tpdimension <id>";
	}
	
	@Override
	public List<String> getAliases() {
		
		return aliases;
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		
		return 2;
	}
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if(args.length < 1) {
			
			sender.sendMessage(new TextComponentTranslation("command.notEnoughArgs", new Object[0]));
			return;
		}
		
		String s = args[0];
		int dimensionId;
		
		try {
			
			dimensionId = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Dimension ID invalid."));
			return;
		}
		
		if(sender instanceof EntityPlayer) {
			
			Teleport.TeleportToDimension((EntityPlayer) sender, dimensionId, (double) sender.getPosition().getX(), (double) sender.getPosition().getX(), (double) sender.getPosition().getX());
		}
	}
}
