package com.yicj.factorybean.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Car {
    private int maxSpeed;
    private String brand;
    private double price;
}
