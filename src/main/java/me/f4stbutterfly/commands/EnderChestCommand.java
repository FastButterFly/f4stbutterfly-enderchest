package me.f4stbutterfly.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.f4stbutterfly.Main;
import org.bukkit.entity.Player;

public class EnderChestCommand implements CommandExecutor{
    private Main _m;
    public EnderChestCommand(Main __m) {
        this._m = __m;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(_m._mgr.PLAYER_REQUIRED());
            return false;
        }
        Player p = (Player)sender;
        if(p.hasPermission(_m.perms.get(1))) {
           p.openInventory(p.getEnderChest()); 
        } else {
            p.sendMessage(_m._mgr.NO_PERMISSION());
        }
        return false;
    }
}
