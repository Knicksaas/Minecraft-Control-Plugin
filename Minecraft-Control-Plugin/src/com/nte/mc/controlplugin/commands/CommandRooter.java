package com.nte.mc.controlplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.nte.mc.controlplugin.main.Variables;

import net.md_5.bungee.api.ChatColor;

public class CommandRooter extends JavaPlugin{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		System.out.println("FinalTest");
		if(cmd.getName().equalsIgnoreCase("mcp")) {
			new Mcp(sender, cmd, label, args);
			System.out.println("Test1");
			return true;
		}
		return false;
	}
	
	public static void sendNoPermissionMsg(Player p) {
		p.sendMessage(ChatColor.RED + Variables.config.getString("Messages.No-permission"));
	}
	public static void sendPlayerOnlyCmdMsg(Player p) {
		System.out.println(Variables.config.getString("Messages.Player-only-command"));
	}
}
