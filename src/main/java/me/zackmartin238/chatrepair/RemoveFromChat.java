package me.zackmartin238.chatrepair;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class RemoveFromChat implements Listener {

    private final List<String> filteredWords;

    public RemoveFromChat(FileConfiguration config) {
        this.filteredWords = config.getStringList("filtered-words");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        for (String word : filteredWords) {
            if (message.toLowerCase().contains(word.toLowerCase())) {
                event.getPlayer().sendMessage(ChatColor.RED + "Your message contains a filtered word.");
                event.setMessage(RandomMessage.getRandomMessage());
                return;
            }
        }
    }
}
