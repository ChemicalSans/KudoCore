package net.nussi.kudo.core;

import net.nussi.kudo.core.database.DatabaseController;
import net.nussi.kudo.core.database.records.PlayerRecord;
import net.nussi.kudo.core.database.records.PlayerRecordBuilder;
import net.nussi.kudo.core.database.records.PlayerRecordHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class KudoCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Print Title
        KudoUtil.PrintTitle();
        Bukkit.getLogger().info("Starting...");

        // LOAD CONFIG
        KudoConfig.LoadConfig();

        // CONNECT DATABASE
        DatabaseController.onEnable();


        // Add Player Handler
        getServer().getPluginManager().registerEvents(new PlayerRecordHandler(), this);
        PlayerRecordHandler.onEnable();

    }

    @Override
    public void onDisable() {

        // Player Handler
        PlayerRecordHandler.onDisable();

        // DISCONNECT DATABASE
        DatabaseController.onDisable();

        //  Print Message
        Bukkit.getLogger().info("KudoCore is now disabled!");
    }
}
