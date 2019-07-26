package com.nte.mc.controlplugin.spawnprotection;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Eventlistener implements Listener{
	
	@EventHandler
	public void playerMoveEvent(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		p.sendMessage("You moved");
	}
}
