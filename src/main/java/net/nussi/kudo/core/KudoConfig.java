package net.nussi.kudo.core;

import org.bukkit.Bukkit;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class KudoConfig {
    public static final String Prefix = "mc.shard";
    public static final String ConfigFilePath = "McShard.properties";

    public static String ServerName;

    public static String DatabaseURI;
    public static String DatabaseName;


    public static boolean LoadConfig() {
        if (!Files.exists(Path.of(ConfigFilePath))) {
            Bukkit.getServer().getLogger().warning("No properties file found! Creating one...");
            CreateDefaultConfig();
        }

        try (InputStream input = new FileInputStream(ConfigFilePath)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            ServerName = prop.getProperty(Prefix + ".general.name");
            DatabaseURI = prop.getProperty(Prefix + ".db.uri", "mongodb://localhost:27017");
            DatabaseName = prop.getProperty(Prefix + ".db.name", "mcshard");


        } catch (IOException ex) {
            return false;
        }

        return true;
    }

    public static void CreateDefaultConfig() {
        Properties prop = new Properties();


        prop.setProperty(Prefix + ".general.name", "Alpha");
        prop.setProperty(Prefix + ".db.uri", "mongodb://localhost:27017");
        prop.setProperty(Prefix + ".db.name", "mcshard");


        try {
            File file = new File("McShard.properties");
            FileWriter writer = new FileWriter(file);
            prop.store(writer, "");
            Bukkit.getServer().getLogger().warning("Succesfully created new properties file!");
        } catch (IOException e) {
            Bukkit.getServer().getLogger().warning("FAIL!!!   Couldn't create properties file!");
        }
    }


}
