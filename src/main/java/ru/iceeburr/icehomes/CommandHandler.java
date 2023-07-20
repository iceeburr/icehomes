package ru.iceeburr.icehomes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equalsIgnoreCase("register") && sender instanceof Player){
            Player player = (Player) sender;
            String stringarg = args[0];
            Plugin.LOGGER.info("ice!homes <|- Player " + player.getName() + " sent string \"" + stringarg + "\" to the server!");
            player.sendRawMessage("ice!homes <|- Successfully sent your string to the server!");

            return true;
        }
        return false;
    }
}