package rip.real.tags.utils.menu.button;

import lombok.AllArgsConstructor;
import rip.real.tags.utils.TypeCallback;
import rip.real.tags.utils.menu.Button;
import rip.real.tags.utils.menu.Menu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@AllArgsConstructor
public class ConfirmationButton extends Button {

	private final boolean confirm;
	private final String confirmMessage;
	private final String denyMessage;
	private final TypeCallback<Boolean> callback;
	private final boolean closeAfterResponse;

	@Override
	public ItemStack getButtonItem(Player player) {
		ItemStack itemStack = new ItemStack(this.confirm ? Material.GREEN_WOOL : Material.RED_WOOL, 1);
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(this.confirm ? ChatColor.GREEN + confirmMessage : ChatColor.RED + denyMessage);
		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	@Override
	public void clicked(Player player, ClickType clickType) {
		if (this.closeAfterResponse) {
			Menu menu = Menu.currentlyOpenedMenus.get(player.getName());

			if (menu != null) {
				menu.setClosedByMenu(true);
			}

			player.closeInventory();
		}

		this.callback.callback(this.confirm);
	}

}
