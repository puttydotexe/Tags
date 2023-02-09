package rip.real.tags.command;

import com.readutf.commandframework.Command;
import com.readutf.commandframework.param.Param;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import rip.real.tags.menu.TagsMenu;
import rip.real.tags.tags.Tag;
import rip.real.tags.tags.TagHandler;
import rip.real.tags.utils.CC;

public class TagsCommand {

    @Command(names = {"tag list"}, permission = "")
    public static void tags(Player player) {
        new TagsMenu().openMenu(player);
    }

}
