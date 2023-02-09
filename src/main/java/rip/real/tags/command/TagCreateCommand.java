package rip.real.tags.command;

import com.readutf.commandframework.Command;
import com.readutf.commandframework.param.Param;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import rip.real.tags.tags.Tag;
import rip.real.tags.tags.TagHandler;

public class TagCreateCommand {

    @Command(names = {"tag create", "tag new"}, permission = "tags.create")
    public static void createTag(Player player, @Param(name = "id") String id, @Param(name = "display name") String displayName, @Param(name = "prefix") String prefix) {

        if (TagHandler.getInstance().getTag(id) != null) {
            player.sendMessage(ChatColor.RED + "That tag already exists.");
            return;
        }

        Tag tag = new Tag(id, displayName, prefix);

        TagHandler.getInstance().getTags().put(id, tag);
        tag.save();

        player.sendMessage(ChatColor.GREEN + "Tag created.");
    }

}
