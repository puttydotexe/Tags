package rip.real.tags.utils.menu;

import com.google.common.collect.ImmutableList;
import rip.real.tags.utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public final class BooleanTraitButton<T> extends Button {

    private final T target;
    private final String trait;
    private final BiConsumer<T, Boolean> writeFunction;
    private final Function<T, Boolean> readFunction;
    private final Consumer<T> saveFunction;

    public BooleanTraitButton(T target, String trait, BiConsumer<T, Boolean> writeFunction, Function<T, Boolean> readFunction) {
        this(target, trait, writeFunction, readFunction, (i) -> {});
    }

    public BooleanTraitButton(T target, String trait, BiConsumer<T, Boolean> writeFunction, Function<T, Boolean> readFunction, Consumer<T> saveFunction) {
        this.target = target;
        this.trait = trait;
        this.writeFunction = writeFunction;
        this.readFunction = readFunction;
        this.saveFunction = saveFunction;
    }

    public String getName(Player player) {
        return ChatColor.GOLD + "Edit " + trait;
    }

    public List<String> getDescription(Player player) {
        return ImmutableList.of(
            ChatColor.YELLOW + "Current: " + ChatColor.WHITE + (readFunction.apply(target) ? "On" : "Off"),
            "",
            ChatColor.GREEN.toString() + ChatColor.BOLD + "Click to toggle"
        );
    }

    public Material getMaterial(Player player) {
        return readFunction.apply(target) ? Material.LEGACY_REDSTONE_TORCH_ON : Material.LEVER;
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
        boolean current = readFunction.apply(target);

        writeFunction.accept(target, !current);
        saveFunction.accept(target);

        player.sendMessage(ChatColor.GREEN + "Set " + trait + " trait to " + (current ? "off" : "on"));
    }

}
