package com.yicj.classinfo.pets.s2;

import com.yicj.classinfo.pets.model.Pet;
import com.yicj.classinfo.pets.s1.PetCreator;

import java.util.ArrayList;

public class Pets {
    public static final PetCreator creator = new LiteralPetCreator() ;
    public static Pet randomPet(){
        return creator.randomPet() ;
    }
    public static Pet[] createArray(int size){
        return creator.createArray(size) ;
    }
    public static ArrayList<Pet> arrayList(int size){
        return creator.arrayList(size) ;
    }
}
