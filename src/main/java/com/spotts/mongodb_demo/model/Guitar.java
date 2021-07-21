package com.spotts.mongodb_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Guitar extends Item {
    private String make;
    private String model;
    private String material;
    private int price;
    private GuitarType guitarType;
}
