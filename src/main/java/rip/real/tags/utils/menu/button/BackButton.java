package rip.real.tags.utils.menu.button;

import lombok.AllArgsConstructor;
import rip.real.tags.utils.ItemBuilder;
import rip.real.tags.utils.menu.Button;
import rip.real.tags.utils.menu.Menu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

@AllArgsConstructor
public class BackButton extends Button {

	private final Menu back;

	@Override
	public ItemStack getButtonItem(Player player) {
		return new ItemBuilder(Material.REDSTONE)
				.name(ChatColor.RED.toString() + ChatColor.BOLD + "Back")
				.setLore(Arrays.asList(
						ChatColor.RED + "Click here to return to",
						ChatColor.RED + "the previous menu.")
				)
				.build();
	}

	@Override
	public void clicked(Player player, ClickType clickType) {
		Button.playNeutral(player);
		back.openMenu(player);
	}

}
