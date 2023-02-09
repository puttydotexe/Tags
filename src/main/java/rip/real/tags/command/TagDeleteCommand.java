package rip.real.tags.command;

import com.readutf.commandframework.Command;
import com.readutf.commandframework.param.Param;
import org.bson.Document;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import rip.real.tags.tags.Tag;
import rip.real.tags.tags.TagHandler;

public class TagDeleteCommand {

    @Command(names = {"tag delete"}, permission = "tags.delete")
    public static void delete(Player player, @Param(name = "id") String id) {
        Tag tag = TagHandler.getInstance().getTag(id);

        if (tag == null) {
            player.sendMessage(ChatColor.RED + "That tag does not exist.");
            return;
        }

        TagHandler.getInstance().getCollection().deleteOne(new Document("id", id));
        TagHandler.getInstance().getTags().remove(id);
        player.sendMessage(ChatColor.GREEN + "Tag deleted.");

    }

}
