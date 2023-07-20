package ru.iceeburr.icehomes;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * homes java plugin
 */
public class Plugin extends JavaPlugin
{
  public static Logger LOGGER=Logger.getLogger("icehomes");
  private CommandHandler commandHandler;

  public void onEnable()
  {

    LOGGER.info("ice!homes <|- Up and runnin!0.0.1");
    commandHandler = new CommandHandler();
    getCommand("register").setExecutor(commandHandler);

  }

  public void onDisable()
  {

    LOGGER.info("ice!homes <|- See you next time!0.0.1");

  }
}
