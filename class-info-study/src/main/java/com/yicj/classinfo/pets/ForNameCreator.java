package com.yicj.classinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
            new ArrayList<Class<? extends Pet>>() ;

    private static String [] typeNames = {
        "com.yicj.classinfo.pets.Mutt",
        "com.yicj.classinfo.pets.Pug",
        "com.yicj.classinfo.pets.EgyptianMau",
        "com.yicj.classinfo.pets.Manx",
        "com.yicj.classinfo.pets.Cymric",
        "com.yicj.classinfo.pets.Rat",
        "com.yicj.classinfo.pets.Mouse",
        "com.yicj.classinfo.pets.Hamster"
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
