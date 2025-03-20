package org.example;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.stream.StreamSupport;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //connect
        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> collection = database.getCollection("products");

            //string ausgabe
            System.out.println("\nString\n");
            StreamSupport.stream(collection.find().spliterator(), false)
                    .map(Document::toString)
                    .forEach(System.out::println);

            //json ausgabe
            System.out.println("\nJson\n");StreamSupport.stream(collection.find().spliterator(), false)
                    .map(Document::toJson)
                    .forEach(System.out::println);
        }
    }
}