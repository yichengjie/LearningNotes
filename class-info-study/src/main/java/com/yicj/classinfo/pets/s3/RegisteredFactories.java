package com.yicj.classinfo.pets.s3;

public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Part.createRandom());
        }
    }

}
