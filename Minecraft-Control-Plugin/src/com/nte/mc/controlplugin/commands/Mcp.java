package com.nte.mc.controlplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Mcp {

	public Mcp(CommandSender sender, Command cmd, String label, String[] args) {
		
		System.out.println("Test");
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Helplist of the Minecraft Control Plugin:");
			p.sendMessage(ChatColor.BLUE + "mcp: Main command, help command");
			System.out.println("Test");
		} else {
			CommandRooter.sendPlayerOnlyCmdMsg((Player)sender);
		}
	}
	
}
