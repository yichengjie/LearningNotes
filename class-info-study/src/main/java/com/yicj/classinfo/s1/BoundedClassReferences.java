package com.yicj.classinfo.s1;

import java.util.Arrays;
import java.util.List;

public class BoundedClassReferences {

    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class ;
        bounded = double.class ;
        bounded = Number.class ;
        //Or anything else derived from Number
        //下面报错
        //List<Class<? extends Number>> list = Arrays.asList(Integer.class) ;
    }
}
