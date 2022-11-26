package de.kaktus.main.event;

import de.kaktus.main.util.Strings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class Death implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e){

        Player p = (Player) e.getEntity();
        if (p.getWorld().getName().equalsIgnoreCase(Strings.world)){
            if (p.getKiller() != null){
                if (e.getEntity().getLevel() > 1 || e.getEntity().getLevel() == 1){
                    e.getEntity().setLevel(e.getEntity().getLevel() - 1);
                    Objects.requireNonNull(e.getEntity().getKiller()).setLevel(Objects.requireNonNull(e.getEntity().getKiller()).getLevel() + 1);
                }else{
                    Objects.requireNonNull(e.getEntity().getKiller()).setLevel(Objects.requireNonNull(e.getEntity().getKiller()).getLevel() + 1);
                }
            }else{
                if (e.getEntity().getLevel() > 1 || e.getEntity().getLevel() == 1) {
                    e.getEntity().setLevel(e.getEntity().getLevel() - 1);
                }
            }

            e.setDeathMessage(null);
            e.getDrops().clear();
            e.setDroppedExp(0);
            e.setKeepLevel(true);

            for (Player all : Objects.requireNonNull(Bukkit.getWorld(Strings.world)).getPlayers()){
                if (p.getKiller() != null){
                    Player killer = p.getKiller();
                    p.spigot().respawn();
                    all.sendMessage(Strings.pre.replaceAll("&", "§") + Strings.killMessage.replaceAll("&", "§").replace("[NAME]", p.getName()).replace("[KILLER]", killer.getName()));
                }else{
                    p.spigot().respawn();
                    all.sendMessage(Strings.pre.replaceAll("&", "§") + Strings.deathMessage.replaceAll("&", "§").replace("[NAME]", p.getName()));
                }
            }
        }
    }
}
