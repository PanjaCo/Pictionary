package com.panjaco.pictionary.components;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.panjaco.pictionary.Pictionary;

import net.md_5.bungee.api.ChatColor;

public class startGame implements CommandExecutor{

	private static Pictionary plugin;
	public startGame(Pictionary pl){
		plugin = pl;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Pictionary.status = true;
		
		for(Player p : Pictionary.players){
			p.teleport(Pictionary.playerLocation);
		}
		
		getWord();
		
		return true;
	}
	
	public static void getWord(){
		//Get a random word
		int index = ThreadLocalRandom.current().nextInt(0, Pictionary.wordList.length);
		//Set the word
		Pictionary.word = Pictionary.wordList[index];
		
		
		//Make an array of all of the letters
		char[] characters = Pictionary.word.toCharArray();
		String newWord = "";
		
		
		for(char c : characters){
			if(c != ' '){
				newWord += "_ ";
			}else{
				newWord += "    ";
			}
		}
		
		
		//Set a new drawer
		if(Pictionary.rounds != 0){
		Pictionary.drawer.teleport(Pictionary.playerLocation);
		Pictionary.drawer.getInventory().clear();
		}
		int playerIndex = ThreadLocalRandom.current().nextInt(0, Pictionary.players.size());
		Player target = (Player) Bukkit.getOnlinePlayers().toArray()[playerIndex];
		Pictionary.drawer = target;
		target.teleport(Pictionary.drawerLocation);
		Pictionary.guessed = false;
		//Give them a paint brush
		Pictionary.drawer.getInventory().addItem(Pictionary.givePaintBrush());
		
		
		newRound(Pictionary.word);
	}
	
	
	@SuppressWarnings("deprecation")
	public static void newRound(String word){
		
		
		final int length = word.length();
		final int[] times;
		
		if(length <= 4){
			times = new int[] { 30, 50 };
		}else if(length <= 8){
			times = new int[] { 15, 30, 50 };
		}else if(length <= 16){
			times = new int[] { 15, 25, 35, 50 };
		}else{
			times = new int[] { 15, 25, 35, 45, 55 };
		}
		
		char[] characters = word.toCharArray();
		final char[] chars = word.toCharArray();
		
		String dis = "";
		for(char c : characters){
			if(c != ' '){
				dis += "_";
			}else{
				dis += " ";
			}
		}
		
		final String disZ = dis;
		
		
		Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable(){
			
			int time = 60;
			String display = disZ;
			
			@Override
			public void run() {
				
				for(int t : times){
					if(t == time){
						
						int index = ThreadLocalRandom.current().nextInt(0, display.length());
						
						if(display.toCharArray()[index] == '_'){
							StringBuilder newDisplay = new StringBuilder(display);
							newDisplay.setCharAt(index, word.toCharArray()[index]);
							
							display = newDisplay.toString();
							
							break;
						}

					}
				}
				
				if(time > 0){
					ActionBarAPI.sendActionBarToAllPlayers(display + " ||| " + time);
				}else{
					Bukkit.getScheduler().cancelTasks(plugin);
					Pictionary.rounds++;
					//Update scoreboard
					
					Bukkit.broadcastMessage(ChatColor.RED + "The round is over!");
					Bukkit.broadcastMessage(ChatColor.GREEN + "The word was: " + word);
					
					if(Pictionary.rounds < 12){
						getWord();
					}
				}
				
				
				time--;
			}
		}, 0L, 20L);
		
		
		
	}
	
	
	
}
