package de.kaktus.main.event;

import de.kaktus.main.Main;
import de.kaktus.main.util.Strings;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Food implements Listener {

    @EventHandler
    public void onFood(FoodLevelChangeEvent e){
        if (e.getEntity() instanceof Player){
            Player p = ((Player) e.getEntity()).getPlayer();
            assert p != null;
            if (p.getWorld().getName().equalsIgnoreCase(Strings.world) && Main.GunGame.contains(p)){
                e.setCancelled(true);
            }
        }
    }
}
