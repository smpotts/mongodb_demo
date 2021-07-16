package com.spotts.mongodb_demo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseService {

    private static final String DB_NAME = "java_test";
    private static final String HOSTNAME = "localhost";
    private static final int PORT = 27017;
    private static final Logger log = LoggerFactory.getLogger(DatabaseService.class);

    private static MongoDatabase mongoDatabase;

    @PostConstruct
    public void setupMongo() {
        MongoClient mongoClient = new MongoClient(HOSTNAME, PORT);
        mongoDatabase = mongoClient.getDatabase(DB_NAME);
        // print the names of the default databases
        for (String dbName : mongoClient.listDatabaseNames()) {
            log.info("Mongo DB has database: " + dbName);
        }
        for (String collectionName : mongoDatabase.listCollectionNames()) {
            log.info("Mongo DB has collection: " + collectionName);
        }
    }

    public void saveInsert(String collectionName, String make, String model) {
        MongoCollection<Document> collection =  mongoDatabase.getCollection(collectionName);
        Document document = new Document();
        document.put("make", make);
        document.put("model", model);
        collection.insertOne(document);
        log.info("Inserted document with make " + make + " and model " + model + ".");
    }

    public void saveUpdate(String collectionName, String model, String newModel) {
        MongoCollection<Document> collection =  mongoDatabase.getCollection(collectionName);
        Document query = new Document();
        query.put("model", model);

        Document newDocument = new Document();
        newDocument.put("model", newModel);

        Document updateObject = new Document();
        updateObject.put("$set", newDocument);

        collection.updateOne(query, updateObject);
        log.info("Updated model from " + model + " to " + newModel + ".");
    }

    public void createCollection(String collectionName) {
        mongoDatabase.createCollection(collectionName);
        log.info("Created collection " + collectionName);
    }
}
