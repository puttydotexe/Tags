package rip.real.tags.listener;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import rip.real.tags.renderer.ChatRenderer;

public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerAsyncChat(AsyncChatEvent event) {
        event.renderer(new ChatRenderer());
    }
}
