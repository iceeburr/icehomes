package ru.iceeburr.icehomes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import ru.iceeburr.icehomes.commands.SetHome;
import ru.iceeburr.icehomes.listeners.PlayerListeners;
import ru.iceeburr.icehomes.commands.HomeCommand;


public class Main extends JavaPlugin
{
    private HashMap<UUID, Location> homes;
    private HomeFiles files;
    private List<UUID> que;
    public static Logger LOGGER=Logger.getLogger("icehomes");

    @Override
    public void onEnable()
    {
        this.homes = new HashMap<>();
        this.files = new HomeFiles(this);
        this.que = new ArrayList<>();
        this.files.init();
        getCommand("sethome").setExecutor(new SetHome(this));
        getCommand("home").setExecutor(new HomeCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerListeners(this), this);
        LOGGER.info("ice!homes <|- Plugin loaded!0.0.2");
    }

    @Override
    public void onDisable()
    {
        this.files.terminate();
    }

    public void addHome(UUID id, Location location)
    {
        this.homes.put(id, location);
    }

    public Location getHome(UUID id)
    {
        return this.homes.get(id);
    }

    public boolean hasHome(UUID id)
    {
        return this.homes.containsKey(id);
    }

    public HomeFiles getFiles()
    {
        return files;
    }

    public void addQue(UUID id)
    {
        this.que.add(id);
    }

    public void cancelQue(UUID id)
    {
        this.que.remove(id);
    }

    public boolean isQued(UUID id)
    {
        return this.que.contains(id);
    }

    public HashMap<UUID, Location> getHomes()
    {
        return this.homes;
    }
}
