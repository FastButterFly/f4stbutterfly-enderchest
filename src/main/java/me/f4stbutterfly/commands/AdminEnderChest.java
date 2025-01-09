package me.f4stbutterfly.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.f4stbutterfly.Main;

public class AdminEnderChest implements CommandExecutor{
    private Main _m;
    public AdminEnderChest(Main __m) {
        this._m = __m;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(_m._mgr.PLAYER_REQUIRED());
            return false;
        }

        Player p = (Player)sender;
        if(p.hasPermission(_m.perms.get(2))) {
            if(args.length != 1) {
                p.sendMessage(_m._mgr.AECUSAGE());
                return false;
            }

            Player a = (Player) Bukkit.getPlayer(args[0]);
            if(a == null) {
                p.sendMessage(_m._mgr.INVALID_PLAYER());
                return false;
            }

            p.openInventory(a.getEnderChest());
        } else {
            p.sendMessage(_m._mgr.NO_PERMISSION());
            return false;
        }
        return false;
    }
}
