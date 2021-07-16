package com.spotts.mongodb_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbDemoApplication.class, args);

		DatabaseService databaseService = new DatabaseService();
//		databaseService.createCollection("car_collection");
//		databaseService.saveInsert("car_collection", "Toyota", "RAV4");
//		databaseService.saveInsert("car_collection", "Ford", "Mustang");
		databaseService.saveUpdate("car_collection", "Mustang", "Bronco");
	}

}
