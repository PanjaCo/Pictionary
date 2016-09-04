package com.panjaco.pictionary.events;

import java.util.HashSet;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.panjaco.pictionary.Pictionary;

public class onRightClick implements Listener {
	
	@EventHandler
	public void onRightClickEvent(PlayerInteractEvent event){
		Player player = event .getPlayer();
		if(Pictionary.status){
			if(player.getInventory().getItemInHand().getType() == Material.STICK){
					//They are holding the paint brush, check if they right clicked
				if(event.getAction() == Action.RIGHT_CLICK_AIR){
					Block block = player.getTargetBlock((HashSet<Byte>) null, 100);
					//Check if the block is wool
					if(block.getType() == Material.WOOL){
						//ItemStack blackWool = new ItemStack(Material.WOOL, 1, DyeColor.BLACK.getData());
						block.setTypeIdAndData(35, DyeColor.BLACK.getData(), true);
					}
				}
					
			}
		}
	}
	
}
