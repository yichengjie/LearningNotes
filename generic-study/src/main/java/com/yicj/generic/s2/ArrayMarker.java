package com.yicj.generic.s2;

import java.lang.reflect.Array;
import java.util.Arrays;

//根据class创建数组
public class ArrayMarker<T> {
    private Class<T> kind ;
    public ArrayMarker(Class<T> kind){
        this.kind = kind ;
    }
    T [] create(int size){
        return (T[]) Array.newInstance(kind,size) ;
    }

    public static void main(String[] args) {
        ArrayMarker<String> stringMaker =
                new ArrayMarker<>(String.class) ;
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }

}
