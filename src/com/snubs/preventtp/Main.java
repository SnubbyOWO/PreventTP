package com.snubs.preventtp;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin {
  public void onEnable() {
    getConfig().options().copyDefaults();
    saveDefaultConfig();
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  
	// Checks Player  
    Player player = (Player) sender;
    
    // Makes it where you can add players to the torture list.
    List<String> tortureList = getConfig().getStringList("players");
    
    if (cmd.getName().equalsIgnoreCase("tp") && player.hasPermission(getConfig().getString("permission_tp"))) {
      if (args.length == 0) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("teleport_specify")));
        return true;
      }
      
      // Checks args if its 2 "/tp (player1) (player2)" when there shouldnt be. Then, it checks the players name if its NOT OG_Perez "!"
      if (args.length == 2 && !tortureList.contains(player.getName())) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("no_mr_perez")));
        return true;
      } else if (args.length == 2 && tortureList.contains(player.getName())) { //BUT if the name EQUALS OG_Perez then it does the following.
    	  // Gives the nausea effect when he does it.
    	  player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));

    	  // Calls his ass out and tells him he did a nono
    	  player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("no_mr_perez")));
    	  
    	  // Also now replaces %Player% with their name
    	  Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("callout_mr_perez").replace("%Player%", player.getName())));
    	  
    	  // Returns everything. Telling the game its done running.
          return true;
      }
      

      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target == null) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("cant_find_player")));
        return true;
      }
      
      player.teleport((Entity) target);
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("teleported_message").replace("%Player%", player.getName())));
      return true;
    }

    if (cmd.getName().equalsIgnoreCase("tpn") && player.hasPermission(getConfig().getString("permission_admin_tp"))) {
      if (args.length != 2) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("teleport_specify")));
        return true;
      }

      Player player1 = Bukkit.getServer().getPlayer(args[0]);
      Player player2 = Bukkit.getServer().getPlayer(args[1]);
      
      if (player1 == null || player2 == null) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("cant_find_player")));
        return true;
      }
      
      player1.teleport((Entity) player2);
      
      // Changes message to display names
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("teleported_message_admin").replace("%Player%", player.getName().replace("%Player2%", player2.getName()))));
      return true;
    }

    if (cmd.getName().equalsIgnoreCase("tpreload") && player.hasPermission(ChatColor.translateAlternateColorCodes('&', getConfig().getString("reload_permission")))) {
      reloadConfig();
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("reloaded_message")));
      return true;
    }

    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("no_permission")));
    return false;
  }
}
