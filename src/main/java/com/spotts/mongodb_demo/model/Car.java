package com.spotts.mongodb_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A Car object.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Car extends Item {
    private int year;
    private String make;
    private String model;
    private Color color;
    private int price;
    private int mileage;
}
