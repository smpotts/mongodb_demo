package com.spotts.mongodb_demo.service;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.spotts.mongodb_demo.context.MongoDBContext;
import com.spotts.mongodb_demo.model.Item;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MongoDBService {
    private static final Logger log = LoggerFactory.getLogger(MongoDBService.class);
    private static MongoDatabase mongoDatabase;

    @PostConstruct
    public void setupDBConnection() {
        MongoDBContext context = new MongoDBContext();
        MongoClient mongoClient = new MongoClient(context.getHostName(), context.getPort());
        mongoDatabase = mongoClient.getDatabase(context.getDatabaseName());
    }

    /**
     * Creates a new collection in the database.
     * @param collectionName The name of the new collection.
     */
    public void createCollection(String collectionName) {
        mongoDatabase.createCollection(collectionName);
        log.info("Created collection " + collectionName);
    }

    /**
     * Gets the collection from the database with that name.
     * @param collectionName The name of the collection.
     * @return The MongoCollection
     */
    public MongoCollection<Document> getCollection(String collectionName) {
        return mongoDatabase.getCollection(collectionName);
    }

    /**
     * Inserts a new Item into the collection.
     * @param collection The collection to add to.
     * @param item a new Item.
     */
    public void insertDocument(MongoCollection<Document> collection, Item item) {
        Document newDocument = new Document();
        newDocument.put("item", item.toJson());
        collection.insertOne(newDocument);
        log.info("Inserted a new document into the collection.");
    }

    /**
     * Updates an old Item with a new Item in the collection.
     * @param collection The collection.
     * @param origItem The old Item.
     * @param newItem The new Item.
     */
    public void updateDocument(MongoCollection<Document> collection, Item origItem, Item newItem) {
        Document existingDoc = new Document();
        existingDoc.put("item", origItem.toJson());

        Document newDoc = new Document();
        newDoc.put("item", newItem.toJson());

        Document updatedDoc = new Document();
        updatedDoc.put("$set", newDoc);

        collection.updateOne(existingDoc, updatedDoc);
        log.info("Updated a document in the collection.");
    }

    /**
     * Deletes Documents from a collection.
     * @param collection The collection.
     */
    public void deleteDocuments(MongoCollection<Document> collection) {
        FindIterable<Document> documents = collection.find();
        for (Document d : documents) {
            collection.deleteOne(d);
        }
        log.info("Documents deleted from the collection.");
    }

    /**
     * Reads Documents in a collection.
     * @param collection The collection.
     */
    public void readDocument(MongoCollection<Document> collection) {
        FindIterable<Document> documents = collection.find();
        for (Document d : documents) {
            System.out.println(d.toJson());
        }
        log.info("All documents read.");
    }
}
