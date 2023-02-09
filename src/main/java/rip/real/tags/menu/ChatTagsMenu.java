package rip.real.tags.menu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import rip.real.tags.utils.ItemBuilder;
import rip.real.tags.utils.menu.Button;
import rip.real.tags.utils.menu.Menu;

import java.util.HashMap;
import java.util.Map;

public class ChatTagsMenu extends Menu {
    @Override
    public String getTitle(Player player) {
        return "Chat Tags";
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        buttons.put(12, new Button() {
            @Override
            public ItemStack getButtonItem(Player player) {
                ItemBuilder builder = new ItemBuilder(Material.NAME_TAG);
                builder.name("&a&lTags");
                builder.setLore("&7Click to view all tags");

                return builder.build();
            }

            @Override
            public void clicked(Player player, ClickType clickType) {
                new TagsMenu().openMenu(player);
            }

        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player player) {
                ItemBuilder builder = new ItemBuilder(Material.GOLD_NUGGET);
                builder.name("&a&lColors");
                builder.setLore("&7Click to view all colors");

                return builder.build();
            }

            @Override
            public void clicked(Player player, ClickType clickType) {
                new ColorsMenu().openMenu(player);
            }

        });

        return buttons;
    }

    @Override
    public int size(Map<Integer, Button> buttons) {
        return 9 * 3;
    }
}
