package com.panjaco.pictionary.components;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.panjaco.pictionary.Pictionary;

import net.md_5.bungee.api.ChatColor;

public class addPlayer implements CommandExecutor{
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player player;
		
		try{
			player = Bukkit.getPlayer(args[1]);
		}catch(Exception e){
			sender.sendMessage(ChatColor.AQUA + "[Pictionary] " + ChatColor.GREEN + args[1] + " can not be found!");
			return true;
		}
		
		if(!Pictionary.players.contains(player)){
			Pictionary.players.add(player);
			Pictionary.points.add(0);
			Bukkit.broadcastMessage(ChatColor.AQUA + "[Pictionary] " + ChatColor.GREEN + player.getDisplayName() + " has joined the game!");
			//broadcast
		}else{
			sender.sendMessage(ChatColor.AQUA + "[Pictionary] " + ChatColor.RED + args[1] + " is already in the game!");
		}
		
		
		
		return true;
	}
	
	
	
}
