package com.spotts.mongodb_demo.service;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.spotts.mongodb_demo.context.MongoDBContext;
import com.spotts.mongodb_demo.model.Car;
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
     * Inserts a new Car into the collection.
     * @param collection The collection to add to.
     * @param car The new Car.
     */
    public void insertDocument(MongoCollection<Document> collection, Car car) {
        Document newDocument = new Document();
        newDocument.put("make", car.getMake());
        newDocument.put("model", car.getModel());
        newDocument.put("year", car.getYear());
        newDocument.put("color", car.getColor());
        newDocument.put("price", car.getPrice());
        collection.insertOne(newDocument);
        log.info("Inserted new car:" + car.getMake() + ", " + car.getModel() + ", " + car.getYear() + ".");
    }

    /**
     * Updates an old car with a new Car in the collection.
     * @param collection The collection.
     * @param oldCar The old Car.
     * @param newCar The new Car.
     */
    public void updateDocument(MongoCollection<Document> collection, Car oldCar, Car newCar) {
        Document existingDoc = new Document();
        existingDoc.put("make", oldCar.getMake());
        existingDoc.put("model", oldCar.getModel());
        existingDoc.put("year", oldCar.getYear());
        existingDoc.put("color", oldCar.getColor());
        existingDoc.put("price", oldCar.getPrice());

        Document newDoc = new Document();
        newDoc.put("make", newCar.getMake());
        newDoc.put("model", newCar.getModel());
        newDoc.put("year", newCar.getYear());
        newDoc.put("color", newCar.getColor());
        newDoc.put("price", newCar.getPrice());

        Document updatedDoc = new Document();
        updatedDoc.put("$set", newDoc);

        collection.updateOne(existingDoc, updatedDoc);
        log.info("Updated a Car in the Collection.");
    }

    /**
     * Deletes a document from a collection.
     * @param document The Document to delete.
     * @param collectionName The name of the collection to remove the document.
     */
    public void deleteDocument(Document document, String collectionName) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        collection.deleteOne(document);
        log.info("Deleted document from " + collectionName);
    }

    /**
     * Reads what is in a Document in a collection.
     * @param collection The collection.
     */
    public void readDocument(MongoCollection<Document> collection) {
        FindIterable<Document> documents = collection.find();
        for (Document d : documents) {
            System.out.println(d.toJson());
        }
    }
}
