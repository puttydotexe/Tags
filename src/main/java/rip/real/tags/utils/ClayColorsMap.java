package rip.real.tags.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class ClayColorsMap {

    public static Map<ChatColor, Material> colors = new HashMap<>();

    static {
        colors.put(ChatColor.AQUA, Material.LIGHT_BLUE_TERRACOTTA);
        colors.put(ChatColor.BLACK, Material.BLACK_TERRACOTTA);
        colors.put(ChatColor.BLUE, Material.BLUE_TERRACOTTA);
        colors.put(ChatColor.DARK_AQUA, Material.CYAN_TERRACOTTA);
        colors.put(ChatColor.DARK_BLUE, Material.BLUE_TERRACOTTA);
        colors.put(ChatColor.DARK_GRAY, Material.GRAY_TERRACOTTA);
        colors.put(ChatColor.DARK_GREEN, Material.GREEN_TERRACOTTA);
        colors.put(ChatColor.DARK_PURPLE, Material.PURPLE_TERRACOTTA);
        colors.put(ChatColor.DARK_RED, Material.RED_TERRACOTTA);
        colors.put(ChatColor.GOLD, Material.ORANGE_TERRACOTTA);
        colors.put(ChatColor.GRAY, Material.LIGHT_GRAY_TERRACOTTA);
        colors.put(ChatColor.GREEN, Material.LIME_TERRACOTTA);
        colors.put(ChatColor.LIGHT_PURPLE, Material.MAGENTA_TERRACOTTA);
        colors.put(ChatColor.RED, Material.RED_TERRACOTTA);
        colors.put(ChatColor.WHITE, Material.WHITE_TERRACOTTA);
        colors.put(ChatColor.YELLOW, Material.YELLOW_TERRACOTTA);

    }
}
