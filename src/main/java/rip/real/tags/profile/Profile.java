package rip.real.tags.profile;

import com.mongodb.client.model.ReplaceOptions;
import lombok.Data;
import org.bson.Document;
import org.bukkit.ChatColor;

import java.util.UUID;

@Data
public class Profile {
    private UUID uuid;

    private String activeTag;
    private ChatColor activeColor;

    public Profile(UUID uuid) {
        this.uuid = uuid;
    }

    public void save() {
        Document document = new Document();

        document.put("uuid", uuid.toString());

        document.put("activeTag", activeTag);

        if (activeColor != null) {
            document.put("activeColor", activeColor.name());
        }

        ProfileHandler.getInstance().getCollection().replaceOne(new Document("uuid", uuid.toString()), document, new ReplaceOptions().upsert(true));

    }

    public void load(Document document) {

        if (document == null) {
            save();
            return;
        }

        this.uuid = UUID.fromString(document.getString("uuid"));

        this.activeTag = document.getString("activeTag");

        if (document.getString("activeColor") != null) {
            this.activeColor = ChatColor.valueOf(document.getString("activeColor"));
        }

    }

}
