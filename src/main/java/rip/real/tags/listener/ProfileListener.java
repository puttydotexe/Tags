package rip.real.tags.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import rip.real.tags.Tags;
import rip.real.tags.profile.ProfileHandler;

public class ProfileListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Bukkit.getScheduler().runTaskAsynchronously(Tags.getInstance(), () -> ProfileHandler.getInstance().getProfile(event.getPlayer().getUniqueId()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        ProfileHandler.getInstance().getProfiles().remove(event.getPlayer().getUniqueId());
    }
}
