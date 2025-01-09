package me.f4stbutterfly.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ColorUtil {
    public static String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    public static List<String> colorizeList(List<String> _a) {
        List<String> _b = new ArrayList<>();
        for (String a : _a) {
            _b.add(colorize(a));
        }
        return _b;
    }
}
