package de.kaktus.main.event;

import de.kaktus.main.util.Strings;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Sign implements Listener {


    @EventHandler
    public void onSignEdit(SignChangeEvent e){
        if (e.getPlayer().hasPermission("gg.createsign")){
            String s = e.getLine(0);
            String s2 = e.getLine(1);

            assert s != null;
            if (s.equalsIgnoreCase("[GG]")){
                e.setLine(0, "§8[§6GunGame§8]");
            }
            if (s2.equalsIgnoreCase("join")){
                e.setLine(1, "§7Join");
            }
        }else{
            String s = e.getLine(0);
            if (s.equalsIgnoreCase("[GG]")){
                e.setLine(0, "§1");
                e.setLine(1, "§1");
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if (e.getClickedBlock() == null) return;

        if (e.getClickedBlock().getState() instanceof org.bukkit.block.Sign){
            String warp = ((org.bukkit.block.Sign) e.getClickedBlock().getState()).getLine(1);


            if (warp.equalsIgnoreCase("§7Join")){
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
                    p.performCommand("gg join");
                }
            }
        }
    }
}
