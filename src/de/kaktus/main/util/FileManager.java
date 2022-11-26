package de.kaktus.main.util;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FileManager {

    File file = new File("plugins/GunGame", "messages.yml");
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    File config = new File("plugins/GunGame", "config.yml");
    YamlConfiguration configuration = YamlConfiguration.loadConfiguration(config);

    public void loadConfig(){
        if (configuration.getString("GunGame World") == null){
            configuration.set("GunGame World", Strings.world);
        }else{
            Strings.world = configuration.getString("GunGame World");
        }
        if (configuration.getString("Lobby World") == null){
            configuration.set("Lobby World", Strings.lobbyWorld);
        }else{
            Strings.lobbyWorld = configuration.getString("Lobby World");
        }
        if (configuration.getString("Spawn Radius") == null){
            configuration.set("Spawn Radius", Strings.spawnRadius);
        }else{
            Strings.spawnRadius = configuration.getInt("Spawn Radius");
        }
        savecfg();
    }

    public void loadMessage(){
        if (cfg.getString("No Permission") == null){
            cfg.set("No Permission", Strings.noPerm);
        }else{
            Strings.noPerm = cfg.getString("No Permission");
        }
        if (cfg.getString("Prefix") == null){
            cfg.set("Prefix", Strings.pre);
        }else{
            Strings.pre = cfg.getString("Prefix");
        }
        if (cfg.getString("Set Spawn") == null){
            cfg.set("Set Spawn", Strings.setSpawn);
        }else{
            Strings.setSpawn = cfg.getString("Set Spawn");
        }
        if (cfg.getString("Usage") == null){
            cfg.set("Usage", Strings.usage);
        }else{
            Strings.usage = cfg.getString("Usage");
        }
        if (cfg.getString("Join Message") == null){
            cfg.set("Join Message", Strings.joinGame);
        }else{
            Strings.joinGame = cfg.getString("Join Message");
        }
        if (cfg.getString("Player is already in a Game") == null){
            cfg.set("Player is already in a Game", Strings.alreadyJoined);
        }else{
            Strings.alreadyJoined = cfg.getString("Player is already in a Game");
        }
        if (cfg.getString("Left the Game") == null){
            cfg.set("Left the Game", Strings.leave);
        }else{
            Strings.leave = cfg.getString("Left the Game");
        }
        if (cfg.getString("Not Ingame") == null){
            cfg.set("Not Ingame", Strings.noInGame);
        }else{
            Strings.noInGame = cfg.getString("Not Ingame");
        }
        if (cfg.getString("Lobby Location set") == null){
            cfg.set("Lobby Location set", Strings.lobbySet);
        }else{
            Strings.lobbySet = cfg.getString("Lobby Location set");
        }
        if (cfg.getString("Kill Message") == null){
            cfg.set("Kill Message", Strings.killMessage);
        }else{
            Strings.killMessage = cfg.getString("Kill Message");
        }
        if (cfg.getString("Death Message") == null){
            cfg.set("Death Message", Strings.deathMessage);
        }else{
            Strings.deathMessage = cfg.getString("Death Message");
        }
        savemsg();
    }

    public void savecfg(){
        try {
            configuration.save(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void savemsg(){
        try {
            cfg.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
