package com.spotts.mongodb_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A Guitar object.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Guitar extends Item {
    private String make;
    private String model;
    private int price;
    private Color color;
    private GuitarType guitarType;
}
