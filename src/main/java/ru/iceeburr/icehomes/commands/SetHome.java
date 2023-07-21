package ru.iceeburr.icehomes.commands;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import ru.iceeburr.icehomes.Main;

public class SetHome implements CommandExecutor {
    private final Main plugin;
    public SetHome(Main plugin)
    {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player){
            Player player = (Player) sender;
            UUID id = player.getUniqueId();
            Location location = player.getLocation();
            plugin.addHome(id, location);
            plugin.getFiles().addHome(id, location);
            if (plugin.hasHome(id)){
                player.sendMessage(ChatColor.GOLD + "Your home has been updated!");
            }else{
                player.sendMessage(ChatColor.GOLD + "Your home has been set!");
            }
        }
        return true;
    }
}
