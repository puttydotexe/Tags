package rip.real.tags.utils.menu.menus;

import rip.real.tags.utils.TypeCallback;
import rip.real.tags.utils.menu.Button;
import rip.real.tags.utils.menu.Menu;
import rip.real.tags.utils.menu.button.ConfirmationButton;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class ConfirmMenu extends Menu {

	private final String title;
	private final TypeCallback<Boolean> response;
	private final boolean closeAfterResponse;
	private final Button[] centerButtons;
	private final String confirm;
	private final String deny;

	public ConfirmMenu(String title, TypeCallback<Boolean> response, boolean closeAfter, String confirm, String deny, @Nullable Button... centerButtons) {
		this.title = title;
		this.response = response;
		this.closeAfterResponse = closeAfter;
		this.confirm = confirm;
		this.deny = deny;
		this.centerButtons = centerButtons;
	}

	@Override
	public Map<Integer, Button> getButtons(Player player) {
		HashMap<Integer, Button> buttons = new HashMap<>();

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				buttons.put(getSlot(x, y), new ConfirmationButton(true, confirm, deny, response, closeAfterResponse));
				buttons.put(getSlot(8 - x, y), new ConfirmationButton(false, confirm, deny, response, closeAfterResponse));
			}
		}

		if (centerButtons != null) {
			for (int i = 0; i < centerButtons.length; i++) {
				if (centerButtons[i] != null) {
					buttons.put(getSlot(4, i), centerButtons[i]);
				}
			}
		}

		return buttons;
	}

	@Override
	public String getTitle(Player player) {
		return title;
	}

}
