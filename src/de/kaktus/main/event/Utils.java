package de.kaktus.main.event;

import de.kaktus.main.util.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftItem;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class Utils implements Listener {


    @EventHandler
    public void onWorld(PlayerChangedWorldEvent e){
        Player p = e.getPlayer();
        if (p.getWorld().getName().equalsIgnoreCase(Strings.world)){
            if (p.getLevel() < 1){
                p.setLevel(p.getLevel() + 1);
            }
        }
    }

    @EventHandler
    public void onLevel(PlayerLevelChangeEvent e){
        Player p = e.getPlayer();
        if (p.getWorld().getName().equalsIgnoreCase(Strings.world)){
            if (p.getLevel() < 1 || p.getLevel() == 1){
                ItemStack itemStack = new ItemStack(Material.WOODEN_AXE);
                p.getInventory().setItem(0, itemStack);
            }else if (p.getLevel() == 2){
                ItemStack itemStack = new ItemStack(Material.WOODEN_SWORD);
                p.getInventory().setItem(0, itemStack);
            }else if (p.getLevel() == 3){
                ItemStack itemStack = new ItemStack(Material.STONE_AXE);
                p.getInventory().setItem(0, itemStack);
            }else if (p.getLevel() == 4){
                ItemStack itemStack = new ItemStack(Material.STONE_SWORD);
                p.getInventory().setItem(0, itemStack);
            }else if (p.getLevel() == 5){
                ItemStack itemStack = new ItemStack(Material.IRON_AXE);
                p.getInventory().setItem(0, itemStack);
            }
        }
    }

    @EventHandler
    public void onInt(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if (p.getWorld().getName().equalsIgnoreCase(Strings.world)){
            Block block = p.getLocation().subtract(0.00, 1.00, 0.00).getBlock();

            if (block.getType() == Material.WATER){
                p.setHealth(0);
                p.spigot().respawn();
                p.teleport(p.getWorld().getSpawnLocation());
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        if (p.getWorld().getName().equalsIgnoreCase(Strings.world)){
            if (p.getLevel() < 1 || p.getLevel() == 1){
                ItemStack itemStack = new ItemStack(Material.WOODEN_AXE);
                p.getInventory().setItem(0, itemStack);
            }else if (p.getLevel() == 2){
                ItemStack itemStack = new ItemStack(Material.WOODEN_SWORD);
                p.getInventory().setItem(0, itemStack);
            }else if (p.getLevel() == 3){
                ItemStack itemStack = new ItemStack(Material.STONE_AXE);
                p.getInventory().setItem(0, itemStack);
            }else if (p.getLevel() == 4){
                ItemStack itemStack = new ItemStack(Material.STONE_SWORD);
                p.getInventory().setItem(0, itemStack);
            }else if (p.getLevel() == 5 || p.getLevel() > 5){
                ItemStack itemStack = new ItemStack(Material.IRON_AXE);
                p.getInventory().setItem(0, itemStack);
            }
        }
    }
}
