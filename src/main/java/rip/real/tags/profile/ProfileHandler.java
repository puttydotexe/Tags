package rip.real.tags.profile;

import com.mongodb.client.MongoCollection;
import lombok.Getter;
import org.bson.Document;
import rip.real.tags.Tags;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileHandler {

    @Getter private static ProfileHandler instance;
    @Getter private MongoCollection<Document> collection = Tags.getInstance().getMongoDatabase().getCollection("profiles");

    @Getter private Map<UUID, Profile> profiles = new HashMap<>();

    public ProfileHandler() {
        instance = this;
    }

    public Profile getProfile(UUID uuid) {
        if (profiles.get(uuid) != null) return profiles.get(uuid);

        Profile profile = new Profile(uuid);
        Document document = collection.find(new Document("uuid", uuid.toString())).first();
        profile.load(document);

        profiles.put(uuid, profile);
        return profile;
    }

}
