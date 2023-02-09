package rip.real.tags.tags;

import com.mongodb.client.model.ReplaceOptions;
import lombok.Data;
import org.bson.Document;
import rip.real.tags.profile.ProfileHandler;

import java.util.UUID;

@Data
public class Tag {
    private String id;
    private String displayName;
    private String prefix;

    public Tag(String id, String displayName, String prefix) {
        this.id = id;
        this.displayName = displayName;
        this.prefix = prefix;
    }

    public void save() {
        Document document = new Document();

        document.put("id", id);

        document.put("displayName", displayName);
        document.put("prefix", prefix);


        TagHandler.getInstance().getCollection().replaceOne(new Document("id", id), document, new ReplaceOptions().upsert(true));
    }

    public void load(Document document) {

        if (document == null) {
            save();
            return;
        }

        this.id = document.getString("id");

        this.displayName = document.getString("displayName");
        this.prefix = document.getString("prefix");

    }

}
