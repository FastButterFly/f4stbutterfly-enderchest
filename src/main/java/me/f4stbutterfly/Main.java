package me.f4stbutterfly;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.permissions.Permission;
import me.f4stbutterfly.updateHandler.updateInfoClass;

import me.f4stbutterfly.commands.*;

public class Main extends JavaPlugin implements Listener
{
    public int version_VID1 = 0;
    public int version_VID2 = 0;
    public int version_VID3 = 2;
    public List<Permission> perms = new ArrayList<>();
    private updateInfoClass update = new updateInfoClass(this);
    public ConfigManager _mgr = new ConfigManager(this);
    public void onEnable() {
        perms.add(new Permission("f4stbutterfly-enderchest.log_update"));
        perms.add(new Permission("f4stbutterfly-enderchest.use"));
        perms.add(new Permission("f4stbutterfly-enderchest.use.other"));
        saveDefaultConfig();
        reloadConfig();
        update.updateInfo();
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("ec").setExecutor(new EnderChestCommand(this));
        getCommand("aec").setExecutor(new AdminEnderChest(this));
        Bukkit.getPluginManager().registerEvents(this, this);
    };

    public void onDisable() {

    };

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (e.getPlayer().hasPermission(perms.get(0))) {
            update.notifyPlrOfUpdate(e.getPlayer());
        }
    }
}
