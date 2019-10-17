package com.yicj.generic.s2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {
    List<T> create(){
        return new ArrayList<>() ;
    }

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>() ;
        List<String> strings = stringMaker.create();
    }
}
