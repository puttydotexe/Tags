package rip.real.tags.command;

import com.readutf.commandframework.Command;
import org.bukkit.entity.Player;
import rip.real.tags.menu.ChatTagsMenu;
import rip.real.tags.menu.TagsMenu;

public class TagMenuCommand {

    @Command(names = {"tag menu"}, permission = "")
    public static void tags(Player player) {
        new ChatTagsMenu().openMenu(player);
    }

}
