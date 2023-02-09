package rip.real.tags.utils.menu;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class Button {

	public static Button placeholder(final Material material, String... title) {
		return (new Button() {
			public ItemStack getButtonItem(Player player) {
				ItemStack it = new ItemStack(material, 1);
				ItemMeta meta = it.getItemMeta();

				meta.setDisplayName(StringUtils.join(title));
				it.setItemMeta(meta);

				return it;
			}
		});
	}

	public static Button fromItem(final ItemStack item) {
		return (new Button() {
			public ItemStack getButtonItem(Player player) {
				return item;
			}
		});
	}

	public static void playFail(Player player) {
		player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, SoundCategory.MASTER, 20F, 0.1F);
	}

	public static void playSuccess(Player player) {
		player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, SoundCategory.MASTER, 20F, 15F);
	}

	public static void playNeutral(Player player) {
		player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, SoundCategory.MASTER, 20F, 1F);
	}

	public abstract ItemStack getButtonItem(Player player);

	public void clicked(Player player, ClickType clickType) {}

	public void clicked(Player player, int slot, ClickType clickType, int hotbarSlot) {}

	public boolean shouldCancel(Player player, ClickType clickType) {
		return true;
	}

	public boolean shouldUpdate(Player player, ClickType clickType) {
		return false;
	}

}