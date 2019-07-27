package com.nte.mc.controlplugin.main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.nte.mc.controlplugin.spawnprotection.Eventlistener;

public class Main extends JavaPlugin{
	
	public FileConfiguration config = getConfig();
	

	@Override
	public void onEnable() {
		System.out.println("[ControlPlugin] Enabled successfully");
		this.saveConfig();
		
		this.getServer().getPluginManager().registerEvents(new Eventlistener(), this);
	}
	
	
	@Override
	public void onDisable() {
		System.out.println("[ControlPlugin] Disabled successfully");
	}
}
