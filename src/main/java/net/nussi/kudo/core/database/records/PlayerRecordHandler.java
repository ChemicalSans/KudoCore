package net.nussi.kudo.core.database.records;

import net.nussi.kudo.core.database.DatabaseController;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerRecordHandler implements Listener {

    public static void onEnable() {}
    public static void onDisable() {}

    public static database = DatabaseController.playersCollection;

    @EventHandler
    void onPlayerLoginEvent(PlayerLoginEvent event) {
        String uuid = event.getPlayer().getUniqueId().toString();



    }

}
