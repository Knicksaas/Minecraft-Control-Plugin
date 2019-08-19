package com.nte.mc.controlplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class PlayerCommands implements Listener{
	
	public static boolean inv(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("mcp.inv")) {
				if(args.length == 1) {					
					for(Player t: Bukkit.getServer().getOnlinePlayers()) {
						if(args[0].equalsIgnoreCase(t.getName())) {
							Inventory inv = t.getInventory();
							p.closeInventory();
							p.openInventory(inv);
							return true;
						} else {
							CommandRooter.sendPlayerNotFoundMsg(p);
							return true;
						}
					} 
				} else if (args.length == 2 && args[1].equalsIgnoreCase("armour")) {
					for(Player t: Bukkit.getServer().getOnlinePlayers()) {
						if(args[0].equalsIgnoreCase(t.getName())) {
							Inventory inv = Bukkit.getServer().createInventory(t, 9, "Armour of " + t.getName() + " do not remove!");
							inv.setContents(t.getInventory().getArmorContents());
							p.closeInventory();
							p.openInventory(inv);
							return true;
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
	
	public static boolean whois(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("mcp.whois")) {
				if(args.length == 1) {
					for(Player t: Bukkit.getServer().getOnlinePlayers()) {
						if(args[0].equalsIgnoreCase(t.getName())) {
							p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Properties of " + t.getName());
							p.sendMessage(ChatColor.AQUA + "UUID: " + t.getUniqueId());
							p.sendMessage(ChatColor.AQUA + "Is operator: " + t.isOp());
							p.sendMessage(ChatColor.AQUA + "World: " + t.getWorld().getName());
							p.sendMessage(ChatColor.AQUA + "Position: X=" + t.getLocation().getBlockX() + " Y=" + t.getLocation().getBlockY() + " Z=" + t.getLocation().getBlockZ());
							p.sendMessage(ChatColor.AQUA + "Pitch: " + t.getLocation().getPitch());
							p.sendMessage(ChatColor.AQUA + "Enabled flying: " + t.getAllowFlight());
							p.sendMessage(ChatColor.AQUA + "Is flying: " + t.isFlying() + "; Speed: " + t.getFlySpeed()*10);
							p.sendMessage(ChatColor.AQUA + "Is sleeping: " + t.isSleeping());
							return true;
						}
					}
					return true;
				} else {
					return false;
				}
			} else {
				CommandRooter.sendNoPermissionMsg(p);
				return true;
			}
		} else {
			if(args.length == 1) {
				for(Player t: Bukkit.getServer().getOnlinePlayers()) {
					if(args[0].equalsIgnoreCase(t.getName())) {
						System.out.println("Properties of " + t.getName());
						System.out.println("UUID: " + t.getUniqueId());
						System.out.println("Is operator: " + t.isOp());
						System.out.println("World: " + t.getWorld().getName());
						System.out.println("Position: X=" + t.getLocation().getBlockX() + " Y=" + t.getLocation().getBlockY() + " Z=" + t.getLocation().getBlockZ());
						System.out.println("Pitch: " + t.getLocation().getPitch());
						System.out.println("Enabled flying: " + t.getAllowFlight());
						System.out.println("Is flying: " + t.isFlying() + "; Speed: " + t.getFlySpeed()*10);
						System.out.println("Is sleeping: " + t.isSleeping());
						return true;
					}
				}
				return true;
			} else {
				return false;
			}
		}
	}
	
	@EventHandler
	public void onInvClickEvent(InventoryClickEvent e) {
		if(e.getInventory().getSize() == 9) {
			e.setCancelled(true);
		}
	}
}
