package rip.real.tags.menu;

import org.apache.commons.lang3.text.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import rip.real.tags.profile.Profile;
import rip.real.tags.profile.ProfileHandler;
import rip.real.tags.tags.Tag;
import rip.real.tags.tags.TagHandler;
import rip.real.tags.utils.CC;
import rip.real.tags.utils.ClayColorsMap;
import rip.real.tags.utils.ItemBuilder;
import rip.real.tags.utils.menu.Button;
import rip.real.tags.utils.menu.pagination.PaginatedMenu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ColorsMenu extends PaginatedMenu {
    @Override
    public String getPrePaginatedTitle(Player player) {
        return "Tag Color";
    }

    @Override
    public Map<Integer, Button> getAllPagesButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();
        Profile profile = ProfileHandler.getInstance().getProfile(player.getUniqueId());

        int i = 0;
        for (ChatColor chatColor : ClayColorsMap.colors.keySet()) {
            buttons.put(i++, new Button() {

                @Override
                public ItemStack getButtonItem(Player player) {
                    ItemBuilder builder = new ItemBuilder(ClayColorsMap.colors.get(chatColor));
                    builder.name(CC.YELLOW + WordUtils.capitalize(chatColor.name().toLowerCase().replace('_', ' ')));
                    builder.setLore(List.of(
                            CC.GRAY + "Sets the color of your tag",
                            CC.GRAY + "in chat to " + chatColor + WordUtils.capitalize(chatColor.name().toLowerCase().replace('_', ' ')) + CC.GRAY + ".",
                            "",
                            CC.GRAY + "Appears in chat as:",
                            chatColor + "Example",
                            "",
                            CC.YELLOW + "Click to select!"
                    ));

                    return builder.build();
                }

                @Override
                public void clicked(Player player, ClickType clickType) {
                    if (!player.hasPermission("color." + chatColor.name().toLowerCase())) {
                        player.sendMessage(CC.RED + "You do not have permission to use this color!");
                        return;
                    }

                    profile.setActiveColor(chatColor);
                    profile.save();
                    player.sendMessage(CC.GREEN + "You have selected the color " + chatColor + chatColor.name() + CC.GREEN + "!");
                }
            });
        }

        return buttons;
    }
}
