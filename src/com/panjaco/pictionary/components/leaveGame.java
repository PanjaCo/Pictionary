package com.panjaco.pictionary.components;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.panjaco.pictionary.Pictionary;

import net.md_5.bungee.api.ChatColor;

public class leaveGame implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player player = (Player) sender;
		
		if(Pictionary.players.contains(player)){
			int index = Pictionary.players.indexOf(player);
			Pictionary.players.remove(player);
			Pictionary.points.remove(index);
			Bukkit.broadcastMessage(ChatColor.AQUA + "[Pictionary] " + ChatColor.RED + player.getDisplayName() + " has left the game!");
		}else{
			sender.sendMessage(ChatColor.AQUA + "[Pictionary] " + ChatColor.RED + "you have left the game!");
		}
		
		return true;
	}
	
	
	
}
