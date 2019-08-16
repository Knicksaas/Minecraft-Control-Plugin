package com.nte.mc.controlplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nte.mc.controlplugin.main.Variables;

public class Mcp {

	public Mcp(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Helplist of the Minecraft Control Plugin:");
				p.sendMessage(ChatColor.BLUE + "mcp: Main command, help command");
			} else if (args.length == 1 && args[0].equalsIgnoreCase("login")) {
				if(p.hasPermission("mcp.login")) {
					if(Variables.adminList.contains(p.getName())) {
						CommandRooter.sendAlredyLoggedInMsg(p);
					} else {
						Variables.adminList.add(p.getName());
						CommandRooter.sendSuccessfulLoggedInMsg(p);
					}
				} else {
					CommandRooter.sendNoPermissionMsg(p);
				}
			} else if (args.length == 1 && args[0].equalsIgnoreCase("logout")) {
				if(p.hasPermission("mcp.logout")) {
					if(Variables.adminList.contains(p.getName())) {
						Variables.adminList.remove(p.getName());
						CommandRooter.sendSuccessfulLoggedOutMsg(p);
					} else {
						CommandRooter.sendAlredyLoggedOutMsg(p);
					}
				} else {
					CommandRooter.sendNoPermissionMsg(p);
				}
			} else if (args.length == 1 && args[0].equalsIgnoreCase("list")) {
				if(p.hasPermission("mcp.list")) {
					CommandRooter.sendLoggedInAdnimListMsg(p);
					p.sendMessage(Variables.adminList.toString());
				} else {
					CommandRooter.sendNoPermissionMsg(p);
				}
			}
		} else {
			CommandRooter.sendPlayerOnlyCmdMsg();
		}
	}
	
}
