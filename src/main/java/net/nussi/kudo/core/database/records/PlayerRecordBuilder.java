package net.nussi.kudo.core.database.records;

import net.nussi.kudo.core.KudoConfig;
import org.bukkit.entity.Player;

public class PlayerRecordBuilder {

    public static PlayerRecord CreateFromPlayer(Player player) {
        return new PlayerRecord(
                player.getUniqueId().toString(),
                player.getName(),
                KudoConfig.ServerName
        );
    }

}
