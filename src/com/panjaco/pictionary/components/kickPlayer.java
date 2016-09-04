package com.panjaco.pictionary.components;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.panjaco.pictionary.Pictionary;

import net.md_5.bungee.api.ChatColor;

public class kickPlayer implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player player;
		
		
		try{
			player = Bukkit.getPlayer(args[1]);
		}catch(Exception e){
			sender.sendMessage(ChatColor.AQUA + "[Pictionary] " + ChatColor.RED + args[1] + " can not be found!");
			return true;
		}
		
		if(!Pictionary.players.contains(player)){
			sender.sendMessage(ChatColor.AQUA + "[Pictionary] " + ChatColor.RED + player.getDisplayName() + " is not in the game!");
		}else{
			int index = Pictionary.players.indexOf(player);
			Pictionary.players.remove(player);
			Pictionary.points.remove(index);
			player.sendMessage(ChatColor.AQUA + "[Pictionary] " + ChatColor.RED + "You have been kicked!");
			Bukkit.broadcastMessage(ChatColor.AQUA + "[Pictionary] " + ChatColor.RED + player.getDisplayName() + " has left the game!");
		}
		
		return true;
	}
	
	
	
}
