package com.panjaco.pictionary.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.panjaco.pictionary.Pictionary;

public class onMove implements Listener{
	
	@EventHandler
	public void onMoveEvent(PlayerMoveEvent event){
		
		Player player = event.getPlayer();
		
		if(player == Pictionary.drawer){
			double x = Pictionary.drawerLocation.getX();
			double y = Pictionary.drawerLocation.getY();
			double z = Pictionary.drawerLocation.getZ();
			
			if(player.getLocation().getX() != x || player.getLocation().getY() != y || player.getLocation().getZ() != z){
				player.teleport(Pictionary.drawerLocation);
			}
			
		}
	}
	
}
