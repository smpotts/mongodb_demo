package com.spotts.mongodb_demo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbDemoApplication.class, args);
		DatabaseService databaseService = new DatabaseService();
	}

}
