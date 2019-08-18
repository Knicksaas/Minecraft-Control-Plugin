package com.nte.mc.controlplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MonitoringCommands {

	public static boolean mem(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("mcp.mem")) {
				if(args.length == 0) {
					int mb = 1024*1024;
					Runtime runtime = Runtime.getRuntime();
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD +  "Monitoring:");
					p.sendMessage(ChatColor.AQUA + "Used memory: " + ((runtime.totalMemory() - runtime.freeMemory())/mb) + " mb");
					p.sendMessage(ChatColor.AQUA + "Free memory: " + runtime.freeMemory()/mb + " mb");
					p.sendMessage(ChatColor.AQUA + "Max. available memory: " + runtime.totalMemory()/mb + " mb");
					p.sendMessage(ChatColor.AQUA + "Total VRM memory: " + runtime.maxMemory()/mb + " mb");
					return true;
				} else {
					return false;
				}
			} else {
				CommandRooter.sendNoPermissionMsg(p);
				return true;
			}
		} else {
			CommandRooter.sendPlayerOnlyCmdMsg();
			return true;
		}
	}
}
