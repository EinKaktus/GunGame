package de.kaktus.main.command;

import de.kaktus.main.Main;
import de.kaktus.main.util.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Locale;
import java.util.Objects;

public class GunGame implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        if (args.length == 1){
            if (args[0].equalsIgnoreCase("setspawn")){
                if (p.hasPermission("gungame.setspawn")){
                    Objects.requireNonNull(Bukkit.getWorld(Strings.world)).setSpawnLocation(p.getLocation());
                    p.sendMessage(Strings.pre.replaceAll("&", "§") + Strings.setSpawn.replaceAll("&", "§"));
                }else{
                    p.sendMessage(Strings.pre.replaceAll("&", "§") + Strings.noPerm.replaceAll("&", "§"));
                }
            }else if (args[0].equalsIgnoreCase("join")){
                if (!Main.GunGame.contains(p)){
                    Main.GunGame.add(p);
                    p.teleport(Objects.requireNonNull(Bukkit.getWorld(Strings.world)).getSpawnLocation());
                    p.sendMessage(Strings.pre.replaceAll("&", "§") + Strings.joinGame.replaceAll("&", "§"));
                    if (p.getWorld().getName().equalsIgnoreCase(Strings.world)){
                        Main.inventory.put(p, p.getInventory().getContents());
                        p.getInventory().clear();
                    }
                    ItemStack itemStack = new ItemStack(Material.WOODEN_AXE);
                    p.getInventory().setItem(0, itemStack);
                }else{
                    p.sendMessage(Strings.pre.replaceAll("&", "§") + Strings.alreadyJoined.replaceAll("&", "§"));
                }
            }else if (args[0].equalsIgnoreCase("leave")){
                if (Main.GunGame.contains(p)){
                    Main.GunGame.remove(p);
                    p.teleport(Objects.requireNonNull(Bukkit.getWorld(Strings.lobbyWorld)).getSpawnLocation());
                    p.sendMessage(Strings.pre.replaceAll("&", "§") + Strings.leave.replaceAll("&", "§"));
                    if (Main.inventory.get(p) != null){
                        p.getInventory().setContents(Main.inventory.get(p));
                    }
                }else{
                    p.sendMessage(Strings.pre.replaceAll("&", "§") + Strings.noInGame.replaceAll("&", "§"));
                }
            }else if (args[0].equalsIgnoreCase("setlobby")){
                if (p.hasPermission("gg.setlobby")){
                    Objects.requireNonNull(Bukkit.getWorld(Strings.lobbyWorld)).setSpawnLocation(p.getLocation());
                    p.sendMessage(Strings.pre.replaceAll("&", "§") + Strings.lobbySet.replaceAll("&", "§"));
                }else{
                    p.sendMessage(Strings.pre.replaceAll("&", "§") + Strings.noPerm.replaceAll("&", "§"));
                }
            }else{
                p.sendMessage(Strings.pre.replaceAll("&", "§") + Strings.usage.replaceAll("&", "§"));
            }
        }else{
            p.sendMessage(Strings.pre.replaceAll("&", "§") + Strings.usage.replaceAll("&", "§"));
        }
        return false;
    }
}
