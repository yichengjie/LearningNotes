package com.yicj.classinfo.pets.s1;

import com.yicj.classinfo.pets.model.Pet;
import com.yicj.classinfo.pets.s1.PetCreator;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
            new ArrayList<Class<? extends Pet>>() ;

    private static String [] typeNames = {
        "com.yicj.classinfo.pets.model.Mutt",
        "com.yicj.classinfo.pets.model.Pug",
        "com.yicj.classinfo.pets.model.EgyptianMau",
        "com.yicj.classinfo.pets.model.Manx",
        "com.yicj.classinfo.pets.model.Cymric",
        "com.yicj.classinfo.pets.model.Rat",
        "com.yicj.classinfo.pets.model.Mouse",
        "com.yicj.classinfo.pets.model.Hamster"
    } ;

    @SuppressWarnings("unchecked")
    private static void loader(){
        try {
            for (String name : typeNames){
                Class<? extends Pet> clazz =
                        (Class<? extends Pet>)Class.forName(name);
                types.add(clazz) ;
            }
        }catch (Exception e){
            throw new RuntimeException(e) ;
        }
    }

    static {
        loader();
    }


    public List<Class<? extends Pet>> types() {
        return types;
    }
}
