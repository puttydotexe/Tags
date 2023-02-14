package rip.real.tags;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.readutf.commandframework.CommandHandler;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import rip.real.tags.listener.ChatListener;
import rip.real.tags.listener.ProfileListener;
import rip.real.tags.profile.Profile;
import rip.real.tags.profile.ProfileHandler;
import rip.real.tags.tags.TagHandler;
import rip.real.tags.utils.menu.MenuListener;

@Getter
public class Tags extends JavaPlugin {
    @Getter private static Tags instance;
    
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private CommandHandler commandHandler;

    @Override
    public void onEnable() {
        instance = this;

        mongoClient = new MongoClient("192.168.0.111", 27017);
        mongoDatabase = mongoClient.getDatabase("RealTags");

        new ProfileHandler();
        new TagHandler();

        TagHandler.getInstance().loadTags();

        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
        Bukkit.getPluginManager().registerEvents(new ProfileListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);

        commandHandler = new CommandHandler(this);
        commandHandler.registerAll(this);
    }

    @Override
    public void onDisable() {

        TagHandler.getInstance().saveTags();

        for (Player player : Bukkit.getOnlinePlayers()) {
            ProfileHandler.getInstance().getProfile(player.getUniqueId()).save();
        }
    }
}
