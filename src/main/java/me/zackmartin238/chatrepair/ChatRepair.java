package me.zackmartin238.chatrepair;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class ChatRepair extends JavaPlugin {

    @Override
    public void onEnable() {
        // Load and pass the custom configuration to RemoveFromChat
        FileConfiguration customConfig = loadCustomConfig();
        RemoveFromChat removeFromChat = new RemoveFromChat(customConfig);

        // Register the listener
        getServer().getPluginManager().registerEvents(removeFromChat, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("ChatRepair disabled");
    }

    private FileConfiguration loadCustomConfig() {
        File customConfigFile = new File(getDataFolder(), "filteredwords.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("filteredwords.yml", false);
        }
        FileConfiguration customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | org.bukkit.configuration.InvalidConfigurationException e) {
            Bukkit.getLogger().severe("Could not load custom config");
        }
        return customConfig;
    }
}
