package me.f4stbutterfly.updateHandler;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.bukkit.entity.Player;

import me.f4stbutterfly.Main;

import java.net.URI;
import java.io.IOException;

public class updateInfoClass {
    private Main _m;
    private boolean lastNewVer = false;
    private boolean parsed = false;
    private String newVer = "dkId223Asdmf#&jdIdk34@@#";
    public updateInfoClass(Main ____m) {
        this._m = ____m;
    }
    public void updateInfo() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://raw.githubusercontent.com/FastButterFly/f4stbutterfly-enderchest/refs/heads/main/ver.txt"))
            .GET()
            .build();
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 304) {
                parsed = true;
                String responseBody = response.body();

                String[] lines = responseBody.split("\n");
                int var1 = Integer.parseInt(lines[0].trim());
                int var2 = Integer.parseInt(lines[1].trim());
                int var3 = Integer.parseInt(lines[2].trim());

                if((_m.version_VID1 != var1) || (_m.version_VID2 != var2) || (_m.version_VID3 != var3)) {
                    lastNewVer = true;
                    newVer = "" + var1 + "." + var2 + "." + var3;
                }
            } else {
                _m.getLogger().warning("Failed to get update version from plugin github repo!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            _m.getLogger().warning("Failed to get update version from plugin github repo!");
        }
    }
    public void notifyPlrOfUpdate(Player p) {
        if (!parsed) {
            p.sendMessage(_m._mgr.UPDATE_STATUS("&4&lFATAL ERROR: FAILED TO GET VERSION FROM REMOTE SERVER"));
            return;
        }
        if(!lastNewVer) {
            p.sendMessage(_m._mgr.UPDATE_STATUS("&a&lUP-TO-DATE"));
            return;
        } else {
            p.sendMessage(_m._mgr.UPDATE_STATUS("&c&lOUTDATED"));
            p.sendMessage(_m._mgr.UPDATE_STATUS_NEW("" + _m.version_VID1 + "." + _m.version_VID2 + "." + _m.version_VID3, newVer));
            return;
        }
    }
}
