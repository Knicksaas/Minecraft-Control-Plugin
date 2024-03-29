package com.nte.mc.controlplugin.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.nte.mc.controlplugin.commands.HealthCommands;
import com.nte.mc.controlplugin.commands.Mcp;
import com.nte.mc.controlplugin.commands.MonitoringCommands;
import com.nte.mc.controlplugin.commands.MovmentsCommands;
import com.nte.mc.controlplugin.commands.PlayerCommands;
import com.nte.mc.controlplugin.spawnprotection.SpwanprotectionEventlistener;

public class Main extends JavaPlugin{
	
	public FileConfiguration config = this.getConfig();

	@Override
	public void onEnable() {
		
		Variables.config = config;
		System.out.println("[ControlPlugin] Enabled successfully");
		this.saveDefaultConfig();
		
		eventRegister();
	}
	
	public void eventRegister() {
		this.getServer().getPluginManager().registerEvents(new SpwanprotectionEventlistener(this), this);
		this.getServer().getPluginManager().registerEvents(new PlayerCommands(), this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("mcp")) {
			new Mcp(sender, cmd, label, args);
			return true;
		} else if (cmd.getName().equalsIgnoreCase("heal")) {
			return HealthCommands.heal(sender, cmd, label, args);
		} else if (cmd.getName().equalsIgnoreCase("speed")) {
			return MovmentsCommands.speed(sender, cmd, label, args);
		} else if (cmd.getName().equalsIgnoreCase("fly")) {
			return MovmentsCommands.fly(sender, cmd, label, args);
		} else if (cmd.getName().equalsIgnoreCase("setmaxhealth")) {
			return HealthCommands.setMaxHealth(sender, cmd, label, args);
		} else if (cmd.getName().equalsIgnoreCase("mem")) {
			return MonitoringCommands.mem(sender, cmd, label, args);
		} else if (cmd.getName().equalsIgnoreCase("inv")) {
			return PlayerCommands.inv(sender, cmd, label, args);
		} else if (cmd.getName().equalsIgnoreCase("whois")) {
			return PlayerCommands.whois(sender, cmd, label, args);
		} else if (cmd.getName().equalsIgnoreCase("lag")) {
			return MonitoringCommands.tps(this, sender, cmd, label, args);
		}
		
		
	return false;
	}
	
	@Override
	public void onDisable() {
		System.out.println("[ControlPlugin] Disabled successfully");
	}
}
