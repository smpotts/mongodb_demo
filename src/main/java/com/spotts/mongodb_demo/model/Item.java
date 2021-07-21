package com.spotts.mongodb_demo.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * An abstract class defining an Item.
 */
public abstract class Item {

    /**
     * Turns an Item into a json String.
     * @return a json String.
     */
    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
