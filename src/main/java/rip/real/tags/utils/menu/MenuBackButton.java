package rip.real.tags.utils.menu;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import rip.real.tags.utils.ItemBuilder;

import java.util.List;
import java.util.function.Consumer;

public final class MenuBackButton extends Button {

    private final Consumer<Player> openPreviousMenuConsumer;

    public MenuBackButton(Consumer<Player> openPreviousMenuConsumer) {
        this.openPreviousMenuConsumer = Preconditions.checkNotNull(openPreviousMenuConsumer, "openPreviousMenuConsumer");
    }

    public String getName(Player player) {
        return ChatColor.RED.toString() + ChatColor.BOLD + "Back";
    }

    public List<String> getDescription(Player player) {
        return ImmutableList.of(
            "",
            ChatColor.RED + "Click here to return to",
            ChatColor.RED + "the previous menu."
        );
    }

    public Material getMaterial(Player player) {
        return Material.REDSTONE;
    }

    @Override
    public ItemStack getButtonItem(Player player) {
        ItemBuilder builder = new ItemBuilder(getMaterial(player));
        builder.name(getName(player));
        builder.setLore(getDescription(player));

        return builder.build();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType, int hotbarSlot) {
        player.closeInventory();
        openPreviousMenuConsumer.accept(player);
    }

}