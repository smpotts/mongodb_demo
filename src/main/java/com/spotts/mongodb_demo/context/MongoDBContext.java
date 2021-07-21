package com.spotts.mongodb_demo.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The MongoDB Context.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true) // generates instance of the builder from orig class
public class MongoDBContext {
    private String databaseName = "java_test";
    private String hostName = "localhost";
    private int port = 27017;
}
