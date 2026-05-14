package Dao;

import DB.MongoConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class AdminDAO {
    private MongoCollection<Document> collection;
    
    public AdminDAO() {
        MongoDatabase db = MongoConnection.getDatabase();
        collection = db.getCollection("Admin");
    }
    
    public boolean login(String username, String password) {
        Document query = new Document("username", username)
                            .append("password", password);
        Document result = collection.find(query).first();
        return result != null;
    }
}