package rip.real.tags.command;

import com.readutf.commandframework.Command;
import org.bukkit.entity.Player;
import rip.real.tags.menu.ColorsMenu;
import rip.real.tags.menu.TagsMenu;

public class ColorsCommand {

    @Command(names = {"colors", "tag colors"}, permission = "")
    public static void colors(Player player) {
        new ColorsMenu().openMenu(player);
    }

}
