package com.spotts.mongodb_demo;

import com.mongodb.BasicDBObject;
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

    private static final Logger log = LoggerFactory.getLogger(DatabaseService.class);

    @PostConstruct
    public void setupMongo() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        // print the names of the default databases
        for (String dbName : mongoClient.listDatabaseNames()) {
            log.info("Mongo DB has database: " + dbName);
        }

        MongoDatabase database = mongoClient.getDatabase("java_test");
//        database.createCollection("first_collection");

        for (String collectionName : database.listCollectionNames()) {
            log.info("Mongo DB has collection: " + collectionName);
        }
    }

    public void saveInsert(MongoDatabase database, String collectionName) {
        MongoCollection<Document> collection =  database.getCollection(collectionName);
        Document document = new Document();
        document.put("make", "Fender");
        document.put("model", "Stratocaster");
        collection.insertOne(document);
    }

    public void createCollection(MongoDatabase database, String collectionName) {
        database.createCollection(collectionName);
    }
}
