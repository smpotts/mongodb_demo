# MongoDB Demo

## Overview 
This is a demo project to learn how to set up a MongoDB database and interact with it using Java. The application creates a new collection, inserts test data (of two different object types) into it, reads from the collection and empties it at the end.

### Technologies
The project is written in Java (v. 11.0.8) using the Spring Boot framework (v. 2.4.5). It is using MongoDB as the database (3.12.9).

### Relevant Terminology
Collection - a collection is similar to a table in traditional database terms.

Document - you put documents into a collection. A document is similar to a record, it's the data to be stored in the collection.

### Design
The project has a few components that orchestrate the demo:
1. MongoDBContext.java: the context contains the default values for the database connection. It defaults to localhost and a test database called "java_test".
2. MongoDBService.java: the service for database operations. The service establishes a database connection, creates collections and inserts, updates and deletes from the collection.
3. DemoOperationsService: the service for running the demo. The service creates the collection and adds test data to it. Then it reads from the collection and deletes the documents it's read.

From a data model perspective, the Guitar and Car classes inherit from the Item class. The Item class contains the toJson() method where I'm using Jackson to convert from an object to a json String.
I chose to have two different objects inherit from the Item class so I could see how MongoDB handles having different in the same collection.  

### Run the application
1. Make sure MongoDB is running on your computer. You can do this with brew by running: "brew services start mongodb-community". 
2. In the MongoDemoApplication class, you can enter a different collection name. The program will create the collection and insert data test into it.
3. Look at the logs to follow along with the steps as it runs the demo.
4. The application will output all the data it has read from the collection before deleting the read documents.

 
 






