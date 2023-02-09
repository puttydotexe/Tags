package rip.real.tags.tags;

import com.mongodb.client.MongoCollection;
import lombok.Getter;
import org.bson.Document;
import rip.real.tags.Tags;
import rip.real.tags.profile.Profile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TagHandler {

    @Getter private static TagHandler instance;
    @Getter private MongoCollection<Document> collection = Tags.getInstance().getMongoDatabase().getCollection("tags");

    @Getter private Map<String, Tag> tags = new HashMap<>();

    public TagHandler() {
        instance = this;
    }

    public Tag getTag(String id) {
        if (tags.get(id) != null) return tags.get(id);

        return null;
    }

    public void loadTags() {

        for (Document document : collection.find()) {
            Tag tag = new Tag(document.getString("id"), document.getString("displayName"), document.getString("prefix"));
            tag.load(document);
            tags.put(tag.getId(), tag);
        }
    }

    public void saveTags() {
        for (Tag tag : tags.values()) {
            tag.save();
        }
    }
}
