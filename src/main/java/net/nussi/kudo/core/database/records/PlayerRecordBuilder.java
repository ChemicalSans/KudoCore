package net.nussi.kudo.core.database.records;

import org.bukkit.entity.Player;

public class PlayerRecordBuilder {
    private Player player;
    private String uuid;
    private String name;
    private String server;

    public PlayerRecordBuilder setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public PlayerRecordBuilder setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public PlayerRecordBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PlayerRecordBuilder setServer(String server) {
        this.server = server;
        return this;
    }

    public PlayerRecord createPlayerRecord() {
        return new PlayerRecord(player);
    }
}