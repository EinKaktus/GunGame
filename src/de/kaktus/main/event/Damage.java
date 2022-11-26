package de.kaktus.main.event;

import de.kaktus.main.util.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Objects;

public class Damage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if (e.getEntity() instanceof Player){
            Player p = ((Player) e.getEntity()).getPlayer();
            int distance = Strings.spawnRadius;
            Location location = Objects.requireNonNull(Bukkit.getWorld(Strings.world)).getSpawnLocation();

            assert p != null;
            if (p.getWorld().getName().equalsIgnoreCase(Strings.world)){
                if (p.getLocation().distance(location) < distance || p.getLocation().distance(location) == distance){
                    e.setCancelled(true);
                }
            }
        }
    }
}
