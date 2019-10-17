package com.yicj.classinfo.pets.model;

public class Individual {
    private static int counter = 0 ;
    private int id = counter ++ ;
    private String name ;

    public Individual(){

    }

    public Individual(String name){
        this.name = name ;
    }
    @Override
    public String toString() {
        return "Individual ["+id+"]" ;
    }
}
