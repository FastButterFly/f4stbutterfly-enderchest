package me.f4stbutterfly;

import me.f4stbutterfly.utils.ColorUtil;

public class ConfigManager {
    private Main _______m;
    public ConfigManager(Main _m) {
        this._______m = _m;
    }
    public String NO_PERMISSION() {
        try {
            return ColorUtil.colorize(_______m.getConfig().getString("NO_PERMISSION"));
        } catch(NullPointerException e) {
            return "ERROR: CONFIG_READ_NULL";
        }
    }
    public String UPDATE_STATUS(String STATUS) {
        try {
            return ColorUtil.colorize(_______m.getConfig().getString("UPDATE_STATUS_INFO").replace("{STATUS}", STATUS));
        } catch(NullPointerException e) {
            return "ERROR: CONFIG_READ_NULL";
        }
    }
    public String UPDATE_STATUS_NEW(String CURRENT, String NEW) {
        try {
            return ColorUtil.colorize(_______m.getConfig().getString("UPDATE_STATUS_NEWV").replace("{CURRENT}", CURRENT).replace("{NEW}", NEW));
        } catch(NullPointerException e) {
            return "ERROR: CONFIG_READ_NULL";
        }
    }
    public String PLAYER_REQUIRED() {
        try {
            return ColorUtil.colorize(_______m.getConfig().getString("ONLY_PLAYER"));
        } catch(NullPointerException e) {
            return "ERROR: CONFIG_READ_NULL";
        }
    }
    public String AECUSAGE() {
        try {
            return ColorUtil.colorize(_______m.getConfig().getString("AEC_COMMAND_USAGE"));
        } catch(NullPointerException e) {
            return "ERROR: CONFIG_READ_NULL";
        }
    }
    public String INVALID_PLAYER() {
        try {
            return ColorUtil.colorize(_______m.getConfig().getString("UNKNOWN_PLAYER"));
        } catch(NullPointerException e) {
            return "ERROR: CONFIG_READ_NULL";
        }
    }
}
