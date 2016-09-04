package com.panjaco.pictionary.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import com.panjaco.pictionary.Pictionary;

import net.md_5.bungee.api.ChatColor;

public class onChatEvent implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		
		Player player = event.getPlayer();
		String message = event.getMessage().toString();
		
		if(Pictionary.status){
			if(Pictionary.drawer != player){
				if(message.equalsIgnoreCase(Pictionary.word)){
						if(!Pictionary.guessed){
							Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "+3 " + player.getDisplayName() + " has guessed the word!");
							int index = Pictionary.players.indexOf(player);
							int points = (int) Pictionary.points.toArray()[index];
							points += 3;
							
							Pictionary.points.set(index, points);
						}else{
							Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "+1 " + player.getDisplayName() + " has guessed the word!");
							int index = Pictionary.players.indexOf(player);
							int points = (int) Pictionary.points.toArray()[index];
							points += 1;
							
							Pictionary.points.set(index, points);
						}
						event.setCancelled(true);
					//Update schoreboard
				}
			}else{
				String newMessage = "";
				for(int i = 0; i < message.length(); i++){
					if(message.toCharArray()[i] == ' '){
						newMessage += " ";
					}else{
						newMessage += "*";
					}
				}
				event.setMessage(ChatColor.RED + newMessage);
			}
		}
		
		/*
		if(Pictionary.drawer == player){
			//Turn what they typed into *s
			char[] characters = message.toCharArray();
			
			for(char c : characters){
				c = '*';
			}
			
			String newMessage = characters.toString();
			
			event.setMessage(newMessage);
			
		}
		*/
				
		
		
	}
	
}
