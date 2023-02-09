package rip.real.tags.renderer;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import rip.real.tags.profile.Profile;
import rip.real.tags.profile.ProfileHandler;
import rip.real.tags.tags.TagHandler;
import rip.real.tags.utils.CC;

public class ChatRenderer implements io.papermc.paper.chat.ChatRenderer {
    @Override
    public @NotNull Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message, @NotNull Audience viewer) {
        Profile profile = ProfileHandler.getInstance().getProfile(source.getUniqueId());
        String prefix = CC.translate((profile.getActiveColor()== null ?  "" : profile.getActiveColor()) + TagHandler.getInstance().getTag(profile.getActiveTag()).getPrefix());

        return Component.translatable(source.getName() + prefix + CC.RESET + ": " + CC.RESET );
    }
}
