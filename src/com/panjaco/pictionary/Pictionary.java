package com.panjaco.pictionary;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.panjaco.pictionary.components.addPlayer;
import com.panjaco.pictionary.components.drawerLoc;
import com.panjaco.pictionary.components.joinGame;
import com.panjaco.pictionary.components.kickPlayer;
import com.panjaco.pictionary.components.leaveGame;
import com.panjaco.pictionary.components.playerLoc;
import com.panjaco.pictionary.components.setMessage;
import com.panjaco.pictionary.components.startGame;
import com.panjaco.pictionary.events.onChatEvent;
import com.panjaco.pictionary.events.onMove;
import com.panjaco.pictionary.events.onRightClick;

public class Pictionary extends JavaPlugin{

	public static ArrayList<Player> players = new ArrayList<Player>();
	public static ArrayList<Integer> points = new ArrayList<Integer>();
	public static Player drawer;
	public static Location drawerLocation;
	public static Location playerLocation;
	public static String[] wordList = {"Pokemon", "Kittens", "House", "Moon"};
	public static String word;
	public static String shownWord;
	public static boolean guessed = false;
	public static int rounds;
	
	
	
	
	public static boolean status;
	
	public Pictionary plugin;
	
	
	public void onEnable(){
		PluginDescriptionFile descFile = getDescription();
		Logger logger = getLogger();
		logger.info("[Pictionary] Enabled");
		
		plugin = this;
		
		//Register commands
		//getCommand("votekick").setExecutor(new startKick(this));
		
		Bukkit.getPluginManager().registerEvents(new onChatEvent(), this);
		Bukkit.getPluginManager().registerEvents(new onMove(), this);
		Bukkit.getPluginManager().registerEvents(new onRightClick(), this);
		
		
	}
	
	public void onDisable(){
		PluginDescriptionFile descFile = getDescription();
		Logger logger = getLogger();
		logger.info("[Pictionary] Disabled");
	}
	
	public void loadConfiguration(){
		
	}
	
	public static ItemStack givePaintBrush(){
		ItemStack paintBrush = new ItemStack(Material.STICK);
		ItemMeta meta = paintBrush.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Paint Brush");
		paintBrush.setItemMeta(meta);
		return paintBrush;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		if(label.equalsIgnoreCase("pictionary")){
			if(args[0].equalsIgnoreCase("join")){
				new joinGame().onCommand(sender, cmd, label, args);
			}else if(args[0].equalsIgnoreCase("add")){
				new addPlayer().onCommand(sender, cmd, label, args);
			}else if(args[0].equalsIgnoreCase("leave")){
				new leaveGame().onCommand(sender, cmd, label, args);
			}else if(args[0].equalsIgnoreCase("kick")){
				new kickPlayer().onCommand(sender, cmd, label, args);
			}else if(args[0].equalsIgnoreCase("set")){
				if(args[1].equalsIgnoreCase("drawer")){
					//new setDrawer();
				}else if(args[1].equalsIgnoreCase("word")){
					//new setWord();
				}
			}else if(args[0].equalsIgnoreCase("start")){
				new startGame(this).onCommand(sender, cmd, label, args);;
			}else if(args[0].equalsIgnoreCase("testmsg")){
				new setMessage(args[1]).onCommand(sender, cmd, label, args);
			}else if(args[0].equalsIgnoreCase("drawerloc")){
				new drawerLoc().onCommand(sender, cmd, label, args);
			}else if(args[0].equalsIgnoreCase("playerloc")){
				new playerLoc().onCommand(sender, cmd, label, args);
			}
		}
		
		return true;
	}
	
}
