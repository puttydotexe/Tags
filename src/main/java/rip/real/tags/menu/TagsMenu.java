package rip.real.tags.menu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import rip.real.tags.profile.Profile;
import rip.real.tags.profile.ProfileHandler;
import rip.real.tags.tags.Tag;
import rip.real.tags.tags.TagHandler;
import rip.real.tags.utils.CC;
import rip.real.tags.utils.ItemBuilder;
import rip.real.tags.utils.menu.Button;
import rip.real.tags.utils.menu.pagination.PaginatedMenu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class TagsMenu extends PaginatedMenu {
    @Override
    public String getPrePaginatedTitle(Player player) {
        return "Chat Tags";
    }

    @Override
    public Map<Integer, Button> getAllPagesButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();
        Profile profile = ProfileHandler.getInstance().getProfile(player.getUniqueId());

        int i = 0;
        for (Tag tag : TagHandler.getInstance().getTags().values()) {
            buttons.put(i++, new Button() {
                @Override
                public ItemStack getButtonItem(Player player) {
                    ItemBuilder builder = new ItemBuilder(Material.GRAY_DYE);
                    builder.name(CC.YELLOW + tag.getDisplayName());
                    builder.setLore(List.of(
                            CC.GRAY + tag.getId(),
                            "",
                            CC.GRAY + "Appears in chat as:",
                            (profile.getActiveColor() != null ? profile.getActiveColor() : "") + tag.getPrefix(),
                            "",
                            CC.GRAY + "You can purchase this tag on",
                            CC.WHITE + "https://store.stray.gg/",
                            "",
                            CC.YELLOW + "Click to select!"
                    ));

                    return builder.build();
                }

                @Override
                public void clicked(Player player, ClickType clickType) {
                    if (!player.hasPermission("tag." + tag.getId())) {
                        player.sendMessage(CC.RED + "You do not have permission to use this tag!");
                        return;
                    }

                    profile.setActiveTag(tag.getId());
                    profile.save();
                    player.sendMessage(CC.GREEN + "You have selected the tag " + CC.YELLOW + tag.getDisplayName() + CC.GREEN + "!");
                }
            });
        }

        return buttons;
    }
}
