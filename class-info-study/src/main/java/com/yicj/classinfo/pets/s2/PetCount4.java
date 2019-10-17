package com.yicj.classinfo.pets.s2;

import com.yicj.classinfo.fresh.TypeCounter;
import com.yicj.classinfo.pets.model.Pet;

public class PetCount4 {

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class) ;
        for(Pet pet : Pets.createArray(20)){
            System.out.print(pet.getClass().getSimpleName() +" ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}
