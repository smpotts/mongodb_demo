package com.spotts.mongodb_demo.service;

import com.mongodb.client.MongoCollection;
import com.spotts.mongodb_demo.model.Car;
import com.spotts.mongodb_demo.model.Guitar;
import com.spotts.mongodb_demo.model.GuitarType;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoOperationsService {
    private static final MongoDBService databaseService = new MongoDBService();
    private static final Logger log = LoggerFactory.getLogger(DemoOperationsService.class);

    public void runDemo(String collectionName) {
        log.info("Setting up a new collection for demo...");
        databaseService.createCollection(collectionName);
        MongoCollection<Document> mongoCollection = databaseService.getCollection(collectionName);
        loadCollection(mongoCollection);
        log.info("Reading documents...");
        databaseService.readDocument(mongoCollection);
        log.info("Deleting read documents...");
        databaseService.deleteDocuments(mongoCollection);
    }

    /**
     * Loads the collection with records for testing.
     * @param collection the Collection to add to.
     */
    private static void loadCollection(MongoCollection<Document> collection){
        log.info("Loading the demo collection...");
        // create a few cars
        Car rav4 = new Car(2011, "Toyota", "RAV4", "silver", 12000, 92000);
        databaseService.insertDocument(collection, rav4);
        Car bug = new Car(2013, "VW", "Beetle", "black", 7500, 86000);
        databaseService.insertDocument(collection, bug);
        Car malibu = new Car(2011, "Chevy", "Malibu", "gold", 8500, 88000);
        databaseService.insertDocument(collection, malibu);
        Car corvette = new Car(2021, "Chevy", "Corvette", "red", 93000, 7);
        databaseService.insertDocument(collection, corvette);

        // create a few guitars
        Guitar pennyStrat = new Guitar("Fender", "Stratocaster", 1000, GuitarType.ELECTRIC);
        databaseService.insertDocument(collection, pennyStrat);
        Guitar tele = new Guitar("Fender", "Telecaster", 3500, GuitarType.ELECTRIC);
        databaseService.insertDocument(collection, tele);
        Guitar parlor = new Guitar("LAG", "Tramontane 270 PE", 300, GuitarType.ACOUSTIC);
        databaseService.insertDocument(collection, parlor);
        Guitar classical = new Guitar("Kremona", "Fiesta", 1500, GuitarType.CLASSICAL);
        databaseService.insertDocument(collection, classical);
    }
}
