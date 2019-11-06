package com.yicj.lookup.entity;

import lombok.Getter;
import lombok.Setter;

public abstract class Car {
    public abstract Taxi createTaxi() ;
    @Getter
    @Setter
    private Taxi taxi ;
}
