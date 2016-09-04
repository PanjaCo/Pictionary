package com.panjaco.pictionary.components;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

public class setMessage implements CommandExecutor{
	
	private String message;
	
	public setMessage(String newMessage){
		message = newMessage;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		ActionBarAPI.sendActionBarToAllPlayers(message, 1000);
		
		
		
		return true;
	}
	  
}