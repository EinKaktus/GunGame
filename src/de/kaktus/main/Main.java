package de.kaktus.main;

import de.kaktus.main.command.GunGame;
import de.kaktus.main.event.*;
import de.kaktus.main.util.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Main extends JavaPlugin {

    public static FileManager fm;

    public static List<Player> GunGame = new ArrayList<>();

    public static HashMap<Player, ItemStack[]> inventory = new HashMap<>();

    @Override
    public void onEnable() {
        PluginManager();
        fm = new FileManager();
        fm.savecfg();
        fm.savemsg();
        fm.loadConfig();
        fm.loadMessage();

        Objects.requireNonNull(getCommand("gg")).setExecutor(new GunGame());
    }

    public void PluginManager(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Build(), this);
        pm.registerEvents(new Food(), this);
        pm.registerEvents(new Damage(), this);
        pm.registerEvents(new Death(), this);
        pm.registerEvents(new Utils(), this);
    }
}
