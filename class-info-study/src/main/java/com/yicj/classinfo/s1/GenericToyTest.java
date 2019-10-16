package com.yicj.classinfo.s1;

public class GenericToyTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> ftClass = FancyToy.class ;
        FancyToy fancyToy = ftClass.newInstance();
        //
        Class<? super FancyToy> up = ftClass.getSuperclass();
        // This won't compile
        //Class<Toy> up2 = ftClass.getSuperclass() ;
        // Only produces Object:
        Object obj = up.newInstance();
    }
}
