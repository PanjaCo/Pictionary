package com.panjaco.pictionary.components;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.panjaco.pictionary.Pictionary;

import net.md_5.bungee.api.ChatColor;

public class joinGame implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player player = (Player) sender;
		
		if(!Pictionary.players.contains(player)){
			Pictionary.players.add(player);
			Pictionary.points.add(0);
			Bukkit.broadcastMessage(ChatColor.AQUA + "[Pictionary] " + ChatColor.GREEN + player.getDisplayName() + " has joined the game!");
			
		}else{
			sender.sendMessage(ChatColor.AQUA + "[Pictionary] " + ChatColor.RED + "You are already in the game!");
		}
		
		return true;
	}
	
	
	
	
}
