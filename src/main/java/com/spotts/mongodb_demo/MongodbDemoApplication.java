package com.spotts.mongodb_demo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.spotts.mongodb_demo.model.Car;
import com.spotts.mongodb_demo.service.MongoDBService;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbDemoApplication.class, args);

		MongoDBService databaseService = new MongoDBService();
//		databaseService.createCollection("car_collection");
//		databaseService.saveInsert("car_collection", "Toyota", "RAV4");
//		databaseService.saveInsert("car_collection", "Ford", "Mustang");
//		databaseService.saveUpdate("car_collection", "Mustang", "Bronco");

		MongoCollection<Document> collection = databaseService.getCollection("car_collection");
		Car newTruck = new Car("Toyota", "Tundra", 2021, "blue", 35000);
	//	databaseService.insertDocument(collection, newTruck);
//        FindIterable<Document> docs = databaseService.readDocument(collection);
//
//        for (Document d : docs) {
//        	System.out.println(d.toJson());
//		}
	}
}
