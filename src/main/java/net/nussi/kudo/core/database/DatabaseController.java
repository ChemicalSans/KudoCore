package net.nussi.kudo.core.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import net.nussi.kudo.core.KudoConfig;
import net.nussi.kudo.core.database.records.PlayerRecord;

public class DatabaseController {



    public static MongoClient mongoClient;
    public static MongoDatabase database;
    public static MongoCollection<PlayerRecord> playersCollection;

    public static void onEnable() {

        mongoClient = MongoClients.create(KudoConfig.DatabaseURI);
        database = mongoClient.getDatabase(KudoConfig.DatabaseName);

        try {
            database.createCollection("players");
        } catch (Exception e) {
        }

        playersCollection = database.getCollection("players", PlayerRecord.class);
    }

    public static void onDisable() {
        playersCollection.updateMany(Filters.eq("server", KudoConfig.ServerName), Updates.set("online", false));

        mongoClient.close();
    }

}
