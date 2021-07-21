package com.spotts.mongodb_demo;

import com.spotts.mongodb_demo.service.DemoOperationsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbDemoApplication.class, args);
		DemoOperationsService opsService = new DemoOperationsService();
		opsService.runDemo("demo_collection");
	}
}
