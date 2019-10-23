package com.yicj.container.s2;

import java.lang.reflect.Array;

public class GetComponentType {

    public static void main(String[] args) {
        System.out.println("the componentType of the char is : "
                + char.class.getComponentType());
        System.out.println("the componentType of the char[] is : "
                + char[].class.getComponentType());
        try {
            char c = (char) Array.newInstance(char.class.getComponentType(),10) ;
        }catch (Exception e){
            System.out.println(e);
        }
        char [] charArray = (char[])Array.newInstance(char.class,10) ;
        System.out.println("charArray length : " + charArray.length);
    }

    public static <T> void sout(T [] arr){
        Class<?> aClass = arr.getClass().getComponentType();
        System.out.println(aClass);
    }
}
