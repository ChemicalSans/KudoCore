package net.nussi.kudo.core.database.records;

import net.nussi.kudo.core.KudoConfig;
import org.bukkit.entity.Player;

public record PlayerRecord(
        String uuid,
        String name,
        String server
) {

    public PlayerRecord(Player player) {
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
        this.server = KudoConfig.ServerName;
    }
}
