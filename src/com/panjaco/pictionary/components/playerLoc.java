package com.panjaco.pictionary.components;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.panjaco.pictionary.Pictionary;

import net.md_5.bungee.api.ChatColor;

public class playerLoc implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player player = (Player) sender;
		Location loc = player.getLocation();
		
		Pictionary.playerLocation = loc;
		sender.sendMessage(ChatColor.AQUA + "[Pictionary] " + ChatColor.GREEN + "Player spawnpoint set.");
		
		return true;
	}
	
	
	
}
