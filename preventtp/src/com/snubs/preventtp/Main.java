package com.snubs.preventtp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
  public void onEnable() {
    getConfig().options().copyDefaults();
    saveDefaultConfig();
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player player = (Player) sender;
    if (cmd.getName().equalsIgnoreCase("tp") && player.hasPermission(getConfig().getString("permission_tp"))) {
      if (args.length == 0) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("teleport_specify")));
        return true;
      }
      
      if (args.length == 2) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("no_mr_perez")));
        return true;
      }

      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target == null) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("cant_find_player")));
        return true;
      }
      
      player.teleport((Entity) target);
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("teleported_message")));
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
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("teleported_message")));
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
