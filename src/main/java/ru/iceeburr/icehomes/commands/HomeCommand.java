package ru.iceeburr.icehomes.commands;

import ru.iceeburr.icehomes.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class HomeCommand implements CommandExecutor
{
    private final Main plugin;
    public HomeCommand(Main plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            UUID id = player.getUniqueId();

            if (!plugin.hasHome(id))
            {
                player.sendMessage(ChatColor.RED + "You don't have a home set!");
            } else
            {
                plugin.addQue(id);
                new BukkitRunnable()
                {
                    int delay = 3;
                    @Override
                    public void run()
                    {
                        if (plugin.isQued(id)){
                            if (delay == 0){
                                player.teleport(plugin.getHome(id));
                                player.sendMessage(ChatColor.GOLD + "Teleporting...");
                                plugin.cancelQue(id);
                                this.cancel();
                            } else {
                                player.sendMessage(ChatColor.GOLD + "Teleporting in " + delay-- + " seconds.");
                             }
                        } else{
                            player.sendMessage(ChatColor.RED + "Teleportation cancelled!");
                            this.cancel();
                        }

                    }
                }.runTaskTimer(plugin, 0, 20);

            }
        }
        return true;
    }
}
