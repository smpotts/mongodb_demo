package com.spotts.mongodb_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car extends Item {
    private String make;
    private String model;
    private int year;
    private String color;
    private int price;
}
