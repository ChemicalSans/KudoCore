package net.nussi.kudo.core;

import net.nussi.kudo.core.database.DatabaseController;
import net.nussi.kudo.core.database.records.PlayerRecord;
import net.nussi.kudo.core.database.records.PlayerRecordBuilder;
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


        ArrayList<PlayerRecord> records = new ArrayList<>();
        for(Player player : getServer().getOnlinePlayers()) {
            records.add(PlayerRecordBuilder.CreateFromPlayer(player));
        }

        if(!records.isEmpty()) DatabaseController.playersCollection.insertMany(records);

    }

    @Override
    public void onDisable() {



        // DISCONNECT DATABASE
        DatabaseController.onDisable();

        //  Print Message
        Bukkit.getLogger().info("KudoCore is now disabled!");
    }
}
