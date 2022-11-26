package de.kaktus.main.event;

import de.kaktus.main.Main;
import de.kaktus.main.util.Strings;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Build implements Listener {


    @EventHandler
    public void onBuild(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if (p.getWorld().getName().equalsIgnoreCase(Strings.world) && Main.GunGame.contains(p)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if (p.getWorld().getName().equalsIgnoreCase(Strings.world) && Main.GunGame.contains(p)){
            e.setCancelled(true);
        }
    }
}
