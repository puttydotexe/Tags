package rip.real.tags.command;

import com.readutf.commandframework.Command;
import com.readutf.commandframework.param.Param;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import rip.real.tags.tags.Tag;
import rip.real.tags.tags.TagHandler;
import rip.real.tags.utils.CC;

public class TagSetDisplayNameCommand {

    @Command(names = {"tag setdisplayname",}, permission = "tags.setdisplayname")
    public static void setDisplayName(Player player, @Param(name = "id") String id, @Param(name = "display name") String displayName) {
        Tag tag = TagHandler.getInstance().getTag(id);

        if (tag == null) {
            player.sendMessage(ChatColor.RED + "That tag does not exist.");
            return;
        }

        tag.setDisplayName(displayName);
        tag.save();

        player.sendMessage(ChatColor.GREEN + "Tag " + CC.YELLOW + tag.getId() + CC.GREEN + " display name set to " + CC.YELLOW + tag.getDisplayName() + CC.GREEN + ".");
    }

}
