package com.nte.mc.controlplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MovmentsCommands {
	
	public static boolean speed(CommandSender sender, Command cmd, String label, String[] args) {
		float speed = 0;
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("mcp.mv.speed")) {
				if(args.length == 1) {
					try {
						speed = Float.parseFloat(args[0]);
						if(p.isFlying()) {
							if(speed<=10) {
								p.setFlySpeed(speed/10);
								return true;
							} else {
								CommandRooter.sendValueToHighMsg(p);
								return true;
							}
						} else {
							if(speed<=10) {
								p.setWalkSpeed(speed/10);
								return true;
							} else {
								CommandRooter.sendValueToHighMsg(p);
								return true;
							}
						}
					} catch (Exception e) {
						return false;
					}
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
	
	public static boolean fly(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("mcp.mv.fly")) {
				if(args.length == 0) {
					if(p.getAllowFlight()) {
						p.setAllowFlight(false);
						return true;
					} else {
						p.setAllowFlight(true);
						return true;
					}
				} else if (args.length == 1) {
					for(Player t: Bukkit.getServer().getOnlinePlayers()) {
						if(t.getDisplayName().equalsIgnoreCase(args[0])) {
							if(t.getAllowFlight()) {
								t.setAllowFlight(false);
								return true;
							} else {
								t.setAllowFlight(true);
								return true;
							}
						} else {
							CommandRooter.sendPlayerNotFoundMsg(p);
							return true;
						}
					}
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
		return false;
	}
}
