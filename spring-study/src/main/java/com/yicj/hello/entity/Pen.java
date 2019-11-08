package com.yicj.hello.entity;

import lombok.Data;

@Data
public class Pen {
    private String name ;

    public Pen(){
        System.out.println("Pen constructor init ....");
    }
}
